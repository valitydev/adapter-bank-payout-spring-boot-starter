package dev.vality.adapter.bank.payout.spring.boot.starter.service;

import dev.vality.adapter.bank.payout.spring.boot.starter.converter.ExitStateToProcessResultConverter;
import dev.vality.adapter.bank.payout.spring.boot.starter.converter.WithdrawalToEntryStateConverter;
import dev.vality.adapter.bank.payout.spring.boot.starter.flow.StepResolver;
import dev.vality.adapter.bank.payout.spring.boot.starter.handler.CommonHandler;
import dev.vality.adapter.bank.payout.spring.boot.starter.handler.GetQuoteHandler;
import dev.vality.adapter.bank.payout.spring.boot.starter.handler.HandleCallbackHandler;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.EntryStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.validator.WithdrawalValidator;
import dev.vality.adapter.common.exception.UnsupportedMethodException;
import dev.vality.damsel.msgpack.Value;
import dev.vality.damsel.withdrawals.provider_adapter.AdapterSrv;
import dev.vality.damsel.withdrawals.provider_adapter.Callback;
import dev.vality.damsel.withdrawals.provider_adapter.CallbackResult;
import dev.vality.damsel.withdrawals.provider_adapter.GetQuoteFailure;
import dev.vality.damsel.withdrawals.provider_adapter.GetQuoteParams;
import dev.vality.damsel.withdrawals.provider_adapter.ProcessResult;
import dev.vality.damsel.withdrawals.provider_adapter.Quote;
import dev.vality.damsel.withdrawals.provider_adapter.Withdrawal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class PayoutAdapterService<T extends EntryStateModel, X extends ExitStateModel> implements AdapterSrv.Iface {

    private final WithdrawalToEntryStateConverter<T> withdrawalToEntryStateConverter;
    private final ExitStateToProcessResultConverter<X> exitStateToProcessResultConverter;
    private final List<CommonHandler<T, X>> handlers;
    private final StepResolver<T, X> resolver;
    private final WithdrawalValidator validator;
    private final GetQuoteHandler getQuoteHandler;
    private final HandleCallbackHandler handleCallbackHandler;

    @Override
    public ProcessResult processWithdrawal(Withdrawal withdrawal, Value state, Map<String, String> options)
            throws TException {
        validator.validate(withdrawal, state, options);
        T entryStateModel = withdrawalToEntryStateConverter.convert(withdrawal, state, options);
        log.info("EntryStateModel: {}", entryStateModel);
        entryStateModel.getState().setStep(resolver.resolveEntry(entryStateModel));
        X exitStateModel = handlers.stream()
                .filter(h -> h.isHandle(entryStateModel))
                .findFirst()
                .orElseThrow(UnsupportedMethodException::new)
                .handle(entryStateModel);
        log.info("ExitStateModel: {}", exitStateModel);
        exitStateModel.getNextState().setStep(resolver.resolveExit(exitStateModel));
        log.info("Step changing: {} -> {}", entryStateModel.getState().getStep(),
                exitStateModel.getNextState().getStep());
        return exitStateToProcessResultConverter.convert(exitStateModel);
    }

    @Override
    public Quote getQuote(GetQuoteParams getQuoteParams, Map<String, String> map) throws GetQuoteFailure, TException {
        return getQuoteHandler.handle(getQuoteParams, map);
    }

    @Override
    public CallbackResult handleCallback(Callback callback, Withdrawal withdrawal, Value value, Map<String, String> map)
            throws TException {
        return handleCallbackHandler.handleCallback(callback, withdrawal, value, map);
    }
}

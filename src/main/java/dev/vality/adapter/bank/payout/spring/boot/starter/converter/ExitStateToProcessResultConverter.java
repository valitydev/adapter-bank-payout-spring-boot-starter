package dev.vality.adapter.bank.payout.spring.boot.starter.converter;

import dev.vality.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;
import dev.vality.damsel.withdrawals.provider_adapter.ProcessResult;

public interface ExitStateToProcessResultConverter<X extends ExitStateModel> {
    ProcessResult convert(X exitStateModel);
}

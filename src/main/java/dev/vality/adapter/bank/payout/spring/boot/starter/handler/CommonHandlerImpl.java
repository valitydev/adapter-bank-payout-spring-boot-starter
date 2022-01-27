package dev.vality.adapter.bank.payout.spring.boot.starter.handler;

import dev.vality.adapter.bank.payout.spring.boot.starter.model.EntryStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.processor.Processor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.function.Function;

@RequiredArgsConstructor
public abstract class CommonHandlerImpl<P, R, T extends EntryStateModel, X extends ExitStateModel>
        implements CommonHandler<T, X> {

    private final Function<P, R> requestFunction;
    private final Converter<T, P> converter;
    private final Processor<R, T, X> processor;

    @Override
    public X handle(T entryStateModel) {
        P request = converter.convert(entryStateModel);
        R response = requestFunction.apply(request);
        return processor.process(response, entryStateModel);
    }
}

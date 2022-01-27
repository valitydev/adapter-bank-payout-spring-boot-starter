package dev.vality.adapter.bank.payout.spring.boot.starter.processor;

import dev.vality.adapter.bank.payout.spring.boot.starter.model.EntryStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;

public interface Processor<R, T extends EntryStateModel, X extends ExitStateModel> {
    X process(R response, T entryStateModel);
}

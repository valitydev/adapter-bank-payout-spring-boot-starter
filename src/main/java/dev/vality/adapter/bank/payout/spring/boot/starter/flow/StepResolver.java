package dev.vality.adapter.bank.payout.spring.boot.starter.flow;

import dev.vality.adapter.bank.payout.spring.boot.starter.model.EntryStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.Step;

public interface StepResolver<T extends EntryStateModel, X extends ExitStateModel> {
    Step resolveEntry(T entryStateModel);

    Step resolveExit(X exitStateModel);
}

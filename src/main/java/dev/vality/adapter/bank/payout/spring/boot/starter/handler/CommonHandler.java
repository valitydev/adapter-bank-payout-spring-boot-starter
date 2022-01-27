package dev.vality.adapter.bank.payout.spring.boot.starter.handler;

import dev.vality.adapter.bank.payout.spring.boot.starter.model.EntryStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;

public interface CommonHandler<T extends EntryStateModel, X extends ExitStateModel> {
    boolean isHandle(T entryStateModel);

    X handle(T entryStateModel);
}

package com.rbkmoney.adapter.bank.payout.spring.boot.starter.processor;

import com.rbkmoney.adapter.bank.payout.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;

public interface Processor<R, T extends EntryStateModel, X extends ExitStateModel> {
    X process(R response, T entryStateModel);
}

package com.rbkmoney.adapter.bank.payout.spring.boot.starter.converter;

import com.rbkmoney.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.damsel.withdrawals.provider_adapter.ProcessResult;

public interface ExitStateToProcessResultConverter<X extends ExitStateModel> {
    ProcessResult convert(X exitStateModel);
}

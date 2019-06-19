package com.rbkmoney.adapter.bank.payout.spring.boot.starter.service;

import com.rbkmoney.adapter.bank.payout.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.damsel.withdrawals.provider_adapter.Intent;

import java.time.Instant;

public interface IntentService {
    Intent getFailure(ExitStateModel exitStateModel);
    Intent getSuccess(ExitStateModel exitStateModel);
    Intent getSleep(ExitStateModel exitStateModel);
    Instant getMaxDateTimeInstant(EntryStateModel entryStateModel);
}

package dev.vality.adapter.bank.payout.spring.boot.starter.service;

import dev.vality.adapter.bank.payout.spring.boot.starter.model.EntryStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;
import dev.vality.damsel.withdrawals.provider_adapter.Intent;

import java.time.Instant;

public interface IntentService {
    Intent getFailureByCode(ExitStateModel exitStateModel);

    Intent getFailureByCodeAndDesc(ExitStateModel exitStateModel);

    Intent getSuccess(ExitStateModel exitStateModel);

    Intent getSleep(ExitStateModel exitStateModel);

    Long getMaxDateTimeInstantMillis(EntryStateModel entryStateModel);

    Instant extractMaxDateTimeInstant(EntryStateModel entryStateModel);
}

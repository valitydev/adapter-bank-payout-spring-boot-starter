package dev.vality.adapter.bank.payout.spring.boot.starter.converter;

import dev.vality.adapter.bank.payout.spring.boot.starter.model.EntryStateModel;
import dev.vality.damsel.msgpack.Value;
import dev.vality.damsel.withdrawals.provider_adapter.Withdrawal;

import java.util.Map;

public interface WithdrawalToEntryStateConverter<T extends EntryStateModel> {

    T convert(Withdrawal withdrawal, Value state, Map<String, String> options);

}

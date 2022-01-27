package dev.vality.adapter.bank.payout.spring.boot.starter.validator;

import dev.vality.adapter.bank.payout.spring.boot.starter.exception.ValidationException;
import dev.vality.damsel.msgpack.Value;
import dev.vality.damsel.withdrawals.provider_adapter.Withdrawal;

import java.util.Map;

public interface WithdrawalValidator {
    void validate(Withdrawal withdrawal, Value state, Map<String, String> options) throws ValidationException;
}

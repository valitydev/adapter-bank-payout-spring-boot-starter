package dev.vality.adapter.bank.payout.spring.boot.starter.handler;

import dev.vality.damsel.msgpack.Value;
import dev.vality.damsel.withdrawals.provider_adapter.Callback;
import dev.vality.damsel.withdrawals.provider_adapter.CallbackResult;
import dev.vality.damsel.withdrawals.provider_adapter.Withdrawal;

import java.util.Map;

public interface HandleCallbackHandler {
    CallbackResult handleCallback(Callback callback, Withdrawal withdrawal, Value value, Map<String, String> map);
}

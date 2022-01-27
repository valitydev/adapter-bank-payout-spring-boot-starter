package dev.vality.adapter.bank.payout.spring.boot.starter.handler;

import dev.vality.damsel.withdrawals.provider_adapter.GetQuoteParams;
import dev.vality.damsel.withdrawals.provider_adapter.Quote;

import java.util.Map;

public interface GetQuoteHandler {
    Quote handle(GetQuoteParams getQuoteParams, Map<String, String> map);
}

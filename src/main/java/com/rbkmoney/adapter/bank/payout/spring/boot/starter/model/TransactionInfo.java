package com.rbkmoney.adapter.bank.payout.spring.boot.starter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class TransactionInfo {
    private String trxId;
    private Map<String, String> trxExtra;
}

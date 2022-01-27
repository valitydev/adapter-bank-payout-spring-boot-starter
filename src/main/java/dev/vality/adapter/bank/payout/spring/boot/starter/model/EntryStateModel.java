package dev.vality.adapter.bank.payout.spring.boot.starter.model;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
public class EntryStateModel {
    private String withdrawalId;
    private Long amount;
    private String currencyCode;
    @ToString.Exclude
    private String pan;
    @ToString.Exclude
    private Map<String, String> options;

    private AdapterState state;
}

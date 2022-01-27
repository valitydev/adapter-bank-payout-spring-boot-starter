package dev.vality.adapter.bank.payout.spring.boot.starter.model;

import lombok.Data;

@Data
public class ExitStateModel {
    private String errorCode;
    private String errorMessage;
    private AdapterState nextState;

    private EntryStateModel entryStateModel;
}

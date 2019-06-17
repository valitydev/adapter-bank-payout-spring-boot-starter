package com.rbkmoney.adapter.bank.payout.spring.boot.starter.model;

import lombok.Data;

@Data
public class ExitStateModel {
    private String errCode;
    private String errMessage;
    private AdapterState nextState;

    private EntryStateModel entryStateModel;
}

package com.rbkmoney.adapter.bank.payout.spring.boot.starter.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.bank.payout.spring.boot.starter.model.AdapterState;
import com.rbkmoney.adapter.common.serializer.StateSerializer;

import java.io.IOException;

public class AdapterStateSerializer extends StateSerializer<AdapterState> {

    public AdapterStateSerializer(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    public AdapterState read(byte[] data) {
        if (data == null) {
            return new AdapterState();
        }
        try {
            return getMapper().readValue(data, AdapterState.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

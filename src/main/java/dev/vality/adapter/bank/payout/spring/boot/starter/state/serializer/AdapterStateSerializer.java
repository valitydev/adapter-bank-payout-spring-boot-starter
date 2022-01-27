package dev.vality.adapter.bank.payout.spring.boot.starter.state.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.AdapterState;
import dev.vality.adapter.common.state.serializer.StateSerializer;

public class AdapterStateSerializer extends StateSerializer<AdapterState> {
    public AdapterStateSerializer(ObjectMapper mapper) {
        super(mapper);
    }
}

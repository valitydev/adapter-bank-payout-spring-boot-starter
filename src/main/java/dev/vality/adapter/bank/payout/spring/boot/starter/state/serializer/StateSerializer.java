package dev.vality.adapter.bank.payout.spring.boot.starter.state.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vality.adapter.bank.payout.spring.boot.starter.exception.SerializationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Base64;

@Getter
@Setter
@AllArgsConstructor
public abstract class StateSerializer<T> implements Serializer<T> {

    private final ObjectMapper mapper;

    @Override
    public byte[] writeByte(Object obj) {
        try {
            return mapper.writeValueAsBytes(obj);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @Override
    public String writeString(Object obj) {
        try {
            return Base64.getEncoder().encodeToString(getMapper().writeValueAsBytes(obj));
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

}
package dev.vality.adapter.bank.payout.spring.boot.starter.state.deserializer;

public interface Deserializer<T> {

    T read(byte[] data);

    T read(String data);

}

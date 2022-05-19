package dev.vality.adapter.bank.payout.spring.boot.starter.state.serializer;

public interface Serializer<T> {

    byte[] writeByte(T obj);

    String writeString(T obj);

}

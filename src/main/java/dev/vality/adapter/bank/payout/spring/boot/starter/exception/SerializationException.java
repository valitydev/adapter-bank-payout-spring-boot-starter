package dev.vality.adapter.bank.payout.spring.boot.starter.exception;

public class SerializationException extends RuntimeException {
    public SerializationException() {
        super();
    }

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }

    public SerializationException(String message, Throwable cause) {
        super(message, cause);
    }
}

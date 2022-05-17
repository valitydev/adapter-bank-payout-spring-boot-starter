package dev.vality.adapter.bank.payout.spring.boot.starter.service;

@FunctionalInterface
public interface BackOffExecution {
    Long nextBackOff();
}

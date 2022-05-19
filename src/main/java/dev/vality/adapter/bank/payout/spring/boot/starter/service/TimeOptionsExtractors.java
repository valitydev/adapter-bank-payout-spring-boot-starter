package dev.vality.adapter.bank.payout.spring.boot.starter.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeOptionsExtractors {

    private static final String TIMER_EXPONENTIAL = "exponential";
    private static final String MAX_TIME_BACKOFF = "max_time_backoff";
    private static final String DEFAULT_INITIAL_EXPONENTIAL = "default_initial_exponential";

    public static Integer extractExponent(Map<String, String> options, int maxTimePolling) {
        return Integer.parseInt(options.getOrDefault(TIMER_EXPONENTIAL, String.valueOf(maxTimePolling)));
    }

    public static Integer extractMaxTimeBackOff(Map<String, String> options, int maxTimeBackOff) {
        return Integer.parseInt(options.getOrDefault(MAX_TIME_BACKOFF, String.valueOf(maxTimeBackOff)));
    }

    public static Integer extractDefaultInitialExponential(Map<String, String> options, int defaultInitialExponential) {
        return Integer.parseInt(
                options.getOrDefault(DEFAULT_INITIAL_EXPONENTIAL, String.valueOf(defaultInitialExponential)));
    }

}

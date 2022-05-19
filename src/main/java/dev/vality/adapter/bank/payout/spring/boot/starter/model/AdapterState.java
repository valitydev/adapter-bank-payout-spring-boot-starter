package dev.vality.adapter.bank.payout.spring.boot.starter.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdapterState {

    private Step step;
    // TODO: backward compatibility
    private Long maxTimePoolingMillis;

    private TransactionInfo trxInfo;

    @JsonUnwrapped
    private PollingInfo pollingInfo;
}

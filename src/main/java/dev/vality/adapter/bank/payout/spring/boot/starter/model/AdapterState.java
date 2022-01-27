package dev.vality.adapter.bank.payout.spring.boot.starter.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import dev.vality.adapter.common.model.PollingInfo;
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

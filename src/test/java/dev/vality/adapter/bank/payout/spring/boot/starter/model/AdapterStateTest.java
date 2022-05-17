package dev.vality.adapter.bank.payout.spring.boot.starter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class AdapterStateTest {

    @Test
    public void testUnwrappedPollingInfo() throws IOException {
        AdapterState as = new AdapterState();
        as.setStep(Step.CHECK);
        PollingInfo pollingInfo = new PollingInfo();
        pollingInfo.setMaxDateTimePolling(Instant.now());
        as.setPollingInfo(pollingInfo);
        ObjectMapper objectMapper = getObjectMapper();
        String str = objectMapper.writeValueAsString(as);
        assertTrue(str.startsWith("{\"step\":\"CHECK\",\"max_date_time_polling\":"));
        AdapterState acRestored = objectMapper.readValue(str, AdapterState.class);
        assertEquals(as.getStep(), acRestored.getStep());
        assertNotNull(acRestored.getPollingInfo());
        assertEquals(as.getPollingInfo().getMaxDateTimePolling(), acRestored.getPollingInfo().getMaxDateTimePolling());
    }

    @Test
    public void testUnwrappedPollingInfoIsNull() throws IOException {
        ObjectMapper om = getObjectMapper();
        AdapterState as = new AdapterState();
        as.setStep(Step.CHECK);
        as.setPollingInfo(null);
        String str = om.writeValueAsString(as);
        assertTrue(str.startsWith("{\"step\":\"CHECK\""));
        AdapterState acRestored = om.readValue(str, AdapterState.class);
        assertEquals(as.getStep(), acRestored.getStep());
        assertNotNull(acRestored.getPollingInfo());
    }

    private ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule())
                .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
package dev.vality.adapter.bank.payout.spring.boot.starter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vality.adapter.bank.payout.spring.boot.starter.config.properties.TimerProperties;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.AdapterState;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.EntryStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.ExitStateModel;
import dev.vality.adapter.bank.payout.spring.boot.starter.model.PollingInfo;
import dev.vality.adapter.common.mapper.ErrorMapping;
import dev.vality.damsel.withdrawals.provider_adapter.Intent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntentServiceImplTest {

    private static final String ERROR_MAPPING_FILE_PATH = "src/test/resources/fixture/errors.json";
    private static final String ERROR_MAPPING_PATTERN = "'%s' - '%s'";

    private IntentServiceImpl intentService;

    @BeforeEach
    public void setUp() throws IOException {
        intentService = new IntentServiceImpl(prepareErrorMapping(), prepareTimerProperties());
    }

    @Test
    public void getSleepIntentSuccess() {
        ExitStateModel exitStateModel = new ExitStateModel();
        EntryStateModel entryStateModel = new EntryStateModel();
        entryStateModel.setOptions(new HashMap<>());
        exitStateModel.setEntryStateModel(entryStateModel);
        AdapterState adapterState = new AdapterState();
        PollingInfo pollingInfo = new PollingInfo();
        pollingInfo.setMaxDateTimePolling(Instant.now().plus(10000L, ChronoUnit.MINUTES));
        adapterState.setPollingInfo(pollingInfo);
        exitStateModel.setNextState(adapterState);
        Intent intent = intentService.getSleep(exitStateModel);
        assertTrue(intent.isSetSleep());
    }

    @Test
    public void getSleepIntentFailure() {
        ExitStateModel exitStateModel = new ExitStateModel();
        AdapterState adapterState = new AdapterState();
        PollingInfo pollingInfo = new PollingInfo();
        pollingInfo.setMaxDateTimePolling(Instant.now().minus(1000L, ChronoUnit.MINUTES));
        adapterState.setPollingInfo(pollingInfo);
        exitStateModel.setNextState(adapterState);
        Intent intent = intentService.getSleep(exitStateModel);
        assertTrue(intent.getFinish().getStatus().isSetFailure());
    }

    @Test
    public void getSleepException() {
        ExitStateModel exitStateModel = new ExitStateModel();
        AdapterState adapterState = new AdapterState();
        adapterState.setPollingInfo(new PollingInfo());
        exitStateModel.setNextState(adapterState);
        assertThrows(IllegalArgumentException.class, () -> intentService.getSleep(exitStateModel));
    }

    private ErrorMapping prepareErrorMapping() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(ERROR_MAPPING_FILE_PATH);
        InputStream is = new FileInputStream(file);
        ErrorMapping errorMapping = new ErrorMapping(is, ERROR_MAPPING_PATTERN, mapper);
        return errorMapping;
    }

    private TimerProperties prepareTimerProperties() {
        TimerProperties timerProperties = new TimerProperties();
        timerProperties.setMaxTimePolling(600);
        timerProperties.setPollingDelay(10);
        return timerProperties;
    }
}
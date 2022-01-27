package dev.vality.adapter.bank.payout.spring.boot.starter.state.utils;

import dev.vality.adapter.bank.payout.spring.boot.starter.model.AdapterState;
import dev.vality.adapter.bank.payout.spring.boot.starter.state.deserializer.AdapterStateDeserializer;
import dev.vality.damsel.proxy_provider.PaymentContext;
import dev.vality.damsel.proxy_provider.RecurrentTokenContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdapterStateUtils {

    public static AdapterState getAdapterState(Object context, AdapterStateDeserializer adapterDeserializer) {
        AdapterState adapterState = new AdapterState();
        byte[] state = getState(context);
        if (state != null && state.length > 0) {
            return adapterDeserializer.read(state);
        }
        return adapterState;
    }

    private static byte[] getState(Object context) {
        if (context instanceof RecurrentTokenContext) {
            if (((RecurrentTokenContext) context).getSession() == null) {
                return new byte[0];
            }
            return ((RecurrentTokenContext) context).getSession().getState();
        }
        return ((PaymentContext) context).getSession().getState();
    }

}

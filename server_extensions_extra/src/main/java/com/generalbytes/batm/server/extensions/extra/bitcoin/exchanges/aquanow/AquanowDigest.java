package com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow;

import com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.bitflyer.BitFlyerDigest;
import org.knowm.xchange.service.BaseParamsDigest;
import si.mazi.rescu.RestInvocation;

import javax.crypto.Mac;

public class AquanowDigest extends BaseParamsDigest {
    private String timestamp;

    private AquanowDigest(byte[] key) {
        super(key, HMAC_SHA_384);
    }

    public static AquanowDigest createInstance(String key, String timestamp) {
        AquanowDigest instance = new AquanowDigest(key.getBytes());
        instance.timestamp = timestamp;
        return instance;
    }

    @Override
    public String digestParams(RestInvocation restInvocation) {
        Mac sha384_HMAC = getMac();
        sha384_HMAC.update(restInvocation.getHttpMethod().getBytes());
        sha384_HMAC.update(restInvocation.getPath().getBytes());
        sha384_HMAC.update(timestamp.getBytes());

        byte[] result = sha384_HMAC.doFinal();
        return bytesToHexString(result).toUpperCase();
    }

    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}

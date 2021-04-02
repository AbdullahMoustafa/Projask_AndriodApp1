package com.zedan.acare.supervisor.data.utils;

public final class ReplaceKeys {
    public static String toValidKey(String key) {
        return key
                .replace('.', '_');
    }
}

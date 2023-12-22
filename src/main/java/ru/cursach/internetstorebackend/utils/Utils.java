package ru.cursach.internetstorebackend.utils;

import java.util.UUID;

public class Utils {
    public static String wrapUUID(String uuid) {
        try {
            return "'"+ UUID.fromString(uuid) + "'";
        } catch (IllegalArgumentException exception) {
            return uuid;
        }
    }
}

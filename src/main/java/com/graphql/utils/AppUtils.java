package com.graphql.utils;

import lombok.experimental.UtilityClass;

import java.util.Random;
import java.util.UUID;

@UtilityClass
public class AppUtils {

    public String randomStr() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {

    }
}

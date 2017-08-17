package com.ywGroup.ieCloud.wenZhouIntelligentGas.util;

/**
 * Created by Administrator on 2017/6/26.
 */
public class DigitalVerificationCode {

    private DigitalVerificationCode() {

    }

    public static String getVerificationCode() {
        int min = 100000;
        int max = 999999;
        int randNum = 100000 + (int)(Math.random() * ((max - min) + 1));
        return String.valueOf(randNum);
    }
}

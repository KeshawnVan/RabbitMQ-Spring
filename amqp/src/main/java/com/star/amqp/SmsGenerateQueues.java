package com.star.amqp;

public class SmsGenerateQueues {
    public static final String PREFIX = "boss.message-center-generate-";

    public static final String RECHARGE = PREFIX + "recharge-sms";
    public static final String RECHARGE_AND_CHANGE = PREFIX + "recharge-and-change-sms";
    public static final String RECHARGE_FAIL = PREFIX + "recharge-fail-sms";
    public static final String CHANGE = PREFIX + "change-sms";
    public static final String ACCEPT_PROGRAM = PREFIX + "accept-program-sms";


    public static final String FAIL_SUFFIX = "-fail";
    public static final String FAIL_RECHARGE = RECHARGE + FAIL_SUFFIX;
    public static final String FAIL_RECHARGE_AND_CHANGE = RECHARGE_AND_CHANGE + FAIL_SUFFIX;
    public static final String FAIL_RECHARGE_FAIL = RECHARGE_FAIL + FAIL_SUFFIX;
    public static final String FAIL_CHANGE = CHANGE + FAIL_SUFFIX;
    public static final String FAIL_ACCEPT_PROGRAM = ACCEPT_PROGRAM + FAIL_SUFFIX;


}

package com.star.amqp;

/**
 * 充值事件类型
 */
public enum RechargeEventType {

    /**
     * 付款(付款明细记录)
     */
    PAY,

    /**
     * 充值卡充值(充值卡充值记录)
     */
    RECHARGE_CARD,

    /**
     * 营业预存(营业账目)
     */
    OPERATION_RECHARGE,

    /**
     * 转账转入(余额转账记录)
     */
    TRANSFER_IN,

    /**
     * 转账转出(余额转账记录)
     */
    TRANSFER_OUT,

    /**
     * 销账(销账明细)
     */
    WRITE_OFF,

    /**
     * 营业支付(营业账目缴退记录)
     */
    OPERATION_PAY,

    /**
     * 特殊调整(余额调整记录)
     */
    SPECIAL_ADJUST,

    /**
     * 扣款(使用量扣款记录)
     */
    CHARGE,

    /**
     * 付款冲正(被冲正的付款明细记录)
     */
    BACK_PAY

}

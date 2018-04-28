package com.star.amqp;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class SmsRechargeInfo extends SmsBaseInfo{

    /**
     * 充值后是否可以罚停开通 充值必填
     */
    @NotNull
    private Boolean canOpen;

    /**
     * 客户标识
     */
    @NotNull
    private Long customerId;

    /**
     * 余额流水的事件类型
     */
    @NotNull
    private RechargeEventType rechargeEventType;

    /**
     * 充值的用户
     * ps. 网关接口中可能是先选择的用户，再选择的充值客户、账户等，此类场景中，需要传入这个值
     */
    private Long subscriberId;

    /**
     * 账户标识
     */
    private Long accountId;

    /**
     * 账本标识
     */
    private Long balanceId;

    /**
     * 基本销售品实例标识
     */
    private Long offerInstanceId;

    /**
     * 本次充值金额
     */
    private Double rechargeAmount;

    /**
     * 资费标识
     */
    private Long rateId;

    /**
     * 充值卡规格
     * ps. 充值卡充值时不能为空
     */
    private Long cardSpecId;

    /**
     * 时段截止日期
     */
    private LocalDate durationEndDate;

    /**
     * 付款记录标识
     */
    private Long paymentId;

    /**
     * 余额支入支出记录
     */
    private Long balanceLogId;

    /**
     * 时段剩余天数
     */
    private Long durationDays;

    /**
     * 不能开通时的差额
     */
    private Double difference;

    /**
     * 社会渠道交易标识
     */
    private Long transactionId;

    public Boolean getCanOpen() {
        return canOpen;
    }

    public void setCanOpen(Boolean canOpen) {
        this.canOpen = canOpen;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public RechargeEventType getRechargeEventType() {
        return rechargeEventType;
    }

    public void setRechargeEventType(RechargeEventType rechargeEventType) {
        this.rechargeEventType = rechargeEventType;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }

    public Long getOfferInstanceId() {
        return offerInstanceId;
    }

    public void setOfferInstanceId(Long offerInstanceId) {
        this.offerInstanceId = offerInstanceId;
    }

    public Double getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(Double rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public LocalDate getDurationEndDate() {
        return durationEndDate;
    }

    public void setDurationEndDate(LocalDate durationEndDate) {
        this.durationEndDate = durationEndDate;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getBalanceLogId() {
        return balanceLogId;
    }

    public void setBalanceLogId(Long balanceLogId) {
        this.balanceLogId = balanceLogId;
    }

    public Long getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Long durationDays) {
        this.durationDays = durationDays;
    }

    public Double getDifference() {
        return difference;
    }

    public void setDifference(Double difference) {
        this.difference = difference;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCardSpecId() {
        return cardSpecId;
    }

    public void setCardSpecId(Long cardSpecId) {
        this.cardSpecId = cardSpecId;
    }
}

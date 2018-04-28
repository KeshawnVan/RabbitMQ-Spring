package com.star.amqp;

import javax.validation.constraints.NotNull;

/**
 * 发送短信所需信息
 */
public class SmsBaseInfo {

    /**
     * 短信的接收者
     */
    @NotNull
    private String receiver;

    /**
     * 公司标识
     */
    @NotNull
    private Long companyId;

    /**
     * 来源标识
     */
    private Long sourceId;

    /**
     * 来源类型
     */
    private MessageSourceType sourceType;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public MessageSourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(MessageSourceType sourceType) {
        this.sourceType = sourceType;
    }
}

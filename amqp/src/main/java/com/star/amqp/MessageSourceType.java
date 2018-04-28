package com.star.amqp;

/**
 * Created by lorin on 2016/9/7.
 */
public enum MessageSourceType {

    /**
     * 订单
     */
    ORDER,

    /**
     * 手工消息发送
     */
    MANUAL,

    /**
     * 工单
     */
    WORK_ORDERS,

    /**
     * 脚本
     */
    SCRIPT,

    /**
     * 欠费处理
     */
    OWE_PROCESSING,

    /**
     * 历史指令重发
     */
    HISTORY_RESENT,

    /**
     * 呼叫中心
     */
    CALL_CENTER,

    /**
     * 客户服务
     */
    CUSTOMER_SERVICE,

    /**
     * 客户管理
     */
    CUSTOMER_MANAGE,

    /**
     * 合作伙伴账户余额告警
     */
    PARTNER_ACCOUNT_BALANCE_ALARM,

    /**
     * 操作员消息发送
     */
    EMPLOYEE_MESSAGE,

    /**
     * 合作伙伴员工重置支付密码
     */
    PARTNER_STAFF_RESET_PIN,

    /**
     * 增加合作伙伴员工
     */
    PARTNER_ADD_STAFF,

    /**
     * 合作伙伴额度发放成功
     */
    PARTNER_CREDIT_ISSUED_SUCCESS,

    /**
     * 合作伙伴代缴
     */
    PARTNER_RECHARGE,

    /**
     * 预计停断日期催缴
     */
   EXPECT_OVERDUE_DATE_CALL,

    /**
     * API调用
     */
    API_INVOKE
}

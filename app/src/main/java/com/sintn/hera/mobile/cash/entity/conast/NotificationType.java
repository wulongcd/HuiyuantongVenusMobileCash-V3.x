package com.sintn.hera.mobile.cash.entity.conast;

/**
 * 
 * @Desc: 通知的类型
 * @com.sintn.hera.mobile.cash.entity.conast
 * @HuiyuantongVenusMobileCash-V3.x
 * @NotificationType.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:12:02
 */
public class NotificationType
{
	// 数据改变
	public static final int DATA_CHANGE = 1;
	
	// 企业主动消息（企业->店铺、员工、消费者）
	public static final int ENTERPRISE = 2;
	
	// 店铺主动消息（店铺->员工、消费者）
	public static final int SHOP = 3;
	
	// 员工主动消息（员工->企业、店铺）
	public static final int STAFF = 4;
	
	// 消费者主动消息（消费者->企业、店铺）
	public static final int CONSUMER = 5;
	
	// 系统主动消息（系统->企业、店铺、员工、消费者、代理商）
	public static final int SYSTEM = 6;
	
	// 消费消息（店铺->消费者）
	public static final int CONSUME = 7;
	
	// 充值消息（店铺->消费者）
	public static final int RECHARGE = 8;
	
	// 购买套餐消息（店铺->消费者）
	public static final int BUY_SALE_GROUP = 9;
	
	// 预约处理消息（店铺->消费者）
	public static final int SUBSCRIBE = 10;
	
	// 企业自动推送的消息（企业->店铺/消费者等）
	public static final int ENTERPRISE_AUTO_PUSH = 11;
	
	// 企业主动推送消息（企业->消费者）
	public static final int ENTERPRISE_PUSH = 12;
}

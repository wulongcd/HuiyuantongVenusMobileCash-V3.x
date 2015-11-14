package com.sintn.hera.mobile.cash.entity;

/**
 * 推送的标志
 */
public class PushFlagType
{
	// 通知
	public static final int NOTIFICATION = 1;

	// 数据改变->店铺相关信息（企业、店铺、店铺管理员、店铺员工）
	public static final int CHANGE_SHOP_RELATED_INFO = 2;

	// 数据改变->店铺商品相关信息（商品分类、商品类型）
	public static final int CHANGE_SHOP_PRODUCT_RELATED_INFO = 3;

	// 数据改变->店铺优惠相关信息（会员卡类型、套餐类型、套餐明细、
	// 代金券类型、折扣券类型、特殊折扣、折扣券折扣、消费赠送规则、充值赠送规则）
	public static final int CHANGE_SHOP_SALE_PROMOTION_INFO = 4;

	// 数据改变->店铺其他信息（时间戳、软件版本、mac地址）
	public static final int CHANGE_SHOP_OTHER_INFO = 5;

	// 数据改变->关闭收银点账号信息同步
	public static final int CLOSE_CASHIER_ACCOUNT = 6;

	// 数据改变->相同账户在另一个地方登录
	public static final int SAME_ACCOUNT_ANOTHER_PLACE_LOGIN = 7;

	// 数据改变->店铺被删除
	public static final int DELETE_SHOP = 8;

	// 数据改变->预约
	public static final int SUBSCRIBE = 9;
}

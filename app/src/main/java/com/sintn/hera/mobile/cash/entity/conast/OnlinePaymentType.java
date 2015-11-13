package com.sintn.hera.mobile.cash.entity.conast;

/**
 * 在线支付的类型
 */
public class OnlinePaymentType
{
	// 支付宝即时到账
	public static final int ALIPAY_DIRECT_PAY = 1;
	
	// 支付宝纯网关接口（银联）
	public static final int ALIPAY_UNIONPAY = 2;
	
	// 支付宝二维码支付用户扫码支付
	public static final int ALIPAY_QRCODE_USER_SCAN = 3;
	
	// 微信二维码支付用户扫码支付
	public static final int WEIXIN_QRCODE_USER_SCAN = 4;
	
	// 微信二维码支付商家扫码支付
	public static final int WEIXIN_QRCODE_SELLER_SCAN = 5;
	
	public static String getOnlinePaymentType(int paymentType)
	{
		if(paymentType == ALIPAY_DIRECT_PAY)
		{
			return "支付宝即时到账支付";
		}
		else if(paymentType == ALIPAY_UNIONPAY)
		{
			return "支付宝银联支付";
		}
		else if(paymentType == ALIPAY_QRCODE_USER_SCAN)
		{
			return "支付宝二维码用户扫码支付";
		}
		else if(paymentType == WEIXIN_QRCODE_USER_SCAN)
		{
			return "微信二维码用户扫码支付";
		}
		else if(paymentType == WEIXIN_QRCODE_SELLER_SCAN)
		{
			return "微信二维码商家扫码支付";
		}
		
		return "";
	}
}

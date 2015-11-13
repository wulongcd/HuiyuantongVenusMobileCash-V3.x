package com.sintn.hera.mobile.cash.entity.conast;

/**
 *App种类:店铺收银App，会员App，Boss客户端，员工app，简易收银app
 */
public class AppType
{
	/**
	 *  店铺收银平板客户端App
	 */
	public static final int APP_SHOP = 1;
	
	/**
	 * 会员客户端App
	 */
	public static final int APP_MEMBER = 2;
	
	/**
	 *  Boss客户端App
	 */
	public static final int APP_BOSS = 3;
	
	/**
	 *  员工客户端App
	 */
	public static final int APP_STAFF = 4;
	
	/**
	 * 简易收银app
	 */
	public static final int APP_SIMPLE_CASHIER = 5;

	public static int getAppShop() {
		return APP_SHOP;
	}

	public static int getAppMember() {
		return APP_MEMBER;
	}

	public static int getAppBoss() {
		return APP_BOSS;
	}

	public static int getAppStaff() {
		return APP_STAFF;
	}

	public static int getAppSimpleCashier() {
		return APP_SIMPLE_CASHIER;
	}
}

package com.sintn.hera.mobile.cash.entity.conast;

/**
 * 操作系统类型
 * @author sintn
 *
 */
public class OSType
{
	/**
	 *  android
	 */
	public static final int OS_ANDROID = 1;
	
	/**
	 *  ios
	 */
	public static final int OS_IOS = 2;
	
	/**
	 * 分不清是IOS还是安卓:0
	 */
	public static final int OS_UNKNOWN=0;

	public static int getOsAndroid() {
		return OS_ANDROID;
	}

	public static int getOsIos() {
		return OS_IOS;
	}

	public static int getOsUnknown() {
		return OS_UNKNOWN;
	}
}

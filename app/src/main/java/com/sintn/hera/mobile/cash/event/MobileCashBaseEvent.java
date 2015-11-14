package com.sintn.hera.mobile.cash.event;

import android.view.View;

/**
 * 
 * @Desc: 事件基类
 * @com.sintn.hera.mobile.cash.event
 * @HuiyuantongVenusMobileCash-V3.x
 * @MobileCashBaseEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午2:41:36
 */

public abstract class MobileCashBaseEvent
{
	/**
	 * 事件类型编码
	 */
	protected final int eventCode;
	/**
	 * 事件完成后是否发送通知
	 */
	protected boolean isNotifyAfterRun;
	/**
	 * 是否异步
	 */
	protected boolean isAsyncRun;
	/**
	 * 当有事件正在处理是否依然处理当前事件
	 */
	private boolean isWaitRunWhenRunning;
	/**
	 * 标签
	 */
	private Object tag;
	/**
	 * 可以跟新状态的VIEW
	 */
	public View relationView;

	public MobileCashBaseEvent(int eventCode)
	{
		this.eventCode = eventCode;
	}

	public int getEventCode()
	{
		return eventCode;
	}

	public void setIsNotifyAfterRun(boolean bNotify)
	{
		isNotifyAfterRun = bNotify;
	}

	public boolean isNotifyAfterRun()
	{
		return isNotifyAfterRun;
	}

	public void setIsAsyncRun(boolean bAsync)
	{
		isAsyncRun = bAsync;
	}

	public boolean isAsyncRun()
	{
		return isAsyncRun;
	}

	public void setIsWaitRunWhenRunning(boolean bWait)
	{
		isWaitRunWhenRunning = bWait;
	}

	public boolean isWaitRunWhenRunning()
	{
		return isWaitRunWhenRunning;
	}

	public void setTag(Object tag)
	{
		this.tag = tag;
	}

	public Object getTag()
	{
		return tag;
	}

	public void onPreRun()
	{
	}

	public void onRunEnd()
	{
	}

	/**
	 * 事件处理抽象函数
	 * 
	 * @param params
	 * @throws Exception
	 */
	public abstract void run(Object... params) throws Exception;

}

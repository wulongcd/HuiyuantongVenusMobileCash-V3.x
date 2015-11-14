package com.sintn.hera.mobile.cash.event.httpevent;

import com.sintn.hera.mobile.cash.utils.core.HttpUtils;

/**
 * 
 * @com.sintn.hera.mobile.cash.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpPostEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 网络POST事件
 * @2015-2-4下午4:01:29
 */
public class HttpPostEvent extends HttpEvent
{
	public HttpPostEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		httpResponse = HttpUtils.doPost(strUrl, params[1]);
		verifyResponse();

	}

}

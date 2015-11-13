package com.sintn.hera.mobile.cash.event.httpevent;

import com.sintn.hera.mobile.cash.utils.core.HttpUtils;


/**
 * 
 * @com.sintn.hera.mobile.cash.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpGetEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 网络获取事件
 * @2015-2-4下午4:01:09
 */

public class HttpGetEvent extends HttpEvent {

	public HttpGetEvent(int nEventCode) {
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception {
		super.run(params);
		httpResponse = HttpUtils.doGet(strUrl);
		verifyResponse();
	}
}

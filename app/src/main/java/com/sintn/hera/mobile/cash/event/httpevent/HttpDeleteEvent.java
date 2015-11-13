package com.sintn.hera.mobile.cash.event.httpevent;

import com.sintn.hera.mobile.cash.utils.core.HttpUtils;


/**
 * 
 * @com.sintn.hera.mobile.cash.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpDeleteEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: http->delete
 * @2015-2-4下午4:00:12
 */

public class HttpDeleteEvent extends HttpEvent {

	public HttpDeleteEvent(int nEventCode) {
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception {
		super.run(params);
		httpResponse = HttpUtils.doDelete(strUrl);
		verifyResponse();
	}

}

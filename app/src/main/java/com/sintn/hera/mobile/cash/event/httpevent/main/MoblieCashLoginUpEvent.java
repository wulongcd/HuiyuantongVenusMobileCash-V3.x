package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.StaffLoginDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;


public class MoblieCashLoginUpEvent extends HttpPostEvent
{

	private  int result;

	public MoblieCashLoginUpEvent(int nEventCode) {
		super(nEventCode);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_IN && isOk && !isMethodNotAllowed())
		{
			result = Integer.parseInt(strHttpResult);
		}
	}

}

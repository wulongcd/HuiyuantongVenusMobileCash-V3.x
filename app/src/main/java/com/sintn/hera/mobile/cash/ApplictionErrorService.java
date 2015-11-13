package com.sintn.hera.mobile.cash;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.up.ClientErrorLogUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.ApplictionErrorUpLoadEvent;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.utils.common.ToastManager;
import com.sintn.hera.mobile.cash.utils.core.EventManager.OnEventListener;
import com.sintn.hera.mobile.cash.R;

/**
 * 
 * @Desc: CASH错误上传服务
 * @com.sintn.hera.mobile.cash
 * @HuiyuantongVenusMobileCash-V3.x
 * @ApplictionErrorService.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:26:24
 */
public class ApplictionErrorService extends Service implements OnEventListener
{

	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		if (intent != null)
		{
			if (intent.getAction().equals("CrashHandler"))
			{
				if (intent.hasExtra("content"))
				{
					AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_APPLICTION_ERROR, this, false);
					AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_APPLICTION_ERROR, 0, URLUtils.URL_POST_APPLICTION_ERROR, new ClientErrorLogUp(intent.getStringExtra("content")));
				}
			}
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onEventRunEnd(MobileCashBaseEvent event)
	{
		// TODO Auto-generated method stub
		int eventCode = event.getEventCode();
		if (eventCode == EventCode.HTTP_POST_APPLICTION_ERROR)
		{
			DialogUtils.dissMissLoading(EventCode.HTTP_POST_APPLICTION_ERROR);
			final ApplictionErrorUpLoadEvent applictionErrorUpLoadEvent = (ApplictionErrorUpLoadEvent) event;
			if (applictionErrorUpLoadEvent.isNetSuccess())
			{
				if (applictionErrorUpLoadEvent.isOk())
				{
					if (applictionErrorUpLoadEvent.getResult().equals("success"))
					{
						ToastManager.getInstance(BaseApplication.getApplication()).show(getResources().getString(R.string.error_log_show));
					}
				} else
				{
					if (applictionErrorUpLoadEvent.getErrorObject() == null)
					{
						ToastManager.getInstance(BaseApplication.getApplication()).show(applictionErrorUpLoadEvent.getStrHttpResult());
					} else
					{
						ToastManager.getInstance(BaseApplication.getApplication()).show(ErrorObject.formatError(applictionErrorUpLoadEvent.getErrorObject()));
					}
				}
			}
			return;
		}
	}

}

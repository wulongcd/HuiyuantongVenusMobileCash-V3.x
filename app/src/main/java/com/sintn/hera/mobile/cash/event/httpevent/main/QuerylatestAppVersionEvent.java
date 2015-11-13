package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.AppVersion;
import com.sintn.hera.mobile.cash.event.httpevent.HttpGetEvent;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * Created by Sintn on 15/10/27.
 */
public class QuerylatestAppVersionEvent extends HttpGetEvent{

    private AppVersion data = null;

    public AppVersion getData() {
        return data;
    }

    public void setData(AppVersion data) {
        this.data = data;
    }

    public QuerylatestAppVersionEvent(int nEventCode)
    {
        super(nEventCode);
    }

    @Override
    public void run(Object... params) throws Exception
    {
        super.run(params);
        if (eventCode == EventCode.HTTP_GET_APPVERSION_QUERYLATEST && isOk && !isMethodNotAllowed())
        {
            data = (AppVersion) JsonCommonUtils.jsonToObject(strHttpResult, AppVersion.class);
        }
    }


}

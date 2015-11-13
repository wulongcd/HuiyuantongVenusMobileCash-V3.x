package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.event.httpevent.HttpGetEvent;

/**
 * Created by Sintn on 15/10/27.
 */
public class QueryStatusForQrcodeOrderEvent extends HttpGetEvent {

    private int result = -1;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public QueryStatusForQrcodeOrderEvent(int nEventCode) {
        super(nEventCode);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void run(Object... params) throws Exception {
        super.run(params);
        if (eventCode == EventCode.HTTP_GET_ORDER_QUERY_STATUS && isOk && !isMethodNotAllowed()) {
            result = Integer.valueOf(strHttpResult);
        }
    }


}

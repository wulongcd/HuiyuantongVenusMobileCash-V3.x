package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.TotalMoneyForSimpleCashierDown;
import com.sintn.hera.mobile.cash.entity.down.TotalMoneyForSimpleCashierDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * Created by Sintn on 15/10/27.
 */
public class QueryQrcodeOrderTotalEvent extends HttpPostEvent {

    private TotalMoneyForSimpleCashierDown data = null;

    public TotalMoneyForSimpleCashierDown getData() {
        return data;
    }

    public void setData(TotalMoneyForSimpleCashierDown data) {
        this.data = data;
    }

    public QueryQrcodeOrderTotalEvent(int nEventCode)
    {
        super(nEventCode);
    }

    @Override
    public void run(Object... params) throws Exception
    {
        super.run(params);
        if (eventCode == EventCode.HTTP_POST_ORDER_QUERYTOTALMONEY && isOk && !isMethodNotAllowed())
        {
            data = (TotalMoneyForSimpleCashierDown) JsonCommonUtils.jsonToObject(strHttpResult, TotalMoneyForSimpleCashierDown.class);
        }
    }


}

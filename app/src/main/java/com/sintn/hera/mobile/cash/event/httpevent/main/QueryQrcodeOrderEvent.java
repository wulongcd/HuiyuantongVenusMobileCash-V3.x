package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.CommonPagerDown;
import com.sintn.hera.mobile.cash.entity.down.OrderForCashierAppDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sintn on 15/10/27.
 */
public class QueryQrcodeOrderEvent extends HttpPostEvent {

    private CommonPagerDown<OrderForCashierAppDown> data = null;

    public CommonPagerDown<OrderForCashierAppDown> getData() {
        return data;
    }

    public void setData(CommonPagerDown<OrderForCashierAppDown> data) {
        this.data = data;
    }

    public QueryQrcodeOrderEvent(int nEventCode)
    {
        super(nEventCode);
    }

    @Override
    public void run(Object... params) throws Exception
    {
        super.run(params);
        if (eventCode == EventCode.HTTP_POST_ORDER_QUERY && isOk && !isMethodNotAllowed())
        {
            data = (CommonPagerDown) JsonCommonUtils.jsonToObject(strHttpResult, CommonPagerDown.class);
            List<OrderForCashierAppDown> list = Arrays.asList((OrderForCashierAppDown[]) JsonCommonUtils.jsonToObject(data.getList().toString(), OrderForCashierAppDown[].class));
            data.setList(list);
        }
    }


}

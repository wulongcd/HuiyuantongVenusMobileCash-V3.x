package com.sintn.hera.mobile.cash.event.httpevent.main;


import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.ConsumeStaffDown;
import com.sintn.hera.mobile.cash.entity.down.OrderResultForSimpleCashierDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpGetEvent;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;


public class CreateQrCodeOrderEvent extends HttpPostEvent {

    private OrderResultForSimpleCashierDown result = null;

    public OrderResultForSimpleCashierDown getResult() {
        return result;
    }

    public void setResult(OrderResultForSimpleCashierDown result) {
        this.result = result;
    }

    public CreateQrCodeOrderEvent(int nEventCode) {
        super(nEventCode);
    }

    @Override
    public void run(Object... params) throws Exception {
        super.run(params);
        if (eventCode == EventCode.HTTP_POST_ORDER_CREATE && isOk && !isMethodNotAllowed()) {
            result = (OrderResultForSimpleCashierDown) JsonCommonUtils.jsonToObject(strHttpResult, OrderResultForSimpleCashierDown.class);
        }
    }

}

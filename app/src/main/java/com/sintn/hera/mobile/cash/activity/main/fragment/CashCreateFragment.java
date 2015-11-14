package com.sintn.hera.mobile.cash.activity.main.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.zxing.common.StringUtils;
import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.entity.conast.OnlinePaymentType;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.down.OrderResultForSimpleCashierDown;
import com.sintn.hera.mobile.cash.entity.up.OrderForSimpleCashierUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.CreateQrCodeOrderEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.QueryStatusForQrcodeOrderEvent;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.widget.dialog.QrcodeDialog;
import com.sintn.hera.mobile.cash.widget.view.EditTextWithFrame;

public class CashCreateFragment extends BaseMainFragment {
    private LinearLayout ll_in_maincativity_of_fragment_create_order_for_root;

    private EditTextWithFrame et_in_maincativity_of_fragment_create_order_for_input;

    private LinearLayout ll_in_maincativity_of_fragment_create_order_for_weixin;

    private LinearLayout ll_in_maincativity_of_fragment_create_order_for_alipay;

    private OrderForSimpleCashierUp orderForSimpleCashierUp = null;

    private OrderResultForSimpleCashierDown orderResultForSimpleCashierDown = null;

    private QrcodeDialog qrcodeDialog = null;
    /**
     * 二维码支付状态查询器
     */
    private QrcodePayOrderStateScanner qrcodePayOrderStateScanner = null;
    /**
     * 二维码支付状态查询线程实例
     */
    private Thread qrcodePayOrderStateScannerThread = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.mainactivity_fragment_for_cash_create, container, false);
        ll_in_maincativity_of_fragment_create_order_for_root = (LinearLayout) rootView.findViewById(R.id.ll_in_maincativity_of_fragment_create_order_for_root);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        addCallbackEventListener(EventCode.DIALOG_CALLBACK_O_CANCLE_QRCODE_PAY);
        addCallbackEventListener(EventCode.CALLBACK_OF_QRCODE_PAY_TIMEOUT);
    }

    @Override
    protected void OnInitUiAndData() {
        // TODO Auto-generated method stub
        super.OnInitUiAndData();

        et_in_maincativity_of_fragment_create_order_for_input = (EditTextWithFrame) ll_in_maincativity_of_fragment_create_order_for_root.findViewById(R.id.et_in_maincativity_of_fragment_create_order_for_input);

        ll_in_maincativity_of_fragment_create_order_for_weixin = (LinearLayout) ll_in_maincativity_of_fragment_create_order_for_root.findViewById(R.id.ll_in_maincativity_of_fragment_create_order_for_weixin);

        ll_in_maincativity_of_fragment_create_order_for_alipay = (LinearLayout) ll_in_maincativity_of_fragment_create_order_for_root.findViewById(R.id.ll_in_maincativity_of_fragment_create_order_for_alipay);

        ll_in_maincativity_of_fragment_create_order_for_weixin.setOnClickListener(this);

        ll_in_maincativity_of_fragment_create_order_for_alipay.setOnClickListener(this);
    }

    @Override
    protected void OnBindDataWithUi() {
        // TODO Auto-generated method stub
        super.OnBindDataWithUi();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (clickViewId == R.id.ll_in_maincativity_of_fragment_create_order_for_weixin) {
            if (!TextUtils.isEmpty(et_in_maincativity_of_fragment_create_order_for_input.getText().toString()) && et_in_maincativity_of_fragment_create_order_for_input.getText().toString().trim().length() > 0) {
                ll_in_maincativity_of_fragment_create_order_for_weixin.setSelected(true);
                ll_in_maincativity_of_fragment_create_order_for_alipay.setSelected(false);

                ll_in_maincativity_of_fragment_create_order_for_weixin.setClickable(false);
                ll_in_maincativity_of_fragment_create_order_for_alipay.setClickable(false);
                createQrorderToServer(Double.valueOf(et_in_maincativity_of_fragment_create_order_for_input.getText().toString().trim()), OnlinePaymentType.WEIXIN_QRCODE_USER_SCAN, true);
            } else {
                mainActivity.toastManager.show(getString(R.string.mainactivity_of_order_create_hint));
            }
        } else if (clickViewId == R.id.ll_in_maincativity_of_fragment_create_order_for_alipay) {
            if (!TextUtils.isEmpty(et_in_maincativity_of_fragment_create_order_for_input.getText().toString()) && et_in_maincativity_of_fragment_create_order_for_input.getText().toString().trim().length() > 0) {
                ll_in_maincativity_of_fragment_create_order_for_weixin.setSelected(false);
                ll_in_maincativity_of_fragment_create_order_for_alipay.setSelected(true);

                ll_in_maincativity_of_fragment_create_order_for_weixin.setClickable(false);
                ll_in_maincativity_of_fragment_create_order_for_alipay.setClickable(false);
                createQrorderToServer(Double.valueOf(et_in_maincativity_of_fragment_create_order_for_input.getText().toString().trim()), OnlinePaymentType.ALIPAY_QRCODE_USER_SCAN, true);
            } else {
                mainActivity.toastManager.show(getString(R.string.mainactivity_of_order_create_hint));
            }
        }
    }

    /**
     * @param money
     * @param paymentType
     * @param showDialog
     */
    private void createQrorderToServer(double money, int paymentType, boolean showDialog) {
        if (showDialog) {
            DialogUtils.showLoading(mainActivity, EventCode.HTTP_POST_ORDER_CREATE);
        }
        orderForSimpleCashierUp = new OrderForSimpleCashierUp();
        orderForSimpleCashierUp.setMoney(money);
        orderForSimpleCashierUp.setPaymentType(paymentType);
        orderForSimpleCashierUp.setRepeatToken(CommonUtils.getUuidAsAToken());
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_ORDER_CREATE, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_ORDER_CREATE, 0, URLUtils.URL_ORDER_CREATE, orderForSimpleCashierUp);
    }

    /**
     * 带参数查询订单在线支付状态
     *
     * @param
     */
    protected void queryStatusForConsumeOrder(long id) {
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_GET_ORDER_QUERY_STATUS, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_GET_ORDER_QUERY_STATUS, 0, String.format(URLUtils.URL_ORDER_QUERY_STATUS, id));
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        super.onEventRunEnd(event);
        if (eventCode == EventCode.HTTP_POST_ORDER_CREATE) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_ORDER_CREATE);
            final CreateQrCodeOrderEvent createQrCodeOrderEvent = (CreateQrCodeOrderEvent) event;
            if (createQrCodeOrderEvent.isNetSuccess()) {
                if (createQrCodeOrderEvent.isOk()) {
                    if (createQrCodeOrderEvent.getResult() != null) {
                        orderResultForSimpleCashierDown = createQrCodeOrderEvent.getResult();
                        qrcodePayOrderStateScanner = new QrcodePayOrderStateScanner(false, orderResultForSimpleCashierDown.getPayTimeout(), orderResultForSimpleCashierDown.getOrderId());
                        qrcodePayOrderStateScannerThread = new Thread(qrcodePayOrderStateScanner);
                        qrcodePayOrderStateScannerThread.start();
                        qrcodeDialog = new QrcodeDialog(mainActivity, orderForSimpleCashierUp.getPaymentType(), 1,
                                orderForSimpleCashierUp.getMoney(), createQrCodeOrderEvent.getResult().getQrcode());
                        qrcodeDialog.show();
                    }
                } else {
                    ll_in_maincativity_of_fragment_create_order_for_weixin.setSelected(false);
                    ll_in_maincativity_of_fragment_create_order_for_alipay.setSelected(false);
                    ll_in_maincativity_of_fragment_create_order_for_weixin.setClickable(true);
                    ll_in_maincativity_of_fragment_create_order_for_alipay.setClickable(true);
                    if (createQrCodeOrderEvent.getErrorObject() == null) {
                        mainActivity.toastManager.show(createQrCodeOrderEvent.getStrHttpResult());
                    } else {
                        mainActivity.toastManager.show(ErrorObject.formatError(createQrCodeOrderEvent.getErrorObject()));
                    }
                }
            }

            return;
        } else if (EventCode.DIALOG_CALLBACK_O_CANCLE_QRCODE_PAY == eventCode) {
            stopQrcodePayOrderStateScanner(orderResultForSimpleCashierDown.getOrderId());
            ll_in_maincativity_of_fragment_create_order_for_weixin.setSelected(false);
            ll_in_maincativity_of_fragment_create_order_for_alipay.setSelected(false);
            ll_in_maincativity_of_fragment_create_order_for_weixin.setClickable(true);
            ll_in_maincativity_of_fragment_create_order_for_alipay.setClickable(true);
            return;
        } else if (EventCode.CALLBACK_OF_QRCODE_PAY_TIMEOUT == eventCode) {
            stopQrcodePayOrderStateScanner(orderResultForSimpleCashierDown.getOrderId());
            qrcodeDialog.dismiss();
            ll_in_maincativity_of_fragment_create_order_for_weixin.setSelected(false);
            ll_in_maincativity_of_fragment_create_order_for_alipay.setSelected(false);
            ll_in_maincativity_of_fragment_create_order_for_weixin.setClickable(true);
            ll_in_maincativity_of_fragment_create_order_for_alipay.setClickable(true);
            mainActivity.toastManager.show(mainActivity.getResources().getString(R.string.show_pay_timeout));
            return;
        } else if (eventCode == EventCode.HTTP_GET_ORDER_QUERY_STATUS) {
            final QueryStatusForQrcodeOrderEvent queryStatusForQrcodeOrderEvent = (QueryStatusForQrcodeOrderEvent) event;
            if (queryStatusForQrcodeOrderEvent.isNetSuccess()) {
                if (queryStatusForQrcodeOrderEvent.isOk()) {
                    if (queryStatusForQrcodeOrderEvent.getResult() == 2) {
                        stopQrcodePayOrderStateScanner(orderResultForSimpleCashierDown.getOrderId());
                        qrcodeDialog.dismiss();
                        ll_in_maincativity_of_fragment_create_order_for_weixin.setSelected(false);
                        ll_in_maincativity_of_fragment_create_order_for_alipay.setSelected(false);
                        ll_in_maincativity_of_fragment_create_order_for_weixin.setClickable(true);
                        ll_in_maincativity_of_fragment_create_order_for_alipay.setClickable(true);
                        et_in_maincativity_of_fragment_create_order_for_input.setText("");
                        mainActivity.toastManager.show(mainActivity.getResources().getString(R.string.show_pay_success));
                        AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(EventCode.CALLBACK_OF_QRCODE_PAY_SUCESS), 0);
                    }
                } else {
                    if (queryStatusForQrcodeOrderEvent.getErrorObject() == null) {
                        stopQrcodePayOrderStateScanner(orderResultForSimpleCashierDown.getOrderId());
                        qrcodeDialog.dismiss();
                        mainActivity.toastManager.show(queryStatusForQrcodeOrderEvent.getStrHttpResult());
                    } else {
                        mainActivity.toastManager.show(ErrorObject.formatError(queryStatusForQrcodeOrderEvent.getErrorObject()));
                    }
                }
            } else {
                stopQrcodePayOrderStateScanner(orderResultForSimpleCashierDown.getOrderId());
                qrcodeDialog.dismiss();
            }
            return;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        removeCallbackEventListener(EventCode.DIALOG_CALLBACK_O_CANCLE_QRCODE_PAY);
    }

    /**
     * @Desc:查询订单二维码支付状态线程
     * @com.sintn.hera.shop.activity.cash
     * @HuiyuantongVenusShopCash-V3.x
     * @PaymentActivity.java
     * @Author:Wxl@Sintn.Inc
     * @2015-5-9下午6:14:12
     */
    public class QrcodePayOrderStateScanner implements Runnable {
        /**
         * 是否被手动打断
         */
        private boolean interruptByHand = false;
        /**
         * 在线支付超时时间，单位毫秒
         */
        private long payTimeout;
        /**
         * 订单Id
         */
        private long orderId;

        public long getOrderId() {
            return orderId;
        }

        public void setOrderId(long orderId) {
            this.orderId = orderId;
        }

        public boolean isInterruptByHand() {
            return interruptByHand;
        }

        public void setInterruptByHand(boolean interruptByHand) {
            this.interruptByHand = interruptByHand;
        }

        public long getPayTimeout() {
            return payTimeout;
        }

        public void setPayTimeout(long payTimeout) {
            this.payTimeout = payTimeout;
        }

        public QrcodePayOrderStateScanner(boolean interruptByHand, long payTimeout, long orderId) {
            super();
            this.interruptByHand = interruptByHand;
            this.payTimeout = payTimeout;
            this.orderId = orderId;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (!interruptByHand) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    Thread.currentThread().interrupt();
                } finally {
                    if (!interruptByHand) {
                        payTimeout--;
                        if (payTimeout == 0) {
                            AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(EventCode.CALLBACK_OF_QRCODE_PAY_TIMEOUT), 0);
                            break;
                        }
                        if (payTimeout % 2 == 0) {
                            // 执行查询
                            queryStatusForConsumeOrder(orderResultForSimpleCashierDown.getOrderId());
                        }
                    }
                }
            }
        }
    }

    /**
     * 结束指定ID订单二维码支付状态查询线性
     *
     * @param orderId
     */
    protected void stopQrcodePayOrderStateScanner(long orderId) {
        if (qrcodePayOrderStateScanner != null) {
            qrcodePayOrderStateScanner.setPayTimeout(0);
            if (qrcodePayOrderStateScanner.getOrderId() == orderId) {
                if (qrcodePayOrderStateScannerThread != null && qrcodePayOrderStateScannerThread.isAlive()) {
                    // 1.先结束Runnable
                    qrcodePayOrderStateScanner.setInterruptByHand(true);
                    // 2.再打断线程
                    qrcodePayOrderStateScannerThread.interrupt();
                    qrcodePayOrderStateScannerThread = null;
                    qrcodePayOrderStateScanner = null;
                }
            }
        }
    }

}

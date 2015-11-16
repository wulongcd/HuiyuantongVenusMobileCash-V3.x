package com.sintn.hera.mobile.cash.activity.wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.entity.down.CommonPagerDown;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.up.ICUp;
import com.sintn.hera.mobile.cash.entity.up.WithdrawForCashierAppUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QuerySubRegionEvent;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;

/**
 * 
 * @Desc: 一级行业选择界面
 * @com.sintn.hera.mobile.cash.activity.main
 * @HuiyuantongVenusMobileCash-V3.x
 * @ChoiceServerActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-8下午2:11:12
 */
public class WithdrawActivity extends BaseActivity
{
	private Button btn_in_withdrawActivity_for_back = null;
	private Button btn_in_withdrawActivity_for_submit = null;
	private TextView tv_in_withdrawActivity_for_title = null;
	private LinearLayout ll_in_withdrawActivity_of_withdrawMoney = null;
	private LinearLayout ll_in_withdrawActivity_of_withdrawBank = null;
	private LinearLayout ll_in_withdrawActivity_of_withdrawPhone = null;
	private LinearLayout ll_in_withdrawActivity_of_withdrawVerification = null;
	private TextView tv_in_withdrawActivity_of_withdrawMoney = null;
	private TextView tv_in_withdrawActivity_of_withdrawBank = null;
	private TextView tv_in_withdrawActivity_of_withdrawPhone = null;
	private TextView tv_in_withdrawActivity_of_withdrawVerification = null;
	private EditText et_in_withdrawActivity_of_withdrawMoney = null;
	private EditText et_in_withdrawActivity_of_withdrawPhone = null;
	private EditText et_in_withdrawActivity_of_withdrawVerification = null;
	private Button btn_in_withdrawActivity_of_withdrawBank = null;
	private Button btn_in_withdrawActivity_of_getVerification = null;
    private WithdrawForCashierAppUp withdrawForCashierAppUp = null;
    private ICUp icUp = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void OnInitUiAndData()
	{
		// TODO Auto-generated method stub
		super.OnInitUiAndData();
		btn_in_withdrawActivity_for_back = (Button) findViewById(R.id.btn_normal_title_for_back);
		btn_in_withdrawActivity_for_submit = (Button) findViewById(R.id.btn_normal_title_for_right);
		tv_in_withdrawActivity_for_title = (TextView) findViewById(R.id.tv_normal_title_for_show_title);

		ll_in_withdrawActivity_of_withdrawMoney = (LinearLayout) findViewById(R.id.ll_in_withdrawActivity_of_withdrawMoney);
		tv_in_withdrawActivity_of_withdrawMoney = (TextView) ll_in_withdrawActivity_of_withdrawMoney.findViewById(R.id.tv_in_infoActivity_item);
		et_in_withdrawActivity_of_withdrawMoney = (EditText) ll_in_withdrawActivity_of_withdrawMoney.findViewById(R.id.et_in_infoActivity_item);

		ll_in_withdrawActivity_of_withdrawBank = (LinearLayout) findViewById(R.id.ll_in_withdrawActivity_of_withdrawBank);
		tv_in_withdrawActivity_of_withdrawBank = (TextView) ll_in_withdrawActivity_of_withdrawBank.findViewById(R.id.tv_in_editItem_of_industry);
		btn_in_withdrawActivity_of_withdrawBank = (Button) ll_in_withdrawActivity_of_withdrawBank.findViewById(R.id.btn_in_editItem_of_industry);

		ll_in_withdrawActivity_of_withdrawPhone = (LinearLayout) findViewById(R.id.ll_in_withdrawActivity_of_withdrawPhone);
		tv_in_withdrawActivity_of_withdrawPhone = (TextView) ll_in_withdrawActivity_of_withdrawPhone.findViewById(R.id.tv_in_verification_item_of_verification);
		et_in_withdrawActivity_of_withdrawPhone = (EditText) ll_in_withdrawActivity_of_withdrawPhone.findViewById(R.id.et_in_verification_item_of_verification);
		btn_in_withdrawActivity_of_getVerification = (Button) ll_in_withdrawActivity_of_withdrawPhone.findViewById(R.id.btn_in_verification_item_of_verification);

		ll_in_withdrawActivity_of_withdrawVerification = (LinearLayout) findViewById(R.id.ll_in_withdrawActivity_of_withdrawVerification);
		tv_in_withdrawActivity_of_withdrawVerification = (TextView) ll_in_withdrawActivity_of_withdrawVerification.findViewById(R.id.tv_in_infoActivity_item);
		et_in_withdrawActivity_of_withdrawVerification = (EditText) ll_in_withdrawActivity_of_withdrawVerification.findViewById(R.id.et_in_infoActivity_item);
        withdrawForCashierAppUp = new WithdrawForCashierAppUp();
        icUp = new ICUp();
	}

	@Override
	protected void OnBindDataWithUi()
	{
		// TODO Auto-generated method stub
		super.OnBindDataWithUi();
		tv_in_withdrawActivity_for_title.setText(R.string.string_of_withdraw);
		tv_in_withdrawActivity_of_withdrawMoney.setText(R.string.string_of_withdraw);
		tv_in_withdrawActivity_of_withdrawBank.setText(R.string.string_of_choose_bank);
		tv_in_withdrawActivity_of_withdrawPhone.setText(R.string.string_of_mobile_number);
		tv_in_withdrawActivity_of_withdrawVerification.setText(R.string.string_of_enterVerification);

		et_in_withdrawActivity_of_withdrawMoney.setHint("当前余额");
		btn_in_withdrawActivity_of_withdrawBank.setText(R.string.hint_string_of_choose_bank);
		et_in_withdrawActivity_of_withdrawPhone.setText(R.string.hint_string_of_mobile_number);
		et_in_withdrawActivity_of_withdrawVerification.setText(R.string.hint_string_of_enterVerification);

		btn_in_withdrawActivity_for_submit.setText(R.string.string_of_submit);
		btn_in_withdrawActivity_for_submit.setOnClickListener(this);
		btn_in_withdrawActivity_of_withdrawBank.setOnClickListener(this);
		btn_in_withdrawActivity_of_getVerification.setOnClickListener(this);
		btn_in_withdrawActivity_for_back.setOnClickListener(this);
		initWithdrawForCashierAppUp();
		withdraw(true);
	}

    /**
     * 获取验证码
     * @param isShow 是否显示加载动画
     */
    public void getVerificationCode(boolean isShow) {
        if(isShow) {
            DialogUtils.showLoading(this, EventCode.HTTP_POST_GET_VERIFICATION_CODE);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_GET_VERIFICATION_CODE, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_GET_VERIFICATION_CODE, 0, URLUtils.URL_POST_GET_VERIFICATION_CODE, icUp);
    }

	/**
	 *  提现
	 * @param isShow 是否显示加载动画
	 */
	public void withdraw(boolean isShow) {
		if(isShow) {
			DialogUtils.showLoading(this, EventCode.HTTP_POST_QUERY_WITHDRAW);
		}
		AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_QUERY_WITHDRAW, this, true);
		AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_QUERY_WITHDRAW, 0, URLUtils.URL_POST_QUERY_WITHDRAW);
	}
	/**
	 * 初始化下级地区查询上行实体
	 */
	private boolean initWithdrawForCashierAppUp() {
        if(et_in_withdrawActivity_of_withdrawMoney.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.toast_phone_not_in_patter);
            return false;
        }
        return true;
	}

	@Override
	public void onEventRunEnd(MobileCashBaseEvent event)
	{
		// TODO Auto-generated method stub
		super.onEventRunEnd(event);
		if (EventCode.HTTP_POST_QUERY_WITHDRAW == eventCode) {
			DialogUtils.dissMissLoading(EventCode.HTTP_POST_QUERY_WITHDRAW);
			final QuerySubRegionEvent querySubRegionEvent = (QuerySubRegionEvent) event;
			if (querySubRegionEvent.isNetSuccess()) {
				if (querySubRegionEvent.isOk()) {
					if (querySubRegionEvent.getResult() != null) {
						CommonPagerDown commonPagerDown = querySubRegionEvent.getResult();
					}
				} else {
					if (querySubRegionEvent.getErrorObject() == null) {
						toastManager.show(querySubRegionEvent.getStrHttpResult());
					} else {
						toastManager.show(ErrorObject.formatError(querySubRegionEvent.getErrorObject()));
					}
				}
			}
		}
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		super.onClick(v);
		switch (clickedViewId) {
			case R.id.btn_normal_title_for_back:
				onBackPressed();
				break;
			case R.id.btn_normal_title_for_right:
				break;
            case R.id.btn_in_verification_item_of_verification:
                if(et_in_withdrawActivity_of_withdrawPhone.getText().toString().trim().length() <= 0) {
                    toastManager.show(R.string.string_of_mobile_number_is_null);
                } else {
                    icUp.setPhone(et_in_withdrawActivity_of_withdrawPhone.getText().toString().trim());
                    getVerificationCode(true);
                }
                break;
			default:
				break;
		}
	}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK) {
        }
    }

    @Override
	protected void onInitAttribute(ActivityBaseAttribute ba)
	{
		super.onInitAttribute(ba);
		ba.setHasNavigationBar(false);
	}

	public static void launch(Activity activity, String code)
	{
		if (!CommonUtils.isActivityAreRunningBefore(activity, WithdrawActivity.class))
		{
			Intent intent = new Intent(activity, WithdrawActivity.class);
			intent.putExtra("code", code);
			activity.startActivityForResult(intent, 0);
		}
	}

	@Override
	public void onBackPressed()
	{
		// TODO Auto-generated method stub
		super.onBackPressed();
		this.finish();
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
	}
}

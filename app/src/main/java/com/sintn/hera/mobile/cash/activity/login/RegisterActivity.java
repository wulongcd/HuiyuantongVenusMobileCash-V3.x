package com.sintn.hera.mobile.cash.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.entity.down.CategoryForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.up.EnterpriseRegisterForCashierAppUp;
import com.sintn.hera.mobile.cash.entity.up.ICUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.RegisterEnterpriseInfoEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.GetVerificationCodeEvent;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.utils.common.PartternUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 注册界面
 * @com.sintn.hera.mobile.cash.activity.login
 * @HuiyuantongVenusWokerAssistant-V3.x
 * @LoginActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-8-4下午4:51:01
 */

public class RegisterActivity extends BaseActivity {
    private Button btn_in_registerActivity_of_back;
    private Button btn_in_registerActivity_of_right;
    private TextView tv_in_registerActivity_of_title;
    private EditText et_in_registerActivity_of_enterprise = null;
    private EditText et_in_registerActivity_of_address = null;
    private EditText et_in_registerActivity_of_phone = null;
    private EditText et_in_registerActivity_of_verification = null;
    private EditText et_in_registerActivity_of_enterpriseAccount = null;
    private EditText et_in_registerActivity_of_setPassword = null;
    private EditText et_in_registerActivity_of_ensurePassword = null;
    private Button btn_in_registerActivity_of_industry = null;
    private Button btn_in_registerActivity_of_verification = null;
    private EnterpriseRegisterForCashierAppUp enterpriseRegisterForCashierAppUp = null;
    private ICUp icUp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void OnInitUiAndData() {
        // TODO Auto-generated method stub
        super.OnInitUiAndData();
        Intent intent = getIntent();
        btn_in_registerActivity_of_back = (Button) findViewById(R.id.btn_normal_title_for_back);
        btn_in_registerActivity_of_right = (Button) findViewById(R.id.btn_normal_title_for_right);
        btn_in_registerActivity_of_industry = (Button) findViewById(R.id.btn_in_editItem_of_industry);
        btn_in_registerActivity_of_verification = (Button) findViewById(R.id.btn_in_registerActivity_of_verification);
        tv_in_registerActivity_of_title = (TextView) findViewById(R.id.tv_normal_title_for_show_title);
        et_in_registerActivity_of_enterprise = (EditText) findViewById(R.id.et_in_registerActivity_of_enterprise);
        et_in_registerActivity_of_address = (EditText) findViewById(R.id.et_in_registerActivity_of_address);
        et_in_registerActivity_of_phone = (EditText) findViewById(R.id.et_in_registerActivity_of_phone);
        et_in_registerActivity_of_verification = (EditText) findViewById(R.id.et_in_registerActivity_of_verification);
        et_in_registerActivity_of_enterpriseAccount = (EditText) findViewById(R.id.et_in_registerActivity_of_enterpriseAccount);
        et_in_registerActivity_of_setPassword = (EditText) findViewById(R.id.et_in_registerActivity_of_setPassword);
        et_in_registerActivity_of_ensurePassword = (EditText) findViewById(R.id.et_in_registerActivity_of_ensurePassword);
        enterpriseRegisterForCashierAppUp = new EnterpriseRegisterForCashierAppUp();
        icUp = new ICUp();
    }

    @Override
    protected void OnBindDataWithUi() {
        // TODO Auto-generated method stub
        super.OnBindDataWithUi();
        tv_in_registerActivity_of_title.setText(R.string.register);
        btn_in_registerActivity_of_right.setText(R.string.string_of_submit);
        btn_in_registerActivity_of_back.setOnClickListener(this);
        btn_in_registerActivity_of_right.setOnClickListener(this);
        btn_in_registerActivity_of_industry.setOnClickListener(this);
        btn_in_registerActivity_of_verification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        super.onClick(v);
        switch (clickedViewId) {
            case R.id.btn_normal_title_for_back:
                onBackPressed();
                break;
            case R.id.btn_normal_title_for_right:
                if(initEnterpriseRegisterForCashierAppUp()) {
                    register(true);
                }
                break;
            case R.id.btn_in_editItem_of_industry:
                FirstCategoryActivity.launch(this);
                break;
            case R.id.btn_in_registerActivity_of_verification:
                if(et_in_registerActivity_of_phone.getText().toString().trim().length() <= 0) {
                    toastManager.show(R.string.enterprisePhone_is_null);
                } else {
                    icUp.setPhone(et_in_registerActivity_of_phone.getText().toString().trim());
                    getVerificationCode(true);
                }
                break;
            default:
                break;
        }
    }

    /**
     * 注册企业信息
     * @param isShow 是否显示加载动画
     */
    public void register(boolean isShow) {
        if(isShow) {
            DialogUtils.showLoading(this, EventCode.HTTP_POST_REGISTER_ENTERPRISE);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_REGISTER_ENTERPRISE, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_REGISTER_ENTERPRISE, 0, URLUtils.URL_POST_REGISTER_ENTERPRISE, enterpriseRegisterForCashierAppUp);
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
     * 初始化企业注册上行实体
     */
    private boolean initEnterpriseRegisterForCashierAppUp() {
        if(et_in_registerActivity_of_enterprise.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.enterpriseName_is_null);
            return false;
        }
        if(btn_in_registerActivity_of_industry.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.industry_is_null);
            return false;
        }
        if(et_in_registerActivity_of_address.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.address_is_null);
            return false;
        }
        if(et_in_registerActivity_of_enterpriseAccount.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.enterpriseAccount_is_null);
            return false;
        }
        if(et_in_registerActivity_of_phone.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.enterprisePhone_is_null);
            return false;
        } else if(!PartternUtil.isMobilePone(et_in_registerActivity_of_phone.getText().toString().trim())) {
            toastManager.show(R.string.toast_phone_not_in_patter);
            return false;
        }
        if(et_in_registerActivity_of_verification.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.verificationCode_null);
            return false;
        }
        if(et_in_registerActivity_of_setPassword.getText().toString().trim().length() > 20 || et_in_registerActivity_of_setPassword.getText().toString().trim().length() <= 0) {
            if(et_in_registerActivity_of_setPassword.getText().toString().trim().length() <= 0) {
                toastManager.show(R.string.password_is_null);
            } else if(et_in_registerActivity_of_setPassword.getText().toString().trim().length() < 6) {
                toastManager.show(R.string.password_is_short);
            } else {
                toastManager.show(R.string.password_is_long);
            }
            return false;
        }
        if(et_in_registerActivity_of_setPassword.getText().toString().trim().length() > 20 || et_in_registerActivity_of_setPassword.getText().toString().trim().length() <= 0) {
            if(et_in_registerActivity_of_ensurePassword.getText().toString().trim().length() <= 0) {
                toastManager.show(R.string.ensurePassword_is_null);
            } else if(et_in_registerActivity_of_setPassword.getText().toString().trim().length() < 6) {
                toastManager.show(R.string.ensurePassword_is_short);
            } else {
                toastManager.show(R.string.ensurePassword_is_long);
            }
            return false;
        }
        if(!et_in_registerActivity_of_ensurePassword.getText().toString().trim().equals(et_in_registerActivity_of_setPassword.getText().toString().trim())) {
            toastManager.show(R.string.ensurePassword_not_equal_password);
            return false;
        }
        enterpriseRegisterForCashierAppUp.setUsername(et_in_registerActivity_of_enterpriseAccount.getText().toString().trim());
        enterpriseRegisterForCashierAppUp.setAddress(et_in_registerActivity_of_address.getText().toString().trim());
        enterpriseRegisterForCashierAppUp.setPhone(et_in_registerActivity_of_phone.getText().toString().trim());
        enterpriseRegisterForCashierAppUp.setCode(et_in_registerActivity_of_verification.getText().toString().trim());
        enterpriseRegisterForCashierAppUp.setName(et_in_registerActivity_of_enterprise.getText().toString().trim());
        enterpriseRegisterForCashierAppUp.setPassword(et_in_registerActivity_of_setPassword.getText().toString().trim());
        return true;
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        // TODO Auto-generated method stub
        super.onEventRunEnd(event);
        if (EventCode.HTTP_POST_REGISTER_ENTERPRISE == eventCode) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_REGISTER_ENTERPRISE);
            final RegisterEnterpriseInfoEvent querySecondCategoryEvent = (RegisterEnterpriseInfoEvent) event;
            if (querySecondCategoryEvent.isNetSuccess()) {
                if (querySecondCategoryEvent.isOk()) {
                    if ("ok".equals(querySecondCategoryEvent.getResult())) {
                        toastManager.show(R.string.register_success);
                        login(et_in_registerActivity_of_enterpriseAccount.getText().toString().trim(), et_in_registerActivity_of_setPassword.getText().toString().trim());
                    }
                } else {
                    if (querySecondCategoryEvent.getErrorObject() == null) {
                        toastManager.show(querySecondCategoryEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(querySecondCategoryEvent.getErrorObject()));
                    }
                }
            }
        } else if (EventCode.HTTP_POST_GET_VERIFICATION_CODE == eventCode) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_GET_VERIFICATION_CODE);
            final GetVerificationCodeEvent getVerificationCodeEvent = (GetVerificationCodeEvent) event;
            if (getVerificationCodeEvent.isNetSuccess()) {
                if (getVerificationCodeEvent.isOk()) {
                    if ("ok".equals(getVerificationCodeEvent.getResult())) {
                        toastManager.show(R.string.verificationCode_is_send);
                    }
                } else {
                    if (getVerificationCodeEvent.getErrorObject() == null) {
                        toastManager.show(getVerificationCodeEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(getVerificationCodeEvent.getErrorObject()));
                    }
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK) {
            List list1 = data.getCharSequenceArrayListExtra("firstCategories");
            String industry = ((CategoryForCashierAppDown) list1.get(0)).getName();
            List list2 = data.getCharSequenceArrayListExtra("secondCategories");
            List<Long> categoryIds = new ArrayList<Long>();
            for(int i=0;i<list2.size();i++) {
                if(list2.get(i) != null) {
                    if(i == 0) {
                        industry += "：" + ((CategoryForCashierAppDown) list2.get(i)).getName();
                    } else {
                        industry += "/" + ((CategoryForCashierAppDown) list2.get(i)).getName();
                    }
                    categoryIds.add(((CategoryForCashierAppDown) list2.get(i)).getId());
                }
            }
            btn_in_registerActivity_of_industry.setText(industry);
            enterpriseRegisterForCashierAppUp.setCategory1Id(((CategoryForCashierAppDown) list1.get(0)).getId());
            enterpriseRegisterForCashierAppUp.setCategory2Ids(categoryIds);
        }
    }

    @Override
    protected void onInitAttribute(ActivityBaseAttribute ba) {
        super.onInitAttribute(ba);
        ba.setHasNavigationBar(false);
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }

    public static void lunch(Activity activity) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, RegisterActivity.class)) {
            Intent intent = new Intent();
            intent.setClass(activity, RegisterActivity.class);
            activity.startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

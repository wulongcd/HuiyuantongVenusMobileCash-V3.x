package com.sintn.hera.mobile.cash.activity.wallet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.sintn.hera.assistant.EventCode;
import com.sintn.hera.assistant.R;
import com.sintn.hera.assistant.URLUtils;
import com.sintn.hera.assistant.activity.base.BaseActivity;
import com.sintn.hera.assistant.adapter.ListAdapterInWalletWithdrawalsActivityForBingBankChoice;
import com.sintn.hera.assistant.entity.down.BindingBankCardDown;
import com.sintn.hera.assistant.entity.down.ErrorObject;
import com.sintn.hera.assistant.entity.show.ChoiceServerListShow;
import com.sintn.hera.assistant.entity.up.ICUp;
import com.sintn.hera.assistant.entity.up.WithdrawUp;
import com.sintn.hera.assistant.event.BossAssistantBaseCallbackEvent;
import com.sintn.hera.assistant.event.BossAssistantBaseEvent;
import com.sintn.hera.assistant.event.httpevent.main.GetIndentifyCodeEvent;
import com.sintn.hera.assistant.event.httpevent.main.QueryBindingBankCardEvent;
import com.sintn.hera.assistant.event.httpevent.main.WalletWithdrawEvent;
import com.sintn.hera.assistant.manager.ActivityBaseAttribute;
import com.sintn.hera.assistant.manager.AndroidEventManager;
import com.sintn.hera.assistant.utils.common.CommonUtils;
import com.sintn.hera.assistant.utils.common.DialogUtils;
import com.sintn.hera.assistant.utils.common.PartternUtil;
import com.sintn.hera.assistant.widget.view.EditTextWithFrame;

/**
 * 
 * @Desc: 钱包提现界面
 * @com.sintn.hera.assistant.activity.main.wallet
 * @HuiyuantongVenusBossAssistant-V3.x
 * @WalletWithdrawalsActivty.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-8下午4:12:36
 */
@SuppressLint("HandlerLeak")
public class WalletWithdrawalsActivty extends BaseActivity
{
	public final static int CODEGETWAITINGER = 2030;
	public final static int CODEGETWAITINTIME = 60;
	public static String CODEGETWAITINGERSTRING = "back";
	private WithdrawUp withdrawUp = null;
//	private Spinner sp_in_walletwithdrawalsactivty_for_cards = null;// 银行卡选择
	private RelativeLayout rl_in_walletwithdrawalsactivity_for_show_bank = null;// 
	private Button btn_in_walletwithdrawalsactivity_for_show_bankList = null;
	private ImageView iv_in_walletwithdrawalsactivity_for_bankList_arrow = null;
	private ListView lv_in_walletwithdrawlsactivity_for_bankList = null;
	private LinearLayout ll_in_walletwithdrawlsactivity_for_content = null;
	private boolean isShowList = false;
	private ListAdapterInWalletWithdrawalsActivityForBingBankChoice<BindingBankCardDown> listAdapter = null;
//	private SpinnerAdapterInWalletWithdrawalsActivityForBingBankChoice<BindingBankCardDown> spAdpter = null;
	private EditTextWithFrame et_in_walletwithdrawalsactivty_for_money = null;// 金额
	private EditTextWithFrame et_in_walletwithdrawalsactivty_for_phone = null;// 手机
	private EditTextWithFrame et_in_walletwithdrawalsactivty_for_code = null;// 验证码
	private Button btn_in_walletwithdrawalsactivty_for_get_code = null;// 获取验证码
	private CodeGetWaitinger codeGetWaitinger = null;
	private Handler codeGetWaitingerHandler = new Handler()
	{

		@Override
		public void handleMessage(Message msg)
		{
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			super.handleMessage(msg);
			switch (msg.what)
			{
			case CODEGETWAITINGER:
				int nowtime = msg.getData().getInt(CODEGETWAITINGERSTRING);
				if (nowtime == 0)
				{
					codeGetWaitinger.setInterrupted(true);
					btn_in_walletwithdrawalsactivty_for_get_code.setClickable(true);
					btn_in_walletwithdrawalsactivty_for_get_code.setText("获取验证码");
				} else
				{
					btn_in_walletwithdrawalsactivty_for_get_code.setClickable(false);
					btn_in_walletwithdrawalsactivty_for_get_code.setText(nowtime + "秒后可重试");
				}
				break;
			default:
				break;
			}
		}

	};

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
		withdrawUp = new WithdrawUp();
//		sp_in_walletwithdrawalsactivty_for_cards = (Spinner) findViewById(R.id.sp_in_walletwithdrawalsactivty_for_cards);// 银行卡选择
//		sp_in_walletwithdrawalsactivty_for_cards.setOnItemSelectedListener(new OnItemSelectedListener()
//		{
//
//			@Override
//			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
//			{
//				// TODO Auto-generated method stub
//				withdrawUp.setBindingBankCardId(spAdpter.getlistObject().get(position).getId());
//			}
//
//			@Override
//			public void onNothingSelected(AdapterView<?> parent)
//			{
//				// TODO Auto-generated method stub
//
//			}
//		});
		rl_in_walletwithdrawalsactivity_for_show_bank = (RelativeLayout) findViewById(R.id.rl_in_walletwithdrawalsactivity_for_show_bank);
		rl_in_walletwithdrawalsactivity_for_show_bank.setOnClickListener(this);
		btn_in_walletwithdrawalsactivity_for_show_bankList = (Button) findViewById(R.id.btn_in_walletwithdrawalsactivity_for_show_bankList);
		iv_in_walletwithdrawalsactivity_for_bankList_arrow = (ImageView) findViewById(R.id.iv_in_walletwithdrawalsactivity_for_bankList_arrow);
		lv_in_walletwithdrawlsactivity_for_bankList = (ListView) findViewById(R.id.lv_in_walletwithdrawlsactivity_for_bankList);
		lv_in_walletwithdrawlsactivity_for_bankList.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
			{
				BindingBankCardDown bankCard = listAdapter.getlistObject().get(position);
				String str = "请选择银行和账户";
				if(position != 0) {
					str = bankCard.getBankName()+"("+bankCard.getCardCode()+")";
				}
				btn_in_walletwithdrawalsactivity_for_show_bankList.setText(str);
				withdrawUp.setBindingBankCardId(bankCard.getId());
				hideList();
			}
		});
		ll_in_walletwithdrawlsactivity_for_content = (LinearLayout) findViewById(R.id.ll_in_walletwithdrawlsactivity_for_content);
		
		et_in_walletwithdrawalsactivty_for_money = (EditTextWithFrame) findViewById(R.id.et_in_walletwithdrawalsactivty_for_money);// 金额
		et_in_walletwithdrawalsactivty_for_phone = (EditTextWithFrame) findViewById(R.id.et_in_walletwithdrawalsactivty_for_phone);// 手机
		et_in_walletwithdrawalsactivty_for_code = (EditTextWithFrame) findViewById(R.id.et_in_walletwithdrawalsactivty_for_code);// 验证码
		btn_in_walletwithdrawalsactivty_for_get_code = (Button) findViewById(R.id.btn_in_walletwithdrawalsactivty_for_get_code);// 获取验证码
		btn_in_walletwithdrawalsactivty_for_get_code.setOnClickListener(this);
		findViewById(R.id.ll_in_walletwithdrawalsactivty_for_sure).setOnClickListener(this);
//		spAdpter = new SpinnerAdapterInWalletWithdrawalsActivityForBingBankChoice<BindingBankCardDown>(mContext);
		listAdapter = new ListAdapterInWalletWithdrawalsActivityForBingBankChoice<BindingBankCardDown>(mContext);
		listAdapter.addItem(new BindingBankCardDown());
	}

	@Override
	protected void OnBindDataWithUi()
	{
		// TODO Auto-generated method stub
		super.OnBindDataWithUi();
//		sp_in_walletwithdrawalsactivty_for_cards.setAdapter(spAdpter);
		lv_in_walletwithdrawlsactivity_for_bankList.setAdapter(listAdapter);
		queryBingBankCardDowns(true);
	}

	/**
	 * 查询绑定的银行卡列表
	 * 
	 * @param showDialog
	 */
	protected void queryBingBankCardDowns(boolean showDialog)
	{
		if (showDialog)
		{
			DialogUtils.showLoading(mContext, EventCode.HTTP_POST_QUERYBINDINGBANKCARD);
		}
		AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_QUERYBINDINGBANKCARD, this, true);
		AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_QUERYBINDINGBANKCARD, 0, URLUtils.URL_QUERYBINDINGBANKCARD);
	}

	/**
	 * 获取验证码
	 * 
	 * @param iCUp
	 * @param showDialog
	 */
	protected void getIndentifyCode(ICUp iCUp, boolean showDialog)
	{
		if (codeGetWaitinger == null)
		{
			codeGetWaitinger = new CodeGetWaitinger(CODEGETWAITINTIME);
		} else
		{
			codeGetWaitinger.setInterrupted(true);
			codeGetWaitinger = new CodeGetWaitinger(CODEGETWAITINTIME);
		}
		new Thread(codeGetWaitinger).start();
		if (showDialog)
		{
			DialogUtils.showLoading(mContext, EventCode.HTTP_POST_GETIDENTIFYINGCODE);
		}
		AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_GETIDENTIFYINGCODE, this, true);
		AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_GETIDENTIFYINGCODE, 0, URLUtils.URL_GETIDENTIFYINGCODE, iCUp);
	}

	/**
	 * 钱包提现
	 * 
	 * @param withdrawUp
	 * @param showDialog
	 */
	protected void walletWithdraw(WithdrawUp withdrawUp, boolean showDialog)
	{
		if (showDialog)
		{
			DialogUtils.showLoading(mContext, EventCode.HTTP_POST_WALLET_WITHDRAW);
		}
		AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_WALLET_WITHDRAW, this, true);
		AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_WALLET_WITHDRAW, 0, URLUtils.URL_WALLET_WITHDRAW, withdrawUp);
	}

	@Override
	public void onEventRunEnd(BossAssistantBaseEvent event)
	{
		// TODO Auto-generated method stub
		super.onEventRunEnd(event);
		if (eventCode == EventCode.HTTP_POST_QUERYBINDINGBANKCARD)
		{
			DialogUtils.dissMissLoading(EventCode.HTTP_POST_QUERYBINDINGBANKCARD);
			final QueryBindingBankCardEvent queryBindingBankCardEvent = (QueryBindingBankCardEvent) event;
			if (queryBindingBankCardEvent.isNetSuccess())
			{
				if (queryBindingBankCardEvent.isOk())
				{
					if (queryBindingBankCardEvent.getResult() != null)
					{
						listAdapter.addAllItem(queryBindingBankCardEvent.getResult());
					}
					return;
				} else
				{
					if (queryBindingBankCardEvent.getErrorObject() == null)
					{
						toastManager.show(queryBindingBankCardEvent.getStrHttpResult());
					} else
					{
						toastManager.show(ErrorObject.formatError(queryBindingBankCardEvent.getErrorObject()));
					}
					return;
				}
			}
		} else if (eventCode == EventCode.HTTP_POST_GETIDENTIFYINGCODE)
		{
			DialogUtils.dissMissLoading(EventCode.HTTP_POST_GETIDENTIFYINGCODE);
			final GetIndentifyCodeEvent getIndentifyCodeEvent = (GetIndentifyCodeEvent) event;
			if (getIndentifyCodeEvent.isNetSuccess())
			{
				if (getIndentifyCodeEvent.isOk())
				{
					if (getIndentifyCodeEvent.getResult() != null && getIndentifyCodeEvent.getResult().equals("ok"))
					{
						toastManager.show("验证码已经成功通过短信发送到手机：" + et_in_walletwithdrawalsactivty_for_phone.getText().toString().trim());
					}
					return;
				} else
				{
					if (getIndentifyCodeEvent.getErrorObject() == null)
					{
						toastManager.show(getIndentifyCodeEvent.getStrHttpResult());
					} else
					{
						toastManager.show(ErrorObject.formatError(getIndentifyCodeEvent.getErrorObject()));
					}
					return;
				}
			}

		} else if (eventCode == EventCode.HTTP_POST_WALLET_WITHDRAW)
		{
			DialogUtils.dissMissLoading(EventCode.HTTP_POST_WALLET_WITHDRAW);
			final WalletWithdrawEvent walletWithdrawEvent = (WalletWithdrawEvent) event;
			if (walletWithdrawEvent.isNetSuccess())
			{
				if (walletWithdrawEvent.isOk())
				{
					if (walletWithdrawEvent.getResult() != null && walletWithdrawEvent.getResult().equals("ok"))
					{
						toastManager.show("成功，提现金额将会在24小时内到账！");
						AndroidEventManager.getInstance().postEvent(new BossAssistantBaseCallbackEvent(EventCode.CALLBACK_OF_WALLET_WITHDRAW_OK), 0, withdrawUp.getValue());
						finish();
					}
					return;
				} else
				{
					if (walletWithdrawEvent.getErrorObject() == null)
					{
						toastManager.show(walletWithdrawEvent.getStrHttpResult());
					} else
					{
						toastManager.show(ErrorObject.formatError(walletWithdrawEvent.getErrorObject()));
					}
					return;
				}
			}
		}
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		super.onClick(v);
		if (clickedViewId == R.id.btn_in_walletwithdrawalsactivty_for_get_code)
		{
			if (!TextUtils.isEmpty(et_in_walletwithdrawalsactivty_for_phone.getText()))
			{
				if (PartternUtil.isMobilePone(et_in_walletwithdrawalsactivty_for_phone.getText().toString().trim()))
				{
					getIndentifyCode(new ICUp(et_in_walletwithdrawalsactivty_for_phone.getText().toString().trim()), true);
					return;
				} else
				{
					toastManager.show("手机号格式不正确");
					return;
				}
			} else
			{
				toastManager.show("请先输入手机号");
				return;
			}
		} else if (clickedViewId == R.id.ll_in_walletwithdrawalsactivty_for_sure)
		{
			if (TextUtils.isEmpty(et_in_walletwithdrawalsactivty_for_money.getText()))
			{
				toastManager.show("请先输入提现金额");
				return;
			} else
			{
				withdrawUp.setValue(Double.valueOf(et_in_walletwithdrawalsactivty_for_money.getText().toString().trim()));
			}
			if (TextUtils.isEmpty(et_in_walletwithdrawalsactivty_for_phone.getText()))
			{
				toastManager.show("请先输入手机号");
				return;
			} else
			{
				withdrawUp.setPhone(et_in_walletwithdrawalsactivty_for_phone.getText().toString().trim());
			}
			if (TextUtils.isEmpty(et_in_walletwithdrawalsactivty_for_code.getText()))
			{
				toastManager.show("请输入正确的验证码");
				return;
			} else
			{
				withdrawUp.setCode(et_in_walletwithdrawalsactivty_for_code.getText().toString().trim());
			}
			withdrawUp.setToken(CommonUtils.getUuidAsAToken());
			walletWithdraw(withdrawUp, true);
			return;
		} else if (clickedViewId == R.id.rl_in_walletwithdrawalsactivity_for_show_bank) {
			if(isShowList) {
				hideList();
			}else {
				showList();
			}
		}
	}

	private void showList()
	{
		lv_in_walletwithdrawlsactivity_for_bankList.setVisibility(View.VISIBLE);
		ll_in_walletwithdrawlsactivity_for_content.setVisibility(View.GONE);
		iv_in_walletwithdrawalsactivity_for_bankList_arrow.setBackgroundResource(R.drawable.arrow_up);
		isShowList = true;
	}

	private void hideList()
	{
		lv_in_walletwithdrawlsactivity_for_bankList.setVisibility(View.GONE);
		ll_in_walletwithdrawlsactivity_for_content.setVisibility(View.VISIBLE);
		iv_in_walletwithdrawalsactivity_for_bankList_arrow.setBackgroundResource(R.drawable.arrow_down);
		isShowList = false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// TODO Auto-generated method stub
		super.onItemClick(parent, view, position, id);
		Object object = parent.getItemAtPosition(position);
		if (object != null)
		{
			if (object instanceof ChoiceServerListShow)
			{
				ChoiceServerListShow c = (ChoiceServerListShow) object;
				AndroidEventManager.getInstance().postEvent(new BossAssistantBaseCallbackEvent(EventCode.CALLBACK_OF_CHOICESERVER_OK), 0, c.getDesc());
				finish();
			}
		}
	}

	@Override
	protected void onInitAttribute(ActivityBaseAttribute ba)
	{
		super.onInitAttribute(ba);
		ba.setHasBackButton(true);
		ba.setNavigationBarBackground(getResources().getColor(R.color.cf0f0f0));
		ba.setTextViewInNavigationBarStringId(R.string.man_walletwithdrawalsactivty_show);
		ba.setTextViewInNavigationBarColor(Color.BLACK);
		ba.setHasImageViewCtener(false);
	}

	public static void launch(Activity activity)
	{
		if (!CommonUtils.isActivityAreRunningBefore(activity, WalletWithdrawalsActivty.class))
		{
			Intent intent = new Intent(activity, WalletWithdrawalsActivty.class);
			activity.startActivity(intent);
		}
	}

	@Override
	public void onBackPressed()
	{
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	protected void onDestroy()
	{
		if (codeGetWaitinger != null)
		{
			codeGetWaitinger.setInterrupted(true);
		}
		withdrawUp = null;
//		sp_in_walletwithdrawalsactivty_for_cards = null;// 银行卡选择
		 rl_in_walletwithdrawalsactivity_for_show_bank = null;// 
		 btn_in_walletwithdrawalsactivity_for_show_bankList = null;
		 iv_in_walletwithdrawalsactivity_for_bankList_arrow = null;
		 lv_in_walletwithdrawlsactivity_for_bankList = null;
		listAdapter.getlistObject().clear();
		listAdapter = null;
		et_in_walletwithdrawalsactivty_for_money = null;// 金额
		et_in_walletwithdrawalsactivty_for_phone = null;// 手机
		et_in_walletwithdrawalsactivty_for_code = null;// 验证码
		btn_in_walletwithdrawalsactivty_for_get_code = null;// 获取验证码
		codeGetWaitingerHandler = null;
		codeGetWaitinger = null;
		super.onDestroy();
	}

	/**
	 * 
	 * @Desc: 验证码等待器
	 * @com.sintn.hera.assistant.activity.main.wallet
	 * @HuiyuantongVenusBossAssistant-V3.x
	 * @WalletWithdrawalsActivty.java
	 * @Author:Wxl@Sintn.Inc
	 * @2015-7-9上午9:46:41
	 */
	public class CodeGetWaitinger implements Runnable
	{
		private int times = -1;
		private boolean interrupted = false;

		public CodeGetWaitinger(int times)
		{
			super();
			this.times = times;
		}

		public int getTimes()
		{
			return times;
		}

		public void setTimes(int times)
		{
			this.times = times;
		}

		public boolean isInterrupted()
		{
			return interrupted;
		}

		public void setInterrupted(boolean interrupted)
		{
			this.interrupted = interrupted;
		}

		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			while (times-- == 0 || !interrupted)
			{
				try
				{
					Thread.sleep(1000 * 1);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					Thread.currentThread().interrupt();
				} finally
				{
					if (times >= 0)
					{
						try
						{
							Message msgMessage = new Message();
							msgMessage.what = CODEGETWAITINGER;
							Bundle bundle = new Bundle();
							bundle.putInt(CODEGETWAITINGERSTRING, times);
							msgMessage.setData(bundle);
							if (codeGetWaitingerHandler != null)
							{
								codeGetWaitingerHandler.sendMessage(msgMessage);
							}

						} catch (Exception e2)
						{
							// TODO: handle exception
							Thread.currentThread().interrupt();
						}

					}
				}
			}
		}

	}
}

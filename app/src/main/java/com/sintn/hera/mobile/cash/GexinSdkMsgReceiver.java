package com.sintn.hera.mobile.cash;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;
import com.sintn.hera.mobile.cash.entity.PushBaseEntity;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;
import com.sintn.hera.mobile.cash.utils.core.EventManager.OnEventListener;

@SuppressLint("ShowToast")
public class GexinSdkMsgReceiver extends BroadcastReceiver implements OnEventListener
{
	public final static String EXTRA_PREORDER = "preOder";
	private PushBaseEntity pushBaseEntity;

	@Override
	public void onReceive(Context context, Intent intent)
	{
		Bundle bundle = intent.getExtras();
		Log.d("GexinSdkMsgReceiver", "onReceive() action=" + bundle.getInt("action"));
		switch (bundle.getInt(PushConsts.CMD_ACTION))
		{

		case PushConsts.GET_MSG_DATA:
			// 获取透传数据
			String appid = bundle.getString("appid");
			System.out.println("appid->" + appid);
			byte[] payload = bundle.getByteArray("payload");
			String taskid = bundle.getString("taskid");
			String messageid = bundle.getString("messageid");
			// smartPush第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
			boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
			System.out.println("第三方回执接口调用" + (result ? "成功" : "失败"));
			if (payload != null)
			{
				String data = new String(payload);
				pushBaseEntity = (PushBaseEntity) JsonCommonUtils.jsonToObject(data, PushBaseEntity.class);
				getPushBaseEntity(pushBaseEntity);
				Log.d("GexinSdkMsgReceiver", "Got Payload:" + data);
			}
			break;
		case PushConsts.GET_CLIENTID:
			// 获取ClientID(CID)
			// 第三方应用需要将CID上传到第三方服务器，并且将当前用户帐号和CID进行关联，以便日后通过用户帐号查找CID进行消息推送
			String cid = bundle.getString("clientid");
			System.out.println("clientid->" + cid);
			BaseApplication.registDevice(0, bundle.getString("clientid"));
			break;
		case PushConsts.THIRDPART_FEEDBACK:
			String _appid = bundle.getString("appid");
			String _taskid = bundle.getString("taskid");
			String _actionid = bundle.getString("actionid");
			String _result = bundle.getString("result");
			long _timestamp = bundle.getLong("timestamp");

			Log.d("GexinSdkMsgReceiver", "appid = " + _appid);
			Log.d("GexinSdkMsgReceiver", "taskid = " + _taskid);
			Log.d("GexinSdkMsgReceiver", "actionid = " + _actionid);
			Log.d("GexinSdkMsgReceiver", "result = " + _result);
			Log.d("GexinSdkMsgReceiver", "timestamp = " + _timestamp);
			break;
		default:
			break;
		}
	}

	/**
	 * 处理信息
	 * 
	 * @param pushBaseEntity
	 */
	private void getPushBaseEntity(PushBaseEntity pushBaseEntity)
	{
		if (pushBaseEntity != null)
		{
			if (!BaseApplication.isLogined())
			{
				return;
			}
			switch (pushBaseEntity.getType())
			{
			// case PushFlagType.NOTIFICATION:// 通知
			// countOfNotificationsChangeSynchro();
			// break;
			// case PushFlagType.CHANGE_SHOP_RELATED_INFO://
			// 数据改变->店铺相关信息（企业、店铺、店铺管理员、店铺员工）
			// shopRealInfoSynchro();
			// break;
			// case PushFlagType.CHANGE_SHOP_PRODUCT_RELATED_INFO://
			// 数据改变->店铺商品相关信息（商品分类、商品类型）
			// shopProductRealInfoSynchro();
			// break;
			// case PushFlagType.CHANGE_SHOP_SALE_PROMOTION_INFO://
			// 数据改变->店铺优惠相关信息（会员卡类型、套餐类型、套餐明细、
			// // 代金券类型、折扣券类型、特殊折扣、折扣券折扣、消费赠送规则、充值赠送规则）
			// shopSalePromotionSynchro();
			// break;
			// case PushFlagType.CHANGE_SHOP_OTHER_INFO://
			// 数据改变->店铺其他信息（时间戳、软件版本、mac地址）
			// shopOtherInfoSynchro();
			// break;
			// case PushFlagType.SUBSCRIBE:// 数据改变->预约
			// countOfUndealSubcribeChangeSynchro();
			// break;
			// case PushFlagType.CLOSE_CASHIER_ACCOUNT:// 数据改变->关闭收银点账号信息同步
			// AndroidEventManager.getInstance().postEvent(new
			// MobileCashBaseCallbackEvent(EventCode.CALLBACK_CLOSE_CASHIER_ACCOUNT),
			// 0);
			// break;
			// case PushFlagType.SAME_ACCOUNT_ANOTHER_PLACE_LOGIN://
			// 数据改变->相同账户在另一个地方登录
			// AndroidEventManager.getInstance().postEvent(new
			// MobileCashBaseCallbackEvent(EventCode.CALLBACK_SAME_ACCOUNT_ANOTHER_PLACE_LOGIN),
			// 0);
			// break;
			// case PushFlagType.DELETE_SHOP:// 数据改变->店铺被删除
			// AndroidEventManager.getInstance().postEvent(new
			// MobileCashBaseCallbackEvent(EventCode.CALLBACK_DELETE_CASHIER_SHOP),
			// 0);
			// break;
			// default:
			// break;
			}
		}
	}

	// /**
	// * 同步时间戳范围以内更改的->店铺相关信息（企业、店铺、店铺管理员、店铺员工）
	// */
	// protected void shopRealInfoSynchro()
	// {
	// AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_GET_SHOP_RELATE_INFO_DOWN_SYNCHRO,
	// this, true);
	// AndroidEventManager.getInstance().postEvent(EventCode.HTTP_GET_SHOP_RELATE_INFO_DOWN_SYNCHRO,
	// 0,
	// String.format(URLUtils.URL_GET_SHOP_RELATE_INFO_DOWN_SYNCHRO,
	// BaseApplication.getEnterpriseManager().getModifyDate()));
	// }
	//
	// /**
	// * 同步时间戳范围以内更改->店铺商品相关信息（商品分类、商品类型）
	// */
	// protected void shopProductRealInfoSynchro()
	// {
	// AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_GET_SHOP_PRODUCT_RALATE_INFO_DOWN_SYNCHRO,
	// this, true);
	// AndroidEventManager.getInstance().postEvent(EventCode.HTTP_GET_SHOP_PRODUCT_RALATE_INFO_DOWN_SYNCHRO,
	// 0,
	// String.format(URLUtils.URL_GET_SHOP_PRODUCT_RALATE_INFO_DOWN_SYNCHRO,
	// BaseApplication.getEnterpriseManager().getModifyDate()));
	// }
	//
	// /**
	// * 同步时间戳范围以内更改的->数据改变->店铺优惠相关信息（会员卡类型、套餐类型、套餐明细、代金券类型、折扣券类型、特殊折扣、折扣券折扣、
	// * 消费赠送规则、充值赠送规则）
	// */
	// protected void shopSalePromotionSynchro()
	// {
	// AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_GET_SHOP_SALE_PROMOTION_INFO_DOWN_SYNCHRO,
	// this, true);
	// AndroidEventManager.getInstance().postEvent(EventCode.HTTP_GET_SHOP_SALE_PROMOTION_INFO_DOWN_SYNCHRO,
	// 0,
	// String.format(URLUtils.URL_GET_SHOP_SALE_PROMOTION_INFO_DOWN_SYNCHRO,
	// BaseApplication.getEnterpriseManager().getModifyDate()));
	// }
	//
	// /**
	// * 同步时间戳范围以内更改->店铺其他信息（时间戳、软件版本、mac地址）
	// */
	// protected void shopOtherInfoSynchro()
	// {
	// AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_GET_SHOP_OTHER_INFO_DOWN_SYNCHRO,
	// this, true);
	// AndroidEventManager.getInstance().postEvent(EventCode.HTTP_GET_SHOP_OTHER_INFO_DOWN_SYNCHRO,
	// 0,
	// String.format(URLUtils.URL_GET_SHOP_OTHER_INFO_DOWN_SYNCHRO,
	// BaseApplication.getEnterpriseManager().getModifyDate()));
	// }
	//
	// /**
	// * 同步时间戳范围以内更改的通知个数变更数据
	// */
	// protected void countOfNotificationsChangeSynchro()
	// {
	// AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_GET_QUERY_NEWNOTIFICATIONCOUNTDS,
	// this, true);
	// AndroidEventManager.getInstance().postEvent(EventCode.HTTP_GET_QUERY_NEWNOTIFICATIONCOUNTDS,
	// 0, URLUtils.URL_GET_QUERY_NEWNOTIFICATIONCOUNTDS);
	// }
	//
	// /**
	// * 同步时间戳范围以内最新预约数量
	// */
	// protected void countOfUndealSubcribeChangeSynchro()
	// {
	// AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_GET_QUERY_UNDEALSUBSCRIBECOUNTDS,
	// this, true);
	// AndroidEventManager.getInstance().postEvent(EventCode.HTTP_GET_QUERY_UNDEALSUBSCRIBECOUNTDS,
	// 0, URLUtils.URL_GET_QUERY_UNDEALSUBSCRIBECOUNTDS);
	// }

	@Override
	public void onEventRunEnd(MobileCashBaseEvent event)
	{
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		int eventCode = event.getEventCode();
		// 通知个数
		// if (eventCode == EventCode.HTTP_GET_QUERY_NEWNOTIFICATIONCOUNTDS)
		// {
		// final CountOfNotificationsChangeSynchroEvent
		// countOfNotificationsChangeSynchroEvent =
		// (CountOfNotificationsChangeSynchroEvent) event;
		// if (countOfNotificationsChangeSynchroEvent.isNetSuccess())
		// {
		// if (countOfNotificationsChangeSynchroEvent.isOk() &&
		// countOfNotificationsChangeSynchroEvent.getData() != null)
		// {
		// BaseApplication.getLocalEnterpriseManager().saveModifyDate(countOfNotificationsChangeSynchroEvent.getData().getModifyDate());
		// BaseApplication.getLocalEnterpriseManager().saveCountOfNotifications(countOfNotificationsChangeSynchroEvent.getData().getData());
		// // 发送全局通知
		// AndroidEventManager.getInstance().postEvent(new
		// MobileCashBaseCallbackEvent(EventCode.CALLBACK_NEWNOTIFICATIONCOUNTDS_SYNCHRO_SCUCESS),
		// 0);
		// }
		// }
		// }
	}
}

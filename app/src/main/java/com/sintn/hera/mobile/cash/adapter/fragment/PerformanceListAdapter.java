package com.sintn.hera.mobile.cash.adapter.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.adapter.MobileCashBaseAdapter;
import com.sintn.hera.mobile.cash.entity.down.ConsumeDown;
import com.sintn.hera.mobile.cash.entity.down.IncomeDown;
import com.sintn.hera.mobile.cash.entity.down.NewMemberDown;
import com.sintn.hera.mobile.cash.entity.down.OnlineBuyDown;
import com.sintn.hera.mobile.cash.entity.down.PassengerFlowItemDown;
import com.sintn.hera.mobile.cash.entity.down.RechargeDown;
import com.sintn.hera.mobile.cash.entity.down.SaleGroupDown;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;
import com.sintn.hera.mobile.cash.R;

@SuppressLint("InflateParams")
public class PerformanceListAdapter<T> extends MobileCashBaseAdapter<T>
{

	private Context context;
	private ViewHolder viewHolder;
	private static int convertViewWidth; // 宽度
	private static int convertViewHight; // 高度

	@SuppressWarnings("deprecation")
	public PerformanceListAdapter(Context context)
	{
		this.context = context;
		convertViewWidth = RelativeLayout.LayoutParams.FILL_PARENT; // 宽度
		convertViewHight = DensityManagerUtils.getScreenHightPx(context) / 11 * 1; // 高度
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		viewHolder = null;
		final T object = (T) getItem(position);
		if (convertView == null)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.adapter_mainactivity_for_perfoemance_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.vg_in_performance_for_adapter_root = (LinearLayout) convertView.findViewById(R.id.vg_in_performance_for_adapter_root);
			viewHolder.tv_in_performance_for_adapter_name = (TextView) convertView.findViewById(R.id.tv_in_performance_for_adapter_name);
			viewHolder.tv_in_performance_for_adapter_num = (TextView) convertView.findViewById(R.id.tv_in_performance_for_adapter_num);
			viewHolder.v_in_performance_for_adapter_line = (View) convertView.findViewById(R.id.v_in_performance_for_adapter_line);
			LinearLayout.LayoutParams lp = ((LinearLayout.LayoutParams)viewHolder.vg_in_performance_for_adapter_root.getLayoutParams());
			lp.setMargins(12, 20, 12, 20);
			viewHolder.vg_in_performance_for_adapter_root.setLayoutParams(lp);
			convertView.setTag(viewHolder);
			onCreateView(convertView);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.tv_in_performance_for_adapter_name.setTextColor(context.getResources().getColor(R.color.c333333));
		viewHolder.tv_in_performance_for_adapter_num.setTextColor(context.getResources().getColor(R.color.c333333));
		if (object instanceof IncomeDown)
		{
			switch (position)
			{
			case 0:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.cfff8f8));
				viewHolder.tv_in_performance_for_adapter_name.setText("收入");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((IncomeDown) object).getTotal()) + "元");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.VISIBLE);
				viewHolder.v_in_performance_for_adapter_line.setBackgroundColor(context.getResources().getColor(R.color.cf84f58));
				break;
			case 1:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("现金");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((IncomeDown) object).getCash()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 2:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("银联");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((IncomeDown) object).getBank()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 3:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("微信");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((IncomeDown) object).getWeixin()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 4:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("支付宝");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((IncomeDown) object).getAli()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			default:
				break;
			}
		} else if (object instanceof ConsumeDown)
		{
			switch (position)
			{
			case 0:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.cfffbf5));
				viewHolder.tv_in_performance_for_adapter_name.setText("消费");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((ConsumeDown) object).getTotal()) + "元");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.VISIBLE);
				viewHolder.v_in_performance_for_adapter_line.setBackgroundColor(context.getResources().getColor(R.color.cf99e00));
				break;
			case 1:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("现金");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((ConsumeDown) object).getCash()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 2:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("银联");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((ConsumeDown) object).getBank()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 3:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("微信");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((ConsumeDown) object).getWeixin()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 4:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("支付宝");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((ConsumeDown) object).getAli()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 5:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("会员卡");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((ConsumeDown) object).getCard()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 6:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("抵用消费");
				viewHolder.tv_in_performance_for_adapter_num.setText(((ConsumeDown) object).getProductAmount() + "个/" + CommonUtils.formatDouble2String(((ConsumeDown) object).getProductValue()));
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 7:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("代金券");
				viewHolder.tv_in_performance_for_adapter_num
						.setText(((ConsumeDown) object).getCashCouponAmount() + "张/" + CommonUtils.formatDouble2String(((ConsumeDown) object).getCashCouponValue()));
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 8:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("折扣券");
				viewHolder.tv_in_performance_for_adapter_num.setText(((ConsumeDown) object).getDiscountCouponAmount() + "张");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 9:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("使用的积分");
				viewHolder.tv_in_performance_for_adapter_num.setText(((ConsumeDown) object).getUseScore() + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 10:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("赠送的积分");
				viewHolder.tv_in_performance_for_adapter_num.setText(((ConsumeDown) object).getPresentScore() + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			default:
				break;
			}
		} else if (object instanceof RechargeDown)
		{
			switch (position)
			{
			case 0:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.cf9f9fc));
				viewHolder.tv_in_performance_for_adapter_name.setText("充值金额");
//				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((RechargeDown) object).getRechargeMoney()) + "元");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.VISIBLE);
				viewHolder.v_in_performance_for_adapter_line.setBackgroundColor(context.getResources().getColor(R.color.c675aac));
				break;
			case 1:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("赠送金额");
//				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((RechargeDown) object).getPresentMoney()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 2:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("赠送积分");
//				viewHolder.tv_in_performance_for_adapter_num.setText(((RechargeDown) object).getPresentScore() + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			default:
				break;
			}
		} else if (object instanceof SaleGroupDown)
		{
			switch (position)
			{
			case 0:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.cf8f7f6));
				viewHolder.tv_in_performance_for_adapter_name.setText("购买套餐");
				viewHolder.tv_in_performance_for_adapter_num.setText(((SaleGroupDown) object).getAmount() + "套");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.VISIBLE);
				viewHolder.v_in_performance_for_adapter_line.setBackgroundColor(context.getResources().getColor(R.color.c4e3720));
				break;
			case 1:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("购买金额");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((SaleGroupDown) object).getValue()) + "元");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 2:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("赠送积分");
				viewHolder.tv_in_performance_for_adapter_num.setText(((SaleGroupDown) object).getScore() + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			default:
				break;
			}
		} else if (object instanceof OnlineBuyDown)
		{
			switch (position)
			{
			case 0:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.cfbfcf6));
				viewHolder.tv_in_performance_for_adapter_name.setText("在线购物");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((OnlineBuyDown) object).getTotalMoney()) + "元");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.VISIBLE);
				viewHolder.v_in_performance_for_adapter_line.setBackgroundColor(context.getResources().getColor(R.color.c98ac10));
				break;
			case 1:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("在线充值");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((OnlineBuyDown) object).getRechargeMoney()) + "/赠送"
						+ CommonUtils.formatDouble2String(((OnlineBuyDown) object).getRechargePresentMoney()) + "元，" + ((OnlineBuyDown) object).getRechargePresentScore() + "积分");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 2:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("在线购买套餐");
				viewHolder.tv_in_performance_for_adapter_num.setText(((OnlineBuyDown) object).getSaleGroupAmount() + "套/"
						+ CommonUtils.formatDouble2String(((OnlineBuyDown) object).getSaleGroupValue()) + "元");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 3:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("储值卡在线购物");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((OnlineBuyDown) object).getCard()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			case 4:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText("现金在线购物");
				viewHolder.tv_in_performance_for_adapter_num.setText(CommonUtils.formatDouble2String(((OnlineBuyDown) object).getCash()) + "");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			default:
				break;
			}
		} else if (object instanceof PassengerFlowItemDown)
		{
			switch (position)
			{
			case 0:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.cf8f8f8));
				viewHolder.tv_in_performance_for_adapter_name.setText("客流量");
				viewHolder.tv_in_performance_for_adapter_num.setText(((PassengerFlowItemDown) object).getAmount() + "人");
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.VISIBLE);
				viewHolder.v_in_performance_for_adapter_line.setBackgroundColor(context.getResources().getColor(R.color.c57586a));
				break;
			default:
				viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
				viewHolder.tv_in_performance_for_adapter_name.setText(((PassengerFlowItemDown) object).getName());
				viewHolder.tv_in_performance_for_adapter_num.setText("男" + ((PassengerFlowItemDown) object).getMale() + "，女" + ((PassengerFlowItemDown) object).getFemale() + "，未知"
						+ ((PassengerFlowItemDown) object).getUnknown());
				viewHolder.v_in_performance_for_adapter_line.setVisibility(View.GONE);
				break;
			}
		} else if (object instanceof NewMemberDown)
		{
			viewHolder.vg_in_performance_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.c00abf3));
			viewHolder.tv_in_performance_for_adapter_name.setText("新增会员");
			viewHolder.tv_in_performance_for_adapter_name.setTextColor(context.getResources().getColor(R.color.white));
			viewHolder.tv_in_performance_for_adapter_num.setTextColor(context.getResources().getColor(R.color.white));
			viewHolder.tv_in_performance_for_adapter_num.setText(((NewMemberDown) object).getAmount() + "人");
			viewHolder.v_in_performance_for_adapter_line.setVisibility(View.VISIBLE);
			viewHolder.v_in_performance_for_adapter_line.setBackgroundColor(context.getResources().getColor(R.color.c00abf3));
		}

		return convertView;
	}

	private void onCreateView(View view)
	{
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight);
		view.setLayoutParams(lp);
	}

	private static class ViewHolder
	{
		LinearLayout vg_in_performance_for_adapter_root;
		TextView tv_in_performance_for_adapter_name;
		TextView tv_in_performance_for_adapter_num;
		View v_in_performance_for_adapter_line;
	}
}

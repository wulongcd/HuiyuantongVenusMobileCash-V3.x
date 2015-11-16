package com.sintn.hera.mobile.cash.adapter.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.assistant.R;
import com.sintn.hera.assistant.adapter.BossAssistantBaseChildViewClickAbleAdapter;
import com.sintn.hera.assistant.entity.down.WithdrawOrderForBossDown;
import com.sintn.hera.assistant.utils.common.CommonUtils;
import com.sintn.hera.assistant.utils.common.DateUtil;
import com.sintn.hera.assistant.utils.common.DensityManagerUtils;

@SuppressLint("InflateParams")
public class WalletOutAdapter<T> extends BossAssistantBaseChildViewClickAbleAdapter<T>
{

	private Context context;
	private ViewHolder viewHolder;
	private static int convertViewWidth; // 宽度
	private static int convertViewHight; // 高度

	@SuppressWarnings("deprecation")
	public WalletOutAdapter(Context context)
	{
		this.context = context;
		convertViewWidth = RelativeLayout.LayoutParams.FILL_PARENT; // 宽度
		convertViewHight = DensityManagerUtils.getScreenHightPx(context) / 15 * 2; // 高度
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		viewHolder = null;
		final T object = (T) getItem(position);
		if (convertView == null)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.adapter_walletinoutactivity_for_fragment_walletout_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_in_walletout_for_adapter_title = (TextView) convertView.findViewById(R.id.tv_in_walletout_for_adapter_title);
			viewHolder.tv_in_walletout_for_adapter_time = (TextView) convertView.findViewById(R.id.tv_in_walletout_for_adapter_time);
			viewHolder.tv_in_walletout_for_adapter_money = (TextView) convertView.findViewById(R.id.tv_in_walletout_for_adapter_money);
			viewHolder.ibtn_in_walletout_for_adapter_info = (ImageButton) convertView.findViewById(R.id.ibtn_in_walletout_for_adapter_info);
			viewHolder.ibtn_in_walletout_for_adapter_info.setOnClickListener(this);
			convertView.setTag(viewHolder);
			onCreateView(convertView);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		if (object instanceof WithdrawOrderForBossDown)
		{
			final WithdrawOrderForBossDown o = (WithdrawOrderForBossDown) object;

			if (o != null)
			{
				viewHolder.tv_in_walletout_for_adapter_title.setText(o.getTitle());
				viewHolder.tv_in_walletout_for_adapter_time.setText(DateUtil.dateToStr(o.getDate(), DateUtil.DTIME_STYLE1) + "");
				viewHolder.tv_in_walletout_for_adapter_money.setText("¥" + CommonUtils.formatDouble2String(o.getMoney()) + "");
			}
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
		TextView tv_in_walletout_for_adapter_title;
		TextView tv_in_walletout_for_adapter_time;
		TextView tv_in_walletout_for_adapter_money;
		ImageButton ibtn_in_walletout_for_adapter_info;
	}
}

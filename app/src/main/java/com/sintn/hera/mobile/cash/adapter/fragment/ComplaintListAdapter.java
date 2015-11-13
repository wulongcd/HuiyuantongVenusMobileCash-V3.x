package com.sintn.hera.mobile.cash.adapter.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.adapter.MobileCashBaseAdapter;
import com.sintn.hera.mobile.cash.entity.down.ConsumerComplaint;
import com.sintn.hera.mobile.cash.entity.down.EnterpriseNotificationDown;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;
import com.sintn.hera.mobile.cash.R;

@SuppressLint("InflateParams")
public class ComplaintListAdapter<T> extends MobileCashBaseAdapter<T>
{

	private Context context;
	private ViewHolder viewHolder;
	private static int convertViewWidth; // 宽度
	private static int convertViewHight; // 高度

	@SuppressWarnings("deprecation")
	public ComplaintListAdapter(Context context)
	{
		this.context = context;
		convertViewWidth = RelativeLayout.LayoutParams.FILL_PARENT; // 宽度
		convertViewHight = DensityManagerUtils.getScreenHightPx(context) / 11 * 3; // 高度
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		viewHolder = null;
		final T object = (T) getItem(position);
		if (convertView == null)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.adapter_mainactivity_for_complaint_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_in_complaint_for_adapter_title = (TextView) convertView.findViewById(R.id.tv_in_complaint_for_adapter_title);
			viewHolder.tv_in_complaint_for_adapter_content = (TextView) convertView.findViewById(R.id.tv_in_complaint_for_adapter_content);
			viewHolder.tv_in_complaint_for_adapter_time = (TextView) convertView.findViewById(R.id.tv_in_complaint_for_adapter_time);
			convertView.setTag(viewHolder);
			onCreateView(convertView);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		if (object instanceof EnterpriseNotificationDown)
		{
			final ConsumerComplaint consumerComplaint = (ConsumerComplaint) JsonCommonUtils.jsonToObject(((EnterpriseNotificationDown) object).getContent(), ConsumerComplaint.class);
			if (consumerComplaint != null)
			{
				viewHolder.tv_in_complaint_for_adapter_title.setText(setTextViewColor(consumerComplaint.getConsumerName() + " 投诉了 " + consumerComplaint.getShopName(), " 投诉了 "));
				viewHolder.tv_in_complaint_for_adapter_content.setText(consumerComplaint.getContent() + "");
				viewHolder.tv_in_complaint_for_adapter_time.setText(((EnterpriseNotificationDown) object).getCreateDate() + "");
			}
		}
		return convertView;
	}

	private SpannableStringBuilder setTextViewColor(String str, String uStr)
	{
		// TODO Auto-generated method stub
		int bstart = str.indexOf(uStr);
		int bend = bstart + uStr.length();
		SpannableStringBuilder style = new SpannableStringBuilder(str);
		style.setSpan(new BackgroundColorSpan(context.getResources().getColor(R.color.c00abf3)), bstart, bend, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.white)), bstart, bend, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return style;
	}

	private void onCreateView(View view)
	{
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight);
		view.setLayoutParams(lp);
	}

	private static class ViewHolder
	{
		TextView tv_in_complaint_for_adapter_title;
		TextView tv_in_complaint_for_adapter_content;
		TextView tv_in_complaint_for_adapter_time;
	}
}

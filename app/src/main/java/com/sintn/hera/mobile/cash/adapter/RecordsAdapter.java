package com.sintn.hera.mobile.cash.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.utils.common.DateUtil;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;
import com.sintn.hera.mobile.cash.R;

@SuppressLint("InflateParams")
public class RecordsAdapter<DividedStaffDown> extends MobileCashBaseAdapter<DividedStaffDown>
{

	private Context context;
	private ViewHolder viewHolder;
	private static int convertViewWidth; // 宽度
	private static int convertViewHight; // 高度

	@SuppressWarnings("deprecation")
	public RecordsAdapter(Context context)
	{
		this.context = context;
		convertViewWidth = RelativeLayout.LayoutParams.FILL_PARENT; // 宽度
		convertViewHight = DensityManagerUtils.getScreenHightPx(context) / 11 * 1; // 高度
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		viewHolder = null;
		if (convertView == null)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.listitem_in_walletinoutrecordsactivity_for_show_records, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
			viewHolder.tv_performance = (TextView) convertView.findViewById(R.id.tv_performance);
			viewHolder.tv_income = (TextView) convertView.findViewById(R.id.tv_income);
			convertView.setTag(viewHolder);
			onCreateView(convertView);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final com.sintn.hera.mobile.cash.entity.down.DividedStaffDown object = (com.sintn.hera.mobile.cash.entity.down.DividedStaffDown) getItem(position);
		if (position % 2 == 0)
		{
			convertView.setBackgroundColor(Color.WHITE);
		} else
		{
			convertView.setBackgroundColor(context.getResources().getColor(R.color.cf8f8f8));
		}
		viewHolder.tv_date.setText(DateUtil.dateToStrLong(object.getCreateDate()));
		viewHolder.tv_performance.setText(object.getPerformance() + "");
		viewHolder.tv_income.setText(object.getIncome() + "");

		return convertView;
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return ((com.sintn.hera.mobile.cash.entity.down.DividedStaffDown) getItem(position)).getId();
	}

	private void onCreateView(View view)
	{
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight);
		view.setLayoutParams(lp);
	}

	private static class ViewHolder
	{
		TextView tv_date;
		TextView tv_performance;
		TextView tv_income;
	}
}

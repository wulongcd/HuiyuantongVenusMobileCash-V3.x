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

import com.sintn.hera.mobile.cash.entity.show.StatisticListShow;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;
import com.sintn.hera.mobile.cash.R;

@SuppressLint("InflateParams")
public class StatisticsAdapter<T> extends MobileCashBaseAdapter<T>
{

	private Context context;
	private ViewHolder viewHolder;
	private static int convertViewWidth; // 宽度
	private static int convertViewHight; // 高度

	@SuppressWarnings("deprecation")
	public StatisticsAdapter(Context context)
	{
		this.context = context;
		convertViewWidth = RelativeLayout.LayoutParams.FILL_PARENT; // 宽度
		convertViewHight = DensityManagerUtils.getScreenHightPx(context) / 7 * 1; // 高度
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		viewHolder = null;
		// final T object = (T) getItem(position);
		if (convertView == null)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.listitem_in_walletinoutrecordsactivity_for_show_statistics, null);
			viewHolder = new ViewHolder();
			viewHolder.left_item_tv_name = (TextView) convertView.findViewById(R.id.left_item_tv_name);
			viewHolder.left_item_tv_count = (TextView) convertView.findViewById(R.id.left_item_tv_count);
			viewHolder.right_item_tv_name = (TextView) convertView.findViewById(R.id.right_item_tv_name);
			viewHolder.right_item_tv_count = (TextView) convertView.findViewById(R.id.right_item_tv_count);
			convertView.setTag(viewHolder);
			onCreateView(convertView);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		StatisticListShow statisticListShow = (StatisticListShow) getItem(position);
		if (position == 0)
		{
			convertView.findViewById(R.id.listItem_up_line).setVisibility(View.VISIBLE);
			convertView.setBackgroundColor(Color.WHITE);
		} else
		{
			convertView.findViewById(R.id.listItem_up_line).setVisibility(View.GONE);
			convertView.setBackgroundColor(Color.WHITE);
		}
		viewHolder.left_item_tv_name.setText(statisticListShow.getLeft().getName());
		viewHolder.left_item_tv_count.setText(statisticListShow.getLeft().getAmount() + "");
		viewHolder.right_item_tv_name.setText(statisticListShow.getRight().getName()==null ? "":statisticListShow.getRight().getName());
		viewHolder.right_item_tv_count.setText(statisticListShow.getRight().getAmount()==0 ?"":statisticListShow.getRight().getAmount() + "");
		return convertView;
	}

	private void onCreateView(View view)
	{
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight);
		view.setLayoutParams(lp);
	}

	private static class ViewHolder
	{
		TextView left_item_tv_name;
		TextView left_item_tv_count;
		TextView right_item_tv_name;
		TextView right_item_tv_count;
	}
}

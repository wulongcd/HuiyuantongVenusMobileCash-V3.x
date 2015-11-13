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
import com.sintn.hera.mobile.cash.entity.down.RankDown;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;
import com.sintn.hera.mobile.cash.R;

@SuppressLint("InflateParams")
public class ShopRankListAdapter<T> extends MobileCashBaseAdapter<T>
{

	private Context context;
	private ViewHolder viewHolder;
	private static int convertViewWidth; // 宽度
	private static int convertViewHight; // 高度

	@SuppressWarnings("deprecation")
	public ShopRankListAdapter(Context context)
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
			convertView = LayoutInflater.from(context).inflate(R.layout.adapter_mainactivity_for_shoprank_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.vg_in_shoprank_for_adapter_root = (LinearLayout) convertView.findViewById(R.id.vg_in_shoprank_for_adapter_root);
			viewHolder.tv_in_shoprank_for_adapter_name = (TextView) convertView.findViewById(R.id.tv_in_shoprank_for_adapter_name);
			viewHolder.tv_in_shoprank_for_adapter_num = (TextView) convertView.findViewById(R.id.tv_in_shoprank_for_adapter_num);
			convertView.setTag(viewHolder);
			onCreateView(convertView);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		if (object instanceof RankDown)
		{
			viewHolder.vg_in_shoprank_for_adapter_root.setBackgroundColor(context.getResources().getColor(R.color.white));
			viewHolder.tv_in_shoprank_for_adapter_name.setText(((RankDown) object).getShopName());
			viewHolder.tv_in_shoprank_for_adapter_num.setText(CommonUtils.formatDouble2String(((RankDown) object).getValue()) + "");
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
		LinearLayout vg_in_shoprank_for_adapter_root;
		TextView tv_in_shoprank_for_adapter_name;
		TextView tv_in_shoprank_for_adapter_num;
	}
}

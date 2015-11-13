package com.sintn.hera.mobile.cash.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.adapter.viewholder.BaseRecycleViewHolder;
import com.sintn.hera.mobile.cash.entity.down.ShopForCashierAppDown;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;

import java.util.ArrayList;

@SuppressLint("InflateParams")
public class ShopListAdapter<T> extends BaseRecyclerAdapter<ShopForCashierAppDown>
{

	private Context context;
	private static int convertViewWidth; // 宽度
	private static int convertViewHeight; // 高度

	@SuppressWarnings("deprecation")
	public ShopListAdapter(Context context)
	{
		this.context = context;
		convertViewWidth = RelativeLayout.LayoutParams.FILL_PARENT; // 宽度
		convertViewHeight = DensityManagerUtils.getScreenHightPx(context) / 16 * 1; // 高度
	}

	private void onCreateView(View view)
	{
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHeight);
		view.setLayoutParams(lp);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.item_in_manager_activity, parent, false);
		return new ViewHolder(view, this);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		ViewHolder viewHolder = (ViewHolder) holder;
		ShopForCashierAppDown object = objects.get(position);
		onCreateView(viewHolder.getItemView());
		if(position == 0) {
			viewHolder.upLine_in_managerActivity_listItem.setVisibility(View.VISIBLE);
			viewHolder.short_downLine_in_managerActivity_listItem.setVisibility(View.VISIBLE);
			viewHolder.short_downLine_in_managerActivity_listItem.setVisibility(View.GONE);
		} else {
			viewHolder.upLine_in_managerActivity_listItem.setVisibility(View.GONE);
			if(position == getCount() - 1) {
				viewHolder.short_downLine_in_managerActivity_listItem.setVisibility(View.GONE);
				viewHolder.long_downLine_in_managerActivity_listItem.setVisibility(View.VISIBLE);
			} else {
				viewHolder.short_downLine_in_managerActivity_listItem.setVisibility(View.VISIBLE);
				viewHolder.long_downLine_in_managerActivity_listItem.setVisibility(View.GONE);
			}
		}
		viewHolder.tv_in_managerActivity_ListItem_of_name.setText(object.getName());
		viewHolder.tv_in_managerActivity_ListItem_of_desc.setText(object.getAddress());
	}

	protected class ViewHolder extends BaseRecycleViewHolder
	{
		TextView tv_in_managerActivity_ListItem_of_name;
		TextView tv_in_managerActivity_ListItem_of_desc;
        ImageView iv_in_managerActivity_listItem_has_more;
        ImageView upLine_in_managerActivity_listItem;
        ImageView short_downLine_in_managerActivity_listItem;
        ImageView long_downLine_in_managerActivity_listItem;

		public ViewHolder(View itemView, BaseRecyclerAdapter baseRecyclerAdapter) {
			super(itemView, baseRecyclerAdapter);
			tv_in_managerActivity_ListItem_of_name = (TextView) itemView.findViewById(R.id.tv_in_managerActivity_ListItem_of_name);
			tv_in_managerActivity_ListItem_of_desc = (TextView) itemView.findViewById(R.id.tv_in_managerActivity_ListItem_of_desc);
            iv_in_managerActivity_listItem_has_more = (ImageView) itemView.findViewById(R.id.iv_in_managerActivity_listItem_has_more);
			upLine_in_managerActivity_listItem = (ImageView) itemView.findViewById(R.id.upLine_in_managerActivity_listItem);
			short_downLine_in_managerActivity_listItem = (ImageView) itemView.findViewById(R.id.short_downLine_in_managerActivity_listItem);
			long_downLine_in_managerActivity_listItem = (ImageView) itemView.findViewById(R.id.long_downLine_in_managerActivity_listItem);
		}
	}

}

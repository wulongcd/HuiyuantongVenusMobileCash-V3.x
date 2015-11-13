package com.sintn.hera.mobile.cash.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.entity.down.LoginDown;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;
import com.sintn.hera.mobile.cash.R;

@SuppressLint("InflateParams")
public class ChoiceEnterpriseActivityListAdapter<T> extends MobileCashBaseAdapter<T>
{

	private Context context;
	private ViewHolder viewHolder;
	private static int convertViewWidth; // 宽度
	private static int convertViewHight; // 高度
	private int selectIndex;

	@SuppressWarnings("deprecation")
	public ChoiceEnterpriseActivityListAdapter(Context context, int selectIndex)
	{
		this.context = context;
		this.selectIndex = selectIndex;
		convertViewWidth = RelativeLayout.LayoutParams.FILL_PARENT; // 宽度
		convertViewHight = DensityManagerUtils.getScreenHightPx(context) / 11 * 1; // 高度
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		viewHolder = null;
		final LoginDown object = (LoginDown) getItem(position);
		if (convertView == null)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.adapter_choiceenterpriseactivity_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_in_choiceEnterpriseActivity_for_itemName = (TextView) convertView.findViewById(R.id.tv_in_choiceEnterpriseActivity_for_itemName);
			viewHolder.iv_in_choiceEnterpriseActivity_of_select = (ImageView) convertView.findViewById(R.id.iv_in_choiceEnterpriseActivity_of_select);
			convertView.setTag(viewHolder);
			onCreateView(convertView);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.tv_in_choiceEnterpriseActivity_for_itemName.setText(object.getEnterpriseName()+"("+object.getShopName()+")");
		if(position == selectIndex) {
			viewHolder.iv_in_choiceEnterpriseActivity_of_select.setVisibility(View.VISIBLE);
		}else
			viewHolder.iv_in_choiceEnterpriseActivity_of_select.setVisibility(View.GONE);
		return convertView;
	}

	private void onCreateView(View view)
	{
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight);
		view.setLayoutParams(lp);
	}

	private static class ViewHolder
	{
		TextView tv_in_choiceEnterpriseActivity_for_itemName;
		ImageView iv_in_choiceEnterpriseActivity_of_select;
	}

	public int getSelectIndex()
	{
		return selectIndex;
	}

	public void setSelectIndex(int selectIndex)
	{
		this.selectIndex = selectIndex;
	}
	
}

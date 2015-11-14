package com.sintn.hera.mobile.cash.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;
import com.sintn.hera.mobile.cash.R;

@SuppressLint("InflateParams")
public class ChoiceServerActivityListAdapter<T> extends MobileCashBaseAdapter<T>
{

	private Context context;
	private ViewHolder viewHolder;
	private static int convertViewWidth; // 宽度
	private static int convertViewHight; // 高度

	@SuppressWarnings("deprecation")
	public ChoiceServerActivityListAdapter(Context context)
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
			convertView = LayoutInflater.from(context).inflate(R.layout.adapter_choiceserveractivity_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_in_choiceserveractivity_for_adapter_num = (TextView) convertView.findViewById(R.id.tv_in_choiceserveractivity_for_adapter_num);
			viewHolder.tv_in_choiceserveractivity_for_adapter_desc = (TextView) convertView.findViewById(R.id.tv_in_choiceserveractivity_for_adapter_desc);
			convertView.setTag(viewHolder);
			onCreateView(convertView);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.tv_in_choiceserveractivity_for_adapter_num.setText(position + "");
		viewHolder.tv_in_choiceserveractivity_for_adapter_desc.setText(object.toString() + "");
		return convertView;
	}

	private void onCreateView(View view)
	{
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight);
		view.setLayoutParams(lp);
	}

	private static class ViewHolder
	{
		TextView tv_in_choiceserveractivity_for_adapter_num;
		TextView tv_in_choiceserveractivity_for_adapter_desc;
	}
}

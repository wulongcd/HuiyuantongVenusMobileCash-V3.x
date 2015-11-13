package com.sintn.hera.mobile.cash.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.entity.down.BindingBankCardDown;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;
import com.sintn.hera.mobile.cash.R;

@SuppressLint("InflateParams")
public class ListAdapterInWalletWithdrawalsActivityForBingBankChoice<T> extends MobileCashBaseAdapter<T>
{

	private Context context;
	private ViewHolder viewHolder;
	private static int convertViewWidth; // 宽度
	private static int convertViewHight; // 高度

	@SuppressWarnings("deprecation")
	public ListAdapterInWalletWithdrawalsActivityForBingBankChoice(Context context)
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
			convertView = LayoutInflater.from(context).inflate(R.layout.zone_spinner_item_layout_for_wallet, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_spinner_item_of_bank = (TextView) convertView.findViewById(R.id.tv_spinner_item_of_bank);
			viewHolder.v_spinner_item_of_line = (View) convertView.findViewById(R.id.v_spinner_item_of_line);
			viewHolder.tv_spinner_item_of_account = (TextView) convertView.findViewById(R.id.tv_spinner_item_of_account);
			convertView.setTag(viewHolder);
			onCreateView(convertView);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.tv_spinner_item_of_bank.setVisibility(View.VISIBLE);
		viewHolder.v_spinner_item_of_line.setVisibility(View.VISIBLE);
		viewHolder.tv_spinner_item_of_account.setVisibility(View.VISIBLE);
		if (object instanceof BindingBankCardDown)
		{
			switch (position)
			{
			case 0:
				viewHolder.tv_spinner_item_of_bank.setVisibility(View.GONE);
				viewHolder.v_spinner_item_of_line.setVisibility(View.GONE);
				viewHolder.tv_spinner_item_of_account.setText("请选择银行和账户");
				break;
			default:
				viewHolder.tv_spinner_item_of_bank.setText(((BindingBankCardDown) object).getBankName() + "");
				viewHolder.tv_spinner_item_of_account.setText(((BindingBankCardDown) object).getCardCode() + "");
				break;
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
		TextView tv_spinner_item_of_bank;
		View v_spinner_item_of_line;
		TextView tv_spinner_item_of_account;
	}
}

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.adapter.MobileCashBaseAdapter;
import com.sintn.hera.mobile.cash.entity.down.OrderForCashierAppDown;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;

public class OrderQueryListAdapter extends MobileCashBaseAdapter<OrderForCashierAppDown> {

    private Context context;
    private ViewHolder viewHolder;
    private static int convertViewWidth; // 宽度
    private static int convertViewHight; // 高度

    @SuppressWarnings("deprecation")
    public OrderQueryListAdapter(Context context) {
        this.context = context;
        convertViewWidth = RelativeLayout.LayoutParams.FILL_PARENT; // 宽度
        convertViewHight = DensityManagerUtils.getScreenHightPx(context) / 11; // 高度
    }

    @SuppressWarnings("unchecked")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = null;
        final OrderForCashierAppDown object = (OrderForCashierAppDown) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_mainactivity_for_orderquery_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_in_order_query_date = (TextView) convertView.findViewById(R.id.tv_in_order_query_date);
            viewHolder.iv_in_order_query_paymenttype = (ImageView) convertView.findViewById(R.id.iv_in_order_query_paymenttype);
            viewHolder.tv_in_order_query_value = (TextView) convertView.findViewById(R.id.tv_in_order_query_value);
            convertView.setTag(viewHolder);
            onCreateView(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        {
            viewHolder.tv_in_order_query_date.setText(object.getCreateDate() == null ? "" : object.getCreateDate());
            if (object.getPaymentType() != null)
            {
                if (object.getPaymentType().contains("微信"))
                {
                    viewHolder.iv_in_order_query_paymenttype.setImageResource(R.drawable.weixin_logo);
                }else  if (object.getPaymentType().contains("支付宝"))
                {
                    viewHolder.iv_in_order_query_paymenttype.setImageResource(R.drawable.alipay_logo);
                }else
                {
                    viewHolder.iv_in_order_query_paymenttype.setImageResource(R.drawable.login);
                }
            }
            viewHolder.tv_in_order_query_value.setText(CommonUtils.formatDouble2String(object.getMoney()));
        }
        return convertView;
    }

    private SpannableStringBuilder setTextViewColor(String str, String uStr) {
        // TODO Auto-generated method stub
        int bstart = str.indexOf(uStr);
        int bend = bstart + uStr.length();
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new BackgroundColorSpan(context.getResources().getColor(R.color.c00abf3)), bstart, bend, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.white)), bstart, bend, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return style;
    }

    private void onCreateView(View view) {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight);
        view.setLayoutParams(lp);
    }

    private static class ViewHolder {
        TextView tv_in_order_query_date;
        ImageView iv_in_order_query_paymenttype;
        TextView tv_in_order_query_value;
    }
}

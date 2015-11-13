package com.sintn.hera.mobile.cash.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.adapter.BaseRecyclerAdapter;

/**
 * Created by Sintn on 15/11/10.
 */
public  class OrderQueryRecycleViewHolder extends BaseRecycleViewHolder{
    public LinearLayout ll_in_order_for_normal;
    public TextView tv_in_order_query_date;
    public ImageView iv_in_order_query_paymenttype;
    public TextView tv_in_order_query_value;

    public LinearLayout ll_in_order_for_total;
    public TextView tv_in_order_query_weixin_assisstant;
    public TextView tv_in_order_query_alipay_assisstant;

    public LinearLayout ll_in_order_for_asssit;
    public  PieChart chart_in_order_for_asssit;
    public View v_in_order_query_deadline;

    public OrderQueryRecycleViewHolder(View itemView, BaseRecyclerAdapter baseRecyclerAdapter) {
        super(itemView, baseRecyclerAdapter);
        ll_in_order_for_normal = (LinearLayout) itemView.findViewById(R.id.ll_in_order_for_normal);
        tv_in_order_query_date = (TextView) itemView.findViewById(R.id.tv_in_order_query_date);
        iv_in_order_query_paymenttype = (ImageView) itemView.findViewById(R.id.iv_in_order_query_paymenttype);
        tv_in_order_query_value = (TextView) itemView.findViewById(R.id.tv_in_order_query_value);

        ll_in_order_for_total= (LinearLayout) itemView.findViewById(R.id.ll_in_order_for_total);
        tv_in_order_query_weixin_assisstant= (TextView) itemView.findViewById(R.id.tv_in_order_query_weixin_assisstant);
        tv_in_order_query_alipay_assisstant= (TextView) itemView.findViewById(R.id.tv_in_order_query_alipay_assisstant);

        ll_in_order_for_asssit = (LinearLayout) itemView.findViewById(R.id.ll_in_order_for_asssit);
        chart_in_order_for_asssit = (PieChart) itemView.findViewById(R.id.chart_in_order_for_asssit);

        v_in_order_query_deadline = (View) itemView.findViewById(R.id.v_in_order_query_deadline);
    }
}
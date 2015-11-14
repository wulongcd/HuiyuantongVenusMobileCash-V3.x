package com.sintn.hera.mobile.cash.adapter.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.adapter.BaseRecyclerAdapter;
import com.sintn.hera.mobile.cash.adapter.viewholder.OrderQueryRecycleViewHolder;
import com.sintn.hera.mobile.cash.entity.down.OrderForCashierAppDown;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;

import java.util.ArrayList;

/**
 * Created by Sintn on 15/10/28.
 */
public class OrderQueryRecycleListAdapter extends BaseRecyclerAdapter<OrderForCashierAppDown> implements OnChartValueSelectedListener {

    public static final int[] PAYMENT_COLORS = {
            Color.rgb(17, 211, 29), Color.rgb(28, 172, 235)
    };

    public static String WEIXIN_ALISSSINIT_STR = "微信";
    public static String ALIPAY_ALISSSINIT_STR = "支付宝";
    public static String OTHER_ALISSSINIT_STR = "其他";


    private static int convertViewWidth; // 宽度
    private static int convertViewHight; // 高度

    private Typeface tf;
    private float weixinSqual = 0.99f;
    private float alipsySqual = 0.01f;


    @SuppressWarnings("deprecation")
    public OrderQueryRecycleListAdapter(Context context) {
        super(context);
//        objects = new ArrayList<OrderForCashierAppDown>();

        convertViewWidth = RelativeLayout.LayoutParams.FILL_PARENT; // 宽度
        convertViewHight = DensityManagerUtils.getScreenHightPx(context) / 13; // 高度
        tf = Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf");
    }


    @Override
    public OrderQueryRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mainactivity_for_orderquery_list_item, parent, false);
        return new OrderQueryRecycleViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        OrderQueryRecycleViewHolder viewHolder = (OrderQueryRecycleViewHolder) holder;
        final OrderForCashierAppDown object = (OrderForCashierAppDown) getItem(position);
        if (object.getTotal() == null) {
            onCreateView(viewHolder.getItemView(), 1);
            viewHolder.ll_in_order_for_asssit.setVisibility(View.GONE);
            viewHolder.ll_in_order_for_total.setVisibility(View.GONE);
            viewHolder.ll_in_order_for_normal.setVisibility(View.VISIBLE);
            viewHolder.v_in_order_query_deadline.setVisibility(View.VISIBLE);
            viewHolder.tv_in_order_query_date.setText(object.getCreateDate() == null ? "" + (position - 1) + "、" : (position - 1) + "、" + object.getCreateDate());
            if (object.getPaymentType() != null) {
                if (object.getPaymentType().contains("微信")) {
                    viewHolder.iv_in_order_query_paymenttype.setImageResource(R.drawable.weixin_logo);
                } else if (object.getPaymentType().contains("支付宝")) {
                    viewHolder.iv_in_order_query_paymenttype.setImageResource(R.drawable.alipay_logo);
                } else {
                    viewHolder.iv_in_order_query_paymenttype.setImageResource(R.drawable.login);
                }
            }
            viewHolder.tv_in_order_query_value.setText("￥" + CommonUtils.formatDouble2String(object.getMoney()));

        } else {
            if (position == 0) {
                onCreateView(viewHolder.getItemView(), 4);
                viewHolder.ll_in_order_for_asssit.setVisibility(View.VISIBLE);
                viewHolder.ll_in_order_for_total.setVisibility(View.GONE);
                viewHolder.ll_in_order_for_normal.setVisibility(View.GONE);
                viewHolder.v_in_order_query_deadline.setVisibility(View.GONE);
                if (object.getTotal().getWeixinMoney() == 0.0 && object.getTotal().getAlipayMoney() == 0.0) {
                    weixinSqual = 0.5f;
                    alipsySqual = 0.5f;
                } else {
                    weixinSqual = (float) (object.getTotal().getWeixinMoney() / (object.getTotal().getWeixinMoney() + object.getTotal().getAlipayMoney()));
                    alipsySqual = (float) (object.getTotal().getAlipayMoney() / (object.getTotal().getWeixinMoney() + object.getTotal().getAlipayMoney()));
                }
                initPieChart(viewHolder.chart_in_order_for_asssit, tf, context, context.getResources().getString(R.string.sale_assisstant), weixinSqual, alipsySqual);
            } else if (position == 1) {
                onCreateView(viewHolder.getItemView(), 1);
                viewHolder.ll_in_order_for_asssit.setVisibility(View.GONE);
                viewHolder.ll_in_order_for_total.setVisibility(View.VISIBLE);
                viewHolder.ll_in_order_for_normal.setVisibility(View.GONE);
                viewHolder.v_in_order_query_deadline.setVisibility(View.VISIBLE);
                viewHolder.tv_in_order_query_weixin_assisstant.setText(
                        CommonUtils.formatDouble2String(object.getTotal().getWeixinMoney()) + "元" + "/" + object.getTotal().getWeixinCount() + "笔");
                viewHolder.tv_in_order_query_alipay_assisstant.setText(
                        CommonUtils.formatDouble2String(object.getTotal().getAlipayMoney()) + "元" + "/" + object.getTotal().getAlipayCount() + "笔");
            }
        }
    }

    private void onCreateView(View view, int bluofhight) {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight * bluofhight);
        view.setLayoutParams(lp);
        }

    //////////////////以下是统计视图相关//////////////////////////
    public void initPieChart(PieChart mChart, Typeface tf, Context context, String centerStr, float weixinSqual, float alipsySqual) {
        mChart.setUsePercentValues(true);
        mChart.setDescription("");
        mChart.setExtraOffsets(5, 10, 5, 5);
        mChart.setDragDecelerationFrictionCoef(0.95f);
        mChart.setCenterTextTypeface(Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf"));
        mChart.setCenterText(generateCenterSpannableText(centerStr));

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColorTransparent(true);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);
        mChart.setOnChartValueSelectedListener(this);

        setData(mChart, 2, 100, tf, weixinSqual, alipsySqual);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
    }

    /**
     * @param src
     * @return
     */
    private SpannableString generateCenterSpannableText(String src) {
        //收银统计
        SpannableString s = new SpannableString(src);
        s.setSpan(new RelativeSizeSpan(1.0f), 0, 4, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 0, 4, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), 0, 4, 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), 0, 4, 0);
        return s;
    }

    private void setData(PieChart mChart, int count, float range, Typeface tf, float weixinSqual, float alipsySqual) {

        float mult = range;

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                yVals1.add(new Entry(weixinSqual, i));
            } else if (i == 1) {
                yVals1.add(new Entry(alipsySqual, i));
            } else
                yVals1.add(new Entry(0.0f, i));
            // 随机数
            // yVals1.add(new Entry((float) (Math.random() * mult) + mult / 5, i));
        }

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < count; i++) {
            if (i == 0) {
                xVals.add(WEIXIN_ALISSSINIT_STR);
            } else if (i == 1) {
                xVals.add(ALIPAY_ALISSSINIT_STR);
            } else
                xVals.add(OTHER_ALISSSINIT_STR);
        }

        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(2f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();


        for (int c : OrderQueryRecycleListAdapter.PAYMENT_COLORS)
            colors.add(c);

        dataSet.setColors(colors);
        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.WHITE);
        data.setValueTypeface(tf);
        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        if (e == null)
            return;
    }

    @Override
    public void onNothingSelected() {
    }

}

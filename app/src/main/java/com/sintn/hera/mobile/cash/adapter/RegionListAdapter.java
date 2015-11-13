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
import com.sintn.hera.mobile.cash.entity.down.RegionForCashierAppDown;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;

import java.util.ArrayList;

@SuppressLint("InflateParams")
public class RegionListAdapter<T> extends BaseRecyclerAdapter<RegionForCashierAppDown>
{

	private Context context;
	private static int convertViewWidth; // 宽度
	private static int convertViewHeight; // 高度
	private int regionMode = RegionMode.REGION_OF_PROVINCE;
    private ArrayList<RegionForCashierAppDown> selectedRegions; //选中的行业position列表

	@SuppressWarnings("deprecation")
	public RegionListAdapter(Context context)
	{
		this.context = context;
        selectedRegions = new ArrayList<RegionForCashierAppDown>();
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
		View view = LayoutInflater.from(context).inflate(R.layout.item_in_categoryactivity, parent, false);
		return new ViewHolder(view, parent, this);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		ViewHolder viewHolder = (ViewHolder) holder;
		RegionForCashierAppDown object = objects.get(position);
		if(position == 0) {
            RelativeLayout header_of_lists = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_in_categoryactivity, viewHolder.viewGroup, false);
			TextView tv_in_for_header = (TextView) header_of_lists.findViewById(R.id.tv_in_categoryItem_of_desc);
            header_of_lists.findViewById(R.id.iv_in_categoryItem_of_isSelected).setVisibility(View.GONE);
            if(regionMode == RegionMode.REGION_OF_PROVINCE) {
                tv_in_for_header.setText(R.string.choose_province);
            } else if(regionMode == RegionMode.REGION_OF_CITY) {
                tv_in_for_header.setText(R.string.choose_city);
            } else if(regionMode == RegionMode.REGION_OF_AREA) {
				tv_in_for_header.setText(R.string.choose_area);
			}
			onCreateView(header_of_lists);
		}
		onCreateView(viewHolder.getItemView());
		if(object.getName() != null)
			viewHolder.tv_in_regionItem_of_desc.setText(object.getName());
        if(selectedRegions.contains(object)) {
            viewHolder.iv_in_regionItem_of_isSelected.setSelected(true);
        } else {
            viewHolder.iv_in_regionItem_of_isSelected.setSelected(false);
        }
	}

	protected class ViewHolder extends BaseRecycleViewHolder
	{
		TextView tv_in_regionItem_of_desc;
        ImageView iv_in_regionItem_of_isSelected;
        ViewGroup viewGroup;

		public ViewHolder(View itemView, ViewGroup viewGroup, BaseRecyclerAdapter baseRecyclerAdapter) {
			super(itemView, baseRecyclerAdapter);
            this.viewGroup = viewGroup;
			tv_in_regionItem_of_desc = (TextView) itemView.findViewById(R.id.tv_in_categoryItem_of_desc);
            iv_in_regionItem_of_isSelected = (ImageView) itemView.findViewById(R.id.iv_in_categoryItem_of_isSelected);
		}
	}

    public ArrayList getSelectedRegions() {
        return selectedRegions;
    }

    public void setSelectedRegions(ArrayList<RegionForCashierAppDown> selectedRegions) {
        this.selectedRegions = selectedRegions;
    }

    public int getRegionMode() {
		return regionMode;
	}

	public void setRegionMode(int regionMode) {
		this.regionMode = regionMode;
	}

	public static class RegionMode {
		public static int REGION_OF_PROVINCE = 0;
		public static int REGION_OF_CITY = 1;
		public static int REGION_OF_AREA = 1;
	}

	public static class RegionList {
		public static String PROVINCE = "provinces";
		public static String CITY = "cities";
		public static String AREA = "areas";
	}
}

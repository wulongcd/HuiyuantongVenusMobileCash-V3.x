package com.sintn.hera.mobile.cash.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.adapter.viewholder.BaseRecycleViewHolder;
import com.sintn.hera.mobile.cash.entity.down.CategoryForCashierAppDown;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("InflateParams")
public class CategoryListAdapter<T> extends BaseRecyclerAdapter<CategoryForCashierAppDown>
{

	private Context context;
	private static int convertViewWidth; // 宽度
	private static int convertViewHeight; // 高度
	private int categoryMode = CategoryMode.CATEGORY_FIRST;
    private ArrayList<CategoryForCashierAppDown> selectedCategories; //选中的行业position列表

	@SuppressWarnings("deprecation")
	public CategoryListAdapter(Context context)
	{
		this.context = context;
        selectedCategories = new ArrayList<CategoryForCashierAppDown>();
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
		CategoryForCashierAppDown object = objects.get(position);
		if(position == 0) {
            RelativeLayout header_of_lists = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_in_categoryactivity, viewHolder.viewGroup, false);
			TextView tv_in_for_header = (TextView) header_of_lists.findViewById(R.id.tv_in_categoryItem_of_desc);
            header_of_lists.findViewById(R.id.iv_in_categoryItem_of_isSelected).setVisibility(View.GONE);
            if(categoryMode == CategoryMode.CATEGORY_FIRST) {
                tv_in_for_header.setText(R.string.choose_first_category);
            } else if(categoryMode == CategoryMode.CATEGORY_SECOND) {
                tv_in_for_header.setText(R.string.choose_second_category);
            }
			onCreateView(header_of_lists);
		}
		onCreateView(viewHolder.getItemView());
		if(object.getName() != null)
			viewHolder.tv_in_categoryItem_of_desc.setText(object.getName());
        if(selectedCategories.contains(object)) {
            viewHolder.iv_in_categoryItem_of_isSelected.setSelected(true);
        } else {
            viewHolder.iv_in_categoryItem_of_isSelected.setSelected(false);
        }
	}

	protected class ViewHolder extends BaseRecycleViewHolder
	{
		TextView tv_in_categoryItem_of_desc;
        ImageView iv_in_categoryItem_of_isSelected;
        ViewGroup viewGroup;

		public ViewHolder(View itemView, ViewGroup viewGroup, BaseRecyclerAdapter baseRecyclerAdapter) {
			super(itemView, baseRecyclerAdapter);
            this.viewGroup = viewGroup;
			tv_in_categoryItem_of_desc = (TextView) itemView.findViewById(R.id.tv_in_categoryItem_of_desc);
            iv_in_categoryItem_of_isSelected = (ImageView) itemView.findViewById(R.id.iv_in_categoryItem_of_isSelected);
		}
	}

    public ArrayList getSelectedCategories() {
        return selectedCategories;
    }

    public void setSelectedCategories(ArrayList<CategoryForCashierAppDown> selectedCategories) {
        this.selectedCategories = selectedCategories;
    }

    public int getCategoryMode() {
		return categoryMode;
	}

	public void setCategoryMode(int categoryMode) {
		this.categoryMode = categoryMode;
	}

	public static class CategoryMode {
		public static int CATEGORY_FIRST = 0;
		public static int CATEGORY_SECOND = 1;
	}
}

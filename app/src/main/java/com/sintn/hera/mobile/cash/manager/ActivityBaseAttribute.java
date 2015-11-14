package com.sintn.hera.mobile.cash.manager;

import java.util.Locale;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.sintn.hera.mobile.cash.R;

/***
 * 
 * @Desc: TODO
 * @com.sintn.hera.mobile.cash.manager
 * @HuiyuantongVenusMobileCash-V3.x
 * @ActivityBaseAttribute.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午5:28:30
 */

public class ActivityBaseAttribute
{
	private Activity activity;
	private boolean hasContentView;
	private boolean hasNavigationBar;
	private int navigationBarId = R.id.navigation_bar;
	private RelativeLayout relativeLayoutNavigationBar;
	private RelativeLayout relativeLayoutNavigationBarLeft;
	private RelativeLayout relativeLayoutNavigationBarCenter;

	private int navigationBarBackground;

	private boolean hasTextViewInNavigationBarMiddle = true;
	private TextView textViewInNavigationBar;
	private int textViewInNavigationBarColor;
	private int textViewInNavigationBarStringId;

	/**
	 * 有无返回按钮
	 */
	private boolean hasBackButton;

	public boolean isHasImageViewCtener()
	{
		return hasImageViewCtener;

	}

	public void setHasImageViewCtener(boolean hasImageViewCtener)
	{
		this.hasImageViewCtener = hasImageViewCtener;
	}

	private boolean hasImageViewCtener = true;

	public RelativeLayout getRelativeLayoutNavigationBarCenter()
	{
		return relativeLayoutNavigationBarCenter;
	}

	public void setRelativeLayoutNavigationBarCenter(RelativeLayout relativeLayoutNavigationBarCenter)
	{
		this.relativeLayoutNavigationBarCenter = relativeLayoutNavigationBarCenter;
	}

	public RelativeLayout getRelativeLayoutNavigationBarLeft()
	{
		return relativeLayoutNavigationBarLeft;
	}

	public void setRelativeLayoutNavigationBarLeft(RelativeLayout relativeLayoutNavigationBarLeft)
	{
		this.relativeLayoutNavigationBarLeft = relativeLayoutNavigationBarLeft;
	}

	public void setHasContentView(boolean hasContentView)
	{
		this.hasContentView = hasContentView;
	}

	public RelativeLayout getRelativeLayoutNavigationBar()
	{
		return relativeLayoutNavigationBar;
	}

	public void setHasNavigationBar(boolean hasNavigationBar)
	{
		this.hasNavigationBar = hasNavigationBar;
	}

	public void setNavigationBarId(int navigationBarId)
	{
		this.navigationBarId = navigationBarId;
	}

	public void setNavigationBarBackground(int navigationBarBackground)
	{
		this.navigationBarBackground = navigationBarBackground;
	}

	public TextView getTextViewInNavigationBar()
	{
		return textViewInNavigationBar;
	}

	public void setHasTextViewInNavigationBarMiddle(boolean hasTextViewInNavigationBarMiddle)
	{
		this.hasTextViewInNavigationBarMiddle = hasTextViewInNavigationBarMiddle;
	}

	public void setTextViewInNavigationBarColor(int textViewInNavigationBarColor)
	{
		this.textViewInNavigationBarColor = textViewInNavigationBarColor;
	}

	public void setTextViewInNavigationBarStringId(int textViewInNavigationBarStringId)
	{
		this.textViewInNavigationBarStringId = textViewInNavigationBarStringId;
	}

	public void setHasBackButton(boolean hasBackButton)
	{
		this.hasBackButton = hasBackButton;
	}

	// Constructor
	public ActivityBaseAttribute(Activity activity)
	{
		this.activity = activity;
	}

	/*
	 * //xml布局文件和activity名字相同（忽略大小写）自动获取布局文件； 使用方式如下 baseAttribute = new
	 * BaseAttribute(this); onInitAttribute(baseAttribute);
	 * baseAttribute.setContentView();
	 */
	public void setContentView()
	{

		if (hasContentView)
		{
			// 得到class文件的名字
			String activityName = activity.getClass().getName();
			int nIndex = activityName.lastIndexOf(".");
			if (nIndex != -1)
			{
				// 转换成把名字转换成小写
				final String strResourceName = activityName.substring(nIndex + 1).toLowerCase(Locale.getDefault());
				//
				final int nLayoutId = activity.getResources().getIdentifier(strResourceName, "layout", activity.getPackageName());

				if (nLayoutId != 0)
				{
					activity.setContentView(nLayoutId);
//					initNavigationBar();
				}
			}
		}
	}

	// 如果有导航条
	private void initNavigationBar()
	{
		if (hasNavigationBar)
		{
			relativeLayoutNavigationBar = (RelativeLayout) activity.findViewById(navigationBarId);
			relativeLayoutNavigationBarLeft = new RelativeLayout(activity);
			relativeLayoutNavigationBarCenter = new RelativeLayout(activity);

			// ??
			relativeLayoutNavigationBar.setBackgroundColor(navigationBarBackground);

			// 设置中部显示的消息

			if (hasTextViewInNavigationBarMiddle)
			{
				// 用来显示下拉列表
				// relativeLayoutNavigationBar.addView(onCreateCenterChoose(),onCreateTextViewInNavigationBarMiddleLayoutParams());

				onCreateTextViewInNavigationBarMiddle();
				addTextForTextViewInNavigationBarMiddle(textViewInNavigationBarStringId);
				setTextViewInNavigationBarColor();

			}
			// 设置左边是否有显示的消息（）
			if (hasBackButton)
			{

				relativeLayoutNavigationBarLeft.addView(onCreateBackButton(), onCreateBackButtonLayoutParamsleftleft());
				relativeLayoutNavigationBar.addView(relativeLayoutNavigationBarLeft, onCreateBackButtonLayoutParams());

				relativeLayoutNavigationBarLeft.setOnClickListener(new OnClickListener()
				{

					@Override
					public void onClick(View v)
					{
						// TODO Auto-generated method stub
						activity.onBackPressed();
					}
				});

			}
		}
	}

	private void addTextForTextViewInNavigationBarMiddle(int nResId)
	{
		textViewInNavigationBar.setText(nResId);
		relativeLayoutNavigationBarCenter.addView(textViewInNavigationBar, onCreateBackButtonLayoutParamsleftleft());
		relativeLayoutNavigationBar.addView(relativeLayoutNavigationBarCenter, onCreateTextViewInNavigationBarMiddleLayoutParams());
	}

	private void setTextViewInNavigationBarColor()
	{
		textViewInNavigationBar.setTextColor(textViewInNavigationBarColor);
	}

	@SuppressLint("InflateParams")
	private void onCreateTextViewInNavigationBarMiddle()
	{
		textViewInNavigationBar = (TextView) LayoutInflater.from(activity).inflate(R.layout.activity_base_attribute_btn_title_left_back_navigation_bar, null);
	}

	private RelativeLayout.LayoutParams onCreateTextViewInNavigationBarMiddleLayoutParams()
	{
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		lp.addRule(RelativeLayout.CENTER_IN_PARENT);
		return lp;
	}

	@SuppressLint("InflateParams")
	private View onCreateBackButton()
	{
		final TextView viewBack = (TextView) LayoutInflater.from(activity).inflate(R.layout.activity_base_attribute_btn_title_left_back_navigation_bar_left_back, null);
		return viewBack;
	}

	private RelativeLayout.LayoutParams onCreateBackButtonLayoutParams()
	{
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		return lp;
	}

	private RelativeLayout.LayoutParams onCreateBackButtonLayoutParamsleftleft()
	{
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		lp.addRule(RelativeLayout.ALIGN_LEFT);
		return lp;
	}

}

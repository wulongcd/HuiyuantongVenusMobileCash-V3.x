package com.sintn.hera.mobile.cash.widget.dialog;

import java.util.Calendar;
import java.util.Date;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.R;

/**
 * 
 * @com.sintn.hera.shop.widget.dialog
 * @HuiyuantongVenusShopCash-V3.x
 * @SearchProductDialog.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 显示通用提示消息的对话框对话框
 * @2015-2-11下午3:41:49
 */
public class NormalDateChoiceWithCallbackDialog extends Dialog implements OnDateChangedListener, OnTimeChangedListener
{
	private String initDateTime;
	private Date dateTime;
	private DatePicker datePicker;
	private TimePicker timePicker;
	private int eventCode = -1;
	private boolean needShowTimePocker;

	public NormalDateChoiceWithCallbackDialog(Context context, boolean needShowTimePocker)
	{
		super(context, R.style.backgroundTransparentDialog);
		this.needShowTimePocker = needShowTimePocker;
		initDailag();
	}

	public NormalDateChoiceWithCallbackDialog(Context context, int eventCode, boolean needShowTimePocker)
	{
		super(context, R.style.backgroundTransparentDialog);
		this.eventCode = eventCode;
		this.needShowTimePocker = needShowTimePocker;
		initDailag();
	}

	@SuppressWarnings("deprecation")
	private void initDailag()
	{
		this.setContentView(R.layout.zone_dialog_of_chioce_date);
		// 设置点击对话框周边消失
		this.setCanceledOnTouchOutside(false);
		Window dialogWindow = this.getWindow();
		// 添加动画
		dialogWindow.setWindowAnimations(R.style.mystyle_translation_from_header_to_bottom_animation);
		WindowManager m = dialogWindow.getWindowManager();
		// 获取屏幕宽、高用
		Display d = m.getDefaultDisplay();
		// 获取对话框当前的参数值
		WindowManager.LayoutParams parm = dialogWindow.getAttributes();
		parm.height = (int) (d.getHeight() * 0.5);
		parm.width = (int) (d.getWidth() * 1.0);
		dialogWindow.setGravity(Gravity.TOP);
		dialogWindow.setAttributes(parm);

		// 初始化UI
		datePicker = (DatePicker) this.findViewById(R.id.datepicker);
		timePicker = (TimePicker) this.findViewById(R.id.timepicker);
		if (!needShowTimePocker)
		{
			timePicker.setVisibility(View.GONE);
		}
		initPicker(datePicker, timePicker);
		timePicker.setIs24HourView(true);
		timePicker.setOnTimeChangedListener(this);

		// set the submit button
		((Button) this.findViewById(R.id.zone_dialog_show_normal_message_tv_sure)).setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				dismiss();
				if (eventCode != -1)
				{
					// 发送全局回调参数表明店铺数据已经成功下载
					AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(eventCode), 0, dateTime);
				} else
				{
					// 发送全局回调参数表明店铺数据已经成功下载
					AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_PRESS_CALLBACK), 0, dateTime);
				}
			}
		});
		((Button) this.findViewById(R.id.zone_dialog_show_normal_message_tv_cancle)).setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				dismiss();
			}
		});
	}

	public void initPicker(DatePicker datePicker, TimePicker timePicker)
	{
		Calendar calendar = Calendar.getInstance();
		if (!(null == initDateTime || "".equals(initDateTime)))
		{
			calendar = this.getCalendarByInintData(initDateTime);
		} else
		{
			initDateTime = calendar.get(Calendar.YEAR) + "年" + calendar.get(Calendar.MONTH) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日 " + calendar.get(Calendar.HOUR_OF_DAY) + ":"
					+ calendar.get(Calendar.MINUTE);
		}

		datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), this);
		timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
		timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
		onDateChanged(null, 0, 0, 0);
	}

	/**
	 * 实现将初始日期时间2012年07月02日 16:45 拆分成年 月 日 时 分 秒,并赋值给calendar
	 * 
	 * @param initDateTime
	 *            初始日期时间值 字符串型
	 * @return Calendar
	 */
	private Calendar getCalendarByInintData(String initDateTime)
	{
		Calendar calendar = Calendar.getInstance();

		// 将初始日期时间2012年07月02日 16:45 拆分成年 月 日 时 分 秒
		String date = spliteString(initDateTime, "日", "index", "front"); // 日期
		String time = spliteString(initDateTime, "日", "index", "back"); // 时间

		String yearStr = spliteString(date, "年", "index", "front"); // 年份
		String monthAndDay = spliteString(date, "年", "index", "back"); // 月日

		String monthStr = spliteString(monthAndDay, "月", "index", "front"); // 月
		String dayStr = spliteString(monthAndDay, "月", "index", "back"); // 日

		String hourStr = spliteString(time, ":", "index", "front"); // 时
		String minuteStr = spliteString(time, ":", "index", "back"); // 分

		int currentYear = Integer.valueOf(yearStr.trim()).intValue();
		int currentMonth = Integer.valueOf(monthStr.trim()).intValue() - 1;
		int currentDay = Integer.valueOf(dayStr.trim()).intValue();
		int currentHour = Integer.valueOf(hourStr.trim()).intValue();
		int currentMinute = Integer.valueOf(minuteStr.trim()).intValue();

		calendar.set(currentYear, currentMonth, currentDay, currentHour, currentMinute);
		return calendar;
	}

	/**
	 * 截取子串
	 * 
	 * @param srcStr
	 *            源串
	 * @param pattern
	 *            匹配模式
	 * @param indexOrLast
	 * @param frontOrBack
	 * @return
	 */
	public static String spliteString(String srcStr, String pattern, String indexOrLast, String frontOrBack)
	{
		String result = "";
		int loc = -1;
		if (indexOrLast.equalsIgnoreCase("index"))
		{
			loc = srcStr.indexOf(pattern); // 取得字符串第一次出现的位置
		} else
		{
			loc = srcStr.lastIndexOf(pattern); // 最后一个匹配串的位置
		}
		if (frontOrBack.equalsIgnoreCase("front"))
		{
			if (loc != -1)
				result = srcStr.substring(0, loc); // 截取子串
		} else
		{
			if (loc != -1)
				result = srcStr.substring(loc + 1, srcStr.length()); // 截取子串
		}
		return result;
	}

	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute)
	{
		// TODO Auto-generated method stub
		onDateChanged(null, 0, 0, 0);
	}

	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth)
	{
		// TODO Auto-generated method stub
		// 获得日历实例
		Calendar calendar = Calendar.getInstance();
		calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), timePicker.getCurrentHour(), timePicker.getCurrentMinute());
		dateTime = calendar.getTime();
	}

}

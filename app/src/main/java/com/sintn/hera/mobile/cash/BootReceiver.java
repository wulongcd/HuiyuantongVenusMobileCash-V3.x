package com.sintn.hera.mobile.cash;

import com.sintn.hera.mobile.cash.activity.login.StartActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent)
	{
		// 接收广播：系统启动完成后运行程序
		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
		{
			Intent newIntent = new Intent(context, StartActivity.class);
			newIntent.setAction("android.intent.action.MAIN");
			newIntent.addCategory("android.intent.category.LAUNCHER");
			newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(newIntent);
		}
		// 接收广播：设备上新安装了一个应用程序包后自动启动新安装应用程序。
		else if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED"))
		{
			String packageName = intent.getDataString().substring(8);
			System.out.println("**************android.intent.action.PACKAGE_ADDED******************" + packageName);
			if (packageName.equals("com.sintn.hera.mobile.cash"))
			{
				Intent newIntent = new Intent();
				newIntent.setClassName(packageName, packageName + ".StartActivity");
				newIntent.setAction("android.intent.action.MAIN");
				newIntent.addCategory("android.intent.category.LAUNCHER");
				newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(newIntent);
			}
		}
		// 接收广播：设备上删除了一个应用程序包。
		else if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
		{
			System.out.println("**************android.intent.action.PACKAGE_REMOVED******************");
		}
	}
}
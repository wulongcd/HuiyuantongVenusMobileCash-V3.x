package com.sintn.hera.mobile.cash.utils.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.os.Environment;
import android.text.TextUtils;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.JsonEntity;
import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.event.httpevent.DownloadEvent;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.manager.LocalDataManager;

/**
 * 
 * @Desc: 网络访问工具类
 * @com.sintn.hera.mobile.cash.utils.core
 * @HuiyuantongVenusMobileCash-V3.x
 * @HttpUtils.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:09:33
 */

public class HttpUtils
{

	/**
	 * 请求超时12秒钟
	 */
	private static final int REQUEST_TIMEOUT = 12 * 1000;
	/**
	 * 等待数据超时时间80秒钟
	 */
	private static final int SO_TIMEOUT = 80 * 1000;
	/**
	 * httpClient客户端本地缓存
	 */
	private static DefaultHttpClient httpClient = null;

	/**
	 * 初始化单例对象
	 * 
	 * @param isLong
	 * @return
	 */
	public static DefaultHttpClient getHttpClient(boolean isLong)
	{
		if (httpClient == null)
		{
			synchronized (HttpUtils.class)
			{
				if (httpClient == null)
				{
					httpClient = new DefaultHttpClient();
				}
			}
		}
		HttpParams params = httpClient.getParams();
		params.setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, "UTF-8");
		if (isLong)
		{
			HttpConnectionParams.setConnectionTimeout(params, 1000 * 7200);
			HttpConnectionParams.setSoTimeout(params, 1000 * 7200);
		} else
		{
			HttpConnectionParams.setConnectionTimeout(params, REQUEST_TIMEOUT);
			HttpConnectionParams.setSoTimeout(params, SO_TIMEOUT);
		}
		return httpClient;
	}

	/**
	 * GET方式访问网络
	 * 
	 * @param strUrl
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static HttpResponse doGet(String strUrl) throws UnsupportedEncodingException
	{
		HttpResponse response = null;
		try
		{
			HttpGet httpGet = new HttpGet(strUrl);

			if (!TextUtils.isEmpty(LocalDataManager.getsInstance().getJsessionId()))
			{
				httpGet.setHeader("Cookie", "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
				System.out.println("Cookie->Up" + "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
			}
			CookieStore mCookieStoreonedd;
			response = getHttpClient(false).execute(httpGet);
			mCookieStoreonedd = getHttpClient(false).getCookieStore();
			List<Cookie> cookiesoneddd = mCookieStoreonedd.getCookies();
			for (int i = 0; i < cookiesoneddd.size(); i++)
			{
				if ("JSESSIONID".equals(cookiesoneddd.get(i).getName()))
				{
					LocalDataManager.getsInstance().setJsessionId(cookiesoneddd.get(i).getValue());
					System.out.println("Cookie->Down" + "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * POST方式访问网络
	 * 
	 * @param strUrl
	 * @param object
	 * @return
	 */
	public static HttpResponse doPost(String strUrl, Object object)
	{
		HttpResponse response = null;
		try
		{
			HttpPost httpPost = new HttpPost(strUrl);
			httpPost.setEntity(new JsonEntity(object));
			if (!TextUtils.isEmpty(LocalDataManager.getsInstance().getJsessionId()))
			{
				httpPost.setHeader("Cookie", "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
				System.out.println("Cookie->Up" + "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
			}
			response = getHttpClient(false).execute(httpPost);
			CookieStore mCookieStoreonedd = getHttpClient(false).getCookieStore();
			List<Cookie> cookiesoneddd = mCookieStoreonedd.getCookies();
			for (int i = 0; i < cookiesoneddd.size(); i++)
			{
				if ("JSESSIONID".equals(cookiesoneddd.get(i).getName()))
				{
					LocalDataManager.getsInstance().setJsessionId(cookiesoneddd.get(i).getValue());
					System.out.println("Cookie->Down" + "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
				}
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 删除网络Cookie
	 * 
	 * @param strUrl
	 * @return
	 */
	public static HttpResponse doDelete(String strUrl)
	{
		HttpResponse response = null;
		try
		{
			HttpDelete httpDelete = new HttpDelete(strUrl);
			if (!TextUtils.isEmpty(LocalDataManager.getsInstance().getJsessionId()))
			{
				httpDelete.setHeader("Cookie", "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
				System.out.println("Cookie->Up" + "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
			}
			response = getHttpClient(false).execute(httpDelete);
			CookieStore mCookieStoreonedd = getHttpClient(false).getCookieStore();
			List<Cookie> cookiesoneddd = mCookieStoreonedd.getCookies();
			for (int i = 0; i < cookiesoneddd.size(); i++)
			{
				if ("JSESSIONID".equals(cookiesoneddd.get(i).getName()))
				{
					LocalDataManager.getsInstance().setJsessionId(cookiesoneddd.get(i).getValue());
					System.out.println("Cookie->Down" + "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 上传数据
	 * 
	 * @param strUrl
	 * @param object
	 * @return
	 */
	public static HttpResponse doPut(String strUrl, Object object)
	{
		HttpResponse response = null;
		try
		{
			HttpPut httpPut = new HttpPut(strUrl);
			httpPut.setEntity(new JsonEntity(object));
			if (!TextUtils.isEmpty(LocalDataManager.getsInstance().getJsessionId()))
			{
				httpPut.setHeader("Cookie", "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());

				System.out.println("Cookie->Up" + "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
			}
			response = getHttpClient(false).execute(httpPut);
			CookieStore mCookieStoreonedd = getHttpClient(false).getCookieStore();
			List<Cookie> cookiesoneddd = mCookieStoreonedd.getCookies();
			for (int i = 0; i < cookiesoneddd.size(); i++)
			{
				if ("JSESSIONID".equals(cookiesoneddd.get(i).getName()))
				{
					LocalDataManager.getsInstance().setJsessionId(cookiesoneddd.get(i).getValue());
					System.out.println("Cookie->Down" + "JSESSIONID=" + LocalDataManager.getsInstance().getJsessionId());
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 根据URL下载文件
	 * 
	 * @param url
	 * @return
	 */
	public static int downFile(String url)
	{
		HttpResponse response = null;
		try
		{
			HttpGet get = new HttpGet(url);
			response = getHttpClient(false).execute(get);
			if (response == null)
			{
				return DownloadEvent.NO_NET;
			}
			HttpEntity entity = response.getEntity();
			long length = entity.getContentLength();
			InputStream is = entity.getContent();
			FileOutputStream fileOutputStream = null;
			if (is != null)
			{
				File file = new File(Environment.getExternalStorageDirectory(), "HeraMobileCash_upldate_cache.apk");
				fileOutputStream = new FileOutputStream(file);
				byte[] buf = new byte[1024];
				int ch = -1;
				int count = 0;
				while ((ch = is.read(buf)) != -1)
				{
					fileOutputStream.write(buf, 0, ch);
					count += ch;
					AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(EventCode.CALLBACK_DownloadProgress, (int) ((count * 100) / length)), 0);
				}
			}
			fileOutputStream.flush();
			if (fileOutputStream != null)
			{
				fileOutputStream.close();
			}
			return DownloadEvent.SUCCESS;
		} catch (Exception e)
		{
			e.printStackTrace();
			return DownloadEvent.FAILD;
		}
	}
}

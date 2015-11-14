package com.sintn.hera.mobile.cash.entity.down;

import java.io.Serializable;

/**
 * 
 * @Desc: 企业通知下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @EnterpriseNotificationDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:08:33
 */
@SuppressWarnings("serial")
public class EnterpriseNotificationDown implements Serializable
{
	private long id;

	private boolean deleted;

	// 状态，参见NotificationStatus类
	private int status;

	// 通知类型，参见NotificationType类
	private int type;

	// 通知内容
	private String content;

	// 创建时间
	private String createDate;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

}

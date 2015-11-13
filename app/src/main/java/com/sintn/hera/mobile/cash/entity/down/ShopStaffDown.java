package com.sintn.hera.mobile.cash.entity.down;

import java.util.Date;


public class ShopStaffDown {

	private long id;
	
	// 用户名称
	private String username;
	
	// 员工编号
	private String code;
	
	// 员工名称
	private String name;
	
	// 性别
	private String sex;
	
	// 电话
	private String phone;
	
	// 身份证
	private String idcard;
	
	// 生日
	private Date birthday;
	
	//职务
	private String job;
	
	// 入职时间
	private Date dateEmployed;
	
	//所属店铺
	private String shop;

	public ShopStaffDown()
	{
		super();
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getIdcard()
	{
		return idcard;
	}

	public void setIdcard(String idcard)
	{
		this.idcard = idcard;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public Date getDateEmployed()
	{
		return dateEmployed;
	}

	public void setDateEmployed(Date dateEmployed)
	{
		this.dateEmployed = dateEmployed;
	}

	public String getShop()
	{
		return shop;
	}

	public void setShop(String shop)
	{
		this.shop = shop;
	}

	public String getJob()
	{
		return job;
	}

	public void setJob(String job)
	{
		this.job = job;
	}
	
}


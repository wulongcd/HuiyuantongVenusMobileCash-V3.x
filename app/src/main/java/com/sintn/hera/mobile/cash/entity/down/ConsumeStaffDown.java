package com.sintn.hera.mobile.cash.entity.down;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class ConsumeStaffDown
{

	//订单ID
	private long id;
	
	//订单类型，1-散客消费订单，2-会员消费订单，更多参考com.sintn.venus.constant.OrderType
	private int type;
	
	//卡片类型名称
	private String cardType;
	
	//会员名称
	private String customerName;
	
	//商品名称product_name:pname
	private String pname;
	
	// 原价originalPrice-op
	private double originalPrice;
		
	// 现价actualPrice-ap
	private double actualPrice;
	
	// 提成基数
	private double base;
	
	//支付方式
	private String payment;
	
	//提成类型
	private String dividType;
	
	//是否是点客，如果不是就表示散客
	private boolean isSelect;
	
	//业绩,DividendItem-actualPrice
	private double sale;
	
	//提成
	private double dividMoney;
	
	//订单Order 的交易时间
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	
	//订单编号
	private String code;

	public ConsumeStaffDown()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getCardType()
	{
		return cardType;
	}

	public void setCardType(String cardType)
	{
		this.cardType = cardType;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public String getPname()
	{
		return pname;
	}

	public void setPname(String pname)
	{
		this.pname = pname;
	}

	public double getOriginalPrice()
	{
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice)
	{
		this.originalPrice = originalPrice;
	}

	public double getActualPrice()
	{
		return actualPrice;
	}

	public void setActualPrice(double actualPrice)
	{
		this.actualPrice = actualPrice;
	}

	public double getBase()
	{
		return base;
	}

	public void setBase(double base)
	{
		this.base = base;
	}

	public String getPayment()
	{
		return payment;
	}

	public void setPayment(String payment)
	{
		this.payment = payment;
	}

	public String getDividType()
	{
		return dividType;
	}

	public void setDividType(String dividType)
	{
		this.dividType = dividType;
	}

	public boolean isSelect()
	{
		return isSelect;
	}

	public void setSelect(boolean isSelect)
	{
		this.isSelect = isSelect;
	}

	public double getSale()
	{
		return sale;
	}

	public void setSale(double sale)
	{
		this.sale = sale;
	}

	public double getDividMoney()
	{
		return dividMoney;
	}

	public void setDividMoney(double dividMoney)
	{
		this.dividMoney = dividMoney;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

}

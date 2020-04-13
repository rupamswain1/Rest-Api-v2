package com.api.paypal.pojo;

import java.util.Map;

public class PurchaseUnits {

	private Amount amount=null;
	
	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public PurchaseUnits(Map<String, String> data)
	{
		this.amount=new Amount(data);
	}
}

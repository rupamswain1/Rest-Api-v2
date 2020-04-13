package com.api.paypal.pojo;

import java.util.Map;

public class Amount {
	private String currency_code=null;
	private String value=null;
	
	
	
	public String getCurrency_code() {
		return currency_code;
	}


	public void setCurrency_Code(String currency_Code) {
		this.currency_code = currency_Code;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public Amount(Map<String, String> data)
	{
		this.currency_code=data.get("currency_code");
		this.value=data.get("value");
	}
}

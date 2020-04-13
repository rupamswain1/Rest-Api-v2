package com.api.paypal.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hpsf.Array;

public class CreateOrderPojo {
	private String intent=null;
	private List<PurchaseUnits> purchase_units=null;
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	
	
	public List<PurchaseUnits> getPurchase_units() {
		return purchase_units;
	}
	public void setPurchase_units(List<PurchaseUnits> purchase_units) {
		this.purchase_units = purchase_units;
	}
	public CreateOrderPojo(Map<String, String> data){
		this.intent=data.get("intent");
		this.purchase_units=new ArrayList<PurchaseUnits>();
		
		this.purchase_units.add(new PurchaseUnits(data));
		System.out.println(purchase_units.size());
		System.out.println(purchase_units.get(0).getAmount().getCurrency_code());
	}
}

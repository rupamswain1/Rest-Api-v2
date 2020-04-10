package com.api.stripe.customer.requests;

import static io.restassured.RestAssured.*;

import com.api.baseClass.BaseApiRequest;

import io.restassured.response.Response;
public class GetCustomer extends BaseApiRequest{

	public Response getAllCutomers() throws Exception
	{
		
		Response response=given().auth().basic(getApplicationData("SECURITY_KEY"), "")
							.get(getApplicationData("baseUri")+getApplicationData("getEndpoint"));
		return response;
	}
	
	public Response getCustomer(String custId) throws Exception
	{
		String uri=getApplicationData("baseUri")+getApplicationData("getEndpoint")+"/"+custId;
		Response response=given().auth().basic(getApplicationData("SECURITY_KEY"), "")
							.get(uri);
		return response;
	}
	public Response getCustomerList(int limit) throws Exception
	{
		Response response=given().auth().basic(getApplicationData("SECURITY_KEY"), "").formParam("limit", limit)
							.get(getApplicationData("baseUri")+getApplicationData("getEndpoint"));
		return response;
	}
	
	/*public static void main(String args[])
	{
		GetCustomer cust=new GetCustomer();
		//cust.getCustomer("cus_H0Lf3RnGMQL6jY").prettyPrint();
		cust.getCustomerList(3).prettyPrint();
	}*/
}

package com.api.stripe.customer.requests;

import static io.restassured.RestAssured.*;
import java.util.Map;

import io.restassured.response.Response;
public class PutCustomer extends BaseApiRequest{

	public Response updateCustomerData(String custId,Map<String, String> data) throws Exception
	{
		String url=getApplicationData("baseUri")+getApplicationData("putEndpoint")+custId;
		Response response=given().auth().basic(getApplicationData("SECURITY_KEY"), "").
				formParams(data).post(url);
		
		return response;
	}
	
	/*public static void main(String args[])
	{
		Map<String , Object> data=new HashMap<String, Object>();
		data.put("description", "demo user 1");
		data.put("email", "abc@pqr.com");
		PutCustomer put=new PutCustomer();
		put.updateCustomerData("cus_H0MR0NjaXQ76aA", data).prettyPrint();
	}*/
}

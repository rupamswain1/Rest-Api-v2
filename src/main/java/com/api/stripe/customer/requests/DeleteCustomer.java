package com.api.stripe.customer.requests;

import static io.restassured.RestAssured.*;

import com.api.baseClass.BaseApiRequest;
import com.api.common.utils.PropertFileReader;

import io.restassured.response.Response;

public class DeleteCustomer extends BaseApiRequest{
	
	public Response deleteCustomer(String custId) throws Exception
	{
		String url=getApplicationData("baseUri")+getApplicationData("deleteEndpoint")+custId;
		Response response=given().auth().basic(getApplicationData("SECURITY_KEY"), "").delete(url);
		return response;
	}
	
	/*public static void main(String[] args)
	{
		DeleteCustomer del=new DeleteCustomer();
		del.deleteCustomer("cus_H0MtoUkSBQPj1X").prettyPrint();
	}*/
}

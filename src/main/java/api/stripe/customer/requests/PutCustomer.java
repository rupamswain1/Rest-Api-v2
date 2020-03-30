package api.stripe.customer.requests;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import api.resources.StripeApiCustomerResources;
import io.restassured.response.Response;
public class PutCustomer {

	public Response updateCustomerData(String custId,Map<String, Object> data)
	{
		StripeApiCustomerResources resource=new StripeApiCustomerResources();
		String url=resource.getBaseUri()+resource.getPutEndpoint()+custId;
		Response response=given().auth().basic(resource.getSECURITY_KEY(), "").
				formParams(data).post(url);
		
		return response;
	}
	
	public static void main(String args[])
	{
		Map<String , Object> data=new HashMap<String, Object>();
		data.put("description", "demo user 1");
		data.put("email", "abc@pqr.com");
		PutCustomer put=new PutCustomer();
		put.updateCustomerData("cus_H0MR0NjaXQ76aA", data).prettyPrint();
	}
}

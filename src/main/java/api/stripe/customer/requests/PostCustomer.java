package api.stripe.customer.requests;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import api.resources.StripeApiCustomerResources;

import io.restassured.response.Response;

public class PostCustomer {
	
	public Response createCustomer() {
		StripeApiCustomerResources resource=new StripeApiCustomerResources();
		Response response=given().auth()
							.basic(resource.getSECURITY_KEY(), "")
							.post(resource.getBaseUri()+resource.getPostEndpoint());
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		return response;
	}
	public Response createCustomer(Map<String, Object> data)
	{
		StripeApiCustomerResources resource=new StripeApiCustomerResources();
		Response response=given().auth()
							.basic(resource.getSECURITY_KEY(), "").formParams(data)
							.post(resource.getBaseUri()+resource.getPostEndpoint());
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		return response;
	}
	
	/*public static void main(String args[])
	{
		PostCustomer cust=new PostCustomer();
		Map<String , Object> data=new HashMap<String, Object>();
		data.put("description", "demo user 1");
		data.put("email", "abc@pqr.com");
		cust.createCustomer(data).prettyPrint();
	}*/
}

package api.stripe.customer.requests;

import static io.restassured.RestAssured.*;

import api.resources.StripeApiCustomerResources;
import io.restassured.response.Response;
public class GetCustomer {

	public Response getAllCutomers()
	{
		StripeApiCustomerResources resources=new StripeApiCustomerResources();
		Response response=given().auth().basic(resources.getSECURITY_KEY(), "")
							.get(resources.getBaseUri()+resources.getGetEndpoint());
		return response;
	}
	
	public Response getCustomer(String custId)
	{
		StripeApiCustomerResources resources=new StripeApiCustomerResources();
		String uri=resources.getBaseUri()+resources.getGetEndpoint()+"/"+custId;
		Response response=given().auth().basic(resources.getSECURITY_KEY(), "")
							.get(uri);
		return response;
	}
	public Response getCustomerList(int limit)
	{
		StripeApiCustomerResources resources=new StripeApiCustomerResources();
		Response response=given().auth().basic(resources.getSECURITY_KEY(), "").formParam("limit", limit)
							.get(resources.getBaseUri()+resources.getGetEndpoint());
		return response;
	}
	
	public static void main(String args[])
	{
		GetCustomer cust=new GetCustomer();
		//cust.getCustomer("cus_H0Lf3RnGMQL6jY").prettyPrint();
		cust.getCustomerList(3).prettyPrint();
	}
}

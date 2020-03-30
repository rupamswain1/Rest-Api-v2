package api.stripe.customer.requests;

import static io.restassured.RestAssured.*;

import api.resources.StripeApiCustomerResources;
import io.restassured.response.Response;

public class DeleteCustomer {
	
	public Response deleteCustomer(String custId)
	{
		StripeApiCustomerResources resource=new StripeApiCustomerResources();
		String url=resource.getBaseUri()+resource.getDeleteEndpoint()+custId;
		Response response=given().auth().basic(resource.getSECURITY_KEY(), "").delete(url);
		return response;
	}
	
	public static void main(String[] args)
	{
		DeleteCustomer del=new DeleteCustomer();
		del.deleteCustomer("cus_H0MtoUkSBQPj1X").prettyPrint();
	}
}

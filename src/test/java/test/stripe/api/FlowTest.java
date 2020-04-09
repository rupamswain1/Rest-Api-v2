package test.stripe.api;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.stripe.customer.requests.DeleteCustomer;
import api.stripe.customer.requests.GetCustomer;
import api.stripe.customer.requests.PostCustomer;
import api.stripe.customer.requests.PutCustomer;
import io.restassured.response.Response;
public class FlowTest {
	static String custId="";
	@Test(description="create a blank customer",priority=1)
	public void createCustomer() throws Exception
	{
		PostCustomer post=new PostCustomer();
		Response response=post.createCustomer();
		assertEquals(response.statusCode(), 200);
		FlowTest.custId=response.jsonPath().get("id");
		JSONObject jsonObject=new JSONObject(response.asString());
		Assert.assertTrue(jsonObject.has("id"));
		System.out.println("Generated customer id is: "+FlowTest.custId);
	}
	
	@Test(description="Get customer details", dependsOnMethods="createCustomer")
	public void getCustomerDetails() throws Exception
	{
		GetCustomer customer=new GetCustomer();
		Response response=customer.getAllCutomers();
		assertEquals(response.getStatusCode(), 200);
		//response.prettyPrint();
		List<String> d=response.jsonPath().getList("data.id");
		System.out.println(d.size());
		for(String s:d)
		{
			System.out.println(s);
		}
	}
	@Test(description="Update customer data",priority=2,dataProvider="dataProvider",dataProviderClass=com.api.dataprovider.DataProviders.class)
	public void updateCustomer(Map<String, String> data) throws Exception
	{
		
		
		PutCustomer updateCustomer=new PutCustomer();
		String custId=data.get("custId");
		data.remove("custId");
		Response response=updateCustomer.updateCustomerData(custId, data);
		assertEquals(response.getStatusCode(), 200);
				
	}
	@Test(description="Validate updated customer details", dependsOnMethods="updateCustomer",dataProvider="dataProvider",dataProviderClass=com.api.dataprovider.DataProviders.class)
	public void validatedUpdatedCustomerDetails(Map<String, String> data) throws Exception
	{
		GetCustomer customer=new GetCustomer();
		Response response=customer.getCustomer(data.get("custId"));
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.jsonPath().get("email"), data.get("email"));
		assertEquals(response.jsonPath().get("description"), data.get("description"));
		//response.prettyPrint();
	}
	@Test(description="delete customer", dependsOnMethods="validatedUpdatedCustomerDetails",dataProvider="dataProvider",dataProviderClass=com.api.dataprovider.DataProviders.class)
	public void deleteCustomer(Map<String, String> data) throws Exception
	{
		DeleteCustomer delete=new DeleteCustomer();
		Response response=delete.deleteCustomer(data.get("custId"));
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.jsonPath().get("id"), data.get("custId"));
		assertEquals(response.jsonPath().get("deleted"), true);
	}
	
}
package test.stripe.api;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import api.stripe.customer.requests.DeleteCustomer;
import api.stripe.customer.requests.GetCustomer;
import api.stripe.customer.requests.PostCustomer;
import api.stripe.customer.requests.PutCustomer;
import io.restassured.response.Response;
public class FlowTest {
	static String custId="";
	@Test(description="create a blank customer")
	public void createCustomer()
	{
		PostCustomer post=new PostCustomer();
		Response response=post.createCustomer();
		assertEquals(response.statusCode(), 200);
	
		FlowTest.custId=response.jsonPath().get("id");
		System.out.println("Generated customer id is: "+FlowTest.custId);
	}
	
	@Test(description="Get customer details", dependsOnMethods="createCustomer")
	public void getCustomerDetails()
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
	@Test(description="Update customer data", dependsOnMethods="getCustomerDetails")
	public void updateCustomer()
	{
		Map<String, Object> data=new HashMap<String, Object>();
		data.put("email", "emeail@email.com");
		data.put("description","No description");
		//data.put("address", "21 Baker street");
		PutCustomer updateCustomer=new PutCustomer();
		Response response=updateCustomer.updateCustomerData(FlowTest.custId, data);
		assertEquals(response.getStatusCode(), 200);
	}
	@Test(description="Validate updated customer details", dependsOnMethods="updateCustomer")
	public void validatedCustomerDetails()
	{
		GetCustomer customer=new GetCustomer();
		Response response=customer.getCustomer(FlowTest.custId);
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.jsonPath().get("email"), "emeail@email.com");
		//response.prettyPrint();
	}
	@Test(description="delete customer", dependsOnMethods="validatedCustomerDetails")
	public void deleteCustomer()
	{
		DeleteCustomer delete=new DeleteCustomer();
		Response response=delete.deleteCustomer(FlowTest.custId);
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.jsonPath().get("id"), FlowTest.custId);
		assertEquals(response.jsonPath().get("deleted"), true);
	}
	
}

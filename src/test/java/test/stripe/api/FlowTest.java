package test.stripe.api;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.api.baseClass.BaseApiTest;
import com.api.listners.ApiListner;
import com.api.stripe.customer.requests.DeleteCustomer;
import com.api.stripe.customer.requests.GetCustomer;
import com.api.stripe.customer.requests.PostCustomer;
import com.api.stripe.customer.requests.PutCustomer;
import com.aventstack.extentreports.Status;
import static com.api.asserts.Assert.*;
import io.restassured.response.Response;
public class FlowTest extends BaseApiTest{
	static String custId="";
	@Test(description="create a blank customer",priority=1)
	public void createCustomer() throws Exception
	{
		PostCustomer post=new PostCustomer();
		Response response=post.createCustomer();
		assertEquals(response.statusCode(), 200,"Staus code");
		FlowTest.custId=response.jsonPath().get("id");
		JSONObject jsonObject=new JSONObject(response.asString());
		assertTrue(jsonObject.has("id"));
		logPass("Customer id generated: "+FlowTest.custId);
		logPass(response.asString());
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
		logPass(response.asString());
	}
	@Test(description="Update customer data",priority=2,dataProvider="dataProvider",dataProviderClass=com.api.dataprovider.DataProviders.class)
	public void updateCustomer(Map<String, String> data) throws Exception
	{
		
		
		PutCustomer updateCustomer=new PutCustomer();
		String custId=data.get("custId");
		data.remove("custId");
		Response response=updateCustomer.updateCustomerData(custId, data);
		assertEquals(response.getStatusCode(), 200);
		logPass(response.asString());
				
	}
	@Test(description="Validate updated customer details", dependsOnMethods="updateCustomer",dataProvider="dataProvider",dataProviderClass=com.api.dataprovider.DataProviders.class)
	public void validatedUpdatedCustomerDetails(Map<String, String> data) throws Exception
	{
		GetCustomer customer=new GetCustomer();
		Response response=customer.getCustomer(data.get("custId"));
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.jsonPath().get("email"), data.get("email"));
		assertEquals(response.jsonPath().get("description"), data.get("description"));
		logPass(response.asString());
		//response.prettyPrint();
	}
	@Test(description="delete customer", dependsOnMethods="validatedUpdatedCustomerDetails",dataProvider="dataProvider",dataProviderClass=com.api.dataprovider.DataProviders.class)
	public void deleteCustomer(Map<String, String> data) throws Exception
	{
		DeleteCustomer delete=new DeleteCustomer();
		Response response=delete.deleteCustomer(data.get("custId"));
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.jsonPath().get("id"), data.get("custId"));
		assertEquals(response.jsonPath().get("deleted").toString(), "true");
		logPass(response.asString());
	}
	
}

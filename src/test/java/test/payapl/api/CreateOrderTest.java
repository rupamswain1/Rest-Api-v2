package test.payapl.api;

import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.api.baseClass.BaseApiTest;
import com.api.paypal.order.requests.PostRequests;
import com.api.paypal.pojo.CreateOrderPojo;

import io.restassured.response.Response;

public class CreateOrderTest extends BaseApiTest{

	@Test(description="create order", dataProviderClass=com.api.dataprovider.DataProviders.class,dataProvider="dataProvider",groups="paypal")
	public void createPaypalOrder(Map<String, String> data) throws Exception
	{
		CreateOrderPojo pojo=new CreateOrderPojo(data);
		Response response=new PostRequests().createOrder(pojo);
		assertEquals(response.getStatusCode(), 201);
		assertEquals(response.jsonPath().get("status"), "CREATED");
		response.prettyPrint();
		JSONObject  jsonObject=new JSONObject(response.asString());
		assertTrue(jsonObject.has("id"));
	}
	
	@Test(description="Invalid data to create order", dataProviderClass=com.api.dataprovider.DataProviders.class,dataProvider="dataProvider",groups="paypal")
	public void createPaypalOrderInvalidData(Map<String, String> data) throws Exception
	{
		CreateOrderPojo pojo=new CreateOrderPojo(data);
		Response response=new PostRequests().createOrder(pojo);
		assertEquals(response.getStatusCode(), 400);
		assertEquals(response.jsonPath().get("name"), "INVALID_REQUEST");
		
	}
}

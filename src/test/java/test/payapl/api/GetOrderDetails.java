package test.payapl.api;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.api.paypal.order.requests.GetRequests;
import com.api.paypal.order.requests.PostRequests;
import com.api.paypal.pojo.CreateOrderPojo;

import io.restassured.response.Response;

public class GetOrderDetails {

	@Test(description="Get order details", dataProviderClass=com.api.dataprovider.DataProviders.class,dataProvider="dataProvider",groups="paypal")
	public void getPaypalOrder(Map<String, String> data) throws Exception
	{
		
		Response response=new GetRequests().getOrder(data.get("orderId"));
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.jsonPath().get("id"), data.get("orderId"));
		//response.prettyPrint();
		assertEquals(response.jsonPath().get("purchase_units[0].amount.currency_code"), data.get("currency_code"));
		assertEquals(response.jsonPath().get("purchase_units[0].amount.value"), data.get("value"));
	}
}

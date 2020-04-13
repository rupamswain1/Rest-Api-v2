package test.payapl.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.api.paypal.order.requests.PostRequests;
import com.api.paypal.pojo.CreateOrderPojo;

import io.restassured.response.Response;

public class CreateToken {

	@Test(description="Generate Token id",groups="paypal")
	public void generateToken() throws Exception
	{
		Response response=new PostRequests().createAccessToken();
		response.prettyPrint();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.jsonPath().get("token_type"), "Bearer");
		JSONObject  jsonObject=new JSONObject(response.asString());
		assertTrue(jsonObject.has("access_token"), "Access token is available");
	}
	
}

package com.api.paypal.order.requests;

import com.api.baseClass.BaseApiRequest;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequests extends BaseApiRequest{

	public Response createAccessToken() throws Exception
	{
		Response response=given().param("grant_type", "client_credentials").
		auth().preemptive()
		.basic(getApplicationData("paypal.clientID"), getApplicationData("paypal.password"))
		.post(getApplicationData("paypal.baseUri")+getApplicationData("paypal.tokenEndpoint"));
		return response;
	}
	
	
	public Response createOrder() throws Exception
	{
		String accessToken=new PostRequests().createAccessToken().jsonPath().get("access_token");
		Response response=given().contentType(ContentType.JSON).
				auth().oauth2(accessToken).
				body("{\r\n" + 
						"  \"intent\": \"CAPTURE\",\r\n" + 
						"  \"purchase_units\": [\r\n" + 
						"    {\r\n" + 
						"      \"amount\": {\r\n" + 
						"        \"currency_code\": \"USD\",\r\n" + 
						"        \"value\": \"100.00\"\r\n" + 
						"      }\r\n" + 
						"    }\r\n" + 
						"  ]\r\n" + 
						"}").
				post(getApplicationData("paypal.baseUri")+getApplicationData("paypal.postEndpoint"));
		return response;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new PostRequests().createOrder().prettyPrint();
	}
}

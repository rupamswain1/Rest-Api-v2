package com.api.paypal.order.requests;

import static io.restassured.RestAssured.*;

import com.api.baseClass.BaseApiRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class GetRequests extends BaseApiRequest{

	public Response getOrder(String orderId) throws Exception
	{
		String accessToken=new PostRequests().createAccessToken().jsonPath().get("access_token");
		//System.out.println(accessToken);
		Response response=given().contentType(ContentType.JSON)
				.auth().oauth2(accessToken).
				get(getApplicationData("paypal.baseUri")+getApplicationData("paypal.getEndPoint").replace("{id}", orderId));
		return response;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new GetRequests().getOrder("222323738W037962U").prettyPrint();
	}

}

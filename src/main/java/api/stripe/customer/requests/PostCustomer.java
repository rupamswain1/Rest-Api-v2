package api.stripe.customer.requests;
import static io.restassured.RestAssured.*;
import java.util.Map;
import io.restassured.response.Response;

public class PostCustomer extends BaseApiRequest{
	
	public Response createCustomer() throws Exception {
		Response response=given().auth()
							.basic(getApplicationData("SECURITY_KEY"), "")
							.post(getApplicationData("baseUri")+getApplicationData("postEndpoint"));
		/*response.prettyPrint();
		System.out.println(response.getStatusCode());*/
		return response;
	}
	public Response createCustomer(Map<String, Object> data) throws Exception
	{
		Response response=given().auth()
							.basic(getApplicationData("SECURITY_KEY"), "").formParams(data)
							.post(getApplicationData("baseUri")+getApplicationData("postEndpoint"));
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		return response;
	}
	
	/*public static void main(String args[])
	{
		PostCustomer cust=new PostCustomer();
		Map<String , Object> data=new HashMap<String, Object>();
		data.put("description", "demo user 1");
		data.put("email", "abc@pqr.com");
		cust.createCustomer(data).prettyPrint();
	}*/
}

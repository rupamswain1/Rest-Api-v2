package test.stripe.steps;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.api.baseClass.BaseApiTest;
import com.api.common.utils.PropertFileReader;
import com.api.common.utils.PropertyFileWriter;
import com.api.stripe.customer.requests.DeleteCustomer;
import com.api.stripe.customer.requests.GetCustomer;
import com.api.stripe.customer.requests.PostCustomer;
import com.api.stripe.customer.requests.PutCustomer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class StripeCustomer {
	static Response response=null;
	@Given("^Create a general blank customer and store the cutomer id in \"([^\"]*)\"$")
	public void create_a_general_blank_customer_and_store_the_cutomer_id_in(String arg1) throws Throwable {
	   PostCustomer create=new PostCustomer();
	   Response response=create.createCustomer();
	   String custId=response.jsonPath().get("id");
	   PropertyFileWriter write=new PropertyFileWriter(); 
	   write.writeProperty(arg1, custId);
	   StripeCustomer.response=response;
	}

	@Then("^Validate customer id is created$")
	public void validate_customer_id_is_created() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(response.jsonPath().get("id").equals(new PropertFileReader().getTempData("custId")));
		
	}

	@Then("validate status code is {string}")
	public void validate_status_code_is_(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		response.prettyPrint();
		//System.out.println(response.getStatusCode()+"*****"+arg1);
		Assert.assertTrue(response.getStatusCode()==Integer.parseInt(arg1));
	}

	@Then("^Create a get request for cutomer \"([^\"]*)\"$")
	public void create_a_get_request_for_cutomer(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetCustomer getCustomer=new GetCustomer();
		String custId=new PropertFileReader().getTempData(arg1);
		StripeCustomer.response=getCustomer.getCustomer(custId);
	}  

	@Then("^Validate customer id is fetched for \"([^\"]*)\"$")
	public void validate_customer_id_is_fetched_for(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  Assert.assertTrue(StripeCustomer.response.jsonPath().get("id").toString().equals(new PropertFileReader().getTempData(arg1)));
	}

	@Then("Validate status code is {string}")
	public void validate_status_code_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(StripeCustomer.response.getStatusCode()==Integer.parseInt(arg1));
	}
	
	@Then("then customer with {string} updated with {string} and {string}")
	public void then_customer_is_updated_with_and(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PutCustomer updateCustomer=new PutCustomer();
		Map<String, String> data=new HashMap<String, String>();
		data.put("email", arg2);
		data.put("description", arg3);
		//System.out.println(data.get("email"));
		StripeCustomer.response=updateCustomer.updateCustomerData(new PropertFileReader().getTempData(arg1), data);
		StripeCustomer.response.prettyPrint();
	}

	
	@Then("validate email and description matches with {string} and {string}")
	public void validate_email_and_description_matches_with_and(String arg1, String arg2) throws Throwable {
	    String email=arg1;
	    String description=arg2;
	    //System.out.println(email);
	   Assert.assertTrue(response.jsonPath().get("email").equals(email));
	  Assert.assertTrue(response.jsonPath().get("description").equals(description));
	   
	}

	@Then("^user deletes customer \"([^\"]*)\"$")
	public void user_deletes_customer(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    DeleteCustomer delete=new DeleteCustomer();
	    StripeCustomer.response=delete.deleteCustomer(new PropertFileReader().getTempData(arg1));
	}

	@Then("user validates status code {string}")
	public void user_validates_status_code(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(StripeCustomer.response.getStatusCode()==Integer.parseInt(arg1));
	}

	@Then("user user validates delete fiels as {string}")
	public void user_user_validates_delete_fiels_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		StripeCustomer.response.prettyPrint();
		Assert.assertTrue(StripeCustomer.response.jsonPath().get("deleted").toString().equals(arg1));
	}


}

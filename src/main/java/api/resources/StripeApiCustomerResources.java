package api.resources;

public class StripeApiCustomerResources {
	private String baseUri="https://api.stripe.com/";
	private String postEndpoint="v1/customers";
	private String putEndpoint="v1/customers/";
	private String getEndpoint="v1/customers";
	private String deleteEndpoint="v1/customers/";
	private final String SECURITY_KEY="sk_test_43SsF03laS0J8GELXCkrLySI00j34NQlzP";
	public String getBaseUri() {
		return baseUri;
	}
	public String getPostEndpoint() {
		return postEndpoint;
	}
	public String getPutEndpoint() {
		return putEndpoint;
	}
	public String getGetEndpoint() {
		return getEndpoint;
	}
	public String getDeleteEndpoint() {
		return deleteEndpoint;
	}
	public String getSECURITY_KEY() {
		return SECURITY_KEY;
	}
	

}

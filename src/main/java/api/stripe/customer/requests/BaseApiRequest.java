package api.stripe.customer.requests;

import api.common.utils.PropertFileReader;

public class BaseApiRequest {
	
	public String getApplicationData(String propertyName) throws Exception
	{
		PropertFileReader props=new PropertFileReader();
		return props.getApplicationData(propertyName);
	}

}

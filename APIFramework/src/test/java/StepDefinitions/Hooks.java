package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;


public class Hooks {
	
	@Before("@DeletePlace")
	
	public  void beforedeletePlace() throws IOException

	{
		
		System.out.println("yohooooo");
		StepDefinitions sd= new StepDefinitions();
		System.out.println(StepDefinitions.place_id);
		if (StepDefinitions.place_id==null)
		
	{ sd.payload_of_AddPlace_API_with( "RachnaName", "MyAddress",  "MyPhone_Number");
		
	sd.is_called_with_http_request("AddPlaceAPI", "POST");
	sd.in_is_same_as("name","GetPlaceAPI", "RachnaName");
		System.out.println("placeid"+StepDefinitions.place_id);
	
		}
		
		
	}

}

package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.IOException;

import Resources.APIResources;
import Resources.GeneratePayload;
import Resources.util;



public class StepDefinitions extends util{

	
	public Response rsp;
	 GeneratePayload Gp= new GeneratePayload();
	 String Payload;
	  RequestSpecification req;
	public static String place_id;
	


@Given("Payload of AddPlace API with {string},{string},{string}")
public void payload_of_AddPlace_API_with(String Name, String Address, String Phone_Number) throws IOException {
	
	req=given().spec(RequestSpecifications()).body(Gp.payload(Name, Address, Phone_Number));
}


@When("{string} is called with {string} http request")
public void is_called_with_http_request(String resource, String method) throws IOException {
	
	APIResources AP=APIResources.valueOf(resource);
	
	System.out.println(AP.getResource());
if (method.equalsIgnoreCase("POST"))
	rsp=req.when().post(AP.getResource());
else if (method.equalsIgnoreCase("GET")& place_id==null)
	{
	//System.out.println(rsp.asString());
	
	place_id=ParseResponse(rsp, "place_id");
	//System.out.println("place_id----"+place_id);
	
	rsp=given().spec(RequestSpecifications()).queryParam("place_id", place_id).
	when().get(AP.getResource());}
else
	{rsp=given().spec(RequestSpecifications()).queryParam("place_id", place_id).
	when().get(AP.getResource());}

}



@Then("{string} is {string}")
public void is(String key, String expectedValue) {
	
	assertEquals(ParseResponse(rsp, key),expectedValue);
	
}
@Then("{string} in {string} is same as {string}")
public void in_is_same_as(String key, String resource, String expectedValue) throws IOException {
    
	is_called_with_http_request(resource, "GET");
	
	System.out.println(rsp.asString());
	if (place_id==null)
	
	{place_id=ParseResponse(rsp, "place_id");}
	
	assertEquals(ParseResponse(rsp, key),expectedValue);
	
}


@Then("API is successfull with statuscode {string}")
public void api_is_successfull_with_statuscode(String string) {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(rsp.statusCode(),200);
}

@Given("Payload of DeletePlace API")
public void payload_of_DeletePlace_API() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	req=given().spec(RequestSpecifications()).body(Gp.DeletePlacePayload(place_id));
	
}


}

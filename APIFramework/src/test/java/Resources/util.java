package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class util {
	static RequestSpecification respec;
	
	public static String GlobalFile(String Key) throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("/Users/rachnagirdhar/Desktop/QA Learnings/API Automation/Udemay Course/APIFramework/TestData1.properties");
		prop.load(file);
		
        return prop.getProperty(Key).toString() ;
        
		
		
	}
	
	public  RequestSpecification RequestSpecifications() throws IOException
	
	{
		if (respec==null )
		{
		PrintStream log=new PrintStream(new FileOutputStream("output.txt"));
		
		RestAssured.baseURI=GlobalFile("baseURI");
		
		 respec= new RequestSpecBuilder().setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").
				addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				
				.build();
		return respec;
		}
		else
			 return respec;
		
		
	}
	
	public String ParseResponse(Response response, String key)
	
	{
		JsonPath js= new JsonPath(response.asString());
		return js.get(key).toString();
	
	}

}

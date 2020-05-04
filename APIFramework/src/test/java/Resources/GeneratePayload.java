package Resources;

import java.util.ArrayList;

import POJO.AddPlace;
import POJO.AddPlace_Location;

public class GeneratePayload {
	
	public  AddPlace payload(String Name, String Address, String Phone_Number)
	{
	
	AddPlace ap=new AddPlace();
	ap.setWebsite("xyz");
	ap.setAccuracy("1234");
	ap.setAddress(Address);
	ap.setLanguage("eng");
	ap.setName(Name);
	ap.setPhone_number(Phone_Number);
	ArrayList<String> type= new ArrayList<String>();
	type.add("chintu");
	type.add("Mintu");
	ap.setTypes(type);
	
	AddPlace_Location loc= new AddPlace_Location();
	
	loc.setLat(-34.5567);
	
    loc.setLng(-67.78989);
    ap.setLocation(loc);
    
    return ap;

	}
	
	public String DeletePlacePayload(String place_id)
	{
		
			return ("{\n" + 
					"    \"place_id\":\""+place_id+"\"\n" + 
					"}");
		
	}

}

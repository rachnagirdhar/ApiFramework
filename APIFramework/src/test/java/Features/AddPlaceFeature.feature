Feature: Add Place in Google map

@AddPlace
Scenario Outline: Verify Place is added in Google Map
Given Payload of AddPlace API with "<Name>","<Address>","<Phone_Number>"
When "AddPlaceAPI" is called with "POST" http request
Then "status" is "OK"
And "scope" is "APP"
#And "statusCode" is "200"
And "name" in "GetPlaceAPI" is same as "<Name>"
And API is successfull with statuscode "200"



Examples:


|Name|Address|Phone_Number|
|Rachna Name|324 Address|123456 Phone_Number|
#|Rachna1 Name|324 Address1|123456 Phone_Number1|

@DeletePlace
Scenario: Veify Place is deleted from Google Map
Given Payload of DeletePlace API 
When "DeletePlaceAPI" is called with "POST" http request
Then API is successfull with statuscode "200"
And "status" is "OK"
And "msg" in "GetPlaceAPI" is same as "Get operation failed, looks like place_id  doesn't exists"


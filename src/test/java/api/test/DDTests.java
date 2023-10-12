package api.test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userId,String userName,String fname,String lname,String useremail,String pwd,String ph ) {
		User userPayload=new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		Response response=UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);	
	}
	
	   @Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	   public void testDeleteUserByName(String userName) {
		Response response=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}

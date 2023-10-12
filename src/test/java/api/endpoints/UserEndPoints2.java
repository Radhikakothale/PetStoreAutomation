package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	    static ResourceBundle getURL(){
		ResourceBundle routes=ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	
	
	public static Response createUser(User payload) {
		String posturl=getURL().getString("posturl");
		Response response=given()
				             .contentType(ContentType.JSON)
				             .accept(ContentType.JSON)
				             .body(payload)
				           .when()
				             .post(posturl);
		                 return response;	
	}
	public static Response getUser(String userName) {
		String geturl=getURL().getString("geturl");
		Response response=given()
				             .pathParam("username",userName)
				           .when()
				             .get(geturl);
		                 return response;	
	}
	public static Response updateUser(String userName,User payload) {
		String updateurl=getURL().getString("updateurl");
		Response response=given()
				             .contentType(ContentType.JSON)
				             .accept(ContentType.JSON)
				             .pathParam("username",userName)
				             .body(payload)
				           .when()
				             .put(updateurl);
		                 return response;	
	}
	public static Response deleteUser(String userName) {
		String deleteurl=getURL().getString("deleteurl");
		Response response=given()
				             .pathParam("username",userName)
				           .when()
				             .delete(deleteurl);
		                 return response;	
	}
	

}

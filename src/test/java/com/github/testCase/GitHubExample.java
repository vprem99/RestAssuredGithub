package com.github.testCase;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GitHubExample {
  @Test(enabled=false,description="get all repository for Authentic user")
  public void getAllRepository() {
	  given()
	  		.auth()				//Giving Authentication
	  		.oauth2("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")
	  .when()
	  		.get("https://api.github.com/user/repos")
	  .then()
	  		.log()
	  		.all()
	  		.statusCode(200);
  }
  
  @Test(enabled=false,description="Getting details of specific repository")
  public void gettingSpecificRepo() {
	  given()
	  		.auth()				//Giving Authentication
	  		.oauth2("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")
	  .when()
	  		.get("https://api.github.com/repos/vprem99/DemoSelenium")
	  .then()
	  		.log()
	  		.all()
	  		.statusCode(200);
  }
  
  
  @Test(enabled = true, description = "get all repository for Authentic user")
  public void createRepository() {
	  JSONObject para=new JSONObject();
	  para.put("name", "882");
	  para.put("description", "Sample for Post Request");
	  para.put("homepage", "http://githubcom/vprem99/DemoSelenium");  
	  given()
	  		.auth()				//Giving Authentication
	  		.oauth2("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")
	  		.header("Content-Type","application/json")
	  		.body(para.toJSONString())
	  .when()
	  		.post("https://api.github.com/user/repos")
	  .then()
	  		.log()
	  		.all()
	  		.statusCode(201);
  }
}
package com.github.testCase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.github.base.Base;
import com.github.utils.AssertionUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AddRepository extends Base {
	@BeforeClass
	public void beforeClass() {
		JSONObject para = new JSONObject();
		para.put("name", "RobotCreation2");
		para.put("description", "Sample for Post Request");
		para.put("homepage", "http://github.com/vprem99/DemoSelenium");
		httpRequest = given().header("Content-Type", "application/json")
				.body(para.toJSONString());
		response = httpRequest.request(Method.POST, "/user/repos");
	}

	@Test(enabled=true,priority = 1)
	public void checkResponseBody() {
		String body = response.getBody().asString();
		AssertionUtils.assertForTrue(body, cTest, "Response body is null");
		AssertionUtils.assertForTrue(body, cTest, "RobotCreation not Present in body");
	}

	@Test(enabled=true,priority = 2)
	public void checkResponseCode() {
		int code = response.getStatusCode();
		AssertionUtils.assertForTrue(code == 201, cTest, "Response code is not 201. it is "+code);

	}

	@Test(enabled=true,priority = 3)
	public void checkStatusLine() {
		String line = response.getStatusLine();
		System.out.println(line);
		AssertionUtils.assertForString("HTTP/1.1 201 CREATED", line, cTest, "Status line did not match & it is "+line);
	}

	@Test(enabled=true,priority = 4)
	public void checkContentType() {
		String type = response.getContentType();
		AssertionUtils.assertForString("application/json; charset=utf-8", type, cTest, "Content type did not match");
	}

	@Test(enabled=true,priority = 5)
	public void checkResponseTime() {
		long time = response.getTime();
		AssertionUtils.assertForTrue(time <= 5000, cTest, "Response time greater than 5000");
	}
}
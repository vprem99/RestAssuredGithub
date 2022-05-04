package com.github.testCase;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.github.base.Base;
import com.github.utils.AssertionUtils;

import io.restassured.http.Method;

public class GetRepo extends Base {
	@BeforeClass
	public void GetAllRepository() {
		httpRequest = given();
		response = httpRequest.request(Method.GET, "/user/repos");
		System.out.println(response.jsonPath().get("[1].name"));
		System.out.println(response.then().log().all());
	}

	@Test(priority = 1)
	public void checkResponseBody() {
		cTest.info("Checking Body should not be null");
		String body = response.getBody().asString();
		AssertionUtils.assertForTrue(body, cTest, "Response body is null");
	}

	@Test(priority = 2)
	public void checkResponseCode() {
		int code = response.getStatusCode();
		AssertionUtils.assertForTrue(code == 200, cTest, "Response code did not match");
	}

	@Test(priority = 3)
	public void checkStatusLine() {
		String line = response.getStatusLine();
		AssertionUtils.assertForString("HTTP/1.1 200 OK", line, cTest, "Status Line did not match");
	}

	@Test(priority = 4)
	public void checkContentType() {
		String type = response.getContentType();
		AssertionUtils.assertForString("application/json", type, cTest, "Content type did not match");
	}

	@Test(priority = 5)
	public void checkResponseTime() {
		long time = response.getTime();
		AssertionUtils.assertForTrue(time <= 5000, cTest, "Response code did not match");
	}
}

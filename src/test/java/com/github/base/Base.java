package com.github.base;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

//@Listeners({ com.github.utils.TestReport.class })
public class Base {
	public static ExtentTest pTest, cTest;

	public static ExtentReports ex;
	public static RequestSpecification httpRequest;
	public static Response response;

	@BeforeSuite
	public void beforeTest() {
		ex = new ExtentReports();
		ex.attachReporter(new ExtentHtmlReporter("github.html"));
		RestAssured.baseURI = "https://api.github.com";
		RestAssured.authentication = RestAssured.oauth2("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");
	}

	@AfterSuite
	public void afterTest() {
		ex.flush();
	}
}

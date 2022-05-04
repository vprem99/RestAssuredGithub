package com.github.utils;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class AssertionUtils {

	public static void assertForString(String expected, String actual, ExtentTest ex, String failureMsg) {
		try {
			Assert.assertEquals(actual, expected);
			ex.pass("Done");
		} catch (AssertionError E) {
			ex.fail(failureMsg);
			Assert.fail(failureMsg);
		}
	}

	public static void assertForTrue(String expected, ExtentTest ex, String failureMsg) {
		try {
			Assert.assertTrue(expected != null);
			ex.pass("Done");
		} catch (AssertionError E) {
			ex.fail(failureMsg);
			Assert.fail(failureMsg);
		}
	}
	public static void assertForTrue(boolean expected, ExtentTest ex, String failureMsg) {
		try {
			Assert.assertTrue(expected);
			ex.pass("Done");
		} catch (AssertionError E) {
			ex.fail(failureMsg);
			Assert.fail(failureMsg);
		}
	}
}

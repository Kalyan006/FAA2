package com.phm.hec.testcases;

import org.testng.annotations.Test;

import com.phm.hec.testcases.TC399ForgotPassword;

public class TC399 {
	@Test
	public void AddProvider() throws Throwable {
		System.out.println("Forgot Password");
		TC399ForgotPassword.forgotpassword();
	}
}

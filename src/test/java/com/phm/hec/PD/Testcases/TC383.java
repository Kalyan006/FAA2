package com.phm.hec.PD.Testcases;

import org.testng.annotations.Test;

public class TC383 {
	@Test
	public void ForgotPassword() throws Throwable {
		System.out.println("TC 383 - Add Provider");
		TC383AddProvider.AddProvider();
	}
}

package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		// logging in
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(5000);

		// adding customer
		driver.findElement(By.linkText("New Customer")).click();
		
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
//		addcust.clickAddNewCustomer();
		Thread.sleep(5000);	
		

		logger.info("providing customer details....");

		addcust.custName("Mikey");
		logger.info("name entered");
		addcust.custgender("male");
		addcust.custdob("1", "4", "2000");
		Thread.sleep(3000);
		addcust.custaddress("JAPAN");
		addcust.custcity("HINO");
		addcust.custstate("TOKYO");
		addcust.custpinno("2000013");
		addcust.custtelephoneno("987890091");

		String email = randomString() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
}
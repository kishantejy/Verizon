package com.project.verizon.verizon;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.WebDriverFactory;


public class TestScenario extends WebDriverFactory{

//	@BeforeMethod
//	public void intializePages(){
//		initializeElements("LandingPage");
//		initializeElements("SmartphonesPage");
//		initializeElements("SupportPage");
//	}
//	
//	@AfterMethod
//	public void goToHomePage(){
//		homePage.goBackToHomePage();
//	}
//	
//	
	@Test
	public void compareCreditPrices(){
		homePage.viewSmartPhones();
		smartphones.creditRating(true);
		smartphones.getMonthlyPrice(true, 1);
		smartphones.creditRating(false);
		smartphones.getMonthlyPrice(false, 1);
		smartphones.compareMonthlyPrices();
	}
	
	@Test
	public void verifyAmountofDisplayedResults(){
		homePage.viewSmartPhones();
		smartphones.filterByBrand("apple");
		smartphones.verifyAmountOfResults("apple");
	}
	
	@Test
	public void verifyTitleOfNote7SupportPage(){
		homePage.viewSupport();
		support.viewNote7Recalls();
		support.VerifyTitle("note7", "Samsung Galaxy Note7 Recall & Exchange FAQs");
	}
	
}

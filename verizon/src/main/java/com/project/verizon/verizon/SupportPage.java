package com.project.verizon.verizon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import utilities.WebDriverFactory;

public class SupportPage {
	
	public SupportPage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	@FindBy(how = How.CSS, using = "a[onclick*='NOTE7_RECALL'")
	private WebElement note7RecallFAQ;
	
	
	@FindBy(how = How.CSS, using = ".title>h1")
	private WebElement note7RecallTitle;
	
	public void viewNote7Recalls(){
		WebDriverFactory.waitUntilVisible(note7RecallFAQ).click();
	}
	
	public void VerifyTitle(String Page, String ExpectedTitle){
		if(Page.contains("note7")){
		Assert.assertEquals(ExpectedTitle, note7RecallTitle.getText());
		}
	}
}

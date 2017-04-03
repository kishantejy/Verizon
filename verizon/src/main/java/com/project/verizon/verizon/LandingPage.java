package com.project.verizon.verizon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    
	public LandingPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = "a[href='/smartphones/'")
	private WebElement smartphonesButton;
	
	@FindBy(how = How.ID, using = "onavmenu2")
	private WebElement supportButton;
	
	@FindBy(how = How.CSS, using = ".o-logo>a")
	private WebElement homePage;
	
	public void viewSmartPhones(){
		smartphonesButton.click();
	}
	
	public void viewSupport(){
		supportButton.click();
	}
	
	public void goBackToHomePage(){
		homePage.click();
	}
}

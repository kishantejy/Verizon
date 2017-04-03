package com.project.verizon.verizon;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class SmartphonesPage {
	private static String goodCreditItemPrice, badCreditItemPrice;

	public SmartphonesPage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	@FindBy(how = How.ID, using = "creditRadio0")
	private WebElement goodCreditRadioBttnFF;
	
	@FindBy(how = How.CSS, using = "#credit-tab>li.tab-2")
	private WebElement goodCreditRadioBttnChrome;
	
	@FindBy(how = How.ID, using = "creditRadio1")
	private WebElement badCreditRadioBttnFF;
	
	@FindBy(how = How.CSS, using = "#credit-tab>li.tab-3")
	private WebElement badCreditRadioBttnChrome;
	
	@FindBy(how = How.CSS, using = "a[href='/smartphones/apple/']>[type='checkbox']")
	private WebElement filterByBrandApple;
	
	@FindBy(how = How.CSS, using = "a[href='/smartphones/apple/']>[for='cid_131_0']")
	private WebElement amountOfApplePhones;
	
	@FindBy(css = ".fontSize_6>strong")
	private List<WebElement> goodCreditMonthlyPrices;
	
	@FindBy(css = ".fontSize_4>strong")
	private List<WebElement> badCreditMonthlyPrices;
	
	@FindBy(how = How.CSS, using = "#devices>.gridwallTile_wrapper")
	private List<WebElement> amountOfAvailableFilteredPhones;

	public void getMonthlyPrice(boolean goodCredit, int itemNumber){
		itemNumber = itemNumber -1;
		if(goodCredit){
			goodCreditItemPrice = goodCreditMonthlyPrices.get(itemNumber).getText();
		}else{
			badCreditItemPrice = badCreditMonthlyPrices.get(itemNumber).getText();
		}
	}
	
	public void compareMonthlyPrices(){
		if(goodCreditItemPrice.equals(badCreditItemPrice)){
			Assert.fail("Good Credit and Bad Credit are the same Price.");
		}
	}

	public void creditRating(boolean good){
		if(good = true){
			if(goodCreditRadioBttnFF.isDisplayed()){
				goodCreditRadioBttnFF.click();
			}else if(goodCreditRadioBttnChrome.isDisplayed()){
				goodCreditRadioBttnChrome.click();
			}
		}else{
			if(badCreditRadioBttnFF.isDisplayed()){
				badCreditRadioBttnFF.click();
			}else if(badCreditRadioBttnChrome.isDisplayed()){
				badCreditRadioBttnChrome.click();
			}
		}
	}
	
	public void filterByBrand(String brand){
		switch(brand){
		case "apple":
			filterByBrandApple.click();
			break;
		}
	}
	
	public void verifyAmountOfResults(String brand){
		switch(brand){
		case "apple":
			Assert.assertEquals(getNumberOfAvailablePhones(filterByBrandApple.getText()), amountOfAvailableFilteredPhones.size());
			break;
		}
	}
	
	private int getNumberOfAvailablePhones(String stringToSplit){
		String numberOfPhones = null;
		for(int i=0; i>stringToSplit.length(); i++){
			char integar = stringToSplit.charAt(i);
			if(Character.isDigit(integar)){
				numberOfPhones += integar;
			}
		}
		int amntOfPhones = Integer.valueOf(numberOfPhones);
		return amntOfPhones;
	}
}

package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.verizon.verizonWireless.LandingPage;
import com.verizon.verizonWireless.SmartphonesPage;
//import com.project.verizon.verzon.Intitailization;
//import com.verizon.verizonWireless.LandingPage;
import com.verizon.verizonWireless.SupportPage;
//import com.verizon.verizonWireless.SmartphonesPage;

public class WebDriverFactory {

//	private static WebDriver driver = null;
//	private final String URL = "https://www.verizonwireless.com/";
//	private final String nodeURL = "http://192.168.1.12:5555/wd/hub";
//	private DesiredCapabilities caps = null;
	protected LandingPage homePage;
	protected SmartphonesPage smartphones;
	protected SupportPage support;
//	
//	@BeforeClass(alwaysRun = true)
//	@Parameters("browserName")
//	public void setUpBrowser(String browserName){
//		chooseBrowser(browserName);
//		driver.navigate().to(URL);
//		driver.manage().window().maximize();
//	}
//	
//	@AfterClass
//	public void tearDown(){
//		if(driver !=null){
//		driver.manage().deleteAllCookies();
//		driver.quit();
//		}
//	}
//	
//	public static WebDriver getDriver() {
//		return driver;
//	}
//	
//	
//	private void chooseBrowser(String browserName){
//		switch(browserName){
//		case "firefox":
//			caps = DesiredCapabilities.firefox();
//			FirefoxDriverManager.getInstance().setup();
//			break;
//		case "chrome":
//			caps = DesiredCapabilities.chrome();
//			ChromeDriverManager.getInstance().setup();
//			break;
//		}
//		caps.setPlatform(Platform.WINDOWS);
//		try {
//			driver = new RemoteWebDriver(new URL(nodeURL), caps);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//	}
//	

	
//	public void initializeElements(String pageName){
//		if(pageName.equalsIgnoreCase("LandingPage") || pageName.contains("home")){
//			this.homePage = new LandingPage(driver);
//		}else if(pageName.equalsIgnoreCase("SmartphonesPAge") || pageName.contains("smartphones")){
//			this.smartphones = new SmartphonesPage(driver);
//		}else if(pageName.equalsIgnoreCase("SupportPage") || pageName.contains("support")){
//			this.support = new SupportPage(driver);
//		}
//	}
//	
	
	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		WebDriverFactory.driver = driver;
	}private static final String Verizon = "https://www.verizon.com/";

	@BeforeClass
	public void WebDriver() {
		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Verizon);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			Thread.sleep(4000);
			driver.close();
		}
	}
	public static WebElement waitUntilVisible(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
}

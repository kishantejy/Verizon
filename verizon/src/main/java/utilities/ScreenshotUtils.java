package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ru.yandex.qatools.allure.annotations.Attachment;

public class ScreenshotUtils {
	
	@Attachment(value = "testFailureScreenshot", type = "image/png")
	protected static byte[] screenshotOnFailure(){
		return ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
	}
	
}

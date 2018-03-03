package generic;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
	public static void waitForElement(WebDriver driver, WebElement e)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		while (true) {
			try {
				wait.until(ExpectedConditions.visibilityOf(e));
				break;
			}catch(Exception a) {

			}

		}
	}

	public static void waitForAlert(WebDriver driver)
	{
		while(true)
		{
			try {
				driver.switchTo().alert();
				break;
			}catch(NoAlertPresentException e)
			{

			}
		}
	}

}

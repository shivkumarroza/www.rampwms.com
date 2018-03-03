package page;



import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;
import generic.CustomWait;

public class RequestForDemoPopUp extends BasePage {
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement closeBTN;
	
	@FindBy(xpath="//h4[@class='modal-title']")
	private WebElement requestDemoTitle;
	
	@FindBy(id="u_workshop")
	private WebElement WorkShopNameTB;
	
	@FindBy(id="u_name")
	private WebElement nameTB;
	
	@FindBy(id="u_email")
	private WebElement emailTB;
	
	@FindBy(id="u_mobile")
	private WebElement mobileNoTB;
	
	@FindBy(id="u_location")
	private WebElement locationTB;
	
	@FindBy(id="u_package")
	private WebElement selectPackageTB;
	
	@FindBy(id="u_address")
	private WebElement addressTB;
	
	@FindBy(id="btnSendEmail")
	private WebElement sendRequestBTN;
	
	public RequestForDemoPopUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void waitForPopUp(WebDriver driver)
	{
		CustomWait.waitForElement(driver, requestDemoTitle);
	}
	
	public void verifyPopUp(String eTitle)
	{
		verifyText(requestDemoTitle, eTitle);
	}
	
	public void closePopUp()
	{
		closeBTN.click();
	}
	
	public void setWorkSpaceName(String wpname)
	{
		WorkShopNameTB.sendKeys(wpname);
	}
	
	public void setUserName(String uname)
	{
		nameTB.sendKeys(uname);
	}
	
	public void setEmail(String email)
	{
		emailTB.sendKeys(email);
	}
	
	public void setMobileNo(String mobnum)
	{
		mobileNoTB.sendKeys(mobnum);
	}
	
	public void setLocation(String location)
	{
		locationTB.sendKeys(location);
	}
	
	public void SelectPackage(int option)
	{
		selectPackageTB.click();
		Select select=new Select(selectPackageTB);
		select.selectByIndex(option);
	}
	public void setAddress(String address)
	{
		addressTB.sendKeys(address);
	}
	
	public void clickSendRequestBTN()
	{
		sendRequestBTN.click();	
	}
	
	public void verifyAlertText(WebDriver driver,String eText)
	{
		CustomWait.waitForAlert(driver);
		Alert alert=driver.switchTo().alert();
		String aText=alert.getText();
		Reporter.log(aText,true);
		Assert.assertEquals(aText, eText);
		alert.accept();
	}
	
}

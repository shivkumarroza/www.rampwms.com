package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.RequestForDemoPopUp;

public class RequestDemo extends BaseTest {
	@Test
	public void testRequestForDemoPopUp()
	{
			int i=0,j=1;
			String popUpTitle = Excel.getData(XL_PATH, "RequestPopUp", i++, j);
			String WorkShopName = Excel.getData(XL_PATH, "RequestPopUp", i++, j);
			String FullName = Excel.getData(XL_PATH, "RequestPopUp", i++, j);
			String Email = Excel.getData(XL_PATH, "RequestPopUp", i++, j);
			String phno = Excel.getData(XL_PATH, "RequestPopUp", i++, j);
			String location = Excel.getData(XL_PATH, "RequestPopUp", i++, j);
			String Address = Excel.getData(XL_PATH, "RequestPopUp", i++, j);
			String successMsg = Excel.getData(XL_PATH, "RequestPopUp", i++, j);
			
			RequestForDemoPopUp rq=new RequestForDemoPopUp(driver);
			rq.waitForPopUp(driver);
			rq.verifyPopUp(popUpTitle);
			rq.setWorkSpaceName(WorkShopName);
			rq.setUserName(FullName);
			rq.setEmail(Email);
			rq.setMobileNo(phno);
			rq.setLocation(location);
			rq.SelectPackage(7);
			rq.setAddress(Address);
			rq.clickSendRequestBTN();
			rq.verifyAlertText(driver,successMsg);
			
	}

}

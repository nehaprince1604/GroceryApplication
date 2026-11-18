package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base {
	HomePage hp;
	ManageDeliveryBoyPage mp;
	@Test(description = "User is trying to add new delivery boy")
	public void verifyWhetherUserIsAbleToAddNewDeliveryBoy() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage" );
		LoginPage lp = new LoginPage(driver); 
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		
		
		mp=hp.clickManageDeliveryBoy();
		
		RandomDataUtility rdu = new RandomDataUtility();
		
		String delName = rdu.generateRandomFullname();
		String delEmail = rdu.generateRandomEmailid();
		String delPhone = rdu.generateRandomPhoneno();
		String delAddress = rdu.generateRandomAddress();
		String delUsername = rdu.generateRandomUsername();
		String delPassword = rdu.generateRandomPassword();
		 
		mp.clickNewButton().enterName(delName).enterEmail(delEmail).enterPhoneno(delPhone).enterAddress(delAddress).enterUsername(delUsername).clickSaveButton();
		/*PageUtility pu = new PageUtility();
		pu.scrollPage(driver);
		mp.enterPassword(delPassword)*/		
		String actual = mp.verifyAddDeliveryBoyAlert();
		String expected = "×\nAlert!\nDelivery Boy Details Created Successfully";
		Assert.assertEquals(actual, expected, Constant.NEWDELIVERYBOYADDERROR);
		
	}
}

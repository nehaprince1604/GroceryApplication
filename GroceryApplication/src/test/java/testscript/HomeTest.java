package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage hp;
	@Test(description = "User is trying to logout")
	public void verifyWhetheruserIsAbleToSuccessfullyLoggedOut() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage" );
		LoginPage lp = new LoginPage(driver); 
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		
		hp.clickAdminButton();
		
		lp=hp.clickLogoutButton();
		
		String actual = lp.verifyWhetherLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, "User is unable to logout");
		
    }
	
}

package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage hp;
	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = ("smoke"))
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		boolean dashboardValue = lp.verifyWhetherDashboardIsDisplayed();
		Assert.assertTrue(dashboardValue, Constant.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "User is trying to login with invalid credentials", retryAnalyzer = Retry.class)
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String usernameValue = ExcelUtility.readStringData(10, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickLoginButton();
		String actual = lp.verifyWhetherLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR);
	}

	@Test(priority = 3, description = "User is trying to login with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String usernameValue = ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickLoginButton();
		String actual = lp.verifyWhetherLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDPASSWORDERROR);
	}

	@Test(priority = 4, description = "User is trying to login with invalid username and valid password", groups = ("smoke"), dataProvider = "Logindata")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword(String usernameValue,String passwordValue ) throws IOException {
		/*String usernameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");*/
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickLoginButton();
		String actual = lp.verifyWhetherLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDUSERNAMEERROR);
	}

	@DataProvider(name = "Logindata")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "admin", "admin123" }, new Object[] { "user", "user123" }, };

	}
}

package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base{
	HomePage hp;
	AdminUsersPage ap; 
	@Test(description = "User is trying to add new admin user")
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage" );
		LoginPage lp = new LoginPage(driver); 
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		
		
		ap=hp.clickAdminUsers();
		
		RandomDataUtility rdu = new RandomDataUtility();
		
		String adminUsername = rdu.generateRandomUsername();
		String adminPassword = rdu.generateRandomPassword();
		
		ap.clickNewButton().enterUsername(adminUsername).enterPassword(adminPassword).selectUsertype().clickSaveButton();
		String actual = ap.verifyAddUserAlertisDisplayed();
		String expected = "×\nAlert!\nUser Created Successfully";
		Assert.assertEquals(actual, expected, Constant.NEWADMINUSERADDERROR);
		
	}
	@Test(description = "User is trying to search newly added admin user")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedAdminUser() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage" );
		LoginPage lp = new LoginPage(driver); 
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		
		
		ap=hp.clickAdminUsers();
		
		
		ap.clickBlueSearchButton().enterUsernameSearch("neha").clickRedSearchButton();
		String actual = ap.searchTableForNewAdminUser();
		String expected = "neha";
		Assert.assertEquals(actual, expected, Constant.SEARCHNEWADMINUSERERROR);
		
		
		
	}
}

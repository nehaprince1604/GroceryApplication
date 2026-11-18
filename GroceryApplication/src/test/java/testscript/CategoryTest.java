package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;


public class CategoryTest extends Base{
	HomePage hp;
	CategoryPage cp;
	@Test(description = "user is trying to add category")
	public void verifyWhetherUserIsAbleToAddCategory() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage" );
		LoginPage lp = new LoginPage(driver); 
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		
		
		cp=hp.clickCategory();
		
		/*RandomDataUtility rdu = new RandomDataUtility();
		String adminUsername = rdu.generateRandomUsername();
		String adminPassword = rdu.generateRandomPassword();*/
		
		cp.clickNewButton().enterCategory("abc").selectGroups().chooseFile().clickSaveButton();
		String actual = cp.verifyCategoryAlertisDisplayed();
		String expected = "×\nAlert!\nCategory Created Successfully";
		Assert.assertEquals(actual, expected, Constant.NEWCATEGORYBADDERROR);
		
	}
	@Test
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedCategory() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage" );
		LoginPage lp = new LoginPage(driver); 
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		
		cp=hp.clickCategory();
		
		cp.clickBlueSearchButton().enterCategorySearch("bee").clickRedSearchButton();
		String actual = cp.searchTableForNewCategory();
		String expected = "bee";
		Assert.assertEquals(actual, expected, Constant.SEARCHCATEGORYERROR);
		
	}
}

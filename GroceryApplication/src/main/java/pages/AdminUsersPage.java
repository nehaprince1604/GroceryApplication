package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	
	public WebDriver driver;
	   public AdminUsersPage(WebDriver driver) {
			  this.driver = driver;
			  PageFactory.initElements(driver, this);
		  }
	   PageUtility pu = new PageUtility();
	   
	   @FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	   @FindBy(xpath ="//input[@id='username']") WebElement username;
	   @FindBy(xpath ="//input[@id='password']") WebElement password;
	   @FindBy(xpath ="//select[@id='user_type']") WebElement usertype;
	   @FindBy(xpath ="//button[@name='Create']") WebElement savebutton;
	   @FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']") WebElement bluesearch;
	   @FindBy(xpath ="//input[@id='un']") WebElement searchusername;
	   @FindBy(xpath ="//button[@name='Search']") WebElement redsearch;
	   @FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']") WebElement alert;//for assertion
	   @FindBy(xpath ="//table[@class=\"table table-bordered table-hover table-sm\"]/tbody/tr[1]/td[1]") WebElement table;//for assertion
	   
	   
	   public AdminUsersPage clickNewButton() {
			  newbutton.click();
			  return this;
		  }
	   public AdminUsersPage enterUsername(String adminUsername ) {
		   username.sendKeys(adminUsername);
		   return this;
	   }
	   public AdminUsersPage enterPassword(String adminPassword ) {
		   password.sendKeys(adminPassword);
		   return this;
	   }
	   public AdminUsersPage selectUsertype() {
		   pu.selectDropdownWithIndex(usertype, 2);
		   return this;
		   /*Select select = new Select(usertype);
		   select.selectByIndex(2);*/
	   }
	   public AdminUsersPage clickSaveButton() {
			  savebutton.click();
			  return this;
		  }
	   public AdminUsersPage clickBlueSearchButton() {
			  bluesearch.click();
			  return this;
		  }
	   public AdminUsersPage enterUsernameSearch(String adminUsername ) {
		   searchusername.sendKeys(adminUsername);
		   return this;
	   }
	   public AdminUsersPage clickRedSearchButton() {
			  redsearch.click();
			  return this;
		  }
	   public String verifyAddUserAlertisDisplayed() {
		   return alert.getText();
	   }
	   public String searchTableForNewAdminUser() {
		   return table.getText();	   }
	   
	   
}

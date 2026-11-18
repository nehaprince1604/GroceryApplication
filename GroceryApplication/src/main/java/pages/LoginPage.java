package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
   public WebDriver driver;
   WaitUtility wu = new WaitUtility();
   public LoginPage(WebDriver driver) {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
	  }
	  @FindBy(xpath ="//input[@name='username']") WebElement username;
	  @FindBy(xpath ="//input[@name='password']") WebElement password;
	  @FindBy(xpath ="//button[text()='Sign In']") WebElement login;
	  @FindBy(xpath = "//p[text()='Dashboard']") WebElement dashboard;
	  @FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement loginpagetext;
	  
	  public LoginPage enterUsernameOnUsernameField(String usernameValue) {
		  username.sendKeys(usernameValue);
		  return this;
	  }
	  public LoginPage enterPasswordOnPasswordField(String passwordValue) {
		  password.sendKeys(passwordValue);
		  return this;
	  }
	  public HomePage clickLoginButton() {
		  wu.waitUntilElementToBeClickable(driver, login);
		  login.click();
		  return new HomePage(driver);
	  }
	  public boolean verifyWhetherDashboardIsDisplayed() {
		  return dashboard.isDisplayed();
		  }
	  public String verifyWhetherLoginTextIsDisplayed() {
		  return loginpagetext.getText();
	  }
}

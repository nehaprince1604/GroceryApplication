package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	   public ManageDeliveryBoyPage(WebDriver driver) {
			  this.driver = driver;
			  PageFactory.initElements(driver, this);
		  }
	   @FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	   @FindBy(xpath ="//input[@id='name']") WebElement name;
	   @FindBy(xpath ="//input[@id='email']") WebElement email;
	   @FindBy(xpath ="//input[@id='phone']") WebElement phoneno;
	   @FindBy(xpath ="//textarea[@id='address']") WebElement address;
	   @FindBy(xpath ="//input[@id='username']") WebElement username;
	   @FindBy(xpath ="//input[@id='password']") WebElement password;
	   @FindBy(xpath ="//button[@name='create']") WebElement savebutton;
	   @FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']") WebElement alert;//for assertion
	 
	   public ManageDeliveryBoyPage clickNewButton() {
			  newbutton.click();
			  return this;
		  }
	   public ManageDeliveryBoyPage enterName(String delName ) {
		   name.sendKeys(delName);
		   return this;
	   }
	   public ManageDeliveryBoyPage enterEmail(String delEmail) {
		   email.sendKeys(delEmail);
		   return this;
	   }
	   public ManageDeliveryBoyPage enterPhoneno(String delPhone ) {
		   phoneno.sendKeys(delPhone);
		   return this;
	   }
	   public ManageDeliveryBoyPage enterAddress(String delAddress) {
		   address.sendKeys(delAddress);
		   return this;
	   }
	   public ManageDeliveryBoyPage enterUsername(String delUsername ) {
		   username.sendKeys(delUsername);
		   return this;
	   }
	   public ManageDeliveryBoyPage enterPassword(String delPassword ) {
		   password.sendKeys(delPassword);
		   return this;
	   }
	   public ManageDeliveryBoyPage clickSaveButton() {
			  savebutton.click();
			  return this;
		  }
	   public String verifyAddDeliveryBoyAlert() {
		   return alert.getText();
	   }
	   
}

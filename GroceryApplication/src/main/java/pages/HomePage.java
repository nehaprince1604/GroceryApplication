package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	public WebDriver driver;
	   public HomePage(WebDriver driver) {
			  this.driver = driver;
			  PageFactory.initElements(driver, this);
		  }
		  @FindBy(xpath ="//a[@data-toggle='dropdown']") WebElement admin;
		  @FindBy(xpath ="//i[@class='ace-icon fa fa-power-off']") WebElement logout;
		  //click moreinfo of adminusers in homepage
		  @FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement admmoreinfo;
		//click moreinfo of manage deliveryboy in homepage
		  @FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']") WebElement delmoreinfo;
		  @FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement categorymoreinfo;
		  
		  //for logout, first step is to click admin
		  public HomePage clickAdminButton() {
			  admin.click();
			  return this;
		  }
		  
		  public LoginPage clickLogoutButton() {
			  logout.click();
			  return new LoginPage(driver);
		  }
		  //for adding admin user, first click more info of admin users
		  public AdminUsersPage clickAdminUsers() {
			  admmoreinfo.click();
			  return new AdminUsersPage(driver);
		  }
		//for adding deliveryboy, first click more info of manage deliveryboy
		  public ManageDeliveryBoyPage clickManageDeliveryBoy() {
			  delmoreinfo.click();
			  return new ManageDeliveryBoyPage(driver);
		  }
		//for adding category, first click more info of category
		  public CategoryPage clickCategory() {
			  categorymoreinfo.click();
			  return new CategoryPage(driver);
		  }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CategoryPage {
	public WebDriver driver;
	   public CategoryPage(WebDriver driver) {
			  this.driver = driver;
			  PageFactory.initElements(driver, this);
		  }
	   @FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	   @FindBy(xpath ="//input[@id='category']") WebElement category;
	   @FindBy(xpath ="//li[@id='1-selectable']") WebElement selgroup;
	   @FindBy(xpath ="//input[@id='main_img']") WebElement image;//inspect on choose file
	   @FindBy(xpath ="//button[@name='create']") WebElement savebutton;
	   @FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']") WebElement bluesearch;
	   @FindBy(xpath ="//input[@name='un']") WebElement searchcategory;
	   @FindBy(xpath ="//button[@name='Search']") WebElement redsearch;
	   @FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']") WebElement alert;//for assertion
	   @FindBy(xpath ="//table[@class=\"table table-bordered table-hover table-sm\"]/tbody/tr/td[1]") WebElement table;//for assertion
	   
	   public CategoryPage clickNewButton() {
			  newbutton.click();
			  return this;
		  }
	   public CategoryPage enterCategory(String categoryName ) {
		   category.sendKeys(categoryName);
		   return this;
	   }
	   public CategoryPage selectGroups() {
		   selgroup.click();
		   return this;
	   }
	   public CategoryPage chooseFile() {
		   image.sendKeys("C:\\Users\\HP\\Pictures\\Untitled.png");
		   return this;
	   }
	   public CategoryPage clickSaveButton() {
		   Actions action=new Actions(driver);
		   action.click(savebutton).perform();
			  return this;
		  }
	   public CategoryPage clickBlueSearchButton() {
			  bluesearch.click();
			  return this;
		  }
	   public CategoryPage enterCategorySearch(String cat ) {
		   searchcategory.sendKeys(cat);
		   return this;
	   }
	   public CategoryPage clickRedSearchButton() {
			  redsearch.click();
			  return this;
}
	   public String verifyCategoryAlertisDisplayed() {
		   return alert.getText();
	   }
	   public String searchTableForNewCategory() {
		   return table.getText();	   }
	   
	   
}

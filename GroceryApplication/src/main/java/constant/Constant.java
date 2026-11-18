package constant;

public class Constant {
	//path of config.property= C:\Users\HP\eclipse-workspace\GroceryApplication\src\main\resources\Config.property
 public static final String CONFIGFILE = System.getProperty("user.dir")+"\\src\\main\\resources\\Config.property";
 //path of excel file in excel utility
 public static final String TESTDATA = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
 public static final String VALIDCREDENTIALERROR = "User is unable to login with valid credentials";
 public static final String INVALIDCREDENTIALERROR = "User is unable to login with invalid credentials";
 public static final String INVALIDPASSWORDERROR = "User is unable to login with valid username and invalid password";
 public static final String INVALIDUSERNAMEERROR = "User is unable to login with invalid username and valid password";
 public static final String NEWADMINUSERADDERROR = "Unable to add new admin user";
 public static final String SEARCHNEWADMINUSERERROR = "Unable to find new admin user";
 public static final String NEWDELIVERYBOYADDERROR = "Unable to add new delivery boy";
 public static final String NEWCATEGORYBADDERROR = "Unable to add new category";
 public static final String SEARCHCATEGORYERROR = "Unable to find new category";
 public static final String LOGOUTERROR = "Unable to add logout";
 
}


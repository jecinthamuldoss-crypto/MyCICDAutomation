package JesssfinalCompany.MyappFrameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import JesssfinalCompany.AbstractComponents.Abstractfile;

public class landingpage extends Abstractfile {
	
	WebDriver driver;
public landingpage(WebDriver driver) {
	super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
	
}

@FindBy (id = "userEmail")
WebElement emailfield;
@FindBy (id = "userPassword")
WebElement passwordfield;
@FindBy (id = "login")
WebElement loginbtn;

//div[@class='ng-tns-c4-10 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']

@FindBy (css = "[class*='flyInOut']")
WebElement myerrormessage;

public void goTo() {
	driver.get("https://rahulshettyacademy.com/client");
}

public ProductCataloguepage landingpageactions(String Myemail, String Mypassword) {
	emailfield.sendKeys(Myemail);
	passwordfield.sendKeys(Mypassword);
	loginbtn.click();
	ProductCataloguepage productpage = new ProductCataloguepage (driver);
	return productpage;
}

public String Errorscenariomessage() {
	waituntilwebelementvisible(myerrormessage);
	return myerrormessage.getText();
}
}


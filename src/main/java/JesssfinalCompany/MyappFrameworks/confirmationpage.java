package JesssfinalCompany.MyappFrameworks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import JesssfinalCompany.AbstractComponents.Abstractfile;

public class confirmationpage extends Abstractfile{

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public confirmationpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
}
	@FindBy (css = "tr[class = 'ng-star-inserted'] label")
	WebElement orderID;
	@FindBy (css = "td h1.hero-primary")
	WebElement finalmessage;
	
	public void Orderdetails() {
		
		String Myid = orderID.getText();
		System.out.println(Myid);
	}
	
	public String confirmMessage() {
		String confirmationmessage=finalmessage.getText();
		 System.out.println(confirmationmessage);
		 return confirmationmessage;
		 
	}
	
		 
	}
	
	


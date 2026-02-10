package JesssfinalCompany.MyappFrameworks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import JesssfinalCompany.AbstractComponents.Abstractfile;

public class cartpage extends Abstractfile{

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	public cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
}
	@FindBy (css = ".cartSection h3")
	List <WebElement> Cartproducts;
	@FindBy (css = ".totalRow button")
	WebElement Checkoutpage;
	
	public Boolean onTheCartPage(String MYProduct) {
		
		 Boolean match = Cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equals(MYProduct));
		 return match;
		
		
	}
	public Paymentpage Checkoutpage() {
		Checkoutpage.click();
		return new Paymentpage(driver);
	}
	
	
	
	
}

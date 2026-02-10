package JesssfinalCompany.MyappFrameworks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import JesssfinalCompany.AbstractComponents.Abstractfile;

public class Orderhistory extends Abstractfile{
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	public Orderhistory(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		
	}
	@FindBy (css = "tr td:nth-child(3)")
	List<WebElement> orderedproducts;
	
	
	public Boolean onTheOrderPage(String MYProduct) {
		
		 Boolean match = orderedproducts.stream().anyMatch(orderedproduct->orderedproduct.getText().equals(MYProduct));
		 return match;
		
	

}
}

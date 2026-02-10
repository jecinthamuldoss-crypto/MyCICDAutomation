package JesssfinalCompany.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import JesssfinalCompany.MyappFrameworks.Orderhistory;

public class Abstractfile {
	WebDriver driver;
	
	
	public Abstractfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		
	}
	@FindBy (css = "[routerlink*= 'myorders']")
	WebElement orderlink;
	By CartIcon = By.cssSelector("[routerlink*='cart']");
	
	
	
	public void waituntilvisibile(By findby ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));

}
	
	public void waituntilwebelementvisible(WebElement Myele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Myele));
	}
	
	
	public void waituntilinvisible(WebElement ele) {	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
	public void goToCartPage() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);"); //scroll to top

		// Small pause for render (optional but helps on macOS)
		try { Thread.sleep(500); } catch (InterruptedException e) {}

		// Now safe to find & click (use JS click for reliability)
		WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
				CartIcon));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartIcon);
		 
		 
	}
	
	public Orderhistory orderhistorypage() {
		orderlink.click();
		Orderhistory orderhistory = new Orderhistory(driver);
		return orderhistory;
		
	}
}

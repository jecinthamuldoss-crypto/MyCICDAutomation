package JesssfinalCompany.MyappFrameworks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import JesssfinalCompany.AbstractComponents.Abstractfile;

public class ProductCataloguepage extends Abstractfile {
	

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	public ProductCataloguepage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy (css = ".mb-3" )
	List<WebElement> Products;
	
	@FindBy (css = ".ng-animating")
	WebElement invisibletoaster;

	By Productlists = By.cssSelector(".mb-3");
	By ADDTOCARTBTN = By.cssSelector(".card-body button:last-of-type");
	By toastloader = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getproductslist(){
		waituntilvisibile(Productlists);
		return Products;
	
	}
	public WebElement getproductbyname(String MYProduct) {
		WebElement prod = getproductslist().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(MYProduct)).findFirst().orElse(null);
		return prod;
		
	}
	public cartpage addproductToCart(String MYProduct) {
		WebElement prod = getproductbyname(MYProduct);
		if (prod == null) {
	        throw new RuntimeException("Product not found: " + MYProduct);
	    }
		
		WebElement addBtn = prod.findElement(ADDTOCARTBTN);
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", addBtn);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn);
	    try {
	        waituntilvisibile(toastloader);  // Wait up to your timeout (10s)
	    } catch (org.openqa.selenium.TimeoutException e) {
	        System.out.println("Toast not visible – proceeding anyway (common site behavior)");
	    }
		
		//waituntilvisibile(toastloader);
		waituntilinvisible(invisibletoaster);
		cartpage cartP = new cartpage(driver);
		return cartP;
	}
	}
		 
		
	
	
	
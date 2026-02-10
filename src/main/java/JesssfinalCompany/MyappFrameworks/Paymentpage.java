package JesssfinalCompany.MyappFrameworks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import JesssfinalCompany.AbstractComponents.Abstractfile;

public class Paymentpage extends Abstractfile {
    WebDriver driver;
    WebDriverWait wait;

    public Paymentpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement countryplaceholder;

    @FindBy(css = ".ta-item:nth-of-type(2)")
    WebElement Selectedoption;

    @FindBy(css = ".actions a")
    WebElement Orderbtn;

    By options = By.cssSelector("section[class*= 'ng-star-inserted']");

    public void paymentpageDetails(String MYcountry) {
        Actions a = new Actions(driver);
        a.sendKeys(countryplaceholder, MYcountry).build().perform();
        waituntilvisibile(options);
    }

    public void countrySelection() {
        Selectedoption.click();
    }

    public confirmationpage Placeorderbtn() {
        Orderbtn.click();
        return new confirmationpage(driver);
    }
}

package JesssfinalCompany.MyappFrameworks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import JesssfinalCompany.Mybasecomponents.basetest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SubmitOrder extends basetest {
	//String MYProduct = "ZARA COAT 3";
	String MYcountry = "india";
	
@Test (dataProvider = "getData", groups = {"Mypurchaseflow"})
	public void submitorder(HashMap <String,String> input) throws IOException  {
		// TODO Auto-generated method stub
		
		
		
		//landing page
		ProductCataloguepage productpage = landing.landingpageactions(input.get("email"), input.get("password"));
		
		//product page
		productpage.getproductslist();
		productpage.getproductbyname(input.get("MYProduct"));
		cartpage cartP = productpage.addproductToCart(input.get("MYProduct"));
		 
		//click on cart button
		productpage.goToCartPage();
		
		//check whether the added product is in the cart 
		Boolean match = cartP.onTheCartPage(input.get("MYProduct"));
		Assert.assertTrue(match);
		
		//checkoutbutton 
		Paymentpage paypage = cartP.Checkoutpage();
		
		//Paymentpage enter the fields
		paypage.paymentpageDetails(MYcountry);
		paypage.countrySelection();
		 
		//Placeorder button
		confirmationpage confirmpg = paypage.Placeorderbtn();

		//confirmation page
		confirmpg.Orderdetails();
		String confirmationmessage = confirmpg.confirmMessage();
		AssertJUnit.assertTrue(confirmationmessage.equalsIgnoreCase("Thankyou for the order."));
	}

@Test (dependsOnMethods = {"submitorder"})
public void OrderHistoryValidation() {
	//landing page
			ProductCataloguepage productpage = landing.landingpageactions("jecinthamuldoss@gmail.com", "Jecintha@19");
			Orderhistory orderhistory = productpage.orderhistorypage();
			Assert.assertTrue(orderhistory.onTheOrderPage("ZARA COAT 3"));
	
}

@DataProvider
public Object[][]getData() throws IOException{
	
	List<HashMap<String, String>> Mydata = getmyjasondata(System.getProperty("user.dir")+"//src//test//java//JesssfinalCompany//data//Mydata.json");
	
	
	return new Object[][] { {Mydata.get(0)} , {Mydata.get(1)} };
}
	}
//HashMap <String,String> map = new HashMap();
//map.put("email", "jecinthamuldoss@gmail.com");
//map.put("password", "Jecintha@19");
//map.put("MYProduct", "ZARA COAT 3");
//
//HashMap <String,String> map1 = new HashMap();
//map1.put("email", "dossjc19@gmail.com");
//map1.put("password", "MyPassword@19");
//map1.put("MYProduct", "ADIDAS ORIGINAL");


package JesssfinalCompany.MyappFrameworks;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import JesssfinalCompany.Mybasecomponents.Retry;
import JesssfinalCompany.Mybasecomponents.basetest;

public class Errorvalidation extends basetest{
	
	@Test (groups = {"errorhandling"}, retryAnalyzer = Retry.class)
	public void errortestcase() {
	
		
	//landing page
	landing.landingpageactions("jecinthamuldoss@gmail.com", "Jecintha@1909");
	Assert.assertEquals("Incorrect email or password.", landing.Errorscenariomessage());
	
}//checking my GitHub link workflow
	@Test 
	public void ErrorScenarionOnsubmitorder()  {
		// TODO Auto-generated method stub
		
		String MYProduct = "ZARA COAT 3";
		
		//landing page
		ProductCataloguepage productpage = landing.landingpageactions("dossjc19@gmail.com", "MyPassword@19");
		
		//product page
		productpage.getproductslist();
		productpage.getproductbyname(MYProduct);
		cartpage cartP = productpage.addproductToCart(MYProduct);
		 
		//click on cart button
		productpage.goToCartPage();
		
		//check whether the added product is in the cart 
		Boolean match = cartP.onTheCartPage("ZARA COAT 33");
		Assert.assertFalse(match);
	
}
}

package JesssfinalCompany.stepdef;
import io.cucumber.java.en.*;

import java.io.IOException;

import javax.security.auth.callback.ConfirmationCallback;
import org.testng.Assert;
import org.testng.AssertJUnit;
import JesssfinalCompany.MyappFrameworks.Paymentpage;
import JesssfinalCompany.MyappFrameworks.ProductCataloguepage;
import JesssfinalCompany.MyappFrameworks.cartpage;
import JesssfinalCompany.MyappFrameworks.confirmationpage;
import JesssfinalCompany.MyappFrameworks.landingpage;
import JesssfinalCompany.Mybasecomponents.basetest;

public class stepdefination extends basetest {

	public landingpage landing;
    ProductCataloguepage productpage;
    cartpage cartP;
    confirmationpage confirmpg;
    Paymentpage paypage;
    

    @Given("I landed on the login page")
    public void i_landed_on_the_login_page() throws Exception {
    	landing=launchapplication();
    }
    
    @Given("^user is logged in with username (.+) and password (.+)$")
    public void user_is_logged_in(String email, String passwordused) {
    	 productpage = landing.landingpageactions(email, passwordused);
    }
    
    @When("^the user is able to add product (.+) to the cart$")
    public void add_product_to_cart(String productname) {
    	productpage.getproductslist();
		productpage.getproductbyname(productname);
		cartP = productpage.addproductToCart(productname); 	
    }
    
    @And("^checkout the (.+)$")
    public void checkout_the_product(String productname) {
    	productpage.goToCartPage();
    	boolean match = cartP.onTheCartPage(productname);
		Assert.assertTrue(match);
		//checkoutbutton 
	    paypage = cartP.Checkoutpage();
		//Paymentpage enter the fields
		paypage.paymentpageDetails("India");
		paypage.countrySelection();
		//Placeorder button
		confirmpg = paypage.Placeorderbtn();
		//confirmation page
		confirmpg.Orderdetails();           
    }
    
    @Then("{string} confirmation message is displayed")
    public void confirmation_message_is_displayed(String expectedMessage) {
    	String confirmationmessage = confirmpg.confirmMessage();
		AssertJUnit.assertTrue(confirmationmessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
    }
    
    @Given("^user is logged in with username (.+) and wrong password (.+)$")
    public void user_is_logged_in_with_username_and_wrong_password(String email, String passwordused) throws IOException{
    	landing=launchapplication();
    	productpage = landing.landingpageactions(email, passwordused);
    }
    
    @Then  ("{string} message is displayed")
    public void error_message_is_displayed(String message) {
    	Assert.assertEquals("Incorrect email or password.", landing.Errorscenariomessage());
    }


}


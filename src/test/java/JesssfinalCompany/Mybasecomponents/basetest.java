package JesssfinalCompany.Mybasecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import JesssfinalCompany.MyappFrameworks.landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
	public WebDriver driver;
	public landingpage landing;
	
	public WebDriver initializebrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/JesssfinalCompany/Resources/GlobalData.properties");
		prop.load(fis);
		String browsername = System.getProperty("browser")!=null?System.getProperty("browser"): prop.getProperty("browser");
		
		if(browsername.contains("chrome")) {
			ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup(); 
		if(browsername.contains("headless")) {
			option.addArguments("headless");
		}
		driver = new ChromeDriver(option);
		driver.manage().window().setSize(new Dimension(1440,900));
		
	}else if (browsername.equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup(); 
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		return driver;
		}
	
	public List<HashMap<String, String>> getmyjasondata(String filepath) throws IOException {
		//convert json to string 
		String jsoncontent = FileUtils.readFileToString(new File(filepath),
				StandardCharsets.UTF_8);
		
		//convert string to hashmap : get jacksondatabind from maven and paste it in the pom.xml
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> Mydata = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){
		
		});
		return Mydata;
		
		}
		
	public String Getscreenshot(String testcasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports"+ testcasename +".png");
		FileUtils.copyFile(source, file);
		return (System.getProperty("user.dir")+ "//reports"+ testcasename + ".png");
		
	
}
	
	
	@BeforeMethod (alwaysRun = true)
	public landingpage launchapplication() throws IOException {
		driver = initializebrowser();
		landing = new landingpage(driver);
		landing.goTo();
		return landing;
	}
	@AfterMethod (alwaysRun = true)
	public void closemyapp() {
		driver.quit();
	}
}


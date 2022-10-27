import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class Initiate_Driver {

	public static WebDriver driver;
	public String geckodriverpath;
	public String chromedriverpath;
	public String lb_country;
	public String lb_language;
	public String lb_username;
	public String lb_password;
		
	
	@BeforeTest
	public void setDriver() {
		
		//driver setting for firefox
		geckodriverpath = System.getProperty("user.dir")+"/src/test/java/browserdriver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckodriverpath);
				
		
		//initiate firefox driver and launch the URL
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("https://pat.libreview.io/");
		
		// wait for condition to be true - visibility of country dropdown
		waitforElement("countryDropdownBtn");
		
		
	}
	
	@BeforeTest
	public WebDriver getdriver() {
		return driver;
	}
	
	
	@AfterTest
	public void CloseDriver() {
		//getDriver().close();
		getdriver().quit();
	}
	
	public void waitforElement(String Obj_name) {
		WebDriverWait wait = new WebDriverWait(getdriver(), 20000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(Obj_name)));
		
	}
}

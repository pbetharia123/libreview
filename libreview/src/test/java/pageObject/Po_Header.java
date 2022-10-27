package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Po_Header {

WebDriver driver;
	
	//patient link
	@FindBy(how=How.ID, using="patHeaderLink")
	public WebElement patient_Link;
	
	// professionals link
	@FindBy(how=How.ID, using="proHeaderLink")
	public WebElement professionals_Link;
}

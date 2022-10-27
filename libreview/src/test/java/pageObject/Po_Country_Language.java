package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Po_Country_Language {

	WebDriver driver;
	
	//select country / region of residence
	@FindBy(how=How.ID, using="countryDropdownBtn")
	public WebElement select_country;
	
	@FindBy(how=How.ID,using="countryDropdown")
	public WebElement country_list;
	
	//select language
	@FindBy(how=How.ID, using="languageDropdownBtn")
	public WebElement select_language;
	
	@FindBy(how=How.ID, using="languageDropdown")
	public WebElement language_list;
	
	//submit button
	@FindBy(how=How.ID, using="modalSubmit")
	public WebElement submit_button;
	
	// change country and language 
	@FindBy(how=How.ID,using="countryFlag")
	public WebElement countryFlag;
	
	public Po_Country_Language(WebDriver driver) {
		this.driver = driver;
	}
	
	
}

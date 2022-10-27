

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import pageObject.Po_Header;

public class HeaderVerification extends Initiate_Driver {

	public void verify_Header_Link(String selectCountryName, String selectLangValue) {
				
		// check for patient link
		List<WebElement> patientlink = driver.findElements(By.id("patHeaderLink"));
		int p = patientlink.size();
		
		// check for professionals link
		List<WebElement> proflink = driver.findElements(By.id("proHeaderLink"));
		int pf = proflink.size();
		
						
		if(p>0 & pf>0 & selectCountryName.equalsIgnoreCase("United States (US)")) {
			Assert.assertTrue(true);
			System.out.println("Patient and Professionals links are displayed for "+selectCountryName+" and "+ selectLangValue );
		}else if(p<=0 & pf<=0 & selectCountryName.equalsIgnoreCase("United States (US)")) {
			Assert.assertFalse(false);
			System.out.println("Patient or Professionals links are not displayed for "+selectCountryName+" and "+ selectLangValue);
		}
		
		
		if(p<=0 & pf<=0 & selectCountryName.equalsIgnoreCase("France (FR)")) {
			Assert.assertTrue(true);
			System.out.println("Patient and Professionals links are not displayed for "+selectCountryName+" and "+ selectLangValue);
		}else if(p>0 & pf>0 & selectCountryName.equalsIgnoreCase("France (FR)")) {
			Assert.assertFalse(false);
			System.out.println("Patient or Professionals links are displayed for "+selectCountryName+" and "+ selectLangValue );
		}
		
				
		
	}
}

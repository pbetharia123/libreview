import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObject.Po_Country_Language;



public class Country_Language_Selection extends Initiate_Driver{

	public XSSFWorkbook excelWBook;
	public XSSFSheet excelWSheet;
	public XSSFCell cell;
	public String filepath;
	public FileInputStream ExcelFile;
	public String selectCountryName;
	public String selectLangValue;
	
	@Test
	public void select_Country_Language() throws InterruptedException, IOException {
		 Po_Country_Language cl = PageFactory.initElements(driver, Po_Country_Language.class);
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 //Extract test data from excel and iterate over it
		 filepath = System.getProperty("user.dir")+"/src/test/java/testData/Libreview_TestData.xlsx";
		 
		try {
			ExcelFile = new FileInputStream(filepath);
			excelWBook = new XSSFWorkbook(ExcelFile);
		    excelWSheet = excelWBook.getSheet("Sheet1");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		 int countRows = excelWSheet.getPhysicalNumberOfRows();
		 for(int r=1;r<countRows;r++) {
			XSSFCell countryValue = excelWSheet.getRow(r).getCell(0); //get Country value in a variable
			XSSFCell languageValue = excelWSheet.getRow(r).getCell(1); // get language value in a variable
					 
			DataFormatter eformatters = new DataFormatter();
			selectCountryName = eformatters.formatCellValue(countryValue);
			selectLangValue = eformatters.formatCellValue(languageValue);
		 
		 //selecting the region from the country dropdown
		 cl.select_country.click();
		 
		 waitforElement("countryDropdown");
		 // click the dropdown button and select country
		 List <WebElement> country_List_Options = cl.country_list.findElements(By.tagName("li"));
		 country_List_Options.size();
		 
		 for(int i=0;i<country_List_Options.size();i++) {
			 String countryName = country_List_Options.get(i).getText();
			 
			 // put country value in a variable
			 if(countryName.equals(selectCountryName)) {
				 country_List_Options.get(i).click();
				 System.out.println("Country selected as "+selectCountryName);
				 break;
			 }
		 }
		 
				 
		 
		 //selecting the language from the dropdown
		 cl.select_language.click();
		 
		 List <WebElement> language_List_Options = cl.language_list.findElements(By.tagName("li"));
		 language_List_Options.size();
		 
		 for(int j=0;j<language_List_Options.size();j++) {
			 String languageName = language_List_Options.get(j).getText();
			 
			 // put language value in a variable
			 if(languageName.equalsIgnoreCase(selectLangValue)) {
				 language_List_Options.get(j).click();
				 System.out.println("Language is selected as "+selectLangValue);
				 break;
			 }
		 }
		
		 //clicking on submit button
		 cl.submit_button.click();
		 
		// to accept all cookies prompt 
		 if(r==1) {
			 acceptCookies();  
		 }
		 
	 
		 
		 // verify header links for Patient and Professionals
		 HeaderVerification hf = new HeaderVerification();
		 hf.verify_Header_Link(selectCountryName,selectLangValue);
		 
		 //Click on the Country Flag to change the Country and Language setting
		 if(r==1) {
			 cl.countryFlag.click();
			 waitforElement("countryDropdownBtn");  
		 }
		 
		 
		 
		 }
		 
		 //close the excel workbook
		 ExcelFile.close();
		
		
	}
	
	
	public void acceptCookies() {
		//Accept all cookies
		if(driver.findElement(By.id("truste-consent-button")).isDisplayed()) {
			driver.findElement(By.id("truste-consent-button")).click();
		}
	}
	
}

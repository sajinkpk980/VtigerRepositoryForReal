package vtigerFrameworkReal.contactstest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import vtigerFrameworkReal.ObjectRepository.ContactsPage;
import vtigerFrameworkReal.ObjectRepository.CreatingNewContactPage;
import vtigerFrameworkReal.ObjectRepository.CreatingNewOrganizationPage;
import vtigerFrameworkReal.ObjectRepository.HomePage;
import vtigerFrameworkReal.genericutility.BaseClass;
import vtigerFrameworkReal.genericutility.ExcelFileUtility;
import vtigerFrameworkReal.genericutility.JavaUtility;
import vtigerFrameworkReal.genericutility.PropertyFileUtility;
import vtigerFrameworkReal.genericutility.WebDriverUtility;

public class CreateContactTest extends BaseClass {

	@Test
	public void CreateContactTest() throws IOException
	{
		
      String LASTNAME = eutil.readDataFromExcel("contact", 1, 2);
      
     HomePage hp = new HomePage(driver);
     hp.clickOnContact();
     
     ContactsPage cp = new ContactsPage(driver);
     cp.clickOnCreateContactImg();
     
     CreatingNewContactPage cr = new CreatingNewContactPage(driver);
     cr.createContact(LASTNAME);
     
      
      
      
	}

}

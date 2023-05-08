package vtigerFrameworkReal.organisationstest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtigerFrameworkReal.ObjectRepository.CreatingNewOrganizationPage;
import vtigerFrameworkReal.ObjectRepository.HomePage;
import vtigerFrameworkReal.ObjectRepository.LoginPage;
import vtigerFrameworkReal.ObjectRepository.OrganizationInformationPage;
import vtigerFrameworkReal.ObjectRepository.OrganizationsPage;
import vtigerFrameworkReal.genericutility.BaseClass;
import vtigerFrameworkReal.genericutility.ExcelFileUtility;
import vtigerFrameworkReal.genericutility.JavaUtility;
import vtigerFrameworkReal.genericutility.PropertyFileUtility;
import vtigerFrameworkReal.genericutility.WebDriverUtility;

public class MultipleOrgTest extends BaseClass
{
	
@Test(dataProvider="orgdata")
public void readMultipleDataTest(String org,String industry) throws IOException {
	
	
	String orgname = org+jutil.getRandomNumber();
        
	

	
	HomePage h = new HomePage(driver);
	h.clickOnOrganisation();
	
	OrganizationsPage or = new OrganizationsPage(driver);
	or.clickOnOrganizationImg();
	
	CreatingNewOrganizationPage cr = new CreatingNewOrganizationPage(driver);
	cr.CreateOrganisation(orgname);
	cr.SelectIndustry(industry);
	cr.clickOnSave();
	
	OrganizationInformationPage of = new OrganizationInformationPage(driver);
	  String orgheader = of.validateOrgHeader();
	  if(orgheader.contains(orgname))
	  {
		  System.out.println("pass");
	  }
	  else
	  {
		  System.out.println("fail");
	  }
	  
	 
}


@DataProvider(name="orgdata")
public Object[][] getData() throws EncryptedDocumentException, IOException{
return 	eutil.readMultipleData("multipledata");
}
}
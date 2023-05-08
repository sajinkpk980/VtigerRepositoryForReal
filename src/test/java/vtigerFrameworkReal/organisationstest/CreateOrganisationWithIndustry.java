package vtigerFrameworkReal.organisationstest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
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
@Listeners(vtigerFrameworkReal.genericutility.ListenersImplimentation.class)
public class CreateOrganisationWithIndustry extends BaseClass {

	@Test(groups= {"SmokeSuite","RegressionSuite"})
	public void CreateOrgWithIndustryTest() throws IOException
	{
		

		String orgname = eutil.readDataFromExcel("Organisation", 4,2)+jutil.getRandomNumber();
            String INDUSTRY = eutil.readDataFromExcel("Organisation", 4, 3);
		

		
		
		HomePage h = new HomePage(driver);
		h.clickOnOrganisation();
		
		OrganizationsPage or = new OrganizationsPage(driver);
		or.clickOnOrganizationImg();
		
		CreatingNewOrganizationPage cr = new CreatingNewOrganizationPage(driver);
		cr.CreateOrganisation(orgname);
		cr.SelectIndustry(INDUSTRY);
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
	@Test(groups= {"SmokeSuite","RegressionSuite"})
	public void demoRegression() {
		Reporter.log("this is regional regression", true);
	}

}

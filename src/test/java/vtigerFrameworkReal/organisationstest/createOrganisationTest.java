package vtigerFrameworkReal.organisationstest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import vtigerFrameworkReal.ObjectRepository.CreatingNewOrganizationPage;
import vtigerFrameworkReal.ObjectRepository.HomePage;
import vtigerFrameworkReal.ObjectRepository.OrganizationsPage;
import vtigerFrameworkReal.genericutility.BaseClass;

public class createOrganisationTest extends BaseClass {

	@Test
	public void createOrgTest() throws IOException
	{
		
		Random r = new Random();
		int rannum = r.nextInt(1000);
		
     
     
     FileInputStream fise = new FileInputStream("./data/vtiger.xlsx");
   Workbook wb = WorkbookFactory.create(fise);
       String ORGNAME = wb.getSheet("Organisation").getRow(1).getCell(2).getStringCellValue()+rannum;
        //opening browser
       
       HomePage hp = new HomePage(driver);
       hp.clickOnOrganisation();
       
       OrganizationsPage or = new OrganizationsPage(driver);
       or.clickOnOrganizationImg();
       
       CreatingNewOrganizationPage cr = new CreatingNewOrganizationPage(driver);
       cr.CreateOrganisation(ORGNAME);
       
       cr.clickOnSave();
       
       
       
	}
	@Test
	public void demoTest() {
		System.out.println("this is demo test");
	}

}

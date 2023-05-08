package vtigerFrameworkReal.contactstest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtigerFrameworkReal.genericutility.BaseClass;
import vtigerFrameworkReal.genericutility.ExcelFileUtility;
import vtigerFrameworkReal.genericutility.JavaUtility;
import vtigerFrameworkReal.genericutility.PropertyFileUtility;
import vtigerFrameworkReal.genericutility.WebDriverUtility;
@Listeners(vtigerFrameworkReal.genericutility.ListenersImplimentation.class)
public class CreateContactWithOrgTest extends BaseClass{

	@Test (groups="SmokeSuite")
	public void createContactWithOrganisationTest() throws IOException
	{
		

		String ORGNAME = eutil.readDataFromExcel("contact", 4,3)+jutil.getRandomNumber();

		driver.findElement(By.xpath("//td[@class='tabUnSelected']/.//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		String ORGHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ORGHEADER.contains(ORGNAME))
		{
			System.out.println("organisatiomn created");
		}
		else
		{
			System.out.println("organisation not created");
		}

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();

		wutil.handlingChildWindow(driver,"Accounts");
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		wutil.handlingChildWindow(driver, "Contacts");

		String LASTNAME = eutil.readDataFromExcel("contact", 4, 2);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME+jutil.getRandomNumber());
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		
		
	}

}

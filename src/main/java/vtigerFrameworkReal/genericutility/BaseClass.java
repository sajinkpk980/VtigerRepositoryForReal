package vtigerFrameworkReal.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerFrameworkReal.ObjectRepository.HomePage;
import vtigerFrameworkReal.ObjectRepository.LoginPage;

public class BaseClass
{
	
	public	WebDriver driver=null;
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public JavaUtility jutil = new JavaUtility();
	public PropertyFileUtility putil = new PropertyFileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	//@Parameters("BROWSER")
	//@BeforeTest
@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
public void bcConfic(/*String BROWSER*/) throws IOException {
	String BROWSER = putil.readtPropertyFile("browser");
	String URL = putil.readtPropertyFile("url");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		//WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		Reporter.log(BROWSER+"---broeser launched---", true);
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		//WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		Reporter.log(BROWSER+"---broeser launched---", true);
	}
	else
	{
		System.out.println("invalid browser");
	}
	wutil.waitForDOMLoad(driver);
	wutil.maximizeWindow(driver);
	driver.get(URL);
	
}

@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
public void bmConfig() throws IOException {
	String USERNAME = putil.readtPropertyFile("username");
	String PASSWORD = putil.readtPropertyFile("password");
	LoginPage lp = new LoginPage(driver);
	lp.loginToApplication(USERNAME, PASSWORD);
	Reporter.log("login successfull", true);
}

@AfterMethod(groups= {"SmokeSuite","RegressionSuite"})
public void amConfig() {
	HomePage hp = new HomePage(driver);
	hp.signOut(driver);
	Reporter.log("logout successfull", true);
}
//@AfterTest
@AfterClass(groups= {"SmokeSuite","RegressionSuite"})
public void acConfig() {
	driver.close();
	Reporter.log("browser closed", true);
}

}
package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtigerFrameworkReal.ObjectRepository.HomePage;
import vtigerFrameworkReal.ObjectRepository.LoginPage;
import vtigerFrameworkReal.genericutility.JavaUtility;
import vtigerFrameworkReal.genericutility.PropertyFileUtility;
import vtigerFrameworkReal.genericutility.WebDriverUtility;

public class GenericPractice {

	public static void main(String[] args) throws IOException {
		WebDriverUtility wutil = new WebDriverUtility();
	     PropertyFileUtility putil = new PropertyFileUtility();
     WebDriver driver =new ChromeDriver();
     driver.get(putil.readtPropertyFile("url"));
     wutil.maximizeWindow(driver);
     wutil.waitForDOMLoad(driver);
     LoginPage p = new LoginPage(driver);
      p.loginToApplication(putil.readtPropertyFile("username"), putil.readtPropertyFile("password"));
      HomePage h = new HomePage(driver);
      h.clickOnContact();
      h.signOut(driver);
	}

}

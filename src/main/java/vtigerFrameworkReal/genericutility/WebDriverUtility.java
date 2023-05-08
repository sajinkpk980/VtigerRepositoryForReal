package vtigerFrameworkReal.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * this method is used for maximizing the window
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
}
/**
 * this method is to load 
 * @param driver
 */
public void waitForDOMLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

/**
 * this is used to handle dropdown based on selectbuindex
 * @param element
 * @param index
 */
public void handlingDropDown(WebElement element,int index) {
	Select s = new Select( element);
	s.selectByIndex(index);
}
/**
 *  this is used to handle dropdown based on selectbyvisibletext
 * @param element
 * @param visibletext
 */
public void handlingDropDown(WebElement element,String visibletext)
{
	Select s = new Select( element);
	s.selectByVisibleText(visibletext);
}
/**
 * this is used to handle dropdown based on selectbyvalue
 * @param value
 * @param element
 */
public void handlingDropDown(String value,WebElement element)
{
	Select s = new Select( element);
	s.selectByValue(value);
}
/**
 * this method is used to point the cursor into specific element
 * @param driver
 * @param element
 */
public void mouseHover(WebDriver driver,WebElement element)
{
   Actions a = new Actions(driver);
   a.moveToElement(element).perform();
}
/**
 * this method is used for double click on element
 * @param driver
 * @param element
 */
public void doubleClickOn(WebDriver driver,WebElement element) {
	Actions a = new Actions(driver);
	a.doubleClick(element).perform();
}
/**
 * this method is used for right click on element
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver , WebElement element)
{
	Actions a = new Actions(driver);
	a.contextClick(element).perform(); 
}
/**
 * this method will dismiss the alert
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * this method will accept alert
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * this method will return the text of alert
 * @param driver
 * @return
 */
public String getTextAlert(WebDriver driver)
{
	String text = driver.switchTo().alert().getText();
	return text;
}

/**
 * this method wait until clickable
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * this method is used for handling childwindow popup
 * @param driver
 * @param expTitle
 */
public void handlingChildWindow(WebDriver driver,String partialtext) {
	Set<String> allwh = driver.getWindowHandles();
	Iterator<String> it = allwh.iterator();
	while(it.hasNext())
	{
		String wid = it.next();
	String currentTitle = driver.switchTo().window(wid).getTitle();
	if(currentTitle.contains(partialtext))
		
	{
		break;
	}
	
	}}
public File takeScreenshot(WebDriver driver,String screenshotname) throws IOException
{
	TakesScreenshot t = (TakesScreenshot)driver;
	File src = t.getScreenshotAs(OutputType.FILE);
	String path = ".\\screenshot\\"+screenshotname+".png";
	File dst = new File(path);
	FileUtils.copyFile(src, dst);
	return dst.getAbsoluteFile();	
}
}

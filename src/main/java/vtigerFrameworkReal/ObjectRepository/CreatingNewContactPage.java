package vtigerFrameworkReal.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerFrameworkReal.genericutility.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility {
@FindBy(name="lastname")
private WebElement LastNameEdit;

@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']\"")
private WebElement OrgNameLookUp;

@FindBy(id="search_txt")
private WebElement SearchText;

@FindBy(name="search")
private WebElement SearchBtn;


@FindBy(name="button")
private WebElement SaveBtn;

private WebDriver driver;

public CreatingNewContactPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getLastNameEdit() {
	return LastNameEdit;
}

public WebElement getOrgNameLookUp() {
	return OrgNameLookUp;
}

public WebElement getSearchText() {
	return SearchText;
}

public WebElement getSearchBtn() {
	return SearchBtn;
}




public WebElement getSaveBtn() {
	return SaveBtn;
}
public void createContact(String LASTNAME)
{
	LastNameEdit.sendKeys(LASTNAME);
	SaveBtn.click();
}

public void createContactLastName(String LASTNAME,String orgname,WebDriver driver)
{
	LastNameEdit.sendKeys(LASTNAME);
	OrgNameLookUp.click();
	handlingChildWindow(driver,"Accounts");
	SearchText.sendKeys(orgname);
	SearchBtn.click();
	driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
	handlingChildWindow(driver, "Contacts");
	SaveBtn.click();
}

	

}

package vtigerFrameworkReal.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement CreateOrganizationImg;

public OrganizationsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCreateOrganizationImg() {
	return CreateOrganizationImg;
}

public void clickOnOrganizationImg()
{
	CreateOrganizationImg.click();
}
}

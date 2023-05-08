package vtigerFrameworkReal.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement OrganisationHeader;

public OrganizationInformationPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getOrganisationHeader() {
	return OrganisationHeader;
}

public String validateOrgHeader() {
	return OrganisationHeader.getText();
}
}

package vtigerFrameworkReal.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerFrameworkReal.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
@FindBy(linkText="Organizations")
private WebElement OrganisationLink;
@FindBy(linkText="Contacts")
private WebElement ContactLink;
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement AdministratorImg;
@FindBy(linkText="Sign Out")
private WebElement SignoutLink;

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getOrganisationLink() {
	return OrganisationLink;
}

public WebElement getContactLink() {
	return ContactLink;
}

public WebElement getAdministratorImg() {
	return AdministratorImg;
}

public WebElement getSignoutLink() {
	return SignoutLink;
}

public void clickOnOrganisation() {
	OrganisationLink.click();
}

public void clickOnContact() {
	ContactLink.click();
}

public void signOut(WebDriver driver) {
	mouseHover(driver, AdministratorImg);
	waitForElementToBeVisible(driver, SignoutLink);
	SignoutLink.click();
}
}

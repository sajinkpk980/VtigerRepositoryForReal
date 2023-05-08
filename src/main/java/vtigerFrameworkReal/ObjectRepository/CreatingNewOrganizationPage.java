package vtigerFrameworkReal.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerFrameworkReal.genericutility.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility{
@FindBy(name="accountname")
private WebElement OrganisationNameEdit;

@FindBy(name="button")
private WebElement SaveBtn;

@FindBy(name="industry")
private WebElement IndustryListBox;

public CreatingNewOrganizationPage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
}

public WebElement getOrganisationNameEdit() {
	return OrganisationNameEdit;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}

public WebElement getIndustryListBox() {
	return IndustryListBox;
}


public void CreateOrganisation(String orgname)
{
	OrganisationNameEdit.sendKeys(orgname);
}

public void SelectIndustry(String INDUSTRY)
{
	handlingDropDown(INDUSTRY, IndustryListBox);
}

public void clickOnSave()
{
	SaveBtn.click();
}
}

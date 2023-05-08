package vtigerFrameworkReal.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(name="user_name")
private WebElement UserNameEdit;
@FindBy(name="user_password")
private WebElement PasswordEdit;
@FindBy(id="submitButton")
private WebElement LoginBtn;

public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getUserNameEdit() {
	return UserNameEdit;
}

public WebElement getPasswordEdit() {
	return PasswordEdit;
}

public WebElement getLoginBtn() {
	return LoginBtn;
}

public void loginToApplication(String username,String password) {
	UserNameEdit.sendKeys(username);
	PasswordEdit.sendKeys(password);
	LoginBtn.click();
}
}

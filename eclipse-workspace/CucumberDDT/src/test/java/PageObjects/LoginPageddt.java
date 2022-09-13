package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageddt {
	public WebDriver driver;
	public LoginPageddt(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtemail;
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpassword;
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement btnLogin;
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname) {
		txtemail.clear();
		txtemail.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	public void clickLogout() {
		lnkLogout.click();
	}
}

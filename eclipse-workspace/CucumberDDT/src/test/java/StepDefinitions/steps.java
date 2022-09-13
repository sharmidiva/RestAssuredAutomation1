package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LoginPageddt;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;

public class steps {
	public WebDriver driver;
	public LoginPageddt lpddt;

@Given("User Launch Chrome browser")
public void user_launch_chrome_browser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	lpddt=new LoginPageddt(driver);
    
}

@When("User Opens URL {string}")
public void user_opens_url(String url) {
	driver.get(url);
   
}

@When("User  enters email as {string} and password as {string}")
public void user_enters_email_as_and_password_as(String email, String password) {
	lpddt.setUserName(email);
	lpddt.setPassword(password);

}

@When("Click on Login")
public void click_on_login() {
	lpddt.clickLogin();
  
}

@Then("Page title shpuld be {string}")
public void page_title_shpuld_be(String title) {
	if(driver.getPageSource().contains("Login was unsuccessful.")) {
		driver.close();
		Assert.assertTrue(false);
		
	}else
	{
	Assert.assertEquals(title,driver.getTitle());
	}
	
   
}

@When("user clicks Logout link")
public void user_clicks_logout_link() throws InterruptedException {
	lpddt.clickLogout();
	Thread.sleep(3000);
   
}

@Then("page title should be {string}")
public void page_title_should_be(String string) {
    
}

@Then("close Browser")
public void close_browser() {
	driver.quit();
   
}

}

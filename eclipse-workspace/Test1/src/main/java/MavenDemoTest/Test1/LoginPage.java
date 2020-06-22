package MavenDemoTest.Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	
	public WebDriver driver;
	
	By userName = By.id("username");
	By continue_btn = By.xpath("//span[text()=\"Continue\"]");
	By password = By.id("password");
	By loginBtn = By.xpath("//button[@data-cy=\"login\"]");
	By logedIn_user = By.xpath("//p[@data-cy=\"loggedInUser\"]");
	By arrowdown = By.id("loginTrigger");
	By account = By.xpath("//li[@data-cy=\"account\"]");
	By logoutButton = By.xpath("//a[@data-cy=\"userMenuLogout\"]");
    By userInputSection = By.xpath("//section[@class=\"modalMain \"]");
    By loginButton = By.xpath("//span[text()=\"Login\"]");
    By userProfile = By.xpath("//div[@class=\"userDropdown fadeInDown makeFlex column\"]");

//Constructor to initialize driver
public LoginPage(WebDriver driver) {
	this.driver =driver;
	}


public void enterUsername()
{
	driver.findElement(userName).sendKeys("msonam1408@gmail.com");
	

}

public void enterPassword()
{
	WebDriverWait wait = new WebDriverWait(driver,40);
	wait.until(ExpectedConditions.presenceOfElementLocated(password));
	 driver.findElement(password).sendKeys("sonam@123");
	
}
public void clickloginBtn()
{
	WebDriverWait wait = new WebDriverWait(driver,50);
	wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
	 driver.findElement(loginBtn).submit();
}
public WebElement clickAccount()
{  
	WebDriverWait wait = new WebDriverWait(driver,40);
	wait.until(ExpectedConditions.presenceOfElementLocated(account));
	return driver.findElement(account);
	
}
public WebElement clickLogout()
{
	return driver.findElement(logoutButton);
}

public void continueBtn() {
	
	WebDriverWait wait = new WebDriverWait(driver,50);
	wait.until(ExpectedConditions.elementToBeClickable(continue_btn));
	//Use submit because click is not working
	System.out.println("The continue button is enabled :" +driver.findElement(continue_btn).isEnabled());
	driver.findElement(continue_btn).submit();

}
public WebElement enterUserInputSection()
{
	return driver.findElement(userInputSection);
}  

public void verifyLoggedinUser() {
	String text = driver.findElement(logedIn_user).getText();
	Assert.assertEquals(text, "Hey sonam");
}
 public void clickLoggedInUser()
 {
	 driver.findElement(arrowdown).click();
	 driver.findElement(userProfile).isDisplayed();
	 Assert.assertEquals(driver.findElement(logoutButton).getText(), "Logout");
	 //driver.findElement(logoutButton);
	// driver.switchTo().frame(0);
	 Actions action =new Actions(driver);
	 action.click();
	 action.click(driver.findElement(logoutButton));
 }
 
}



package MavenDemoTest.Test1;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestLogin001 extends MultiBrowser {
	WebDriver driver;
	LoginPage loginpage;
	BookFlight bookflight;
	ExtentreportNG report;
	ExtentTest logger;
	
@BeforeMethod
public void setUp() throws Exception
{
	driver=getDriver();
	driver.get(getAppurl());
	//report.getReportObject();
	
}
@Test
public void testValidLogin()
{
	
	bookflight = new BookFlight(driver);
	loginpage = new LoginPage(driver);
	report= new ExtentreportNG();
	//logger= new ExtentTest(null, null);
	//logger.getRunStatus();
			loginpage.clickAccount().click();
			loginpage.enterUserInputSection();
			loginpage.enterUsername();
			loginpage.continueBtn();
			loginpage.enterPassword();
			loginpage.clickloginBtn();
			loginpage.verifyLoggedinUser();
			//bookflight.getParentWindow(); 
			//bookflight.verifyLogo();
			bookflight.widegetLoader();
			bookflight.getFromBtn(); //click on from 
			bookflight.enterFromCity().sendKeys("Mumbai");//enter city
			bookflight.clickOnSelectedFromCity();
			bookflight.getToCity();
			bookflight.enterToCity().sendKeys("Delhi");
			bookflight.selectOptionToCity();
			bookflight.selectDate();
			//loginpage.clickAccount().click();
			loginpage.clickLoggedInUser();
			loginpage.clickLogout();
			
			
				
		}
@AfterMethod
public void close() {
//public void getResult(ITestResult result)
//{
//	if(result.getStatus()==ITestResult.FAILURE)
//	{
//		}
	driver.quit();

}
}
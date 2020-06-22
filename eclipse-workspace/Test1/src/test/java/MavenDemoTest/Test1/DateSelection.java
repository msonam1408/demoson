package MavenDemoTest.Test1;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateSelection {
	
	
 WebDriver driver;
 
 public DateSelection(WebDriver driver)
 {
	 this.driver=driver;
 }
By selectDeparture = By.xpath("//div[@class=\"fsw_inputBox dates inactiveWidget \"]");
By verifyText = By.xpath("//span[@data-cy=\"selectReturnDate\"]");
By nextMonth = By.xpath("//span[@aria-label=\"Next Month\"]");
By Date = By.xpath("//div[@class='DayPicker-Day']");
By month = By.xpath("//div[@class='DayPicker-Month'][1]");
By date = By.xpath("//div[@class='dateInnerCell'][1]");
By month_caption = By.xpath("//div[@class='DayPicker-Caption'][1]");
String month1 = "July 2020";
By date1 = By.xpath("//div[@class='DayPicker-Day'][@aria-label=\"Thu Jul 30 2020\"]");
By search_btn = By.xpath("//a[text()=\"Search\"]");
By visible_text = By.id("travellerAndClass");
By loading_text = By.xpath("//span[text()=\"Hold on, we’re fetching flights for you..\"]");
By flight_list = By.xpath("//button[@class=\"ViewFareBtn  text-uppercase \"]");
By book_btn=By.xpath("//div[@class=\"make_relative\"]//button[text()=\" Book Now \"]");
By fair_summary= By.xpath("//p[text()=\"Fare Summary\"]");

@Test
		public void selectDate()
		{
//			System.setProperty("webdriver.gecko.driver", "D:/SeleniumDrivers/geckodriver.exe");
//			driver = new FirefoxDriver();
//			driver.get("https://www.makemytrip.com");
			WebDriverWait wait = new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.presenceOfElementLocated(selectDeparture));
			driver.findElement(selectDeparture).click();
			driver.findElement(nextMonth).click();
			//Assert.assertEquals(month, "JUNE 2020");
			
			
			while(true)
			{
				String element = driver.findElement(month_caption).getText();
				System.out.println(element);
				if(element.equals(month1))
				{
				System.out.println("selected month is :" +month1);	
				driver.findElements(date1).get(0).click();
				break;
				}
				else {
				
					driver.findElement(nextMonth).click();
			}
		}
			driver.findElement(search_btn).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loading_text));
			driver.findElements(flight_list).get(0).click();
			driver.findElements(book_btn).get(0).click();
			System.out.println("Go to review page now");
			//Get all the available windows and switch to it
			Set<String>set = driver.getWindowHandles();
			for(String windowHandle: set)
			{
				driver.switchTo().window(windowHandle);
				System.out.println("Getting the wndow handle:"+windowHandle);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(fair_summary));
			String fair_summary_detail = driver.findElement(fair_summary).getText();
			System.out.println(fair_summary_detail);
			Assert.assertEquals("Fare Summary",fair_summary_detail,"Fair summary page is open");
		
			
		}}
		
			
		



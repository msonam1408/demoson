package MavenDemoTest.Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BookFlight
{
   
     WebDriver driver; 
     
     private By mmtlogo = By.cssSelector(".mmtLogo.makeFlex"); 
     private By radioRoundTrip = By.xpath("//li[@data-cy=\"roundTrip\"]");
     private By fromCity = By.xpath("//span[text()=\"From\"]");
     private By fromSearch = By.xpath("//input[@placeholder=\"From\"]");
     private By toCity = By.xpath("//label//span[text()=\"To\"]");
     private By toSearch = By.xpath("//input[@placeholder=\"To\"]");
     private By selectFromCity = By.xpath("//li[contains(@id,\"react-autowhatever-1\")]");
     private By selectToCity =By.xpath("//li[contains(@id,\"react-autowhatever-1\")]");
     private By selectDeparture1 = By.xpath("//div[@class=\"fsw_inputBox dates inactiveWidget \"]");
     private By verifyText1 = By.xpath("//span[@data-cy=\"selectReturnDate\"]");
     private By nextMonth1 = By.xpath("//span[@aria-label=\"Next Month\"]");
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
     
     //
     By widgetLoader = By.xpath("//div[@class=\"widgetLoader\"]");
  
	
    public BookFlight(WebDriver driver)
    {
 	   this.driver=driver;
    }
   
   public void verifyLogo() 
   {
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  System.out.println("MMT logo is displeyed!"+ driver.findElement(mmtlogo).isDisplayed());
	  driver.findElement(mmtlogo).click();
   }
   
   public void widegetLoader()
   {
	  System.out.println( driver.findElement(widgetLoader).isDisplayed());
   }
   public WebElement clickRoundTrip()
   {
	  return driver.findElement(radioRoundTrip);
   }
   
   public void getFromBtn()
   {
	   WebDriverWait wait = new WebDriverWait(driver,60);
   wait.until(ExpectedConditions.presenceOfElementLocated(fromCity));
   Actions actions = new Actions(driver);
   actions.moveToElement(driver.findElement(fromCity)).click().build().perform();
	// return driver.findElement(fromCity);
   }
   public WebElement enterFromCity()
   {
	   WebDriverWait wait = new WebDriverWait(driver,60);
       wait.until(ExpectedConditions.presenceOfElementLocated(fromSearch));
	   return driver.findElement(fromSearch);
   }
   public WebElement getToCity()
   {
	   WebDriverWait wait = new WebDriverWait(driver,60);
	   wait.until(ExpectedConditions.presenceOfElementLocated(toCity));
	   return driver.findElement(toCity);
	  
   }
   public WebElement selectOptionFromCity()
   {
	   return driver.findElement(selectFromCity);
   }
   public WebElement enterToCity()
   {
	 return  driver.findElement(toSearch);
   }
   public WebElement selectOptionToCity()
   {
	   return driver.findElement(selectToCity);
   }
 
   public void verifyText()
   {
	   
	   Assert.assertEquals(verifyText1, "Book round trip for great savings");
   }
   public  void waitForLogo()
	{
	    WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mmtlogo));
	}
   public WebElement selectNextMonth()
   {
	   
	return   driver.findElement(nextMonth1);	   
	   
   }
   public void selectDate()
	{
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.presenceOfElementLocated(selectDeparture1));
		driver.findElement(selectDeparture1).click();
		driver.findElement(nextMonth1).click();
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
			
				driver.findElement(nextMonth1).click();
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
		Assert.assertEquals("Fare Summary",fair_summary_detail,"Fair summary page is not open");
		System.out.println("Page summary is here go ahead with the payment!");
	
	}
   
   public void clickOnSelectedFromCity()    //Get list of all available autosuggested options
   {
	driver.findElement(selectFromCity).click();
   
	
}

}
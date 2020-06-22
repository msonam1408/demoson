package MavenDemoTest.Test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowser {
	public static WebDriver driver;
	public Properties  pro ;
	
	public   WebDriver getDriver() throws IOException
	{
		
		pro = new Properties();
		
		FileInputStream fis = new FileInputStream ( "C:\\Users\\LENOVO\\eclipse-workspace\\Test1\\Config\\config.properties");
	       
        pro.load(fis);
       
        String browser = pro.getProperty("browser");
        
        
        
		if(browser.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver","D:\\SeleniumDrivers\\geckodriver.exe");
		driver=new FirefoxDriver();	
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\SeleniumDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.IEDriverServerz.driver","D:\\SeleniumDrivers\\IEDriverServer.exe");
			driver=new FirefoxDriver();
			
		}
		else
		{
			System.out.println("Invalid selection");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    return driver;
	}
	public String getAppurl() throws Exception
	{
		String url = pro.getProperty("url");
		if(url!=null)
		return url;
		else throw new Exception("url not found");
	}
	
	public String getScreenshot(String testcasenames,WebDriver driver ) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\Reports\\"+testcasenames+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		
	}
	
}

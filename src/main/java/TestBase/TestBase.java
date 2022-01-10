package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.Testutil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\RP\\eclipse-workspace\\pomhybrid\\src\\main\\java\\configProperties\\config.properties");
			prop.load(ip);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
	}
	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			
			
		    driver=new ChromeDriver();
		    
		}
		
		
		  else if(browsername.equalsIgnoreCase("firefox")) {
		 System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe"); 
		 driver=new FirefoxDriver();
		 
		 }
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT,TimeUnit.SECONDS);	
	
	    driver.get(prop.getProperty("url"));
	}

}

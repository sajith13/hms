package hms.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hms.utility.WebEventListener;

public class testbase {
	
	public static Properties pop;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebEventListener web_el;
	public static EventFiringWebDriver event_fire;
	
public testbase() {
	pop=new Properties();
	try {
		FileInputStream ipconfig=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/hms/config/config.properties");
	    pop.load(ipconfig);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}
//initial setup
public static void initialisation() {
	  String browserName=pop.getProperty("browser");
	  if(browserName.equals("chrome")) {
           System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
           driver=new ChromeDriver();
	  }else if(browserName.equals("ff")){
		  System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
		  driver=new FirefoxDriver();
	  }	else if(browserName.equals("edge")) {
		  System.setProperty("webdriver.edge.driver","./src/test/resources/msedgedriver1.exe");
		  driver=new EdgeDriver();
	  }

	//basic method
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(70,TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get(pop.getProperty("url"));
	  //Event firing webdriver
	  web_el=new WebEventListener();
	  event_fire=new EventFiringWebDriver(driver);
	  event_fire.register(web_el);
	  driver=event_fire;	  
}
//for ExplicitWait

   public static void waitforElementVisible(WebElement el){
	   wait=new WebDriverWait(driver,30);
	   wait.until(ExpectedConditions.visibilityOf(el));
   }
  	
}

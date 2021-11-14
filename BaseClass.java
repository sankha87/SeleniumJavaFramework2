package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
  public static WebDriver driver;
  @Parameters({"browser"})
  @BeforeClass
  public void launchBrowser(String browser) {
	  if(browser.equalsIgnoreCase("Chrome")){
System.setProperty("webdriver.chrome.driver", "C:\\browser drivers\\chromedriver.exe");
 		 driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("Firefox")) {
System.setProperty("webdriver.gecko.driver", "C:\\browser drivers\\geckodriver.exe");
	 	 driver = new FirefoxDriver();
	  }
	  else if(browser.equalsIgnoreCase("Edge")) {
System.setProperty("webdriver.edge.driver", "C:\\browser drivers\\edgedriver.exe");
	 	 driver = new EdgeDriver();
	  }
	  else {
System.setProperty("webdriver.chrome.driver", "C:\\browser drivers\\chromedriver.exe");
	 	 driver = new ChromeDriver();
	  }
driver.get(Constants.URL);	  
  }
  
  @AfterClass
  public void tearDown() {
	  driver.manage().deleteAllCookies();
	  driver.quit();
  }
	
}

package RestAssuredGroup.parallelTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void crossBrowser(String browser) {

		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:/Users/Kranti/Documents/Tools/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("security.sandbox.content.level", 5);
			driver = new FirefoxDriver(options);
		}
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/Kranti/Documents/Tools/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:/Users/Kranti/Documents/Tools/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
	@Test
	public void getTitle(){
		driver.get("https://www.seleniumhq.org");
		String title = driver.getTitle();
		System.out.println("Title of the page is: "+title);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

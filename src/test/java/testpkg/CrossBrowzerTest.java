package testpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowzerTest {
	
	WebDriver driver;
	String url="https://surabhigandhi.co/";
	
	@Parameters({"browzer"})
	@BeforeTest
	public void setUp(String browzer) {
		
		if(browzer.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		else if(browzer.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
			
		}
		
		else if(browzer.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		
	}
	
	@Test
	public void crossBrowzerTest() {
		driver.get(url);
	}
	
	@AfterTest
	public void gearDown() {
		driver.quit();
	}

}

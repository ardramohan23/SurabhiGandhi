package pagepkg;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	

	WebDriver driver;
	public final static Logger LOGGER=Logger.getLogger(HomePage.class.getName());
	@FindBy(xpath="//*[@id=\"HeaderMenu-home\"]/span")
	WebElement home;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void homelabelTest() {
		
		String exp_url="https://surabhigandhi.co/";
		try {
		home.click();
		String actual_url=driver.getCurrentUrl();
		Assert.assertEquals(actual_url, exp_url);
		LOGGER.info("Home when clicked redirected to intended page");
		}catch (Exception e) {
			LOGGER.severe("Home when clicked redirects to wrong page");
		}
		
	}
	
	public void linkValidationTest()  {
			
			List<WebElement> linklist=driver.findElements(By.tagName("a"));
			System.out.println("Total number of links present in home page: "+linklist.size());
			for(WebElement list:linklist) {
				String link=list.getAttribute("href");
				String linkName=list.getText();
				try {
					URL u=new URL(link);
					HttpURLConnection ht=(HttpURLConnection) u.openConnection();
					int responseCode=ht.getResponseCode();
					if(responseCode>=200&&responseCode<300) {
				
						System.out.println(linkName+" "+link+" "+responseCode+" ---SUCCESS---");
					}
					else {
						System.out.println(linkName+" "+link+" "+responseCode+" ---FAILED---");
					}
				}catch (Exception e) {
					
					System.out.println(linkName+" "+link+" has some issues");
					e.getMessage();
					
				}
				
					
					
				}
					
			}

}

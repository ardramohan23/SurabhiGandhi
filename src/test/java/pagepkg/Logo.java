package pagepkg;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Logo {
	

	WebDriver driver;
	private final static Logger LOGGER = Logger.getLogger(Logo.class.getName());
	@FindBy(xpath="//*[@id=\"shopify-section-sections--15572544553158__header\"]/sticky-header/header/h1/a")
	WebElement logo;
	@FindBy(tagName = "img")
	WebElement logoSize;
	
	
	
	
	public Logo(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void logoTest() {
		
		String exp_url="https://surabhigandhi.co/";
		try {
		logo.click();
		Assert.assertEquals(driver.getCurrentUrl(), exp_url);
		LOGGER.log(Level.INFO, "Logo when clicked redirected to homepage");
		}catch(AssertionError e){
			  LOGGER.log(Level.SEVERE, "Assertion failed", e);
		}
		Dimension dimention=logoSize.getSize();
		int expwidth=170;
		int actualWidth=dimention.getWidth();
		int expheight=55;
		int actualheight=dimention.getHeight();
		try {
			Assert.assertEquals(actualWidth, expwidth);
			LOGGER.info("Width satisfies expectation");
			Assert.assertEquals(actualheight, expheight);
			LOGGER.info("Height satisfies expectation");
		}catch (Exception e) {
			LOGGER.severe("Width doesn't satisfy expectation");
		}
	}

}

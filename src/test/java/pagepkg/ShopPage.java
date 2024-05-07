package pagepkg;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
	
	static WebDriver driver;
	Logger LOGGER=Logger.getLogger(ShopPage.class.getName());
	@FindBy(xpath="//*[@id=\"HeaderMenu-shop\"]/span")
	WebElement shoplabel;
	@FindBy(xpath="//*[@id=\"HeaderMenu-shop-by-collection\"]/span")
	WebElement byCollection;
	@FindBy(xpath="//*[@id=\"HeaderMenu-shop-by-collection-the-sorello-sunset-2023-2024\"]")
	WebElement sorelloSunset;
	@FindBy(xpath="//*[@id=\"shopify-section-template--15572544028870__main-collection-product-grid\"]/div/div")
	static
	WebElement products;
	@FindBy(name="add")
	static
	WebElement addtocartButton;
	@FindBy(xpath="//*[@id=\"cart-notification\"]/div[3]/button")
	static
	WebElement continueShopping;
	public ShopPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void shopByCollectionTest() {
		
		shoplabel.click();
		byCollection.click();
		sorelloSunset.click();
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("argument[0].scrollIntoView()", products);
		productValidation();
	}
	
	public static void productValidation() {
		
		List<WebElement> list=products.findElements(By.tagName("a"));
		int listSize=list.size();
		System.out.println("No of products = "+listSize);
		for(WebElement product:list) {
			String productLink=product.getAttribute("href");
			String productName=product.getText();
			System.out.println(productLink+" "+productName);
			if(productName.isEmpty()||productName.equals("null")) {
				continue;
			}
			try {
				Alert alert = driver.switchTo().alert();
			    alert.dismiss();
			    System.out.println("Alert was present and accepted");
			} catch (NoAlertPresentException e) {
			    // If the alert is not present, catch the exception and continue
			    System.out.println("Alert was not present");
			}
			product.click();
			addtocartButton.click();
			driver.navigate().back();
			
			
		}
	}


	

}

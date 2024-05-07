package pagepkg;


import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	Logger LOGGER=Logger.getLogger(AccountPage.class.getName());
	@FindBy(xpath="//*[@id=\"shopify-section-sections--15572544553158__header\"]/sticky-header/header/div/a[1]")
	WebElement accountIcon;
	@FindBy(xpath="//*[@id=\"customer_login\"]/a[2]")
	WebElement createAccount;
	@FindBy(xpath="//*[@id=\"RegisterForm-FirstName\"]")
	WebElement firstname;
	@FindBy(xpath="//*[@id=\"RegisterForm-LastName\"]")
	WebElement lastname;
	@FindBy(xpath="//*[@id=\"RegisterForm-email\"]")
	WebElement email;
	@FindBy(xpath="//*[@id=\"RegisterForm-password\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"create_customer\"]/button")
	WebElement createButton;
	@FindBy(xpath="//*[@id=\"CustomerEmail\"]")
	WebElement customer_email;
	@FindBy(xpath="//*[@id=\"CustomerPassword\"]")
	WebElement customer_password;
	@FindBy(xpath="//*[@id=\"customer_login\"]/button")
	WebElement logIn_Button;
	@FindBy(xpath="//*[@id=\"shopify-section-template--15572544291014__main\"]/div/div[1]/a")
	WebElement logOut;
	
	
    public AccountPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

    public void accountPage() {
	
	accountIcon.click();
	
    }
    
    public void createAccount() {
    	
    	createAccount.click();
    	firstname.sendKeys("Anna");
    	lastname.sendKeys("Ann");
    	email.sendKeys("abc@gmail.com");
    	password.sendKeys("Abc1234@");
    	createButton.click();
    	
    }
    
    public void logInCredentials(String username, String password) {
    	
    	customer_email.sendKeys(username);
    	customer_password.sendKeys(password);
  
    }
    
    public void logIn() {
    	
    	logIn_Button.click();
    	
    }
    
    public void logOut() {
    	logOut.click();
    }
    
    
	
	


}

      


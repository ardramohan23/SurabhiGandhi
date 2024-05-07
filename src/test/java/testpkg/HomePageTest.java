package testpkg;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import basepkg.BaseClass;
import pagepkg.HomePage;

public class HomePageTest extends BaseClass {
	
	@Test
	public void homeTest() throws MalformedURLException {
		HomePage hp=new HomePage(driver);
		hp.homelabelTest();
		hp.linkValidationTest();
	}

}

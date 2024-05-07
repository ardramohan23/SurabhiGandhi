package testpkg;

import org.testng.annotations.Test;

import basepkg.BaseClass;
import pagepkg.ShopPage;

public class ShopTest extends BaseClass {
	
	@Test
	public void shopPageTest() {
		
		ShopPage sh=new ShopPage(driver);
		sh.shopByCollectionTest();
		
	}
	
	

}

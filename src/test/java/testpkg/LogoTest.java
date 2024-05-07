package testpkg;

import org.testng.annotations.Test;

import basepkg.BaseClass;
import pagepkg.Logo;

public class LogoTest extends BaseClass {
	
	@Test
	public void logotest() {
		Logo ob=new Logo(driver);
		ob.logoTest();

}
}
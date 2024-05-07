package testpkg;

import org.testng.annotations.Test;

import basepkg.BaseClass;
import pagepkg.AccountPage;
import utilitypkg.ExcelUtils;

public class AccountPageTest extends BaseClass {
	
	@Test
	public void accountPageTest() throws Exception {
		
		AccountPage ap=new AccountPage(driver);
		test=extent.createTest("accountPageTest");
		ap.accountPage();
//		ap.createAccount();
		String x1="C:\\Users\\ARDRA MOHAN\\OneDrive\\Documents\\JavaNotepadcodes\\surabhilogin.xlsx";
		String sheet="Sheet1";
		int rowCount=ExcelUtils.getRowCount(x1, sheet);
		System.out.println("Row count: "+rowCount);
//		for(int i=1;i<=rowCount;i++) {
			String username=ExcelUtils.getCellValue(x1, sheet, 1, 0);
			System.out.print("UserName: "+username);
			String password=ExcelUtils.getCellValue(x1, sheet, 1, 1);
			System.out.println(" Password: "+password);
			ap.logInCredentials(username, password);
			ap.logIn();
//			ap.logOut();
//		}
	}

}

package basepkg;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	public static WebDriver driver;
    String url="https://surabhigandhi.co/";
    ExtentHtmlReporter reporter;
	protected ExtentTest test;
	protected ExtentReports extent;
	
	@BeforeTest
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		reporter=new ExtentHtmlReporter("./Reports/TestReport1.html");
		reporter.config().setDocumentTitle("Automation-Test-Report");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("HOSTNAME", "LOCALHOST");
		extent.setSystemInfo("OS", "WINDOWS11");
		extent.setSystemInfo("TESTER NAME", "Ardra");
		extent.setSystemInfo("BROWZER NAME", "Chrome");
		driver=new ChromeDriver();
		
		
	}
	
	@BeforeMethod
	public void before() {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	
	@AfterMethod
	public void browzerclose(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "test case failed is "+result.getName());
			test.log(Status.FAIL, "test case failed because "+result.getThrowable());
			String screenshotpath=screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
			
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "test case skipped is "+result.getName());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "test case is passed "+result.getName());
		}
		
	}
	
	private String screenshotMethod(WebDriver driver, String screenshotname) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination="./Screenshots/"+screenshotname+".png";
		FileHandler.copy(src, new File(destination));
		return destination;
	}
	
	@AfterTest
	public void gearDown() {
		extent.flush();
	}


}

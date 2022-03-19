package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import freemarker.template.SimpleDate;

public class BaseClass {
	
	public static WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeTest
	public void dataSetup() throws IOException {
		FileInputStream fis = new FileInputStream("Logindata.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Sheet1");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
		String strdate = formatter.format(date);
		report = new ExtentReports("reports\\extentreport  "+strdate+".html");
		
	}
	
	@AfterTest
	public void dataTearDown() throws IOException {
		wb.close();
		report.flush();
		report.close();
	}
	
	@BeforeMethod
	public void setUp(Method method) {
		
		test= report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void tearDown() {
		report.endTest(test);
		driver.close();
	}

}

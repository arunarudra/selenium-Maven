package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	
	
	
	@Test
	public void LoginFailureTest() {
		
		test = report.startTest("LoginFailureTest");
		LoginPage lp=new LoginPage();
		
		//WebDriverWait wait= new WebDriverWait(driver,40);
		
		//wait.until(ExpectedConditions.elementToBeClickable(loginLink));

		lp.loginFunc("aruna.rudra76@gmail.com","Dfsdf@55word123");
		
		WebElement errormsg =driver.findElement(By.id("msg_box"));
		
		String msg = errormsg.getText();
		String expmsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(msg, expmsg);
		
		//report.endTest(test);
		
		
		
		
	} 
	

	@Test
	public void loginSuccessTest() throws Exception {
		
	//	test = report.startTest("loginSuccessTest");
		LoginPage lp=new LoginPage();
		HomePage hp=new HomePage();
			
			//WebDriverWait wait= new WebDriverWait(driver,40);
			
			//wait.until(ExpectedConditions.elementToBeClickable(loginLink));
			
			lp.loginFunc("aruna.rudra76@gmail.com","N0newp@55word");
			
					
			String msg =driver.getTitle();
			System.out.println("url is : " +msg);
			
			//String msg = errormsg.getText();
			//String expmsg = "The email or password you have entered is invalid.";
			
			Assert.assertEquals(msg, "Learning on Simplilearn");
			hp.clickProfile();
			hp.clickLogOut();
			
		//	report.endTest(test);
	} 
	
/*	@Test
	@Parameters({"param1","param2"})
	
	public void parameterTest(String username,String pass) {
		LoginPage lp=new LoginPage();
		lp.loginFunc(username,pass);
		
		
	} */

	@Test(enabled=false)
	
	public void externalDataTest() {
		LoginPage lp=new LoginPage();
		String username = sheet.getRow(1).getCell(0).getStringCellValue();
		String pass = sheet.getRow(1).getCell(1).getStringCellValue();
		lp.loginFunc(username,pass);
		
		
	}
	
}

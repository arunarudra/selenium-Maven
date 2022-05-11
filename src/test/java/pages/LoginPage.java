package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage  {
	
	WebDriver driver=BaseClass.driver;
	ExtentTest test= BaseClass.test;
//================WebElements=========================
	
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	@FindBy(name="user_login")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(name="btn_login")
	WebElement loginbtn;
	
	@FindBy(className="rememberMe")
	WebElement chkbox;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	

//=================== Action methods===============================
	
	public void loginFunc(String usrname, String pass) {
		//WebDriver driver=BaseClass.driver;
		
		
		loginLink.click();
		
		test.log(LogStatus.PASS, "Click on Login Link","Link Clicked successfully");
		username.sendKeys(usrname);
		password.sendKeys(pass);
		test.log(LogStatus.PASS, "username and password provided ","succesfully provided");

		chkbox.click();
		loginbtn.click();	
		test.log(LogStatus.PASS, "login button clicked successfully ","succesfully clicked");

	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcases.BaseClass;

public class HomePage {
	WebDriver driver=BaseClass.driver;
	
	//================WebElements=========================
		
		@FindBy(xpath="//span[@class='profile-img']")
		WebElement profileclick;
		
		@FindBy(xpath="//*[contains(@title,'Logout')]")
		WebElement logout;
	
		public HomePage() {
			PageFactory.initElements(driver, this);
		}

		
		public void clickProfile() {
			
			profileclick.click();
		}
		
		public void clickLogOut() {
			logout.click();
			
		}
}

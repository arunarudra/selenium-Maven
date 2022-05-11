package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testcases.BaseClass;

public class TestNGListenerClass implements ITestListener {
	
	public void onTestStart(ITestResult result) {
	    System.out.println(" =========Test case started======");
	  }
	
	public void onTestFailure(ITestResult result) {
	    
		TakesScreenshot obj = (TakesScreenshot)BaseClass.driver;
		File srcfile = obj.getScreenshotAs(OutputType.FILE);
		File trgfile = new File("failedtest.png");
		try {
			FileUtils.copyFile(srcfile, trgfile);
			System.out.println("screenshot taken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	  }
}

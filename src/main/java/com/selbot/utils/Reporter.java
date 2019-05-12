package com.selbot.utils;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public abstract class Reporter extends AbstractTestNGCucumberTests{
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public String testcaseName, testcaseDec, author, category;
	public static  String excelFileName;
	
	@BeforeSuite
	public void startReport() {
		reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true); 
		extent   = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
    @BeforeClass
	public void report() throws IOException {
		test = extent.createTest(testcaseName, testcaseDec);
	    test.assignAuthor(author);
	    test.assignCategory(category);  
	}
    public abstract long takeSnap();
    
    public void reportStep(String desc, String status,boolean bSnap ) {
    	MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".jpg").build();
			} catch (IOException e) {
				
			}
		}
    	if(status.equalsIgnoreCase("pass")) {
    		test.pass(desc, img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		test.fail(desc, img); 
    	} else if(status.equalsIgnoreCase("INFO")) {
    		test.pass(desc); 
    	}
    }
    public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

    
    @AfterSuite
    public void stopReport() {
    	extent.flush();
    }

	public void click(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void append(WebElement ele, String data) {
		// TODO Auto-generated method stub
		
	}

	public void clear(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void clearAndType(WebElement ele, String data) {
		// TODO Auto-generated method stub
		
	}

	public String getElementText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBackgroundColor(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTypedText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyDisappeared(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyEnabled(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	public void startApp(String url) {
		// TODO Auto-generated method stub
		
	}

	public void startApp(String browser, String url) {
		// TODO Auto-generated method stub
		
	}

	public WebElement locateElement(String locatorType, String value) {
		// TODO Auto-generated method stub
		return null;
	}
}















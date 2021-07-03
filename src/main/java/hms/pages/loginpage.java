package hms.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.testbase;

public class loginpage extends testbase {
	
	
	@FindBy (css="input#email") WebElement uname;
	@FindBy (css="input#password") WebElement upass; 
	@FindBy (css="button.btn") WebElement bttn;
	@FindBy (linkText=" Forgot Password?") WebElement fpass;
	@FindBy(css="div.form-top-left>img")WebElement HMSlogo;
	
	//initializing the page object
	public loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	//to verify titletestng.xml
	public String verifytitle() {
	return driver.getTitle();
	}
	
	//to verify logo
	public boolean verifylogo() {
		return HMSlogo.isDisplayed();	
	}

   //for login
	public dashboardpage loging(String User,String Pass){
		uname.sendKeys(User);
		upass.sendKeys(Pass);
		bttn.click();
		return new dashboardpage();	
		
	}

}

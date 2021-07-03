package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import hms.base.testbase;

public class dashboardpage extends testbase {
	
	
	@FindBy(css="img.topuser-image")WebElement logclk;
	@FindBy(xpath="//h4[contains(text(),'Super Admin')]")WebElement logotxt;
	@FindBy(css="ul.sidebar-menu>li")WebElement frontoffice;


     public dashboardpage() {
	    PageFactory.initElements(driver, this);     	
     }


    public boolean verifyprofilename() {
		logclk.click();
		//waitforElementVisible(logotxt);
		boolean obj=logotxt.isDisplayed();	
    	return obj; 	
    }
    public frontofficepage clkfrontoffice() {
    	frontoffice.click();
    	return new frontofficepage();
    }
   


}
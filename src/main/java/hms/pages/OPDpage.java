package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import hms.base.testbase;

public class OPDpage extends testbase{
	
	@FindBy(xpath="//*[contains(text(),'OPD - Out Patient')]")WebElement vCliOPD;
	@FindBy(xpath="//h3[contains(text(),'OPD Patient')]") WebElement vVerifypagetitle;
	@FindBy(css="a#add") WebElement vClkAddPatint;
	@FindBy(xpath="//div[@id='myModal']/div/div/div[1]/h4")WebElement vVerifypopuptit;
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div[1]/div[1]/div/div[1]/div/input")WebElement vName;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(2)>div>input")WebElement vGuarName;
	@FindBy(xpath="//form[@id='formadd']/div/div/div/div[3]/div/select") WebElement vGender;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(4)>div>select")WebElement vMarstat;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(5)>div>input")WebElement vPhn;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(7)>div>input")WebElement vEmail;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(8)>div>input[name='address']")WebElement vAddress;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(9)>div>div>input[name='age']")WebElement vAgeyear;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(9)>div>div>input[name='month']") WebElement vAgemonth;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(10)>div>select")WebElement vBloodgrp;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(11)>div>input")WebElement vHeight;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(12)>div>input")WebElement vWeight;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(13)>div>input")WebElement vBP;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(14)>div>textarea")WebElement vSymp;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(15)>div>textarea")WebElement vAllergy;
	@FindBy(css="form#formadd>div>div>div>div:nth-child(16)>div>textarea")WebElement vNote;
	@FindBy(xpath="//div[@id='myModal']/div/div/div[1]/button")WebElement vClose;
	
	public OPDpage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean clk_verifyOPD() {
		vCliOPD.click();
		boolean obj=vVerifypagetitle.isDisplayed();
		return obj;
	}
	public boolean clk_verifyPOPup() {
		vClkAddPatint.click();
		waitforElementVisible(vVerifypopuptit);
		boolean obj1=vVerifypopuptit.isDisplayed();
		return obj1;	
	}
	public void enter_details(String data[]) {
		waitforElementVisible(vName);
		vName.sendKeys(data[0]);  
		vGuarName.sendKeys(data[1]);
         Select slt=new Select(vGender);
         slt.selectByVisibleText(data[2]);
         Select slt1=new Select(vMarstat);
         slt1.selectByVisibleText(data[3]);
         vPhn.sendKeys(data[4]);
         vEmail.sendKeys(data[5]);
         vAddress.sendKeys(data[6]);
         vAgeyear.sendKeys(data[7]);
         vAgemonth.sendKeys(data[8]);
         Select slt2=new Select(vBloodgrp);
         slt2.selectByVisibleText(data[9]);
         vHeight.sendKeys(data[10]); 
         vWeight.sendKeys(data[11]);
         vBP.sendKeys(data[12]);
         vSymp.sendKeys(data[13]);
         vAllergy.sendKeys(data[14]);
         vNote.sendKeys(data[15]);
         
         //vClose.click();
	}
	
}

package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.testbase;

public class frontofficepage extends testbase {
	
	@FindBy(xpath="//h3[contains(text(),'Appointment Details')]")WebElement pageName;
	@FindBy(xpath="//a[contains(text(),' Visitor Book')]")WebElement addvisclk;
	//@FindBy(css="div.box-tools>a[data-toggle='modal']")WebElement vAddAppClk;
	

public frontofficepage() {
	PageFactory.initElements(driver, this);
}
public boolean verifypageName(){	
	boolean obj=pageName.isDisplayed();	
	return obj;	
}
public visitorbookPage clickvisbook() {
	addvisclk.click();
	return new visitorbookPage();
}
//	public void enter_dteails() {
//	}

}

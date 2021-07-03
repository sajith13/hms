package hms.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import hms.base.testbase;
import hms.utility.CommonUtility;
import hms.utility.Datepicker;
public class visitorbookPage extends testbase {	
	Datepicker date=new Datepicker();
	
	@FindBy(css="form#formadd>div>div>div>div>select[name='purpose']")WebElement purpose;
	@FindBy(xpath="//h3[contains(text(),'Visitor List')]")WebElement verifypageNameVistrList;
	@FindBy(xpath="//a[contains(text(),'Add Visitor')]")WebElement clkAddVistr; 
	@FindBy(xpath="/html/body/div[3]/div/div/div[1]/h4")WebElement verifyPagePopup;
    @FindBy(css="form#formadd>div>div>div>div>input[name='name']")WebElement Name;
    @FindBy(css="form#formadd>div>div>div>div>input[name='contact']")WebElement Phone;
    @FindBy(css="form#formadd>div>div>div>div>input[name='id_proof']")WebElement ID;
    @FindBy(css="form#formadd>div>div>div>div>input[name='pepples']")WebElement NumberofPrsn;
    @FindBy(css="textarea#description")WebElement Note;
    @FindBy(css="div#myModal>div>div>div>button[class='close']")WebElement Close;
    @FindBy(css="input#date")WebElement vdate;
    @FindBy(xpath="//*[@id='formadd']/div[1]/div[6]/div/div/input")WebElement vUpload;
    @FindBy(xpath="//input[@name='time'][@id='stime_']")WebElement vIntime;
    @FindBy(xpath="//input[@name='out_time'][@id='stime_']") WebElement vOuttime;
    


public visitorbookPage() {
	PageFactory.initElements(driver, this);
}
public boolean verifyPageName() {
	boolean obj=verifypageNameVistrList.isDisplayed();
	return obj;
}
public void clkAddVistr() {
	clkAddVistr.click();
}
public boolean verify_PagePopup() {
	boolean obj9=verifyPagePopup.isDisplayed();
	return obj9;
}
public void enterDetails(String data[]) {
	String flop="C:\\Users\\sajith\\Desktop\\fileupload\\Letter.pdf";
	
	Select slt=new Select(purpose);
	slt.selectByVisibleText(data[0]);
	Name.sendKeys(data[1]);
	Phone.sendKeys(data[2]);
	ID.sendKeys(data[3]);
	NumberofPrsn.sendKeys(data[4]);
	vdate.click();
	date.datpicker(data[5]);
	//time pick
	CommonUtility.mouseClick(vIntime);
	vIntime.sendKeys(data[6]);
	CommonUtility.mouseClick(vOuttime);
	vOuttime.sendKeys(data[7]);
	Note.sendKeys(data[8]);
	//to upload
	CommonUtility.mouseClick(vUpload);
	CommonUtility.fileUpload(flop);
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	Close.click();	
}
}

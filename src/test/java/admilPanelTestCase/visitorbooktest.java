package admilPanelTestCase;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hms.base.testbase;
import hms.pages.dashboardpage;
import hms.pages.frontofficepage;
import hms.pages.loginpage;
import hms.pages.visitorbookPage;
import hms.utility.ReadExcel;

public class visitorbooktest extends testbase{
	loginpage objlogin;
	dashboardpage objdash;
	frontofficepage objfrontofc;
	visitorbookPage objvistpage;
	
	public visitorbooktest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialisation(); 
		objlogin=new loginpage();
		objdash=objlogin.loging(pop.getProperty("username"), pop.getProperty("password"));
		objfrontofc=objdash.clkfrontoffice();
		objvistpage=objfrontofc.clickvisbook();	
	}
	@DataProvider
	public Object[][] getvisdata(){
		String sheetName="vistor";
		Object[][] testdata=ReadExcel.getTestData(sheetName);
		return testdata;
	}
    @Test(dataProvider="getvisdata")
    public void verifypageVistList(String args[]) {
    	Assert.assertTrue(objvistpage.verifyPageName());
    	objvistpage.clkAddVistr();
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	Assert.assertTrue(objvistpage.verify_PagePopup());
    	objvistpage.enterDetails(args);
    }
    @AfterMethod
    public void teardown() {
    	driver.close(); 	
    }
}

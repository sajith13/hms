package admilPanelTestCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hms.base.testbase;
import hms.pages.OPDpage;
import hms.pages.loginpage;
import hms.utility.ReadExcel;

public class OPDpagetest extends testbase{
	loginpage objlogin;
	OPDpage objopd;
	
	@BeforeClass
	public void setup() {
		initialisation();
		objlogin=new loginpage();
		objlogin.loging(pop.getProperty("username"),pop.getProperty("password"));
		objopd=new OPDpage();
	}
	@DataProvider
	public  Object[][] getdata() {
		String sheetName="addpatient";
		Object[][] data=ReadExcel.getTestData(sheetName);
		return data;
	}
	@Test(priority=1)
	public void verifyOPD() {
	   	Assert.assertTrue(objopd.clk_verifyOPD());   	
	}
	@Test(priority=2)
	public void verifyAddPatnt() {
		Assert.assertTrue(objopd.clk_verifyPOPup());
	}
	@Test(dataProvider="getdata")
	public void enterDetails (String args[]) {
		objopd.enter_details(args);
		
	}
	@AfterClass
	public void teardown() {
	    driver.close();
	}
	

}

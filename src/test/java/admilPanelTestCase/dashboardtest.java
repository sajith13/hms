package admilPanelTestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.dashboardpage;
import hms.pages.loginpage;

public class dashboardtest extends testbase {
	loginpage objlogin;
	dashboardpage objdash;
	
	public dashboardtest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialisation();
		objlogin=new loginpage();
		objdash=objlogin.loging(pop.getProperty("username"), pop.getProperty("password"));
		
		
	}
	@Test()
	public void verifyprofileName() {
		Assert.assertTrue(objdash.verifyprofilename());
	}
	@Test()
	public void clickfrontoffice() {
		objdash.clkfrontoffice();
	}
	@AfterMethod
	public void teardown() {
		
		driver.close();
}
}
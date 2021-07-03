package admilPanelTestCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import hms.base.testbase;
import hms.pages.dashboardpage;
import hms.pages.frontofficepage;
import hms.pages.loginpage;

public class frontofficpagetest extends testbase {
	loginpage oblogin;
	dashboardpage obdash;
	frontofficepage objfrontofc;
	
	public frontofficpagetest() {
		super();
	}
	@BeforeClass
	public void setup() throws InterruptedException {
		initialisation();
		oblogin=new loginpage();
		obdash=oblogin.loging(pop.getProperty("username"),pop.getProperty("password"));
	    objfrontofc=obdash.clkfrontoffice();
	}
	@Test
	public void front_office() {
		Assert.assertTrue(objfrontofc.verifypageName());
		objfrontofc.clickvisbook();
	}
	@AfterClass
	public void teardown() {
		driver.close();
	}
}

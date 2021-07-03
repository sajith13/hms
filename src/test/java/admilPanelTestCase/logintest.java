package admilPanelTestCase;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.loginpage;

public class logintest extends testbase {
	   
	loginpage objlogin;
	
	
	public logintest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		objlogin=new loginpage();
	}
    @Test
    public void verifylogo() {
        Assert.assertTrue(objlogin.verifylogo());    
    }
    @Test
    public void verfytitle() {
    	String acttitlte=objlogin.verifytitle();
    	String expctitle="Smart Hospital : Hospital Management System";
        Assert.assertEquals(acttitlte, expctitle);	
    }
    @Test
    public void login() {
    	objlogin.loging(pop.getProperty("username"), pop.getProperty("password"));
    	//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    @AfterMethod
public void teardown() {
	driver.close();
}
}

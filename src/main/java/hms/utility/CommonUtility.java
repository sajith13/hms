package hms.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import hms.base.testbase;

public class CommonUtility extends testbase {
	
	//script for mouse_click
	public static void mouseClick(WebElement el) {
		Actions act=new Actions(driver);
		act.click(el).build().perform();
	}
	//script to file_upload
	public static void fileUpload(String flop) {
		StringSelection file=new StringSelection(flop);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		Robot r;
		try {
			r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Script for Screenshot on fail

	public static void takescreenshot()
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		File destination=new File(currentDir+"./Screenshot/"+System.currentTimeMillis()+".png");
		try {
			FileHandler.copy(scrFile,destination );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

}
	}
}

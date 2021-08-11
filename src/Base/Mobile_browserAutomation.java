package Base;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Mobile_browserAutomation  extends base_MobileBrower {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities("Emulator");
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		driver.findElement(By.cssSelector("a[href*='products']")).click();
		
		//Scrolling in Selenium via JavaScriptExecutor//
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		
		String Text= driver.findElement(By.cssSelector("a[href*='/angularAppdemo/products/3']")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text, "Devops");
		
	}

}

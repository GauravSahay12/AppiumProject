package Base;


import java.net.MalformedURLException;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Shopping_Cart_Sce1_negative extends base_Shopping {

	//Positive case
	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver =capabilities("Emulator");
		driver.findElementsByClassName("android.widget.Spinner").get(0).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));");
		driver.findElementByAndroidUIAutomator("text(\"Bangladesh\")").click();
		//driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Gaurav Sahay");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		
		String Toast_name=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println(Toast_name);
		Assert.assertEquals("Please enter your name",Toast_name);
		
		
	}

}

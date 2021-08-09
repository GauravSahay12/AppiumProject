package Base;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppiumTest1 extends base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver =base.capabilities("Real");
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByAndroidUIAutomator("text(\"3. Preference dependencies\")").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		//in Case of reductant classname
		driver.findElementsByClassName("android.widget.RelativeLayout").get(1).click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='android:id/edit']").sendKeys("Hello Gaurav");
		driver.findElementById("android:id/button1").click();
		//driver.findElementByAndroidUIAutomator("resource-id(\"android:id/button1\")").click();
		
		
	}

}

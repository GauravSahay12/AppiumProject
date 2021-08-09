package Base;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollingGesture extends base {
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities("Emulator");
			
			driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
			// Below we just simply uses android API code for our conviencence
			//Note Scrolling is not possible in Appium nor in Selenium 
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));");

	}
}

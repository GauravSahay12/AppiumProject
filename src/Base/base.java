package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
		
		File appdir=new File("src/Base");//Parent folder
		File app=new File(appdir,"ApiDemos-debug.apk");
		//Providing path of apk_&_apk-name//download Appium_api demos_apk
		
		DesiredCapabilities cap = new DesiredCapabilities();
		//Adding capability for real device//This will root to real device
		if(device.equals("Emulator"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"GauravEmulator");	
		}
		else if(device.equals("Real")) 
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
		}
		
	
		cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;   
	}

}

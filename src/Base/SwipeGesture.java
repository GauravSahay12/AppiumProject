package Base;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
public class SwipeGesture extends base{

	public static void main(String[] args) throws MalformedURLException {
		
	AndroidDriver<AndroidElement> driver = capabilities("Emulator");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		driver.findElementByXPath("//*[@content-desc='9']").click();
        WebElement first=	driver.findElementByXPath("//*[@content-desc='15']");
	    WebElement second=	driver.findElementByXPath("//*[@content-desc='45']");
	
		TouchAction t = new TouchAction(driver);
		//long press //on element// 2 sec// move to another element and you release
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
		
		
	}
}

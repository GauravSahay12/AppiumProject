package Base;

import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;


public class Shopping_Cart_Sce4_5_6_optimize extends base_Shopping {
	
	public static double opt(String Value) {
		
		
		String Value1=Value.substring(1);
	    	double Fin= Double.parseDouble(Value1);
	    	return Fin;
		
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
//4.	Validate the total amount displayed in the checkout page matches with sum of product amounts selected for shopping.
		AndroidDriver<AndroidElement> driver = capabilities("Emulator");
		driver.findElementsByClassName("android.widget.Spinner").get(0).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByAndroidUIAutomator("text(\"Argentina\")").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Gaurav Sahay");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
	int count=	driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
	
	double Sum=0;
	for (int i=0;i<count;i++)
	{
		String text=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
		Double Final=Shopping_Cart_Sce4_5_6_optimize.opt(text);
		Sum=Sum+Final;
	}
	
	

System.out.println("Sum value of added Product : "+Sum );
	
String Amt =	driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
String Pur_Amt=Amt.substring(1);
double Purchase_Amt1=Double.parseDouble(Pur_Amt);

System.out.println("Total Purchase Amount : "+Purchase_Amt1 );
Assert.assertEquals(Purchase_Amt1, Sum);


//5.	Validate mobile gesture working for link(long press) and navigate to WebView.

WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
WebElement ReadText = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
TouchAction t=new TouchAction(driver);
t.tap(tapOptions().withElement(element(checkbox))).perform();
t.longPress(longPressOptions().withElement(element(ReadText)).withDuration(ofSeconds(2))).release().perform();

driver.findElementById("android:id/button1").click();

driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();

		
//6.	Validate the user can do operation on Webview and can navigate back to native app if needed.
Thread.sleep(7000);
Set<String> Context=driver.getContextHandles();
for(String ContextName : Context)
{
	System.out.println(ContextName);
}

driver.context("WEBVIEW_com.androidsample.generalstore");

driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Apple");
driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
driver.pressKey(new KeyEvent(AndroidKey.BACK));
//Now if wish to continue the automation on native app , then swtich to Native
driver.context("NATIVE_APP");

	}

}

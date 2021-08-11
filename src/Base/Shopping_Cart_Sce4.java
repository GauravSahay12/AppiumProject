package Base;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Shopping_Cart_Sce4 extends base_Shopping {
	
	

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
	String P1=	driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
	String P2=	driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
	
	
//This will separate the string based on index
	String Pro1=P1.substring(1);
	System.out.println(Pro1);
	
   String Pro2=P2.substring(1);
	System.out.println(Pro2);
	
	
Double Final_P1=Double.parseDouble(Pro1);
Double Final_P2=Double.parseDouble(Pro2);


Double Sum =Final_P1+Final_P2;
System.out.println("Sum value of added Product : "+Sum );
	
String Amt =	driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
String Pur_Amt=Amt.substring(1);
Double Purchase_Amt1=Double.parseDouble(Pur_Amt);

System.out.println("Total Purchase Amount : "+Purchase_Amt1 );
Assert.assertEquals(Purchase_Amt1, Sum);
		
	}

}

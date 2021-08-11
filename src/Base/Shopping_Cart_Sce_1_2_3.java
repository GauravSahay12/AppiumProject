package Base;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Shopping_Cart_Sce_1_2_3 extends base_Shopping {

	// 1. Fill the form details and submit
	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities("Emulator");
		driver.findElementsByClassName("android.widget.Spinner").get(0).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));");
		driver.findElementByAndroidUIAutomator("text(\"Bangladesh\")").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Gaurav Sahay");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementsByClassName("android.widget.Button").get(0).click();

		// 2. Shop the item in the app by scrolling to specific Product and add to cart.

		// Here by using scroll like above it will not scroll the completely
		// So we can the scroll functionality : By calling the lists_of
		// entire_scroll(Parent List)on page then move to particular_element(Child
		// List).
		// This will make sure product will be completely displayed.

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))"));

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).size();

		for (int i = 0; i <= count; i++) {
			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			System.out.println(text);
			if (text.equalsIgnoreCase("Air Jordan 9 Retro")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				System.out.println("Added to cart");
				break;
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// 3. Validate if the item selected in the page 2 are matching with the item displayed in check out page.
		String LastPage = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals("Air Jordan 9 Retro", LastPage);

	}

}

package appiumWebCheck;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class StartChrome {
	
	@SuppressWarnings("rawtypes")
	@Test
	public void test1() throws MalformedURLException, InterruptedException {
		
		//Create object of DesiredCapabilities class and specify android platform
		DesiredCapabilities cap = DesiredCapabilities.android();
		
		//Set the capability to execute test in Chrome browser
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		cap.setCapability("platform", "ANDROID");
		
		//We need to define platform name
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");		
		
		//Set the device name as well (We can give any name here)
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MyPhone");
		
		//Set the android version as well
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
		
		//Create Object of URL class and specify the appium server address
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		//Create Object of AndroidDriver class and pass url and capability that we created
		WebDriver driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open Url in android chrome browser
		driver.get("http://www.facebook.com");
		
		System.out.println("FaceBook Title: " + driver.getTitle());
		driver.findElement(By.name("email")).sendKeys("appiumdemo@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("typePasswordHere");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}

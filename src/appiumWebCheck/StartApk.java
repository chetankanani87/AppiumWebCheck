package appiumWebCheck;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class StartApk {
	
	@SuppressWarnings("rawtypes")
	@Test
	public void test1() throws MalformedURLException, InterruptedException {
		
		//Create object of DesiredCapabilities class and specify android platform
		DesiredCapabilities cap = DesiredCapabilities.android();
		
		//Set the capability as blank to execute test in Android apk
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		
		//We need to define platform name
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		//Set the android version as well
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
				
		//Set the device name as well (We can give any name here)
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MyPhone");
		
		cap.setCapability("appPackage", "io.selendroid.testapp");
		cap.setCapability("appActivity", ".HomeScreenActivity");
		
		//Create Object of URL class and specify the appium server address
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		//Create Object of AndroidDriver class and pass url and capability that we created
		WebDriver driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"startUserRegistrationCD\"]")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("selenium3.demo");
		driver.findElement(By.id("inputEmail")).sendKeys("selenium3.demo@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("typePasswordHere");
		driver.findElement(By.id("inputName")).clear();
		driver.findElement(By.id("inputName")).sendKeys("Chetan Kanani");
		//driver.findElement(By.id("input_preferedProgrammingLanguage")).click();
		driver.findElement(By.id("input_adds")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}

}

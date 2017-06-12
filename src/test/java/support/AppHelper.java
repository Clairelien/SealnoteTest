package support; /**
 * Created by Claire on 2017/6/2.
 */
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
//import io.appium.java_client.android.Activity;

import java.net.MalformedURLException;
import java.net.URL;

public class AppHelper {
    public static AndroidDriver driver;
    //public static AppiumDriverLocalService service;

    public static void sealNoteSetup() throws MalformedURLException {
        System.out.println("strat-------");
        // start appium server
//        service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
        // set capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.6.4");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "emulator-5554");
//        capabilities.setCapability("app", System.getProperty("user.dir")+"\\apps\\Sealnote-debug.apk");
        capabilities.setCapability("appPackage", "com.twistedplane.sealnote");
        capabilities.setCapability("appActivity", "com.twistedplane.sealnote.SealnoteActivity");
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        // launch app
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//        driver.launchApp();
    }

    public static void sealNoteSetupNoRest() throws MalformedURLException {
        System.out.println("strat-------");
        // start appium server
//        service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
        // set capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.6.4");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.twistedplane.sealnote");
        capabilities.setCapability("appActivity", "com.twistedplane.sealnote.SealnoteActivity");
        // can type chinese
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        // launch app
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub")/*service.getUrl()*/, capabilities);
//        driver.launchApp();
    }

    public static void loginToSealnote() {
        driver.findElement(By.id("password_meter_input")).sendKeys("123456");
        driver.findElement(By.id("password_action_button")).click();
    }

    public static void closeSealnote() {
        driver.quit();
//        service.stop();
        System.out.println("end-------");
    }
}

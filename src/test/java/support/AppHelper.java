/**
 * Created by Claire on 2017/6/2.
 */

package support;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppHelper {

    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    public static void sealNoteSetup() throws MalformedURLException {
        System.out.println("strat-------");
        // start appium server

        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        // set capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("appium-version", "1.6.4");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("deviceName", "emulator-5554"); // emulator-5554
        capabilities.setCapability("app", System.getProperty("user.dir")+"\\apps\\Sealnote-debug.apk");
        capabilities.setCapability("appPackage", "com.twistedplane.sealnote");
        capabilities.setCapability("appActivity", "com.twistedplane.sealnote.SealnoteActivity");
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        // launch app
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//        driver.launchApp();
    }


    public static void loginToSealnote() {
        driver.findElement(By.id("password_meter_input")).sendKeys("123456");
        driver.findElement(By.id("password_action_button")).click();
    }

    public static void closeSealnote() {
        driver.quit();
        service.stop();
        System.out.println("end-------");
    }

    public static void addBeforeDelete() {
        AppHelper.driver.findElement(By.id("action_new_note")).click();
        AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();
        AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement tags = AppHelper.driver.findElement(By.id("note_activity_tags")) ;
        tags.sendKeys("yoyo ");
        AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys("test");
        AppHelper.driver.findElement(By.id("note_activity_note")).sendKeys("hello world");
        AppHelper.driver.findElement(By.id("action_save_note")).click();
    }
}

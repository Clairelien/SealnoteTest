/**
 * Created by Claire on 2017/6/2.
 */
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
//import io.appium.java_client.android.Activity;

import java.net.MalformedURLException;
import java.net.URL;


public class AppSetup {
    public static AndroidDriver driver;
    private static AppiumDriverLocalService service;

    public static void prepareSealNoteForAppium() throws MalformedURLException {

        // start appium server
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        // set capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.6.4");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "C:/Users/Claire/Desktop/AppiumDemo/apps/Sealnote-debug.apk");
        capabilities.setCapability("appPackage", "com.twistedplane.sealnote");
        capabilities.setCapability("appActivity", "com.twistedplane.sealnote.SealnoteActivity");
        // launch app
        driver = new AndroidDriver(/*new URL("http://0.0.0.0:4723/wd/hub")*/service.getUrl(), capabilities);
        driver.launchApp();
        //driver.startActivity("appPackage", "com.twistedplane.sealnote", null, null);
    }
}

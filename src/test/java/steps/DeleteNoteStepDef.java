package steps;

import cucumber.api.java8.En;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.
import org.openqa.selenium.WebElement;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

/**
 * Created by Claire on 2017/6/12.
 */
public class DeleteNoteStepDef implements En {
    TouchAction action = new TouchAction(AppHelper.driver);
    public DeleteNoteStepDef() {
        Given("^user select the latest text note$", () -> {
//            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            WebElement btn = AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']"));
//            AppHelper.driver.findElementById("card_main_layout").click();
            action.longPress( AppHelper.driver.findElementById("card_main_layout") ).release().perform() ;
//            action.tap(btn.getLocation().getX(),btn.getLocation().getY()).perform() ;
//            WebElement btn = AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']"));
//            System.out.println(btn.getLocation().toString());
//            AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']")).click();
//            AppHelper.driver.findElement(By.id("action_new_note")).click();
//            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();
//            System.out.println(AppHelper.driver.findElementById("card_main_layout").toString());
//
//            AppHelper.driver.findElementById("card_main_layout").click();
//            AppHelper.driver.findElement(By.className("android.widget.ImageButton")).click();
////            try {
////                Thread.sleep(1000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']")).click();
//            System.out.println(AppHelper.driver.findElement(By.xpath("/android.widget.FrameLayout")).toString()+"******");
//            System.out.println(AppHelper.driver.findElement(By.xpath("/android.widget.FrameLayout/android.view.ViewGroup[contains(@resource-id,'decor_content_parent')]")).toString()+"******");
//            System.out.println(AppHelper.driver.findElement(By.xpath("/android.widget.FrameLayout/android.view.ViewGroup[contains(@resource-id,'decor_content_parent')]/android.widget.FrameLayout[@index='1']")).toString()+"******");
//            System.out.println(AppHelper.driver.findElement(By.xpath("//android.view.ViewGroup[contains(@resource-id,'action_bar')]")).toString()+"******");
        });
        When("^user delete this note$", () -> {

            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElementById("action_delete").click();
//            WebElement delBtn = AppHelper.driver.findElementByClassName("android.widget.ImageButton") ;
//            action.longPress()
//            AppHelper.driver.findElementByClassName("android.widget.ImageButton");//.findElementByXPath("//android.widget.FrameLayout[@resource-id='action_bar_container']/android.view.ViewGroup/android.widget.LinearLayout[@index='1']/android.widget.ImageButton");//.findElementByAndroidUIAutomator("new UiSelecor().description(\"More options\")").click();
            System.out.println("when");
        });
        Then("^user can see the text note in the trash section$", () -> {
            System.out.println("then");

        });
    }
}

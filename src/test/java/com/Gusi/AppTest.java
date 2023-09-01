package com.Gusi;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest extends ReportProvider {

    WebDriver mWebDriver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        System.out.println(mHostAddress);
        System.out.println(mGetReportAddress);
        System.out.println(mDeleteReportAddress);
        System.out.println(HTML_REPORT_DIR);
        DesiredCapabilities mCapabilities=new DesiredCapabilities();
        mCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        mCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME , "Android");
        mCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION , "9");
        mCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME , "Android Emulator");
        mCapabilities.setCapability(MobileCapabilityType.APP ,
                System.getProperty("user.dir")+"/apps/gusi_android.apk");
        this.mWebDriver=new AndroidDriver(new URL(mHostAddress),mCapabilities);

        System.out.println("<<<<<<<<<<<<<<<<<<< New Test Session setup for Android >>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }


    @AfterTest
    public void closeSession() throws Exception{
        if(mWebDriver!=null){
            mWebDriver.quit();
        }
    }


}

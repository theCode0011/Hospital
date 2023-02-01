package common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static common.Config.PLATFORM_AND_BROSWER;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {
    protected static WebDriver driver = null;

    @BeforeMethod
    public WebDriver getDriver(){

        switch (PLATFORM_AND_BROSWER){
            case "macOS_chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/adriankostya/browsersDrivers/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Platform or browser is incorrect"+PLATFORM_AND_BROSWER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}

package ui.pages;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static constants.Constant.Url.BASE_URL;

public abstract class AbstractPage extends CommonActions {

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.get(BASE_URL);
    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }



}

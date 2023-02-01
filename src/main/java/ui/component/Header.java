package ui.component;

import ui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {
    @FindBy(xpath = "//span[@jhitranslate='global.menu.home']")
    private WebElement homeIcon;

    @FindBy(xpath = "//span[@jhitranslate='global.menu.entities.main']")
    private WebElement entitiesBtn;

    @FindBy(xpath = "//span[@jhitranslate='global.menu.account.main']")
    private WebElement accountIcon;

    @FindBy(xpath = "//span[@jhitranslate='global.menu.account.login']")
    private WebElement signInBtn;

    @FindBy(xpath = "//span[@jhitranslate='global.menu.account.register']")
    private WebElement registerBtn;

    @FindBy(xpath = "//span[@jhitranslate='global.menu.account.logout']")
    private WebElement signOutBtn;


    public Header(WebDriver driver) {
        super(driver);
    }

    public LoginForm getAccountIcon(){
        accountIcon.click();
        signInBtn.click();
        return new LoginForm(driver);
    }

    public boolean isLogoutBtnPresent(){
        accountIcon.click();
        return signOutBtn.isDisplayed();
    }

    public EntitiesList getEntitiesBtn(){
        entitiesBtn.click();
        return new  EntitiesList(driver);
    }













}

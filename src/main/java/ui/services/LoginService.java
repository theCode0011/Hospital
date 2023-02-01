package ui.services;

import ui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import ui.component.LoginForm;
import ui.pages.HomePage;

public class LoginService extends AbstractPage {

    public LoginService(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String user, String password){
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        softAssert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        LoginForm loginForm = homePage.getHeader().getAccountIcon();
        softAssert.assertTrue(loginForm.isLoginFormOpened(), "Login form is not opened");
        loginForm.login(user, password);
        softAssert.assertTrue(homePage.isUserSuccessLogin(), "User is logged incorrect");
        softAssert.assertTrue(homePage.getHeader().isLogoutBtnPresent(), "Log out btn is not present");
        softAssert.assertAll();
        return homePage;
    }
}

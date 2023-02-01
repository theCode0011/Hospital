package ui.component;

import ui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.HomePage;
import ui.services.UserService;

public class LoginForm extends AbstractPage {
    UserService userService = new UserService();
    User user = userService.setUserData();

    @FindBy(className = "modal-content")
    private WebElement loginForm;

   @FindBy(id="username")
   private WebElement usernameField;

   @FindBy(id = "password")
   private WebElement passwordField;

   @FindBy(xpath = "//button[@jhitranslate='login.form.button']")
   private WebElement signInBtn;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String user, String password){
        usernameField.click();
        usernameField.sendKeys(user);
        passwordField.sendKeys(password);
        signInBtn.click();
        return new HomePage(driver);
    }

    public HomePage wrongLogin(){
        usernameField.sendKeys(user.getName());
        usernameField.sendKeys("123455");
        signInBtn.click();
        return new HomePage(driver);
    }

    public String getUserName(){
        return user.getName();
    }

    public boolean isLoginFormOpened(){
        return loginForm.isDisplayed();
    }




}

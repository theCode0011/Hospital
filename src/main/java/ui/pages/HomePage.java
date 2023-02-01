package ui.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.component.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.component.User;
import ui.services.UserService;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @FindBy(className = "display-4")
    public WebElement welcomeTxt;

    @FindBy(xpath = "//jhi-navbar")
    public Header header;

    @FindBy(id = "home-logged-message")
    public WebElement succesLogedTxt;

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
    }

    public boolean isPageOpened(){
        return welcomeTxt.getText().equals("Welcome, dear Tester!");
    }

    public Header getHeader(){
        return header;
    }

    public boolean isUserSuccessLogin(){
        UserService userService = new UserService();
        User user = userService.setUserData();
        String s = succesLogedTxt.getText();
        return s.equals("You are logged in as user "+'"'+user.getName()+'"'+".");
    }
}

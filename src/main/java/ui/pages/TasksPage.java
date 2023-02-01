package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class TasksPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(TasksPage.class);

    @FindBy(xpath = "//tbody/tr/td[2]")
    private List<WebElement>  titles;

    @FindBy(xpath = "//tbody/tr/td[3]")
    private  List<WebElement> descriptions;

    @FindBy(xpath = "//h2[@id='page-heading']/span[contains(text(), 'Tasks')]")
    private WebElement title;


    public TasksPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return title.isDisplayed();
    }

    public List<String> getTitles(){
        List<String> titleList = new LinkedList<>();
        for (WebElement el:titles){
            titleList.add(el.getText());
        }
        return titleList;
    }

    public List<String> getDescription(){
        List<String> descList = new LinkedList<>();
        for (WebElement el:descriptions){
            descList.add(el.getText());
        }
        return descList;
    }

    public boolean isEachTitleHaveTask(){
        boolean result = false;
        if(!getDescription().isEmpty()&&!getTitles().isEmpty()){
            result = true;
            for (int i =0; i<getTitles().size();i++){
             if(getDescription().get(i).isEmpty()){
                 System.out.println("for this title "+getTitles().get(i)+" is not assigned description");
                 result = false;
             }
            }
        }
        return result;
    }

}

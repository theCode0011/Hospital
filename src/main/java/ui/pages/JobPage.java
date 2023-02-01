package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class JobPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(JobPage.class);

    @FindBy(xpath = "//div[@class='table-responsive']//tbody//tr/td[2]")
    private List<WebElement> jobTitles;

    @FindBy(xpath = "//div[@class='table-responsive']//tbody//tr/td[5]")
    private List<WebElement> employeeList;

    @FindBy(xpath = "//h2[@id='page-heading']/span[contains(text(), 'Jobs')]")
    private WebElement title;

    public JobPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return title.isDisplayed();
    }

    public List<String> getJobTitles(){
        List<String> jobTitleList = new LinkedList<>();
        for (WebElement el:jobTitles){
            jobTitleList.add(el.getText());
        }
        return jobTitleList;
    }

    public List<String> getEmployees(){
        int i =0;
        List<String> employeeListStr = new LinkedList<>();
            for (WebElement el : employeeList) {
                if(el.getText().length()==0){
                   // LOGGER.warn("No emp for index :"+i);
                }else {
                    employeeListStr.add(el.getText());
                }
                i++;
            }
        return employeeListStr;
    }

    public boolean isEmployeeHaveJob(List<String>employeesCompleteName) {
        int j =0;
        boolean isContain = false;
        if (!getEmployees().isEmpty()) {
            isContain = true;
            for (int i = 0; i < jobTitles.size(); i++) {
                String emplCompleteName = employeeList.get(i).getText();
                if (!employeesCompleteName.contains(emplCompleteName)){
                    LOGGER.warn("No such employee in DB for this position : "+getJobTitles().get(i));
                    isContain = false;
                }
            }
        }else LOGGER.warn("Employee list is empty");
        return isContain;

    }
}

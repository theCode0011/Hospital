package ui.component;

import ui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.EmployersListPage;
import ui.pages.JobPage;
import ui.pages.MedicinesPage;
import ui.pages.TasksPage;

public class EntitiesList extends AbstractPage {
    @FindBy(xpath = "//ul[@aria-labelledby='entity-menu']//span[contains(text(), 'Employee')]")
    private WebElement employerListPage;

    @FindBy(xpath = "//ul[@aria-labelledby='entity-menu']//span[contains(text(), 'Job')]")
    private WebElement jobPage;

    @FindBy(xpath = "//ul[@aria-labelledby='entity-menu']//span[contains(text(), 'Task')]")
    private WebElement task;

    @FindBy(xpath = "//ul[@aria-labelledby='entity-menu']//span[contains(text(), 'Medicine')]")
    private WebElement medicine;

    public EntitiesList(WebDriver driver) {
        super(driver);
    }

    public EmployersListPage getEmployersListPage(){
        employerListPage.click();
        return new EmployersListPage(driver);
    }
    public JobPage getJobPage(){
        jobPage.click();
        return new JobPage(driver);
    }

    public TasksPage getTaskPage(){
        task.click();
        return new TasksPage(driver);
    }

    public MedicinesPage getMedicinePage(){
        medicine.click();
        return new MedicinesPage(driver);
    }

}

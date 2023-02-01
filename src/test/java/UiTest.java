import common.CommonActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.component.User;
import ui.pages.*;
import ui.services.LoginService;
import ui.services.UserService;

import java.util.List;

public class UiTest  extends CommonActions {

    @Test
    public  void successLoginAsUser(){
        UserService userService = new UserService();
        User user = userService.setUserData();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getHeader().getAccountIcon().login(user.getName(), user.getPassword());
        Assert.assertTrue(homePage.isUserSuccessLogin(), "User is not logged correct");
        Assert.assertTrue(homePage.getHeader().isLogoutBtnPresent(), "Log out btn is not present");
    }

    @Test
    public void employersCorrectlyTrackedCheck(){
        UserService userService = new UserService();
        User user = userService.setUserData();
        LoginService loginService = new LoginService(driver);
        HomePage homePage= loginService.login(user.getName(), user.getPassword());
        EmployersListPage empListPage= homePage.getHeader().getEntitiesBtn().getEmployersListPage();
        Assert.assertTrue(empListPage.isPageOpened(),"Employers list Page is not opened");
        empListPage.isEmployersCorrectlyTracked();
    }

    @Test
    public void isEachEmployerHaveTrackedJob(){
        UserService userService = new UserService();
        User user = userService.setUserData();
        LoginService loginService = new LoginService(driver);
        HomePage homePage = loginService.login(user.getName(), user.getPassword());
        EmployersListPage empListPage= homePage.getHeader().getEntitiesBtn().getEmployersListPage();
        Assert.assertTrue(empListPage.isPageOpened(), "Employers list Page is not opened");
        List<String> nameAndSurname = empListPage
                .getCompleteName(empListPage.getNames(), empListPage.getSurnames());
        JobPage jobPage =homePage.getHeader().getEntitiesBtn().getJobPage();
        Assert.assertTrue(jobPage.isPageOpened(), "Job Page is not opened");
        Assert.assertTrue(jobPage.isEmployeeHaveJob(nameAndSurname), "Not all employee have tracked job ");
    }

    @Test
    public void isEachTitleHaveTask() {
        UserService userService = new UserService();
        User user = userService.setUserData();
        LoginService loginService = new LoginService(driver);
        HomePage homePage = loginService.login(user.getName(), user.getPassword());
        TasksPage tasksPage = homePage.getHeader().getEntitiesBtn().getTaskPage();
        Assert.assertTrue(tasksPage.isPageOpened(), "Task page is not opened");
        Assert.assertTrue(tasksPage.isEachTitleHaveTask(), "Not each title have task");
    }

    @Test
    public void isMedicineRightTracked() {
        UserService userService = new UserService();
        User user = userService.setUserData();
        LoginService loginService = new LoginService(driver);
        HomePage homePage = loginService.login(user.getName(), user.getPassword());
        MedicinesPage medPage = homePage.getHeader().getEntitiesBtn().getMedicinePage();
        Assert.assertTrue(medPage.isPageOpened());
        Assert.assertTrue(medPage.isMedicinePresentInDB(medPage.getMedicines(), medPage.getMedDescription()));
    }
}

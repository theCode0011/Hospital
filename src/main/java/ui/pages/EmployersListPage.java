package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;
import ui.services.ValidationService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmployersListPage extends AbstractPage{
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployersListPage.class);


    @FindBy(xpath = "//h2[@id='page-heading']/span[contains(text(), 'Employees')]")
    private WebElement title;

    @FindBy(xpath = "//table[@class='table table-striped']//tr/td[2]")
    private List<WebElement> names;

    @FindBy(xpath = "//table[@class='table table-striped']//tr/td[3]")
    private List<WebElement> surnames;

    @FindBy(xpath = "//table[@class='table table-striped']//tr/td[4]")
    private List<WebElement> emails;

    @FindBy(xpath = "//table[@class='table table-striped']//tr/td[5]")
    private List<WebElement> phones;

    @FindBy(xpath = "//table[@class='table table-striped']//tr/td[7]")
    private List<WebElement> salaries;

    @FindBy(xpath = "//table[@class='table table-striped']//tr/td[8]")
    private List<WebElement> commissions;

    @FindBy(xpath = "//table[@class='table table-striped']//tr/td[9]")
    private List<WebElement> departments;

    @FindBy(xpath = "//table[@class='table table-striped']//tr/td[10]")
    private List<WebElement> managers;

    public EmployersListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return title.getText().equals("Employees");
    }

    public List<String> getNames(){
        List<String> namesList = new ArrayList<>();
        for (WebElement el:names){
            namesList.add(el.getText());
        }
        return namesList;
    }

    public List<String> getSurnames(){
        List<String> surnameList = new LinkedList<>();
        for (WebElement el:surnames){
            surnameList.add(el.getText());
        }
        return surnameList;
    }

    public List<String> getCompleteName(List<String>nm, List<String>snm){
        List<String> completeName = new LinkedList<>();
        for (int i =0;i<nm.size();i++){
            completeName.add(nm.get(i)+" "+snm.get(i));
        }
        return completeName;
    }

    public List<String> getEmails(){
        List<String> emailList = new LinkedList<>();
        for (WebElement el:emails){
            emailList.add(el.getText());
        }
        return emailList;
    }

    public List<String>getPhones(){
        List<String> phonesList = new LinkedList<>();
        for (WebElement el:phones){
            phonesList.add(el.getText());
        }
        return phonesList;
    }

    public List<String> getSalary(){
        List<String> salariesList = new LinkedList<>();
        for (WebElement el:salaries){
            salariesList.add(el.getText());
        }
        return salariesList;
    }

    public List<String>getCommission(){
        List<String> commissionsList = new LinkedList<>();
        for (WebElement el:commissions){
            commissionsList.add(el.getText());
        }
        return commissionsList;
    }

    public List<String>getDeppartments(){
        List<String> departmentsList = new LinkedList<>();
        for (WebElement el:departments){
            departmentsList.add(el.getText());
        }
        return departmentsList;
    }

    public List<String>getManager(){
        List<String> managerList = new LinkedList<>();
        for (WebElement el:managers){
            managerList.add(el.getText());
        }
        return managerList;
    }

    public EmployersListPage isEmployersCorrectlyTracked(){
        SoftAssert softAssert = new SoftAssert();
        ValidationService valS = new ValidationService();
        softAssert.assertTrue(valS.isAlphabetValid(getNames()), "Name is not valid");
        softAssert.assertTrue(valS.isAlphabetValid(getSurnames()), "Surname is not Valid");
        softAssert.assertTrue(valS.isEmailValid(getEmails()), "Email is not valid");
        softAssert.assertTrue(valS.isPhoneValid(getPhones()), "Phone is not valid");
        softAssert.assertTrue(valS.isSalaryValid(getSalary()), "Salary is not valid");
        softAssert.assertTrue(valS.isSalaryValid(getCommission()), "Commission is not valid");
        softAssert.assertTrue(valS.isAlphabetValid(getDeppartments()), "Departments is not valid");
        softAssert.assertAll();
        return new EmployersListPage(driver);
    }




}

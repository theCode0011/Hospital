package ui.pages;

import enums.MedicineList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class MedicinesPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicinesPage.class);

    @FindBy(xpath="//tbody/tr/td[2]")
    private List<WebElement> medicines;

    @FindBy(xpath="//tbody/tr/td[3]")
    private List<WebElement> description;

    @FindBy(xpath = "//h2[@id='page-heading']/span[contains(text(), 'Medicines')]")
    private WebElement title;

    public MedicinesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return title.isDisplayed();
    }

    public List<String> getMedicines(){
        List<String> medicinesStr = new LinkedList<>();
        for (WebElement el:medicines){
            medicinesStr.add(el.getText());

            }
        return medicinesStr;
    }

    public List<String> getMedDescription(){
        List<String> descriptionList = new LinkedList<>();
        for (WebElement el:description){
            descriptionList.add(el.getText());
        }
        return descriptionList;
    }

    public  boolean isMedicinePresentInDB(List<String> med, List<String>descr) {
        boolean result = false;
        if(!med.isEmpty()||!descr.isEmpty()) {
            result=true;
            for (int i = 0; i < med.size(); i++) {
                String medEl = med.get(i).toUpperCase(Locale.ROOT);
                String descEl = descr.get(i);
                try {
                    Enum medEnum = MedicineList.valueOf(medEl);
                    String enumDesc = MedicineList.valueOf(medEl).getValue();
                    if (!enumDesc.equals(descEl)) {
                        Assert.fail(medEnum + " Description not correspond to this medicine");
                        result = false;
                    }
                } catch (IllegalArgumentException e) {
                    Assert.fail(medEl+ " This medicine is not present in DB");
                }
            }
        }LOGGER.warn("Medicines list or description list is EMPTY");
        return result;
    }
}

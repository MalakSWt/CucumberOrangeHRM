package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

public class PimPage {
    WebDriver driver;
    WaitUtils wait;

    public PimPage(WebDriver driver){
        this.driver=driver;
        wait = new WaitUtils(driver);
    }

    private By deleteBtn = By.xpath("//button[.//i[contains(@class,'bi-trash')]]");
    private By confirmDeleteBtn = By.xpath("//button[normalize-space()='Yes, Delete']");
    private By successToast = By.xpath("//div[contains(@class,'oxd-toast')]");

    public void clickDeleteForEmployee(){


        wait.waitForClickability(deleteBtn).click();
    }
    public void confirmDelete(){
        wait.waitForClickability(confirmDeleteBtn).click();
    }
    public boolean isDeleteSuccessMessageDisplayed(){
        return wait.waitForVisibility(successToast).isDisplayed();
    }
}

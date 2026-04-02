package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class EditEmployeePage {

    WebDriver driver;
    WaitUtils wait;

    public EditEmployeePage(WebDriver driver){
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    By saveBtn = By.xpath("//button[@type='submit']");
    By headerName = By.xpath("//div[@class='orangehrm-edit-employee-name']//h6");


    By loader = By.className("oxd-form-loader");

    public void updateLastName(String lastName) throws InterruptedException {


        WebElement element1 = wait.waitForVisibility(headerName);
        wait.waitForInvisibility(loader);
        WebElement element = driver.findElement(lastNameInput);


        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);


        element.sendKeys(lastName);


        wait.waitForClickability(saveBtn).click();


        wait.waitForInvisibility(loader);
        wait.waitForInvisibility(loader);

        driver.navigate().refresh();


        wait.waitForVisibility(headerName);
        wait.waitForTextToBePresent(headerName, lastName);
    }

    public String getEmployeeName(){
        WebElement element = wait.waitForVisibility(headerName);
        wait.waitForTextToBePresent(headerName, element.getText());

        return element.getText().trim();
    }
}
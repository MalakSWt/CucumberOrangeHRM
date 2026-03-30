package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage {

    WebDriver driver;

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    By firstNameInput = By.name("firstName");
    By lastNameInput = By.name("lastName");
    By empIDInput = By.name("employeeId");
    By saveBtn = By.xpath("//button[@type='submit']");


    By firstNameError = By.xpath("//span[text()='Required']");
    By lastNameError = By.xpath("//span[text()='Required']");
    By duplicateIDError = By.xpath("//span[contains(text(),'Already exists')]");

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterEmployeeID(String empId) {
        driver.findElement(empIDInput).clear();
        driver.findElement(empIDInput).sendKeys(empId);
    }

    public void clickSave() {
        driver.findElement(saveBtn).click();
    }

    public String getEmployeeNameHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By nameLocator = By.xpath("//div[@class='orangehrm-edit-employee-name']//h6");


        wait.until(driver -> {
            String text = driver.findElement(nameLocator).getText();
            return text != null && !text.trim().isEmpty();
        });

        return driver.findElement(nameLocator).getText().trim();
    }

    public boolean isFirstNameErrorDisplayed() {
        return driver.findElement(firstNameError).isDisplayed();
    }

    public boolean isLastNameErrorDisplayed() {
        return driver.findElement(lastNameError).isDisplayed();
    }

    public boolean isDuplicateIDErrorDisplayed() {
        return driver.findElement(duplicateIDError).isDisplayed();
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchEmployeePage {
    WebDriver driver;

    public SearchEmployeePage(WebDriver driver){
        this.driver=driver;
    }
    private By pimTab = By.xpath("//span[text()='PIM']");
    private By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By resultName = By.xpath("//div[@class='oxd-table-card']//div[3]");

    public void navigateToPIM() {
        driver.findElement(pimTab).click();
    }

    public void searchEmployee(String name) {
        driver.findElement(employeeNameField).sendKeys(name);
        driver.findElement(searchButton).click();
    }

    public String getSearchResultName() {
        return driver.findElement(resultName).getText();
    }
}

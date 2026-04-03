package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SearchEmployeePage;
import utils.DriverFactory;

import java.time.Duration;

import static org.testng.Assert.*;

public class SearchEmployeeSteps {
WebDriver driver = DriverFactory.getDriver();
LoginPage loginPage = new LoginPage(driver);
SearchEmployeePage searchEmployeePage = new SearchEmployeePage(driver);
DashboardPage dashboardPage = new DashboardPage(driver);



    @Given("user navigates to PIM page")
    public void navigateToPIM(){
        searchEmployeePage.navigateToPIM();
    }
    @When("user searches for employee {string}")
    public void searchEmployee(String name) {
        searchEmployeePage.searchEmployee(name);

    }
    @When("user searches for employee ID {string}")
    public void user_searches_for_employee_id(String id) {
        searchEmployeePage.searchEmployeeID(id);
    }

    @Then("employee {string} should appear in search results")
    public void validateEmployee(String expectedName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".oxd-loading-spinner")
        ));
        String actualName = searchEmployeePage.getSearchResultName();
        System.out.println("This is the actual name" + actualName);
        assertTrue(actualName.contains(expectedName));
    }
}

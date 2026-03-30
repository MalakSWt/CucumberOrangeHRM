package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DriverFactory;

import static org.testng.Assert.*;

public class AddEmployeeSteps {

    WebDriver driver = DriverFactory.getDriver();
    DashboardPage dashboardPage = new DashboardPage(driver);
    AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Given("user has logged in with {string} and {string}")
    public void user_has_logged_in(String username, String password) {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.login(username, password);
        assertTrue(dashboardPage.isDashboardDisplayed(), "Login failed");
    }

    @Given("user is on {string} page")
    public void user_is_on_page(String pageName) {
        dashboardPage.navigateTo(pageName);
    }

    @When("user enters first name {string} and last name {string}")
    public void user_enters_first_last_name(String firstName, String lastName) {
        addEmployeePage.enterFirstName(firstName);
        addEmployeePage.enterLastName(lastName);
    }

    @When("user enters last name {string} only")
    public void user_enters_last_name_only(String lastName) {
        addEmployeePage.enterLastName(lastName);
    }

    @When("user enters first name {string} only")
    public void user_enters_first_name_only(String firstName) {
        addEmployeePage.enterFirstName(firstName);
    }

    @When("user enters first name {string}, last name {string}, and employee ID {string}")
    public void user_enters_employee_id(String firstName, String lastName, String empId) {
        addEmployeePage.enterFirstName(firstName);
        addEmployeePage.enterLastName(lastName);
        addEmployeePage.enterEmployeeID(empId);
    }

    @When("user clicks save")
    public void user_clicks_save() {
        addEmployeePage.clickSave();
    }

    @Then("employee {string} should be listed in the employee table")
    public void employee_should_be_listed(String fullName) {
        assertEquals(addEmployeePage.getEmployeeNameHeader(),fullName, fullName + " not found in employee list");
    }

    @Then("error message should be displayed for first name")
    public void error_message_first_name() {
        assertTrue(addEmployeePage.isFirstNameErrorDisplayed(), "First name error not displayed");
    }

    @Then("error message should be displayed for last name")
    public void error_message_last_name() {
        assertTrue(addEmployeePage.isLastNameErrorDisplayed(), "Last name error not displayed");
    }

    @Then("error message should be displayed for duplicate ID")
    public void error_message_duplicate_id() {
        assertTrue(addEmployeePage.isDuplicateIDErrorDisplayed(), "Duplicate ID error not displayed");
    }

}
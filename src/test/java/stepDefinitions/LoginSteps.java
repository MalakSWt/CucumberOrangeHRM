package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DriverFactory;

import static org.testng.Assert.*;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Given("user is on login page")
    public void user_is_in_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String username , String password) {
        loginPage.login(username,password);
    }

    @Then("user should be navigated to dashboard")
    public void user_should_be_navigated_to_dashboard() {
        assertTrue(dashboardPage.isDashboardDisplayed(),"Login failed");
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed(){
        assertTrue(loginPage.isErrorMessgeDisplayed());
    }
    @Then("required error message should be displayed")
    public void error_required_message_should_be_displayed(){
        assertTrue(loginPage.isRequiredErrorDisplayed());
    }
    @When("user clicks login without entering credentials")
    public void user_clicks_login_without_entering_credentials(){
        loginPage.clickloginBtn();
    }
    @When("user enters username only")
    public void user_enters_username_only(){
        loginPage.enterusername("Admin");
        loginPage.clickloginBtn();
    }
    @When("user enters password only")
    public void user_enters_password_only(){
        loginPage.enterpassword("admin123");
        loginPage.clickloginBtn();
    }
}
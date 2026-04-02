package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EditEmployeePage;
import utils.DriverFactory;

import static org.testng.Assert.*;

public class EditEmployeeSteps {


    WebDriver driver = DriverFactory.getDriver();
    EditEmployeePage editPage = new EditEmployeePage(driver);

    @When("user updates last name to {string} and click save")
    public void updateLastname(String lastName) throws InterruptedException {
        editPage.updateLastName(lastName);
    }

    @Then("employee name should be {string}")
    public void validateUpdatedName(String expected) {

        String actual = editPage.getEmployeeName();
        assertTrue(actual.contains(expected));
    }
}
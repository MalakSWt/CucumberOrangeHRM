package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.PimPage;
import utils.DriverFactory;

import static org.testng.Assert.*;

public class DeleteEmployeeSteps {
    WebDriver driver = DriverFactory.getDriver();
    PimPage pimPage = new PimPage(driver);

    @When("user deletes the employee")
    public void user_deletes_the_employee() {
        pimPage.clickDeleteForEmployee();
        pimPage.confirmDelete();
    }
    @Then("employee should be deleted successfully")
    public void employee_should_be_deleted_successfully() {
        assertTrue(pimPage.isDeleteSuccessMessageDisplayed());
        System.out.println("the user is deleted successfully");
    }
}

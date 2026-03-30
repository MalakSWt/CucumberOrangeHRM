package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }

    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    By pimMenu = By.xpath("//span[text()='PIM']");
    By addEmployeeMenu = By.xpath("//a[text()='Add Employee']");

    public boolean isDashboardDisplayed() {
        return driver.findElement(dashboardHeader).isDisplayed();
    }
    public void navigateTo(String pageName) {
        switch (pageName.toLowerCase()) {
            case "add employee":
                driver.findElement(pimMenu).click(); // Open PIM menu first
                driver.findElement(addEmployeeMenu).click();
                break;


            default:
                System.out.println("Page not found: " + pageName);
        }
    }
}

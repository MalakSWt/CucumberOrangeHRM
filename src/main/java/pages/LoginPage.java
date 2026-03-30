package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By errormsg = By.xpath("//p[contains(@class,'alert-content-text')]");
    private By requirederror = By.xpath("//span[text()='Required']");

    public void enterusername(String user){
        driver.findElement(username).sendKeys(user);
    }
    public void enterpassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickloginBtn(){
        driver.findElement(loginBtn).click();
    }
    public void login(String user , String pass){
        enterusername(user);
        enterpassword(pass);
        clickloginBtn();
    }

    public boolean isErrorMessgeDisplayed(){
        return driver.findElement(errormsg).isDisplayed();
    }
    public boolean isRequiredErrorDisplayed() {
        return driver.findElement(requirederror).isDisplayed();
    }



}

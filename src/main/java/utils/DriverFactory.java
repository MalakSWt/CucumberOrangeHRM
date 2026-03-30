package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void initDriver(){
        if(driver == null){

            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}

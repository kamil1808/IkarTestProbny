package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverAndWaits {
    static WebDriver driver;
    protected static WebDriverWait driverWait;



    public static void setDefaultImplicitlyWaits() {
        setImplicitlyWaits(20_000);
    }

    public static void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kamil\\IdeaProjects\\CHROME_DRIVER_JEST_TU\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        setDefaultImplicitlyWaits();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public static void setImplicitlyWaits(int milliseconds) {
        driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
    }

    public static void waitForElementClickable(By locator) {
        driverWait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(30))
                .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
    }
    public static void waitForLoader() {
        WebElement Loader = driver.findElement(By.id("mLoader"));
        driverWait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(30))
                .until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(Loader)));
    }
}
//By.xpath("//*[@id=\"mLoader\"]")
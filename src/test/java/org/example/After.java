package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class After extends WebElements {

    public void logOut() {
        driver.findElement(By.xpath("//*[@id=\"m_header_topbar\"]/div/ul/button")).click();
        waitForPageFullyLoaded();
        waitForPageToBe(WebSiteURL);
        Assert.isTrue(driver.getCurrentUrl().equals(WebSiteURL), "NIE POWROCONO NA POCZATKOWA STRONE");
        System.out.println("POPRAWNIE WYLOGOWANO");
    }
    public static boolean isDriverClosed() {
        try {
            driver.getCurrentUrl();
            return false;
        } catch (Exception Ex) {
            return true;
        }
    }
    public void closeAndQuit() {
        driver.close();
        driver.quit();
        Assert.isTrue(isDriverClosed(), "Driver is not closed and quit properly.");
        System.out.println("ZAKONCZONO SESJE I ZAMKNIETO PRZEGLADARKE");
    }

}

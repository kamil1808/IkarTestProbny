package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;


public class After extends WebElements {

    public void logOut() {
        driver.findElement(By.xpath("//*[@id=\"m_header_topbar\"]/div/ul/button")).click();
        waitForPageFullyLoaded();
        waitForElementToBeDisplayed("m_login");
        waitForPageToBe(WebSiteURL);
        Assert.isTrue(driver.getCurrentUrl().equals(WebSiteURL), "NIE POWROCONO NA POCZATKOWA STRONE");
        System.out.println("POPRAWNIE WYLOGOWANO");
    }
    public boolean isDriverClosed() {
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
        Assert.isTrue(isDriverClosed(), "DRIVER NIE ZOSTAL POPRAWNIE WYLACZONY I ZAMKNIETY");
        System.out.println("ZAKONCZONO SESJE I ZAMKNIETO PRZEGLADARKE");
    }

}

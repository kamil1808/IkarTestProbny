package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class After extends WebElements {

    public void logOut() {
        driver.findElement(By.xpath("//*[@id=\"m_header_topbar\"]/div/ul/button")).click();
        waitForPageFullyLoaded();

        String currenturl = driver.getCurrentUrl();
        System.out.println(currenturl);
        //Assert.isTrue(currenturl.equals(WebSiteURL), "NIE POWROCONO NA POCZATKOWA STRONE");
    }
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }

}

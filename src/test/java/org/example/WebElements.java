package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.DriverAndWaits.driver;

public class WebElements  {
    protected String WebSiteURL = "https://uatikar.blachotrapez.eu/";
    protected String email = "t.kowalski@blachotrapez.com.pl";
    protected String password = "QAZxswKS1@";
    DriverAndWaits driverAndWaits = new DriverAndWaits();
    Before before = new Before();
    TestMethods testMethods = new TestMethods();
    After after = new After();
    protected String CustomerTabId = "bdvCustomerBreadcrumb";
    protected String DeliveryTabId = "bdvDeliveryBreadcrumb";
}

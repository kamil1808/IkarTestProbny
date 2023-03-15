package org.example;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ikarTestProbny extends WebElements{

    @BeforeTest
    public void prepareWebsite() {
        driverAndWaits.driverSetUp();
        before.goToWebsite(WebSiteURL);
        before.logIn(email, password);
    }

    @Test(dataProvider = "inputData")
    public void makeOrder(String searchQuery) {
        testMethods.chooseCustomer(searchQuery);

        //KONTRAHENT - CUSTOMER
        testMethods.checkCurrentTab(CustomerTabId);
        testMethods.goNextStep();

        //DOSTAWA - DELIVERY
        testMethods.checkCurrentTab(DeliveryTabId);
        testMethods.goNextStep();

        //PROFIL - PROFILES
        testMethods.checkCurrentTab("bdvProfilesBreadcrumb");
        testMethods.goNextStep();

        //OBRÓBKI - PROCESSING PRODUCTS
        testMethods.checkCurrentTab("bdvProcessingProductsBreadcrumb");
        testMethods.goNextStep();

        //TOWARY HANDLOWE - COMMODITY GOODS
        testMethods.checkCurrentTab("bdvCommodityGoodsBreadcrumb");
        testMethods.goNextStep();

        //USŁUGI - SERVICES
        testMethods.checkCurrentTab("bdvServicesBreadcrumb");
        testMethods.goNextStep();

        //SPRZEDAŻ 8% - EIGHT PERCENT
        testMethods.checkCurrentTab("bdvEightPercentBreadcrumb");
        testMethods.goNextStep();

        //RABATY - DISCOUNTS
        testMethods.checkCurrentTab("bdvDiscountsBreadcrumb");
        testMethods.goNextStep();

        //DODATKOWE INFORMACJE - ADDITIONAL INFORMATIONS
        testMethods.checkCurrentTab("bdvAdditionalInformationsBreadcrumb");
        testMethods.goNextStep();

        //ZAŁĄCZNIKI - ATTACHMENTS
        testMethods.checkCurrentTab("bdvAttachmentsBreadcrumb");
        testMethods.clickSaveButton();
        testMethods.goNextStep();

        //PODSUMOWANIE - SUMMARY
        testMethods.checkCurrentTab("bdvSummaryBreadcrumb");

        //testMethods.clickSaveButton();
    }

    @AfterTest
    public void closeWebsite() {
        after.logOut();
        after.closeAndQuit();
    }

    @DataProvider(name = "inputData")
    public Object[][] provideData() {
        return new Object[][]{
                {"Jan Cygan"},
                //{"Tomasz Nowak"},
                //{"Patrycja Wójciak"}
        };
    }
}
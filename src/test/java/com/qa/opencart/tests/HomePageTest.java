package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


    @Test (priority = 1)
    public void homePageTitle() {
        Assert.assertEquals( homePage.getPageTitle(), AppConstants.Home_PAGE_TITLE);
        page.context().close();
    }

    @DataProvider
    public Object[][] getProductData() {
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getProductData",priority = 2)
    public void productSearch(String productName) {
        if(page.context().isClosed()){
            setUp();
        }
        Assert.assertEquals("Search - " + productName, homePage.doSearch(productName));
    }



}

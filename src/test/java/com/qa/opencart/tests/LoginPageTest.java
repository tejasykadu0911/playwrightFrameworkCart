package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test (priority = 1)
    public void validateLoginPageTitleTest(){
        loginPage = homePage.navigateToLoginPage();
        Assert.assertEquals(loginPage.getPageTitle(), AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test (priority = 2)
    public void verifyForgotLinkExistTest(){
        loginPage = homePage.navigateToLoginPage();
        Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
    }

    @Test (priority = 3)
    public void appLoginTest(){
        loginPage = homePage.navigateToLoginPage();
        Assert.assertTrue(loginPage.login(prop.getProperty("username"), prop.getProperty("password")));
    }
}

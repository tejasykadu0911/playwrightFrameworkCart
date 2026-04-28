package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private String emailId = "//input[@name = 'email']";
    private String password = "//input[@name = 'password']";

    private String loginButton = "//input[@type='submit' and @value='Login']";

    private String forgotPwdLink = "//div[@class='form-group']//a[text()='Forgotten Password']";

    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    public LoginPage(Page page){
        this.page = page;
    }

    public String getPageTitle(){
        return page.title();
    }

    public boolean isForgotPasswordLinkExist(){
        return page.locator(forgotPwdLink).isVisible();
    }

    public boolean login(String emailId,String password){
        page.locator(this.emailId).fill(emailId);
        page.locator(this.password).fill(password);
        page.locator(loginButton).click();

        if(page.isVisible(logoutLink)){
            System.out.println("Login was success");
            return true;
        }
        return false;
    }

}

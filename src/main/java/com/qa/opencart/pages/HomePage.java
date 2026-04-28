package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

    private String search = "//input[@name='search']";
    private String searchButton = "//button[@type='button' and @class='btn btn-default btn-lg']";
    private String searchPageHeader = "//div[@id='content']/h1";

    private String accountLink = "//span[normalize-space()='My Account']";
    private String loginLink = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']";


    public HomePage(Page page){
        this.page = page;
    }

    public String getPageTitle(){
        return page.title();
    }

    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchButton);
        return page.textContent(searchPageHeader);
    }

    public LoginPage navigateToLoginPage(){
        page.locator(accountLink).click();
        page.locator(loginLink).click();
        return new LoginPage(page);
    }

}

package com.TestCases;

import org.testng.annotations.Test;
import com.Pages.BaseClass;
import com.Pages.LoginPage;
import com.Pages.Navigate_to_Admin;

public class Run_Test_Cases extends BaseClass {

    @Test
    public void run() {
        LoginPage login = new LoginPage(driver);
        login.loginToApp("Admin", "admin123");
        Navigate_to_Admin adminPage = new Navigate_to_Admin(driver);
        adminPage.openAdminTab();
        
    }
    
    @Test
    public void run1() {
        LoginPage login = new LoginPage(driver);
        login.loginToApp("Admin", "admin123");
        Navigate_to_Admin adminPage = new Navigate_to_Admin(driver);
        adminPage.openAdminTab();
    }
    
  
}

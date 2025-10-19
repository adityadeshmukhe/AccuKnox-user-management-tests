package com.Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Navigate_to_Admin {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
    WebElement adminTab;
    
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    WebElement clickaddbtn;
    
 
	 
    
   
    
    
     public Navigate_to_Admin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAdminTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(adminTab));
        adminTab.click();
    }
    
    public void clickuserbtn() {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	  wait.until(ExpectedConditions.elementToBeClickable(adminTab));
    	  clickaddbtn.click();
    }
    

}


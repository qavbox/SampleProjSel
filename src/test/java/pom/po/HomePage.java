package pom.po;

import Utility.PageEl;
import base.ExtentReport;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.Pages;

public class HomePage {

        private static final Logger logger = LogManager.getLogger(HomePage.class);

        PageEl username =  new PageEl(By.id("user-name"));

        PageEl password =  new PageEl(By.id("password"));

        PageEl login =  new PageEl(By.id("login-button"));

        public void login(){
                username.sendKeys("standard_user");
                password.sendKeys("secret_sauce");
                login.click();
                ExtentReport.getTest().log(Status.INFO, "Login clicked - from extent");
                //ExtentReport.getTest().info("Login clicked - from extent");
                logger.info("Login clicked - from log");
        }
}

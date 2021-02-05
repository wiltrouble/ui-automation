package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;

    @FindBy(css = "a[href*='https://trello.com']")
    private WebElement trelloLink;

    @FindBy(css = "#username")
    private WebElement usernameTxtBox;

    @FindBy(css = "#login-submit")
    private WebElement loginBtn;

    @FindBy(css = "#password")
    private WebElement passwordTxtBox;

    @FindBy(css = "#login-submit")
    private WebElement loginSubmitBtn;


    public LoginPage(){
        // browser communication
        WebDriverManager.chromedriver().setup();

        // open browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // windows size
        driver.manage().window().setSize(new Dimension(1024, 1366));

        // load url
        driver.get("https://id.atlassian.com/login");

        PageFactory.initElements(driver, this);
    }

    public BoardsPage loginAs(String username, String password) {
        usernameTxtBox.sendKeys(username);
        loginBtn.click();
        passwordTxtBox.sendKeys(password);
        loginSubmitBtn.click();
        trelloLink.click();
        return new BoardsPage(driver);
    }
}

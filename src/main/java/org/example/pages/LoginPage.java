package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    private By trelloLink;
    private By userNameTxtBox;
    private By loginBtn;
    private By passwordTxtBox;
    private By loginSubmitBtn;


    public LoginPage(){
        // browser communication
        WebDriverManager.chromedriver().setup();

        // open browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(1024, 1366));

        // load url
        driver.get("https://id.atlassian.com/login");
    }

    public BoardsPage loginAs(String username, String password) {
        userNameTxtBox = By.cssSelector("#username");
        driver.findElement(userNameTxtBox).sendKeys(username);

        loginBtn = By.cssSelector("#login-submit");
        driver.findElement(loginBtn).click();

        passwordTxtBox = By.cssSelector("#password");
        driver.findElement(this.passwordTxtBox).sendKeys(password);

        loginSubmitBtn = By.cssSelector("#login-submit");
        driver.findElement(loginSubmitBtn).click();

        trelloLink = By.cssSelector("a[href*='https://trello.com']");
        driver.findElement(this.trelloLink).click();

        return new BoardsPage(driver);
    }
}

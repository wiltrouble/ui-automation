package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.BoardsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;

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
        WebElement usernameTxtBox = driver.findElement(By.cssSelector("#username"));
        usernameTxtBox.sendKeys(username);
        WebElement loginBtn = driver.findElement(By.cssSelector("#login-submit"));
        loginBtn.click();
        WebElement passwordTxtBox = driver.findElement(By.cssSelector("#password"));
        passwordTxtBox.sendKeys(password);
        WebElement loginWithBtn = driver.findElement(By.cssSelector("#login-submit"));
        loginWithBtn.click();
        WebElement trelloLink = driver.findElement(By.cssSelector("a[href*='https://trello.com']"));
        trelloLink.click();

        return new BoardsPage(driver);
    }
}

package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Demo {

    @Test
    public void demo() {

        // browser communication
        WebDriverManager.chromedriver().setup();

        // open browser
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(414, 736));

        // load url
        driver.get("http://formy-project.herokuapp.com/form");

        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        firstName.sendKeys("wilson");

        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        lastName.sendKeys("lopez");

        WebElement jobTitle = driver.findElement(By.cssSelector("#job-title"));
        jobTitle.sendKeys("Automation");

        WebElement educationRadioBtn = driver.findElement(By.cssSelector("#radio-button-1"));
        educationRadioBtn.click();

        WebElement sexChkbox = driver.findElement(By.cssSelector("#checkbox-1"));
        sexChkbox.click();

        Select experienceLstBox = new Select(driver.findElement(By.cssSelector("#select-menu")));
        experienceLstBox.selectByValue("3");
        experienceLstBox.selectByVisibleText("10+");

        WebElement submitButton = driver.findElement(By.cssSelector(".btn-primary"));
        submitButton.click();

        String successfullyMessageExpected = "The form was successfully submitted!";

        WebElement message = driver.findElement(By.cssSelector(".alert-success"));

        assertEquals(successfullyMessageExpected, message.getText());

        driver.quit();
    }
}

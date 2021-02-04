package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Demo {

    @Test
    public void demo() {

        // browser comunication
        WebDriverManager.chromedriver().setup();

        // open browser
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(414, 736));

        // load url
        driver.get("http://formy-project.herokuapp.com/form");
        
        List<WebElement> checkboxs = driver.findElements(By.cssSelector("input[type='checkbox']"));

        System.out.println(checkboxs.size());

        driver.quit();


    }

}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardsPage {

    private WebDriver driver;

    public BoardsPage(WebDriver driver) {
        this.driver = driver;
    }

    public BoardPage createNewBoard(String boardName) {
        WebElement createNewBoardBtn = driver.findElement(By.cssSelector(".mod-add"));
        createNewBoardBtn.click();

        WebElement addBoardTitleTxt = driver.findElement(By.cssSelector("input[data-test-id='create-board-title-input']"));
        addBoardTitleTxt.sendKeys(boardName);

        WebElement createBoardBtn = driver.findElement(By.cssSelector("button[data-test-id='create-board-submit-button']"));
        createBoardBtn.click();
        return new BoardPage(driver);
    }
}

package org.example.pages;

import org.example.pages.BoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.awt.windows.WEmbeddedFrame;

public class BoardsPage {

    @FindBy(css = ".mod-add")
    private WebElement createNewBoardBtn;

    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement addBoardTitleTxt;

    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement createBoardBtn;

    private WebDriver driver;

    public BoardsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BoardPage createNewBoard(String boardName) {
        createNewBoardBtn.click();
        addBoardTitleTxt.sendKeys(boardName);
        createBoardBtn.click();
        return new BoardPage(driver);
    }
}

package org.example.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewRepositoryPage extends Page{

    public NewRepositoryPage(WebDriver driver, String PageURL) {
        super(driver, PageURL);
    }
    public NewRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "New")
    private WebElement repositoryNewButton;

    public CreateNewRepositoryPage pressRepositoryNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(repositoryNewButton));
        repositoryNewButton.click();
        return PageFactory.initElements(driver, CreateNewRepositoryPage.class);
    }
    }



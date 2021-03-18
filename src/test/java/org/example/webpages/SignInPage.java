package org.example.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends Page{
    String login, password;

    public SignInPage(WebDriver driver) {
        super(driver);
    }
    public SignInPage(WebDriver driver, String PageURL) {
        super(driver, PageURL);
    }

    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "commit")
    private WebElement commitButton;

    public SignInPage setLogin(String login) {
        this.login = login;
        wait.until(ExpectedConditions.elementToBeClickable(loginField));
        loginField.clear();
        loginField.sendKeys(login);
        return this;
    }

    public SignInPage setPassword(String password) {
        this.password = password;
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public NewRepositoryPage pressCommitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(commitButton));
        commitButton.click();
        return PageFactory.initElements(driver, NewRepositoryPage.class);
    }
    }

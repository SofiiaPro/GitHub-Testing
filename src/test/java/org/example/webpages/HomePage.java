package org.example.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Page{

     public HomePage(WebDriver driver, String PageURL) {
        super(driver);
        driver.get(PageURL);
    }
    public HomePage(WebDriver driver) {
        super(driver);
    }

        @FindBy(linkText = "Sign in")
        private WebElement signInButton;

        public SignInPage pressSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }
}



package org.example.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOutPage extends Page {

    public SignOutPage(WebDriver driver, String PageURL) {
        super(driver, PageURL);
    }
    public SignOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[1]/header/div[7]/details/summary")
    private WebElement headerLink;

    @FindBy(xpath = "/html/body/div[1]/header/div[7]/details/details-menu/form/button")
    private WebElement signOutButton;

   public void pressHeaderLink(){
       headerLink.click();
   }
    public void pressSignOutButton(){
        signOutButton.click();
    }
}

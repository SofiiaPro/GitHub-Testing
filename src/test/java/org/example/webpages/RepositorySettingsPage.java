package org.example.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RepositorySettingsPage extends Page{
    String deleteInputText;

    public RepositorySettingsPage(WebDriver driver, String PageURL) {
        super(driver, PageURL);
    }
    public RepositorySettingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[4]/div/main/div[2]/div/div/div[2]/div/div[10]/ul/li[4]/details/summary")
    private WebElement deleteRepositoryButton;

    @FindBy(xpath = "/html/body/div[4]/div/main/div[2]/div/div/div[2]/div/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")
    private WebElement deleteInput;

    @FindBy(xpath = "/html/body/div[4]/div/main/div[2]/div/div/div[2]/div/div[10]/ul/li[4]/details/details-dialog/div[3]/form/button/span[1]")
    private WebElement submitDeletingButton;

    public void pressDeleteRepositoryButton(){
        deleteRepositoryButton.click();
    }
    public void SetDeleteInput(String deleteInputText){
        this.deleteInputText = deleteInputText;
        wait.until(ExpectedConditions.elementToBeClickable(deleteInput));
        deleteInput.clear();
        deleteInput.click();
        deleteInput.sendKeys(deleteInputText);
    }
    public SignOutPage pressSubmitDeletingButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitDeletingButton));
        submitDeletingButton.click();
        return PageFactory.initElements(driver, SignOutPage.class);
    }
}

package org.example.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReadMePage extends Page{
    String readmeText, message;

    public ReadMePage(WebDriver driver) {
        super(driver);
    }
    public ReadMePage(WebDriver driver, String PageURL) {
        super(driver, PageURL);
    }

    @FindBy(xpath = "//a[contains(text(),'Add a README')]")
    private WebElement addReadMeButton;

    @FindBy(xpath = "//pre[@class=' CodeMirror-line ']")
    private WebElement readmeTextField;

    @FindBy(id = "commit-summary-input")
    private WebElement commitMessageField;

    @FindBy(id = "submit-file")
    private WebElement CommitNewFileButton;

    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    private WebElement settingsButton;

    public void pressAddReadme(){
        addReadMeButton.click();
    }
    public void addReadmeText(String readmeText){
        this.readmeText = readmeText;
        readmeTextField.click();
        readmeTextField.sendKeys(readmeText);
    }
    public void addCommitMessage(String commitMessage){
        this.message = commitMessage;
        commitMessageField.click();
        commitMessageField.sendKeys(commitMessage);
    }
    public void pressCommitNewFileButton(){
        CommitNewFileButton.click();
    }

    public RepositorySettingsPage pressSettingsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(settingsButton));
        settingsButton.click();
        return PageFactory.initElements(driver, RepositorySettingsPage.class);
    }
    }

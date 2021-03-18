package org.example.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;

public class CreateNewRepositoryPage extends Page{
    String repositoryName, language;

    public CreateNewRepositoryPage(WebDriver driver) {
        super(driver);
    }
    public CreateNewRepositoryPage(WebDriver driver, String PageURL) {
        super(driver, PageURL);
    }

    @FindBy(id = "repository_name")
    private WebElement repositoryNameField;

    @FindBy(id = "repository_gitignore_template_toggle")
    private WebElement gitIgnoreButton;

    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[4]/div[4]/div[2]/span[2]/details/summary")
    private WebElement filterIgnores;

    @FindBy(id = "context-ignore-filter-field")
    private WebElement chooseFilter;

    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[4]/button")
    private WebElement createRepositoryButton;

    public void setRepositoryName(String repositoryName){
        this.repositoryName = repositoryName;
        repositoryNameField.click();
        repositoryNameField.sendKeys(repositoryName);
    }
    public void setGitIgnoreProgramLanguage(String language) {
        this.language = language;
        gitIgnoreButton.click();
        filterIgnores.click();
        chooseFilter.click();
        WebElement gitIgnoreFilter = driver.findElement(By.xpath("//*[@id=\"context-ignore-filter-field\"]"));
        gitIgnoreFilter.sendKeys(language);
        chooseFilter.click();
        chooseFilter.sendKeys(Keys.ENTER );
    }
    public ReadMePage pressCreateRepository(){
        wait.until(ExpectedConditions.elementToBeClickable(createRepositoryButton));
        createRepositoryButton.click();
        return PageFactory.initElements(driver, ReadMePage.class);
    }
}

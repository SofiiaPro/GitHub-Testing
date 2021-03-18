package org.example;

import org.example.webpages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AppTest implements Values{
    WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,10);

    }

    @Test
    public void applyAsDeveloper() {

        HomePage home = new HomePage(driver, PAGE_URL);
        home.pressSignInButton();

        SignInPage sign = new SignInPage(driver);
        sign.setLogin(login);
        sign.setPassword(password);
        sign.pressCommitButton();

        NewRepositoryPage newRepositoryPage = new NewRepositoryPage(driver);
        newRepositoryPage.pressRepositoryNewButton();

        CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
        createNewRepositoryPage.setRepositoryName(repositoryName);
        createNewRepositoryPage.setGitIgnoreProgramLanguage(language);
        createNewRepositoryPage.pressCreateRepository();

        ReadMePage readMePage = new ReadMePage(driver);
        readMePage.pressAddReadme();
        readMePage.addReadmeText(readmeText);
        readMePage.addCommitMessage(commitMessage);
        readMePage.pressCommitNewFileButton();
        readMePage.pressSettingsButton();

        RepositorySettingsPage repositorySettingsPage = new RepositorySettingsPage(driver);
        repositorySettingsPage.pressDeleteRepositoryButton();
        repositorySettingsPage.SetDeleteInput(deleteInputText);
        repositorySettingsPage.pressSubmitDeletingButton();

        SignOutPage signOutPage = new SignOutPage(driver);
        signOutPage.pressHeaderLink();
        signOutPage.pressSignOutButton();
    }

    @After
    public void close(){
        driver.close();
    }
}













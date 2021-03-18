package org.example;

import org.example.webpages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppTest {
    WebDriver driver;
    private static String propertiesFilePath = "properties";
    private static String login ;
    private static String password;
    private static String repositoryName ;
    private static String language ;
    private static String readmeText ;
    private static String commitMessage;
    private static String deleteInputText;
    private static String PAGE_URL;

    @Before
    public void setup(){
        loadAccountProperties();
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

    public static void loadAccountProperties() {
        try(InputStream inputStream = new FileInputStream(propertiesFilePath)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            PAGE_URL=properties.getProperty("PAGE_URL");
            login = properties.getProperty("login");
            password = properties.getProperty("password");
            repositoryName = properties.getProperty("repositoryName");
            readmeText = properties.getProperty("readmeText");
            commitMessage = properties.getProperty("commitMessage");
            deleteInputText = properties.getProperty("deleteInputText");
            language = properties.getProperty("language");

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @After
    public void close(){
        driver.close();
    }
}













package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        driver.get("https://github.com");

        //Sign in
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement signInButton = driver.findElement(By.linkText("Sign in"));
        signInButton.click();
        driver.findElement(By.id("login_field")).click();
        driver.findElement(By.id("login_field")).sendKeys("sofiahrn242@gmail.com");
        driver.findElement(By.id("password")).sendKeys("XXXXXXXX");
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.linkText("New")).click();

        //create a repository TestRepository
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement repositoryName = driver.findElement(By.id("repository_name"));
        repositoryName.click();
        repositoryName.sendKeys("TestRepository");

        //select checkboxes
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement checkboxReadme = driver.findElement(By.className("form-checkbox"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkboxReadme); //scroll
        WebElement checkBoxGitIgnore = driver.findElement(By.id("repository_gitignore_template_toggle"));
        checkBoxGitIgnore.click();

        //select dropdown
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement filterIgnores = driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[4]/div[4]/div[2]/span[2]/details/summary"));
        filterIgnores.click();
        WebElement chooseFilter = driver.findElement(By.id("context-ignore-filter-field"));
        chooseFilter.click();
        chooseFilter.sendKeys("Java");
        chooseFilter.click();
        chooseFilter.sendKeys(Keys.ENTER);
        WebElement createRepositoryButton = driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[4]/button"));
        createRepositoryButton.click();

        // Add a README
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"repo-content-pjax-container\"]/div/div[2]/div[1]/div[4]/a")).click();

        // Commit new file
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement commitInput = driver.findElement(By.id("commit-summary-input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", commitInput);
        commitInput.click();
        commitInput.sendKeys("Create README.md");
        WebElement commitDescription = driver.findElement(By.id("commit-description-textarea"));
        commitDescription.click();
        commitDescription.sendKeys("Add readme file");
        WebElement createCommitButton = driver.findElement(By.xpath("//*[@id=\"submit-file\"]"));
        createCommitButton.click();

        //delete repository
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement settingsButton = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/ul/li[9]/a"));
        settingsButton.click();
        WebElement deleteRepositoryButton = driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/summary"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteRepositoryButton);
        deleteRepositoryButton.click();
        WebElement deleteInput = driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input"));
        deleteInput.sendKeys("SofiiaPro/TestRepository");
        driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).click();
        WebElement submitDeletingButton = driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/button"));
        submitDeletingButton.click();

        //Sign Out
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement headerLink = driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary"));
        headerLink.click();
        WebElement signOutButton = driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/form/button"));
        signOutButton.click();

        //close driver
        driver.close();
    }
}

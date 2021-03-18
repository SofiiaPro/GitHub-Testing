package org.example.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract  class Page {
    private static final String PAGE_URL = "https://github.com";

    protected final WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public Page(WebDriver driver, String PageURL) {
        this.driver = driver;
        driver.get(PAGE_URL);
    }
}

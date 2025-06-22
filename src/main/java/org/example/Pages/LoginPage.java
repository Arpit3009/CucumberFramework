package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='email']")
    private WebElement emailBox;

    @FindBy(css = "[name='password']")
    private WebElement passwordBox;

    @FindBy(css = "[value='Login']")
    private WebElement loginButton;

    @FindBy(css = ".alert")
    private WebElement errorMessageElement;

    public void enterUsernamePassword(String username, String password){
        waitForElementVisible(emailBox);
        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
    }

    public void clickOnLoginButton(){
        waitForElementVisible(loginButton);
        loginButton.click();
    }

    public String errorMessage(){

        waitForElementVisible(errorMessageElement);
        System.out.println(errorMessageElement.getText());
        return errorMessageElement.getText();
    }
    public void waitForElementVisible(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}

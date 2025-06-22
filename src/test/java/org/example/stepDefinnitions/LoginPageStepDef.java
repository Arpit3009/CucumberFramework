package org.example.stepDefinnitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String []{"enable-automation"});
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
    }

    @Given("I am on login page.")
    public void i_am_on_login_page(){
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    }

    @Given("I enter wrong {string} and {string}.")
    public void i_enter_wrong_and(String username, String password){
        loginPage.enterUsernamePassword(username, password);
    }

    @When("I ckicked on login button")
    public void i_ckicked_on_login_button(){
        loginPage.clickOnLoginButton();
    }

    @Then("error {string} should come.")
    public void error_should_come(String error_message){
        String me = loginPage.errorMessage();
        System.out.println("message"+me);
        Assert.assertTrue(me.contains(error_message));
    }

    @Given("I enter username and password.")
    public void i_enter_username_and_password(DataTable creds){
//        List<List<String>> data = creds.raw();
//        List<List<String>> data = creds.asLists(String.class);//used in this way in latest version
        for(List<String> data : creds.asLists(String.class)) {
            loginPage.enterUsernamePassword(data.get(0), data.get(1));
        }
    }

}

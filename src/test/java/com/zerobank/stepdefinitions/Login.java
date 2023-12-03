package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login {

    @Given("the user on the signin page")
    public void the_user_on_the_signin_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.signin.click();
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
    }

    @Then("The title contains {string}")
    public void the_title_contains(String expected) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(expected));
    }


    @When("the user is logged in as {string} {string}")
    public void the_user_is_logged_in_as(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithInvalidCredentials(username,password);
    }

    @Then("error message is displayed as {string}")
    public void error_message_is_displayed_as(String expected) {
        BrowserUtils.waitFor(2);
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(loginPage.errorMessage.getText(),expected);
    }

    @When("the user clicks signin")
    public void the_user_clicks_signin() {
        LoginPage loginPage = new LoginPage();
        loginPage.submit.click();
    }



}

package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountsActivity {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login();

    }

    @When("the user clicks on Savings link on the Account Summary page Then the Account Activity page should be displayed")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page_Then_the_Account_Activity_page_should_be_displayed() {
        AccountSummary accountSummary = new AccountSummary();
        BrowserUtils.waitFor(2);
        accountSummary.table("Savings");
    }

    @When("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        BrowserUtils.waitFor(1);
        AccountSummary accountSummary = new AccountSummary();
        Assert.assertEquals(accountSummary.dropdownsaving().getFirstSelectedOption().getText(),"Savings");
    }

    @When("the user clicks on Brokerage link on the Account Summary page Then the Account Activity page should be displayed")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page_Then_the_Account_Activity_page_should_be_displayed() {

        AccountSummary accountSummary = new AccountSummary();
        BrowserUtils.waitFor(2);
        accountSummary.table("Brokerage");

    }

    @When("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        BrowserUtils.waitFor(1);
        AccountSummary accountSummary = new AccountSummary();
        Assert.assertEquals(accountSummary.dropdownsaving().getFirstSelectedOption().getText(),"Brokerage");

    }

    @When("the user clicks on Checking link on the Account Summary page Then the Account Activity page should be displayed")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page_Then_the_Account_Activity_page_should_be_displayed() {

        AccountSummary accountSummary = new AccountSummary();
        BrowserUtils.waitFor(2);
        accountSummary.table("Checking");
    }

    @When("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        BrowserUtils.waitFor(1);
        AccountSummary accountSummary = new AccountSummary();
        Assert.assertEquals(accountSummary.dropdownsaving().getFirstSelectedOption().getText(),"Checking");
    }

    @When("the user clicks on Credit card link on the Account Summary page Then the Account Activity page should be displayed")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page_Then_the_Account_Activity_page_should_be_displayed() {
        AccountSummary accountSummary = new AccountSummary();
        BrowserUtils.waitFor(2);
        accountSummary.table("Credit Card");
    }

    @When("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        BrowserUtils.waitFor(1);
        AccountSummary accountSummary = new AccountSummary();
        Assert.assertEquals(accountSummary.dropdownsaving().getFirstSelectedOption().getText(),"Credit Card");

    }

    @When("the user clicks on Loan link on the Account Summary page Then the Account Activity page should be displayed")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page_Then_the_Account_Activity_page_should_be_displayed() {
        AccountSummary accountSummary = new AccountSummary();
        BrowserUtils.waitFor(2);
        accountSummary.table("Loan");
    }

    @When("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        BrowserUtils.waitFor(1);
        AccountSummary accountSummary = new AccountSummary();
        Assert.assertEquals(accountSummary.dropdownsaving().getFirstSelectedOption().getText(),"Loan");
    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        BrowserUtils.waitFor(1);
        AccountSummary accountSummary = new AccountSummary();
        accountSummary.savings1.click();
    }

    @Then("the default option should be {string}")
    public void the_default_option_should_be(String expected) {
        BrowserUtils.waitFor(2);
        AccountActivity accountActivity = new AccountActivity();
        String actual = accountActivity.actualAccountDropDowns().getFirstSelectedOption().getText();
        Assert.assertEquals(expected, actual);
    }

    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expected) {
        AccountActivity accountActivity = new AccountActivity();
        List<String> actual = BrowserUtils.getElementsText(accountActivity.actualAccountDropDowns().getOptions());
        Assert.assertEquals(expected, actual);
    }

    @Then("Transactions table should have the following options")
    public void transactions_table_should_have_the_following_options(List<String> expected) {
        AccountActivity accountActivity = new AccountActivity();
        List<String> actual = BrowserUtils.getElementsText(accountActivity.transactionTypes);
        Assert.assertEquals(actual, expected);

    }



}

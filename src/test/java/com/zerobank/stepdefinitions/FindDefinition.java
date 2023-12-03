package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FindDefinition {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {

        AccountActivity accountActivity = new AccountActivity();
        accountActivity.findTransaction.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        BrowserUtils.waitFor(2);
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.fromDate.sendKeys(fromDate);
        accountActivity.toDate.sendKeys(toDate);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {

        BrowserUtils.waitFor(2);
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.expectedDate(fromDate,toDate);

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {
        BrowserUtils.waitFor(2);
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.sortedDate();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String notContainDate) throws ParseException {

        BrowserUtils.waitFor(2);
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.notContain(notContainDate);
    }

    @Then("results table should  show transactions dates between {string} to {string}")
    public void results_table_should_show_transactions_dates_between_to(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the results should sorted by most recent date")
    public void the_results_should_sorted_by_most_recent_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String dscrb) {
        BrowserUtils.waitFor(2);
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.description.sendKeys(dscrb);
        BrowserUtils.waitFor(1);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String dscrb) {
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.containDescribtionTable(dscrb);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String dscrb) {

        AccountActivity accountActivity = new AccountActivity();
        accountActivity.notContainDescriptionTable(dscrb);
    }

    @Given("clicks search")
    public void clicks_search() {
        BrowserUtils.waitFor(1);
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.find.click();
        accountActivity.fromDate.clear();
        accountActivity.toDate.clear();
        accountActivity.description.clear();

    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtils.waitFor(1);
        AccountActivity accountActivity = new AccountActivity();
        Assert.assertTrue(accountActivity.textDeposit());
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {

        AccountActivity accountActivity = new AccountActivity();
        Assert.assertTrue(accountActivity.textWithdrawal());
    }

    @When("user selects type {string}")
    public void user_selects_type(String str) {
        BrowserUtils.waitFor(2);
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.selectType(str);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {

        AccountActivity accountActivity = new AccountActivity();
        Assert.assertFalse(accountActivity.textWithdrawal());

    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        AccountActivity accountActivity = new AccountActivity();
        Assert.assertFalse(accountActivity.textDeposit());
    }



}

package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.DashboardPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Account_Summary {

    @Then("Account summary page should have to following options")
    public void account_summary_page_should_have_to_following_options(List<String> expected) {

        BrowserUtils.waitFor(2);
        List<String> actual = BrowserUtils.getElementsText(new AccountSummary().accountTypes);
        Assert.assertEquals(expected, actual);
    }

    @And("Credit Accounts page should have to following options")
    public void credit_Accounts_page_should_have_to_following_options(List<String> expected) {
        List<String> actual = BrowserUtils.getElementsText(new AccountSummary().creditAccountTypes);
        Assert.assertEquals(expected, actual);

    }

}

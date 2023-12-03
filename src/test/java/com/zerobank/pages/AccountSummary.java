package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummary extends BasePage {

    @FindBy(xpath = "//a[text()=\"Savings\"]")
    public List<WebElement> savings;

    @FindBy(xpath = "(//table[@class=\"table\"]/tbody//td/a)[2]")
    public WebElement savings2;

    @FindBy(linkText = "Savings")
    public WebElement savings1;

    @FindBy(xpath = "//select[@id=\"aa_accountId\"]")
    public WebElement dropdownsaving;

    @FindBy(className = "board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//div[@class='board-content'])[3]//th")
    public List<WebElement> creditAccountTypes;



    public Select dropdownsaving(){
        return new Select(dropdownsaving);
    }

    public void table(String str){
        Driver.get().findElement(By.linkText(str)).click();
    }





}

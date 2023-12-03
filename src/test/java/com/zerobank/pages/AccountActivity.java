package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountActivity extends BasePage {

    @FindBy(xpath = "//li[@class=\"ui-state-default ui-corner-top\"]")
    public WebElement findTransaction;

    @FindBy(xpath = "//input[@id=\"aa_fromDate\"]")
    public WebElement fromDate;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement find;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[1]")
    public List<WebElement> actualDate;

    @FindBy(xpath = "//input[@id='aa_description']")
    public WebElement description;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[2]")
    public List<WebElement> descriptionTable;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[3]")
    public List<WebElement> deposit;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[4]")
    public List<WebElement> withdrawal;

    @FindBy(xpath = "//select[@id='aa_type']")
    public WebElement type;

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement accountDropDowns;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> transactionTypes;



    public void expectedDate(String fromDate, String toDate) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromdate = simpleDateFormat.parse(fromDate);
        Date todate = simpleDateFormat.parse(toDate);

        for (int i = 0; i < actualDate.size(); i++) {

            String actualdate = actualDate.get(i).getText();
            Date ActualDate = simpleDateFormat.parse(actualdate);

            Assert.assertTrue(ActualDate.compareTo(fromdate)>=0&&ActualDate.compareTo(todate)<=0);

        }

    }

    public void sortedDate() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> totalDates = new ArrayList<>();
        for (int i = 0; i < actualDate.size()-1; i++) {
             String actualdate = actualDate.get(i).getText();
             String actualdatenext = actualDate.get(i+1).getText();
             Date ActualDate = simpleDateFormat.parse(actualdate);
             Date ActualDateNext = simpleDateFormat.parse(actualdatenext);
             Assert.assertTrue(ActualDate.after(ActualDateNext));

        }
  }

  public void notContain(String notContainDate) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date notcontaindate = simpleDateFormat.parse(notContainDate);
        List<Date> totalDates = new ArrayList<>();
      for (int i = 0; i < actualDate.size(); i++) {
           String actualdate = actualDate.get(i).getText();
           Date ActualDate = simpleDateFormat.parse(actualdate);
           Assert.assertFalse(ActualDate.compareTo(notcontaindate)==0);

      }

  }

  public void containDescribtionTable(String dscrb) {

      for (int i = 0; i < descriptionTable.size(); i++) {
          Assert.assertTrue(descriptionTable.get(i).getText().contains(dscrb));
      }
  }

  public void notContainDescriptionTable(String dscrb){
      for (int i = 0; i < descriptionTable.size(); i++) {
           Assert.assertFalse(descriptionTable.get(i).getText().contains(dscrb));

      }
  }

  public boolean textDeposit(){
        boolean flag = false;

      for (int i = 0; i < deposit.size(); i++) {
           if(!(deposit.get(i).getText().isEmpty())){
               flag=true;
               break;
           }else{
               flag=false;
           }
      }

      return flag;
  }

    public boolean textWithdrawal(){
        boolean flag = false;

        for (int i = 0; i < withdrawal.size(); i++) {
            if(!(withdrawal.get(i).getText().isEmpty())){
                flag=true;
                break;
            }else{
                flag=false;
            }
        }

        return flag;
    }

    public void selectType(String str){
        Select select = new Select(type);
        select.selectByVisibleText(str);
    }

    public Select actualAccountDropDowns(){return new Select(accountDropDowns);}

    public void navigateModule(String str){

        Driver.get().findElement(By.linkText(str));

    }

}

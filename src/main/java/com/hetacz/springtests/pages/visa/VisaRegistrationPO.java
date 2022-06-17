package com.hetacz.springtests.pages.visa;

import com.hetacz.springtests.base.BasePage;
import com.hetacz.springtests.framework.annotations.Page;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.Objects;

@Page
public class VisaRegistrationPO extends BasePage {

    @FindBy(id = "first_4")
    private WebElement q4userNamefirstInput;

    @FindBy(id = "last_4")
    private WebElement q4userNamelastInput;

    @FindBy(id = "input_46")
    private WebElement q46fromCountrySelect;

    @FindBy(id = "input_47")
    private WebElement q47toCountrySelect;

    @FindBy(id = "input_24_month")
    private WebElement q24birthDate24monthSelect;

    @FindBy(id = "input_24_day")
    private WebElement q24birthDate24daySelect;

    @FindBy(id = "input_24_year")
    private WebElement q24birthDate24yearSelect;

    @FindBy(id = "input_6")
    private WebElement q6userEmailInput;

    @FindBy(id = "input_27_phone")
    private WebElement q27mobileNumberphoneInput;

    @FindBy(id = "input_45")
    private WebElement q45clickTo45Textarea;

    @FindBy(id = "submitBtn")
    private WebElement submitBtnButton;

    @FindBy(id = "requestnumber")
    private WebElement requestNumber;

    public VisaRegistrationPO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/sb/visa/udemy-visa.html");
    }

    private void setNames(String firstName, String lastName) {
        q4userNamefirstInput.sendKeys(firstName);
        q4userNamelastInput.sendKeys(lastName);
    }

    private void setCountries(String countryFrom, String countryTo) {
        new Select(q46fromCountrySelect).selectByValue(countryFrom);
        new Select(q47toCountrySelect).selectByValue(countryTo);
    }

    private void setBirthDate(@NotNull LocalDate localDate) {
        new Select(q24birthDate24daySelect).selectByVisibleText(String.valueOf(localDate.getDayOfMonth()));
        new Select(q24birthDate24monthSelect).selectByValue(localDate.getMonth().toString());
        new Select(q24birthDate24yearSelect).selectByVisibleText(String.valueOf(localDate.getYear()));
    }

    private void setEmail(String email) {
        q6userEmailInput.sendKeys(email);
    }

    private void setPhone(String phone) {
        q27mobileNumberphoneInput.sendKeys(phone);
    }

    private void setComment(String comment) {
        q45clickTo45Textarea.sendKeys(Objects.toString(comment,""));
    }

    public void fillData(String firstName, String lastName, String countryFrom, String countryTo, LocalDate dob, String email, String phone, String comment) {
        setNames(firstName,lastName);
        setCountries(countryFrom, countryTo);
        setBirthDate(dob);
        setEmail(email);
        setPhone(phone);
        setComment(comment);
    }

    public void submit() {
        submitBtnButton.click();
    }

    public String getRequestNumber() {
        wait.until(dr -> requestNumber.isDisplayed());
        return requestNumber.getText();
    }

    @Override
    public boolean isAt() {
        return wait.until(dr -> submitBtnButton.isDisplayed());
    }
}

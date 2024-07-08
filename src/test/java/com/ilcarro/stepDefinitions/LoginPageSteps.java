package com.ilcarro.stepDefinitions;

import com.ilcarro.pages.HomePage;
import com.ilcarro.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.ilcarro.pages.BasePage.driver;

public class LoginPageSteps {

    @And("User clicks on Log in Link")
    public void user_click_on_Log_in_Link(){
        new HomePage(driver).clickOnLoginLink();

    }
    @And("User enters valid data")
    public void enter_valid_data(){
        new LoginPage(driver).enterData("test@mail.com","ee33!!aaA");

    }

    @And("User clicks on Yala button")
    public void click_On_Yalla_button(){
        new LoginPage(driver).clickOnYallaButton();

    }
    @Then("User verifyes Success Message is displayed")
    public void verify_Success_Message(){
        new LoginPage(driver).isMessageTextPresent("Logged in success");

    }

    @And("User enters valid email and invalid password")
    public void enter_invalid_password(DataTable table){
        new LoginPage(driver).enterInvalidPassword(table);
    }

    @Then("User verifyes Error Message is displayed")
    public void verifyError(){
        new LoginPage(driver).isMessageTextPresent("\"Login or Password incorrect\"");
    }
    //test@mail.com
    //ee33!!aaA
}

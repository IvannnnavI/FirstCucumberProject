package com.ilcarro.stepDefinitions;

import com.ilcarro.pages.HomePage;
import com.ilcarro.pages.LetTheCarWorkPage;
import com.ilcarro.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

import static com.ilcarro.pages.BasePage.driver;

public class LetTheCarWorkPageSteps {


    @And("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        new HomePage(driver).clickOnLoginLink();
        new LoginPage(driver).enterData("test@mail.com", "ee33!!aaA")
                .clickOnYallaButton()
                .clickOnOkButton();
    }

    @And("User navigates to Let the car work page")
    public void user_navigates_to_Let_the_car_work_page() {
        new HomePage(driver).clickOnLetTheCarWorkPage();
    }


    @And("User selects pick up place {string}")
    public void user_selects_pick_up_place(String city) {
        new LetTheCarWorkPage(driver).selectCity(city);
    }

    @And("User fills in car work form with valid data")
    public void user_fills_in_car_work_form_with_valid_data() {
        String uniqueRegistrationNumber = generateUniqueRegistrationNumber();
        LetTheCarWorkPage letTheCarWorkPage = new LetTheCarWorkPage(driver);
        letTheCarWorkPage.enterCarDetailsInOrder("Toyota", "Camry", "2020", "Diesel",
                "5", "1", uniqueRegistrationNumber, "50",
                "Well-maintained car in excellent condition", "C:/Users/bahek/AUTOMOBILE.jpg");
    }
//"C:\Users\bahek\AUTOMOBILE.jpg"
    @And("User clicks on Submit button")
    public void user_clicks_on_Submit_button() {
        new LetTheCarWorkPage(driver).clickOnSubmitButton();
    }

    @Then("User verifies Success Message is displayed")
    public void successMessageIsDisplayed() {
        new LetTheCarWorkPage(driver).verifyConfirmationMessage("Car added","added successful");
    }
    @And("User quits browser")
    public void user_quits_browser() {
        new HomePage(driver).quiteBrowser();
    }

    private String generateUniqueRegistrationNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(100000);
        return "ABC" + randomNumber;
    }


}

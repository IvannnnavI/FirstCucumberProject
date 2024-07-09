package com.ilcarro.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LetTheCarWorkPage extends BasePage {

    public LetTheCarWorkPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "pickUpPlace")
    WebElement pickUpPlaceInput;

    public LetTheCarWorkPage selectCity(String city) {
        type(pickUpPlaceInput, city);
        pause(2000);


        Actions actions = new Actions(driver);
        actions.sendKeys(pickUpPlaceInput, Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        return this;
    }

    @FindBy(id = "make")
    WebElement manufactureInput;
    @FindBy(id = "model")
    WebElement modelInput;
    @FindBy(id = "year")
    WebElement yearInput;
    @FindBy(id = "fuel")
    WebElement fuelSelect;
    @FindBy(id = "seats")
    WebElement seatsInput;
    @FindBy(id = "class")
    WebElement carClassInput;
    @FindBy(id = "serialNumber")
    WebElement carRegistrationNumberInput;
    @FindBy(id = "price")
    WebElement priceInput;
    @FindBy(id = "about")
    WebElement aboutInput;

//    @FindBy(xpath = "//label[contains(text(),'Add photos of your car')]")
//    WebElement uploadPhotosButton1;
    @FindBy(id = "photos")
    WebElement uploadPhotosButton;

    public LetTheCarWorkPage uploadPhoto(String photoPath) {
        clickWithRectangle(uploadPhotosButton,3,3);
        uploadPhotosButton.sendKeys(photoPath);
        pause(2000);
        return this;
    }

public LetTheCarWorkPage enterCarDetailsInOrder(String manufacture, String model, String year, String fuel,
                                                String seats, String carClass, String carRegistrationNumber,
                                                String price, String about, String photoPath) {
    type(manufactureInput, manufacture);
    type(modelInput, model);
    type(yearInput, year);
    selectFuelType(fuel);
    type(seatsInput, seats);
    type(carClassInput, carClass);
    type(carRegistrationNumberInput, carRegistrationNumber);
    type(priceInput, price);
    type(aboutInput, about);
    uploadPhoto(photoPath);
    return this;
}

public LetTheCarWorkPage selectFuelType(String fuel) {
    Select fuelDropdown = new Select(fuelSelect);
    fuelDropdown.selectByVisibleText(fuel);
    return this;
}

@FindBy(xpath = "//button[contains(text(),'Submit')]")
WebElement submitButton;

public LetTheCarWorkPage clickOnSubmitButton() {
    pause(2000);
    click(submitButton);
    return this;
}

@FindBy(xpath = "//h1[contains(text(),'Car added')]")
WebElement confirmationTitle;
@FindBy(css = ".dialog-container .message")
WebElement confirmationMessage;
@FindBy(css = ".message")
WebElement confirmationMessage1;

public LetTheCarWorkPage verifyConfirmationMessage(String title,String message) {
    pause(2000);
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(confirmationTitle.getText()).contains(title);
    softAssertions.assertThat(confirmationMessage1.getText()).contains(title);
    softAssertions.assertAll();

    return this;
}
}

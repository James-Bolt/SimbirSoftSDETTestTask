package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    private final WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement logField;

    @FindBy(id = "password")
    private WebElement passField;

    @FindBy(css = "input[class='submit-button btn_action']")
    private WebElement continueLogButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueBuyButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(xpath = "//*[@id='checkout_complete_container']/h2")
    private WebElement completeOrderMessage;

    @FindBy(xpath = "//*[@id='login_button_container']/div/form/div[3]/h3")
    private WebElement errorLogMessage;

    public GooglePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Ввод строки {str} в поле логина")
    public GooglePage inputStrInLogField(String str) {
        logField.sendKeys(str);
        return this;
    }

    @Step("Ввод строки {str} в поле пароля")
    public GooglePage inputStrInPassField(String str) {
        passField.sendKeys(str);
        return this;
    }

    @Step("Нажатие кнопки Login")
    public GooglePage clickContinueButtonInLogField() {
        continueLogButton.click();
        return this;
    }

    @Step("Нажатие кнопки Add to cart")
    public GooglePage clickAddButton() {
        addButton.click();
        return this;
    }

    @Step("Открытие корзины")
    public GooglePage clickShoppingCart() {
        shoppingCart.click();
        return this;
    }

    @Step("Нажатие кнопки Checkout")
    public GooglePage clickCheckoutButton() {
        checkoutButton.click();
        return this;
    }

    @Step("Ввод строки {str} в поле 'FirstName'")
    public GooglePage inputStrInFirstNameField(String str) {
        firstNameField.sendKeys(str);
        return this;
    }

    @Step("Ввод строки {str} в поле 'LastName'")
    public GooglePage inputStrInLastNameField(String str) {
        lastNameField.sendKeys(str);
        return this;
    }

    @Step("Ввод строки {str} в поле 'CodeField'")
    public GooglePage inputStrInPostalCodeField(String str) {
        postalCodeField.sendKeys(str);
        return this;
    }

    @Step("Нажатие кнопки продолжения оформления заказа")
    public GooglePage clickContinueButtonInShoppingCart() {
        continueBuyButton.click();
        return this;
    }

    @Step("Нажатие кнопки Finish")
    public GooglePage clickFinishButton() {
        finishButton.click();
        return this;
    }

    @Step("Проверка отображения сообщения об успешной покупке")
    public String checkCompleteOrderMessageIsVisible() {
        if (completeOrderMessage.isDisplayed()) {
            return completeOrderMessage.getText();
        } else return "Error";
    }

    @Step("Проверка отображения сообщения об ошибке авторизации")
    public String checkErrorLogMessageIsVisible() {
        if (errorLogMessage.isDisplayed()) {
            return errorLogMessage.getText();
        } else return "Error";
    }
}

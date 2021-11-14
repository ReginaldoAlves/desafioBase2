package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css = "input[name='username']")
    private WebElement usernameInput;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "font[color='red']")
    private WebElement errorMessageLabel;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage fillUsername(String username) {
        usernameInput.sendKeys(username);

        return this;
    }

    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);

        return this;
    }

    public MyViewPage submitLoginForm() {
        submitButton.click();

        return new MyViewPage(getWebDriver());
    }

    public LoginPage submitWrongLoginForm() {
        submitButton.click();

        return this;
    }

    public String getFailLoginMessage() {
        return errorMessageLabel.getText();
    }
}

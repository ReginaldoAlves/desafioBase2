package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyViewPage extends BasePage {

    @FindBy(css = ".login-info-left")
    private WebElement loginInfoLabel;

    @FindBy(linkText = "Report Issue")
    private WebElement reportIssueLink;

    public MyViewPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Boolean isLoggedIn() {
        return loginInfoLabel.isDisplayed();
    }

    public SelectProjectPage goToReportIssuePage() {
        reportIssueLink.click();

        return new SelectProjectPage(getWebDriver());
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueReportFeedbackPage extends BasePage{

    @FindBy(css = "body > div[align='center']")
    private WebElement successMessageLabel;

    @FindBy(partialLinkText = "View Submitted Issue")
    private WebElement goToCreatedIssueLink;

    protected IssueReportFeedbackPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getMessage(){
        return successMessageLabel.getText();
    }

    public IssuePage clickViewReport() {
        goToCreatedIssueLink.click();
        return new IssuePage(getWebDriver());
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueReportPage extends BasePage{

    @FindBy(name = "category_id")
    private WebElement categorySelector;

    @FindBy(css = "option[value='65']")
    private WebElement categoryOption;

    @FindBy(name = "summary")
    private WebElement summaryInput;

    @FindBy(name="description")
    private WebElement descriptionInput;

    @FindBy(css = "form[name='report_bug_form'] input[type='submit']")
    private WebElement submitFormButton;

    protected IssueReportPage(WebDriver webDriver) {
        super(webDriver);
    }

    public IssueReportPage clickToSelectCategory() {
        categorySelector.click();
        return this;
    }

    public IssueReportPage selectCategory() {
        categoryOption.click();
        return this;
    }

    public IssueReportPage fillSummary(String summary) {
        summaryInput.sendKeys(summary);
        return this;
    }

    public IssueReportPage fillDescription(String description) {
        descriptionInput.sendKeys(description);
        return this;
    }

    public IssueReportFeedbackPage submitReport() {
        submitFormButton.click();
        return new IssueReportFeedbackPage(getWebDriver());
    }

}

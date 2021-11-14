package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectProjectPage extends BasePage{

    @FindBy(name = "project_id")
    private WebElement projectSelector;

    @FindBy(css = "form[action='set_project.php'] option[value='268']")
    private WebElement projectOption;

    @FindBy(css = "form[action='set_project.php'] input[type='submit']")
    private WebElement submitFormButton;

    protected SelectProjectPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SelectProjectPage clickToSelectProject() {
        projectSelector.click();
        return this;
    }

    public SelectProjectPage selectProject() {
        projectOption.click();
        return this;
    }

    public IssueReportPage clickSelectProjectButton() {
        submitFormButton.click();
        return new IssueReportPage(getWebDriver());
    }
}

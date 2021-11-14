package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.CSS;

public class IssuePage extends BasePage{

    @FindBy(name = "bugnote_text")
    private WebElement noteInput;

    @FindBy(css = "input[value='Add Note'")
    private WebElement saveNoteButton;

    @FindBy(css = ".bugnote-note-public")
    private WebElement savedNoteLabel;

    protected IssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    public IssuePage addNote(String note) {
        noteInput.sendKeys(note);
        saveNoteButton.click();
        return this;
    }

    public String getNote() {
        return savedNoteLabel.getText();
    }

}

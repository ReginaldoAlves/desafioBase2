package modules.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

@DisplayName("Testes web do módulo de Issues")
public class IssueTest {
    private WebDriver webDriver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "/Users/reginaldoalves/drivers/chromedriver95/chromedriver");
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.webDriver.get("https://mantis-prova.base2.com.br/login_page.php");
    }

    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }

    @Test
    @DisplayName("Reportar issue")
    public void testReportIssue() {
        String displayedMessage = new LoginPage(webDriver)
                .fillUsername("reginaldo.alves")
                .fillPassword("base2@2021")
                .submitLoginForm()
                .goToReportIssuePage()
                .clickToSelectProject()
                .selectProject()
                .clickSelectProjectButton()
                .clickToSelectCategory()
                .selectCategory()
                .fillSummary("Título da issue")
                .fillDescription("Descricão da issue.")
                .submitReport()
                .getMessage();

        Boolean displayedMessageContainsSuccessfulMessage = displayedMessage.contains("Operation successful.");
        Assertions.assertEquals(Boolean.TRUE, displayedMessageContainsSuccessfulMessage);
    }

    @Test
    @DisplayName("Adicionar nota em issue existente")
    public void addNoteToExistingIssue() {
        String note = "Nota de teste";
        String noteDisplayed = new LoginPage(webDriver)
                .fillUsername("reginaldo.alves")
                .fillPassword("base2@2021")
                .submitLoginForm()
                .goToReportIssuePage()
                .clickToSelectProject()
                .selectProject()
                .clickSelectProjectButton()
                .clickToSelectCategory()
                .selectCategory()
                .fillSummary("Título da issue")
                .fillDescription("Descricão da issue.")
                .submitReport()
                .clickViewReport()
                .addNote(note)
                .getNote();

        Assertions.assertEquals(note, noteDisplayed);
    }
}

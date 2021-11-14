package modules.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do módulo de Login")
public class LoginTest {
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
    @DisplayName("Login com usuário e senha válidos")
    public void testLogin() {
         Boolean isLoggedIn = new LoginPage(webDriver)
                .fillUsername("reginaldo.alves")
                .fillPassword("base2@2021")
                .submitLoginForm()
                .isLoggedIn();

         Assertions.assertEquals(isLoggedIn, Boolean.TRUE);
    }

    @Test
    @DisplayName("Tentativa de login com senha inválida")
    public void testLoginInvalidPassword() {
        String errorMessage = new LoginPage(webDriver)
                .fillUsername("reginaldo.alves")
                .fillPassword("12345678")
                .submitWrongLoginForm()
                .getFailLoginMessage();

        String expectedMessage =
                "Your account may be disabled or blocked or the username/password you entered is incorrect.";
        Assertions.assertEquals(expectedMessage, errorMessage);
    }

}

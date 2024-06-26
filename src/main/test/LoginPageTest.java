import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    CalculatorPage calculatorPage;


    @Test
    void validLogin() {
        loginPage = new LoginPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.inputUsername("Adminas");
        loginPage.inputPassword("Adminas");
        loginPage.loginClick();

        String expectedString = "Skaičiuotuvas";
        String actualString = calculatorPage.registerElement();
        assertThat(actualString).isEqualTo(expectedString);

    }


    @Test
    void invalidLogin(){

        loginPage = new LoginPage(driver);
        calculatorPage = new CalculatorPage(driver);


        loginPage.inputUsername("Adminas");
        loginPage.inputPassword("Adminas1");
        loginPage.loginClick();

        String expectedString = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String actualString= loginPage.invalidLoginUser();
        assertThat(actualString).isEqualTo(expectedString);

    }

}

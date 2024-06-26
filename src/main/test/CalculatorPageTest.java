import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorPageTest extends BaseTest{

    LoginPage loginPage;
    CalculatorPage calculatorPage;

    @Test
    void validMath (){
        loginPage = new LoginPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.inputUsername("Adminas");
        loginPage.inputPassword("Adminas");
        loginPage.loginClick();
        calculatorPage.numberFirstRow("5");
        calculatorPage.numberSecondRow("5");
        calculatorPage.chooseMathLabel("Daugyba");
        calculatorPage.numberResult();

        String expectedStringOfNumbers = "5 * 5 = 25";
        String actualStringOfNumbers = calculatorPage.resultOfNumbers();
        assertThat(actualStringOfNumbers).isEqualTo(expectedStringOfNumbers);

    }
    @Test
    void invalidMath(){
        loginPage = new LoginPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.inputUsername("Adminas");
        loginPage.inputPassword("Adminas");
        loginPage.loginClick();
        calculatorPage.numberFirstRow("-5");
        calculatorPage.numberSecondRow("-5");
        calculatorPage.chooseMathLabel("Daugyba");
        calculatorPage.numberResult();

        String expectedString = "Validacijos klaida: skaičius negali būti neigiamas";
        String actualString = calculatorPage.invalidNumbers();
        assertThat(actualString).isEqualTo(expectedString);
    };
}

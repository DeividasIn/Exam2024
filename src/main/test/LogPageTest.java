import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogPageTest extends BaseTest {
    LoginPage loginPage;
    CalculatorPage calculatorPage;
    LogPage logPage;

    @Test
    void creatingALog() {
        loginPage = new LoginPage(driver);
        calculatorPage = new CalculatorPage(driver);
        logPage = new LogPage(driver);

        loginPage.inputUsername("Adminas");
        loginPage.inputPassword("Adminas");
        loginPage.loginClick();
        calculatorPage.numberFirstRow("4");
        calculatorPage.numberSecondRow("5");
        calculatorPage.chooseMathLabel("Sudėtis");
        calculatorPage.numberResult();
        logPage.openingLogScreen();

        String expectedStringOfNumbers = "Trinti";
        String actualStringOfNumbers = logPage.existingLogOfNumberSum();
        assertThat(actualStringOfNumbers).isEqualTo(expectedStringOfNumbers);
    }

    @Test
    void editingALogPositively() {

        loginPage = new LoginPage(driver);
        calculatorPage = new CalculatorPage(driver);
        logPage = new LogPage(driver);

        loginPage.inputUsername("Adminas");
        loginPage.inputPassword("Adminas");
        loginPage.loginClick();
        calculatorPage.numberFirstRow("5");
        calculatorPage.numberSecondRow("5");
        calculatorPage.chooseMathLabel("Dalyba");
        calculatorPage.numberResult();
        logPage.openingLogScreen();
        logPage.changeNumbersInLog();
        logPage.editFirstRow("5");
        logPage.equationUpdate();

        String expectedStringOfNumbers = "Id:";
        String actualStringOfNumbers = logPage.textAfterUpdate();
        assertThat(actualStringOfNumbers).isEqualTo(expectedStringOfNumbers);

    }

    @Test
    void editingALogNegatively() {

        loginPage = new LoginPage(driver);
        calculatorPage = new CalculatorPage(driver);
        logPage = new LogPage(driver);

        loginPage.inputUsername("Adminas");
        loginPage.inputPassword("Adminas");
        loginPage.loginClick();
        calculatorPage.numberFirstRow("5");
        calculatorPage.numberSecondRow("5");
        calculatorPage.chooseMathLabel("Dalyba");
        calculatorPage.numberResult();
        logPage.openingLogScreen();
        logPage.changeNumbersInLog();
        logPage.editFirstRow("-1");
        logPage.equationUpdate();

        String expectedStringOfNumbers = "Whitelabel Error Page";
        String actualStringOfNumbers = logPage.errorMessageAfterUpdate();
        assertThat(actualStringOfNumbers).isEqualTo(expectedStringOfNumbers);

    }
}

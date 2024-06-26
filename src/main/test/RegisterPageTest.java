import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterPageTest extends BaseTest{

    RegisterPage registerPage;
    LoginPage loginPage;
    CalculatorPage calculatorPage;

    @Test
    void oneTimeNewUserRegister (){
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        calculatorPage = new CalculatorPage(driver);


        loginPage.clickRegisterNewUser();
        registerPage.userCreationName("Adminas");
        registerPage.userPasswordCreation("Adminas");
        registerPage.userPasswordCreationRepeat("Adminas");
        registerPage.clickRegister();

        String expectedElement = "Skaičiuotuvas";
        String actualElement = calculatorPage.registerElement();
        assertThat(actualElement).isEqualTo(expectedElement);
    }

    @Test
    void validUserCreation() {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        calculatorPage = new CalculatorPage(driver);


        loginPage.clickRegisterNewUser();
        registerPage.validUserCreationName();
        registerPage.userPasswordCreation("Adminas");
        registerPage.userPasswordCreationRepeat("Adminas");
        registerPage.clickRegister();

        String expectedElement = "Skaičiuotuvas";
        String actualElement = calculatorPage.registerElement();
        assertThat(actualElement).isEqualTo(expectedElement);


    }


    @Test
    void invalidUserCreation(){

        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.clickRegisterNewUser();
        registerPage.userCreationName("AdminasHaha");
        registerPage.userPasswordCreation("1");
        registerPage.userPasswordCreationRepeat("1");
        registerPage.clickRegister();

        String expectedElement = "Privaloma įvesti bent 3 simbolius";
        String actualElement = registerPage.invalidPasswordAssert();
        assertThat(actualElement).isEqualTo(expectedElement);

    }



}

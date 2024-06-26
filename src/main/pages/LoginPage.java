import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//a[contains(text(),'Sukurti naują paskyrą')]")
    private WebElement registerNewUser;
    @FindBy(xpath = "//input[@placeholder='Prisijungimo vardas']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@placeholder='Slaptažodis']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement clickLogin;

    @FindBy(xpath = "//span[contains(text(),'Įvestas prisijungimo vardas ir/ arba slaptažodis y')]")
    private WebElement invalidLoginUsername;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterNewUser(){
        registerNewUser.click();
    }

    public void inputUsername(String text) {
        inputUsername.sendKeys(text);
    }
    public void inputPassword(String text){
        inputPassword.sendKeys(text);
    }
    public void loginClick() {
        clickLogin.click();
    }
    public String invalidLoginUser(){
        return invalidLoginUsername.getText();
    }

}

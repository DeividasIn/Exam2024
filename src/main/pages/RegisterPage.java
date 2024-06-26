import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.UUID;

public class RegisterPage extends BasePage{

    @FindBy(xpath = "//input[@id='username']")
    private WebElement registerNewUserUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement registerNewUserPassword;

    @FindBy(xpath = "//input[@id='passwordConfirm']")
    private WebElement registerNewUserRepeatPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement newUserClickRegister;

    @FindBy(xpath = "//span[@id='password.errors']")
    private WebElement invalidPassword;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    int desiredLength = 5;
    String random = UUID.randomUUID().toString().substring(0,desiredLength);
    public void validUserCreationName(){
        registerNewUserUsername.sendKeys(random);
    }

    public void userCreationName(String text){
        registerNewUserUsername.sendKeys(text);
    }
    public void userPasswordCreation(String text){
        registerNewUserPassword.sendKeys(text);
    }

    public void userPasswordCreationRepeat(String text){
        registerNewUserRepeatPassword.sendKeys(text);
    }

    public void clickRegister(){
        newUserClickRegister.click();
    }

    public String invalidPasswordAssert(){
        return invalidPassword.getText();
    }


}

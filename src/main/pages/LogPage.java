import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogPage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Atliktos operacijos']")
    private WebElement logNavBar;
    @FindBy(xpath = "//a[normalize-space()='Trinti']")
    private WebElement existingLog;
    @FindBy(xpath = "//a[normalize-space()='Keisti']")
    private WebElement changingLog;
    @FindBy(xpath = "//input[@name='sk1']")
    private WebElement editingFirstRow;
    @FindBy(xpath = "//input[@value='Atnaujinti']")
    private WebElement updateEquation;
    @FindBy(xpath = "//h1[normalize-space()='Whitelabel Error Page']")
    private WebElement errorMessage;
    @FindBy(xpath = "//b[normalize-space()='Id:']")
    private WebElement afterUpdatingEquation;

    public LogPage(WebDriver driver) {
        super(driver);
    }

    public void openingLogScreen() {
        logNavBar.click();
    }

    public String existingLogOfNumberSum() {
        return existingLog.getText();
    }

    public void changeNumbersInLog() {
        changingLog.click();
    }

    public void editFirstRow(String number){
        editingFirstRow.clear();
        editingFirstRow.sendKeys(number);
    }
    public void equationUpdate(){
        updateEquation.click();
    }

    public String errorMessageAfterUpdate(){
        return errorMessage.getText();
    }

    public String textAfterUpdate(){
        return afterUpdatingEquation.getText();
    }
}

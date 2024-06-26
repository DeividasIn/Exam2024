import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage extends BasePage{


    @FindBy(xpath = "//a[@class='navbar-brand']")
    private WebElement afterRegisterElement;

    @FindBy(xpath = "//input[@id='sk1']")
    private WebElement firstRowNumber;

    @FindBy(xpath = "//input[@id='sk2']")
    private WebElement secondRowNumber;

    @FindBy(xpath = "//select[@name='zenklas']")
    private WebElement mathLabel;

    @FindBy(xpath = "//input[@value='skaičiuoti']")
    private WebElement sumOfNumber;

    @FindBy(xpath = "//h4[contains(text(),'5 *')]")
    private WebElement endResultOfNumbers;

    @FindBy(xpath = "//span[@id='sk1.errors']")
    private WebElement numbersDoNotMultiply;


    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public String registerElement(){
       return afterRegisterElement.getText();
    }

    public void numberFirstRow(String number){
        firstRowNumber.clear();
        firstRowNumber.sendKeys(number);
    }

    public void numberSecondRow(String number){
        secondRowNumber.clear();
        secondRowNumber.sendKeys(number);
    }

    public void chooseMathLabel(String label){
        Select objSelect =new Select(mathLabel);
        objSelect.selectByVisibleText(label);
    }

    public void numberResult(){
        sumOfNumber.click();
    }

    public String resultOfNumbers(){
        return endResultOfNumbers.getText();
    }

    public String invalidNumbers(){
        return numbersDoNotMultiply.getText();
    }

}

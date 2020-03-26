package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.ID, using = "login-username")
    private WebElement userField;
    @FindBy(how = How.ID, using = "login-password")
    private WebElement passwordField;
    @FindBy(how = How.ID, using = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username){
        wait.until(ExpectedConditions.elementToBeClickable(userField));
        userField.sendKeys(username);

    }

    public void setPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
    }

    public DashboardPage clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new DashboardPage(driver);
    }


}

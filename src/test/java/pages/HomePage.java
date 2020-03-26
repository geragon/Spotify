package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HomePage {


    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.CSS, using = ".b5b01e376bfe3156c865cba3909f11c3-scss > div:nth-child(4) > button:nth-child(2)" )
    private WebElement loginLink;


    public HomePage(WebDriver driver){
        this.driver = driver;

        wait = new WebDriverWait(driver, 15);
        //El page factory es el que agarra los FindBy
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
        return new LoginPage(driver);
    }

}

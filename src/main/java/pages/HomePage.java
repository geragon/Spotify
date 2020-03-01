package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private WebDriver driver;
    private By loginLink = By.cssSelector(".b5b01e376bfe3156c865cba3909f11c3-scss > div:nth-child(4) > button:nth-child(2)");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickLoginButton(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

}

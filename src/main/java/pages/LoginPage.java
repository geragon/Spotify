package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private By userField = By.cssSelector("#login-username");
    private By passwordField = By.cssSelector("#login-password");
    private By loginButton = By.cssSelector("#login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(userField).sendKeys(username);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public Dashboard clickLoginButton(){
        driver.findElement(loginButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new Dashboard(driver);
    }
}

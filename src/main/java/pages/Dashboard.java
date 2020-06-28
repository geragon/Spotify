package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

    private WebDriver driver;
    private By userName = By.xpath("//span[@data-testid=\"user-widget-name\"]");

    public Dashboard(WebDriver driver){
        this.driver = driver;
    }

    public String getUserName(){
       return  driver.findElement(userName).getText();
    }

}

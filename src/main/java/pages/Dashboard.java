package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

    private WebDriver driver;
    private By userName = By.xpath("/html/body/div[3]/div/div[3]/div[1]/header/div[4]/button");

    public Dashboard(WebDriver driver){
        this.driver = driver;
    }

    public String getUserName(){
       return  driver.findElement(userName).getText();
    }

}

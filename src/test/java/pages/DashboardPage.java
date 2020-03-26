package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[3]/div[1]/header/div[4]/button")
    private WebElement userName;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
        PageFactory.initElements(driver, this);
    }

    public String getUserName(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div[3]/div[1]/header/div[4]/button")));
       return  userName.getText();
    }

}

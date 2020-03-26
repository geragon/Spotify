package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlaylistPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.CLASS_NAME, using = "inputBox-input")
    WebElement nuevaPlaylistField;
    @FindBy(how = How.XPATH, using = "//*[@id='main']/div/div[4]/div/div[2]/div[2]/button")
    WebElement crearButton;

    public PlaylistPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
        PageFactory.initElements(driver, this);
    }

    public void setPlaylistName(String playlistName){
        nuevaPlaylistField.sendKeys("TestingAutomation");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inputBox-input")));
        crearButton.click();
    }


}

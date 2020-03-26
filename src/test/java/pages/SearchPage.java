package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;
    //Static elements
    @FindBy(how = How.CSS, using = "[data-testid='search-input']")
    private WebElement searchField;
    //Dinamic elements
    private By resultadoPrincipalSection = By.cssSelector("[aria-label='Resultado principal']");
    private By cancionesSection = By.cssSelector("[data-testid='search-tracks-result']");
    private By iconoPlay = By.cssSelector("[aria-label='Reproducir']");
    private By imagenAlbum = By.cssSelector("//*[@data-testid='search-tracks-result']//div[@draggable = 'true' and contains(., 'Metallica')]//img");
    private By iconoPausa = By.cssSelector("[aria-label='Pause']");

    public SearchPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
        PageFactory.initElements(driver,this);
    }

    public void setSongName(String linkCancion){
        searchField.sendKeys(linkCancion);
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
    }

    public void validateMainSong(String songName) {
        //mover el raton hacia el contenedor del resultado principal
        //Actions action = new Actions(driver);
        //WebElement targetLink = driver.findElement(By.xpath("//*[@aria-label='Resultado principal']//a[@title = '"+songName+"']"));
        //action.moveToElement(targetLink).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Resultado principal']//a[contains(@title , '"+songName+"')]")));
    }

    public void validateSongList(String songName, String artistName) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//section[@data-testid='search-tracks-result']//div[@draggable='true' and contains(.,'"+ artistName +"')]"), 0));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//section[@data-testid='search-tracks-result']//div[@draggable='true' and contains(., '"+ songName +"')]"), 0));
    }

    public void playMainSong(String songName){
        Actions action = new Actions(driver);
        WebElement targetLink = driver.findElement(By.xpath("//*[@aria-label='Resultado principal']//a[contains(@title, '"+songName+"')]"));
        action.moveToElement(targetLink).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(iconoPlay)).click();

    }

}

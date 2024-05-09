package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import runner.TestRunner;

public class HomePage{

    WebDriver driver;

    private By searchTextBoxLocator = By.xpath("//input[@id='searchTerm']");
    private By searchIconLocator = By.xpath("//button[@data-test='search-button']");
    private By cookiesSectionLocator=By.xpath("//*[@class='explicit-consent-prompt']");
    private By requiredCookiesButtonLocator = By.xpath("//button[@id='explicit-consent-prompt-reject']");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void homePageNav(){
        driver.get(" https://www.argos.co.uk/");
        driver.manage().window().maximize();
    }

    public void acceptCookies(){
        WebElement cookiesSection=driver.findElement(cookiesSectionLocator);
        WebElement requiredCookiesButton= driver.findElement(requiredCookiesButtonLocator);
        if(cookiesSection.isDisplayed()){
            requiredCookiesButton.click();
        }
    }

    public void searchProduct(String productName) {
        acceptCookies();
        WebElement searchTextBox = driver.findElement(searchTextBoxLocator);
        searchTextBox.sendKeys(productName);
        WebElement searchIcon = driver.findElement(searchIconLocator);
        searchIcon.click();
    }

}

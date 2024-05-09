package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class SearchResultsPage {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public static float costPrice;

    private By resultsTextTitleLocator = By.xpath("//div[@data-el='search-title']/h4");
    private By productTitleLocator = By.xpath("//div[*]/div[1]/div/div[1]/div/div[1]/div[2]/a[2]/div[1]");
    private By addToTrolleyBtnLocator = By.xpath("//div[8]/div[1]/div/div[1]/div/div[2]/button");
    private By productPriceLocator=By.xpath("//div[@data-test='product-list'][1]//div[@data-test='product-group-card-0']//div[@data-test='component-product-card-valueMessagingContainer']//strong");
    private By addToTrolleyPopUpHeaderLocator=By.xpath("//*[@id=\"component-att-modal-drawer-title\"]");
    private By addToTrolleyBtnOnPopUpLocator = By.xpath("//*[@class='xs-row']/div[2]/a");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifySearchResultsPage(String productName) {
        WebElement resultsTextTitle = driver.findElement(resultsTextTitleLocator);
        WebElement productTitle = driver.findElement(productTitleLocator);
        wait.until(ExpectedConditions.visibilityOf(resultsTextTitle));
        Assert.assertTrue((productTitle.getText()).contains(productName));
        Assert.assertTrue(resultsTextTitle.getText().toUpperCase().contains(productName.toUpperCase()));
    }

    public void addProductToBasket() {
        WebElement addToTrolleyBtn = driver.findElement(addToTrolleyBtnLocator);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.moveToElement(addToTrolleyBtn);
        captureUnitPrice();
        addToTrolleyBtn.click();
        addToTrolleyPopUp();
    }

    public void captureUnitPrice() {
        WebElement productPrice = driver.findElement(productPriceLocator);
        String PriceWithCurrencySymbol=productPrice.getText();
        String PriceWithoutCurrencySymbol = PriceWithCurrencySymbol.replaceAll("[^\\d.]", "");
        costPrice = Float.parseFloat(PriceWithoutCurrencySymbol);
    }

    public void addToTrolleyPopUp(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement addToTrolleyPopUpHeader = driver.findElement(addToTrolleyPopUpHeaderLocator);
        wait.until(ExpectedConditions.visibilityOf(addToTrolleyPopUpHeader));
        WebElement addToTrolleyBtnOnPopUp = driver.findElement(addToTrolleyBtnOnPopUpLocator);
        addToTrolleyBtnOnPopUp.click();
    }

}

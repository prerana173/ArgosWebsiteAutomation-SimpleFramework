package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

public class TrolleyPage extends SearchResultsPage{

    WebDriver driver;
    String itemInTheTrolley;
    Float updatedSubTotal;
    int quantity;
    String subTotalWithCurrencySymbol;
    String subTotalWithoutCurrencySymbol;
    Float calculatedSubTotal;

    private By productInTheTrolleyLocator = By.xpath("//a[@data-e2e='product-name']");
    private By quantityDropdownLocator = By.xpath("//*[@data-e2e=\"product-quantity\"]");
    private By subTotalLocator = By.xpath("//*[@data-e2e=\"basket-total-price\"]");

    public TrolleyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyProductNameInBasket(String productName){
        WebElement productInTheTrolley = driver.findElement(productInTheTrolleyLocator);
        itemInTheTrolley= productInTheTrolley.getAttribute("innerHTML");
        Assert.assertTrue(itemInTheTrolley.contains(productName));
    }

    public void increaseProductQuantity(int quantity){
        this.quantity=quantity;
        Select quantityDropdown = new Select(driver.findElement(quantityDropdownLocator));
        quantityDropdown.selectByVisibleText(String.valueOf(quantity));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void subTotalUpdate(){
        WebElement subTotal = driver.findElement(subTotalLocator);
        subTotalWithCurrencySymbol=subTotal.getText();
        subTotalWithoutCurrencySymbol = subTotalWithCurrencySymbol.replaceAll("[^\\d.]", "");
        updatedSubTotal = Float.parseFloat(subTotalWithoutCurrencySymbol);
        calculatedSubTotal=(SearchResultsPage.costPrice)*quantity;
        Assert.assertEquals(updatedSubTotal,calculatedSubTotal);
    }

}

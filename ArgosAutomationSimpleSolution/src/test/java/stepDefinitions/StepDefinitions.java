package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;

public class StepDefinitions {

    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    TrolleyPage trolleyPage;

    @Before
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^I am on the Argos website$")
    public void iAmOnTheArgosWebsite() {
        homePage = new HomePage(driver);
        homePage.homePageNav();
    }

    @When("^I search for \\\"(.*?)\\\"$")
    public void iSearchForTheProduct(String productName) {
        homePage.searchProduct(productName);
    }

    @Then("^I should see search results containing \\\"(.*?)\\\"$")
    public void iShouldSeeSearchResultsContainingProduct(String productName) {
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.verifySearchResultsPage(productName);
    }

    @When("^I add the first product to the basket")
    public void iAddTheFirstProductToTheBasket() {
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.addProductToBasket();
    }

    @Then("^I should see \\\"(.*?)\\\" in the basket$")
    public void iShouldSeeProductInTheBasket(String productName) {
        trolleyPage = new TrolleyPage(driver);
        trolleyPage.verifyProductNameInBasket(productName);
    }

    @And("I increase the quantity by {int}")
    public void increaseTheQuantity(int quantity) {
        trolleyPage = new TrolleyPage(driver);
        trolleyPage.increaseProductQuantity(quantity);
    }

    @Then("the subtotal should be updated accordingly")
    public void theSubtotalShouldBeUpdatedAccordingly() {
        trolleyPage.subTotalUpdate();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class AddingToCart {
    private static WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Test
    public void testAmountOfAddedItemsToCart()  throws InterruptedException {
        webDriver.get("https://www.alexandermcqueen.com/en-us/boots/hybrid-chelsea-boot-586198WHX521000.html");
        String EXPECTED_AMOUNT = "1";

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(
                "onetrust-accept-btn-handler"))).click();

        WebElement openSelectSize = webDriver.findElement(By.xpath(
                "//select[@data-action='selectProductSize']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(openSelectSize));
        openSelectSize.click();

        WebElement buttonSize = webDriver.findElement(By.xpath(
                "//option[@data-attr-value='44']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonSize));
        buttonSize.click();

        Thread.sleep(1000);

        WebElement buttonAddToCart = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//button[@data-action='addProductToCart']")));
        buttonAddToCart.click();

        WebElement amountOfProductsInCart = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//span[@class='c-minicart__quantity']")));

        Assert.assertEquals(amountOfProductsInCart.getText(), EXPECTED_AMOUNT);
    }

    @Test
    public void testCheckingSize()  throws InterruptedException {
        webDriver.get("https://www.alexandermcqueen.com/en-us/boots/hybrid-chelsea-boot-586198WHX521000.html");
        String EXPECTED_SIZE = "44";

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(
                "onetrust-accept-btn-handler"))).click();

        WebElement openSelectSize = webDriver.findElement(By.xpath(
                "//select[@data-action='selectProductSize']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(openSelectSize));
        openSelectSize.click();

        WebElement buttonSize = webDriver.findElement(By.xpath(
                "//option[@data-attr-value='44']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonSize));
        buttonSize.click();

        Thread.sleep(1000);

        WebElement buttonAddToCart = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//button[@data-action='addProductToCart']")));
        buttonAddToCart.click();

        WebElement buttonOpenCart = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//a[@data-action='cartShowLink']")));
        buttonOpenCart.click();

        WebElement sizeOfItem = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//div[@data-ref='lineItemSizeValue']")));

        Assert.assertEquals(sizeOfItem.getText(), EXPECTED_SIZE);
    }

    @Test
    public void testCheckingName()  throws InterruptedException {
        webDriver.get("https://www.alexandermcqueen.com/en-us/boots/hybrid-chelsea-boot-586198WHX521000.html");
        String EXPECTED_NAME = "HYBRID CHELSEA BOOT";

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(
                "onetrust-accept-btn-handler"))).click();

        WebElement openSelectSize = webDriver.findElement(By.xpath(
                "//select[@data-action='selectProductSize']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(openSelectSize));
        openSelectSize.click();

        WebElement buttonSize = webDriver.findElement(By.xpath(
                "//option[@data-attr-value='44']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonSize));
        buttonSize.click();

        Thread.sleep(1000);

        WebElement buttonAddToCart = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//button[@data-action='addProductToCart']")));
        buttonAddToCart.click();

        WebElement buttonOpenCart = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//a[@data-action='cartShowLink']")));
        buttonOpenCart.click();

        WebElement sizeOfItem = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//a[@data-ref='lineitemName']")));

        Assert.assertEquals(sizeOfItem.getText(), EXPECTED_NAME);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        webDriver.quit();
        webDriver = null;
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SizeCheck {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Lab9\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testCheckingSize() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1600, 1000));
        driver.get("https://www.alexandermcqueen.com/en-us/boots/hybrid-chelsea-boot-586198WHX521000.html");
        wait.until(ExpectedConditions.elementToBeClickable(By.id(
                "onetrust-accept-btn-handler"))).click();
        Thread.sleep(1000);
        WebElement selectSizeOpener = driver.findElement(By.xpath(
                "//*[@id=\"main-content\"]/div/div[8]/div[2]/div/div/div/div[2]/div[4]/select"));
        wait.until(ExpectedConditions.elementToBeClickable(selectSizeOpener)).click();
        Thread.sleep(1000);
        WebElement selectSize = driver.findElement(By.xpath(
                "//*[@id=\"main-content\"]/div/div[8]/div[2]/div/div/div/div[2]/div[4]/select/option[12]"));
        wait.until(ExpectedConditions.elementToBeClickable(selectSize)).click();
        Thread.sleep(1000);
        WebElement addToCart = driver.findElement(By.xpath(
                "//*[@id=\"addToCartBtn\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
        Thread.sleep(7000);
        WebElement clothCart = driver.findElement(By.xpath(
                "//*[@id=\"minicart\"]/div[1]/a/i"));
        wait.until(ExpectedConditions.elementToBeClickable(clothCart)).click();
        WebElement viewCart = driver.findElement(By.xpath(
                "/html/body/div[4]/div[3]/div/div[2]/div/div[2]/div[4]/div/div[4]/div[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[@id=\"main-content\"]/div/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")).getText(),"44");
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
        driver = null;
    }
}

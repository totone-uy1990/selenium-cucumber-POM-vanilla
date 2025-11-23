package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    private static ChromeOptions options;

    //WebDriverWait genera una espera pero devuelve un Webdriver con esa espera
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    static {
        options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    //identifica si es css selector o xpath selector
    private static By getBy(String locator) {
        locator = locator.trim();

        // Detecta si es XPath
        if (locator.startsWith("/") || locator.startsWith("(")) {
            return By.xpath(locator);
        }
        // Caso contrario, CSS
        else {
            return By.cssSelector(locator);
        }
    }

    //retorna un WebElemnt pero primero usa una espera para localizarlo
    private WebElement find(String locator) {
        //el by indica que locator usar

        return wait.until(ExpectedConditions.presenceOfElementLocated(getBy(locator))); //retorna el webdriver con el locator
    }

    public void clickElement(String locator) {
        find(locator).click();
    }


    public static void closeBrowser() {
        driver.quit();
    }


    public void write(String locator, String keysToSend) {
        find(locator).clear();
        find(locator).sendKeys(keysToSend);
    }

    //DROPDOWNS
    //by value
    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(value);

    }

    //by index
    public void selectFromDropdownByIndex(String locator, int Index) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(Index);
    }

    //pick Size
    public int dropdownSize(String locator) {
        Select dropdown = new Select(find(locator));
        List<WebElement> dropdownelements = dropdown.getOptions();
        return dropdownelements.size();
    }

    public void selectFromDropDown(String locator, String text) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(text);
    }

}




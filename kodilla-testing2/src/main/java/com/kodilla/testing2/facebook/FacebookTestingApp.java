package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {

    public static final String XPATH_COOKIE = "//button[contains(@data-testid, \"cookie-policy-dialog-accept-button\")]";
    public static final String XPATH_NEW_ACCOUNT = "//a[contains(@data-testid, \"open-registration-form-button\")]";
    public static final String XPATH_FORM = "/html//form[@id=\"reg\"]";
    public static final String XPATH_DAY = "//select[@id=\"day\"]";
    public static final String XPATH_MONTH = "//select[@id=\"month\"]";
    public static final String XPATH_YEAR = "//select[@id=\"year\"]";
    public static final WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);

    public static void main(String[] args) {
        driver.get("https://www.facebook.com/");

        WebElement cookieButton = driver.findElement(By.xpath(XPATH_COOKIE));
        cookieButton.click();

        WebElement newAccountButton = driver.findElement(By.xpath(XPATH_NEW_ACCOUNT));
        newAccountButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_FORM)));

        fillFormElement("firstname", "firstname");
        fillFormElement("lastname", "lastname");
        fillFormElement("reg_email__", "email@email");
        fillFormElement("reg_passwd__", "password");
        selectElement(XPATH_DAY, 0);
        selectElement(XPATH_MONTH, 10);
        selectElement(XPATH_YEAR, 32);

        WebElement element = driver.findElement(By.xpath(XPATH_FORM.concat("//input[@name=\"sex\" and @value = \"1\"]")));
        element.click();
    }

    private static void selectElement(String xpath, int index){
        WebElement element = driver.findElement(By.xpath(xpath));
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    private static void fillFormElement(String inputName, String inputValue) {
        WebElement element = driver.findElement(By.xpath(XPATH_FORM.concat("//input[@name=\"" + inputName + "\"]")));
        element.sendKeys(inputValue);
    }
}

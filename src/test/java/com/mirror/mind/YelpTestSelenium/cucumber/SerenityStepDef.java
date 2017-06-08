package com.mirror.mind.YelpTestSelenium.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;

class SerenityStepDef {

    private WebDriver webDriver;

    void initializeDriver(WebDriver driver) {
        this.webDriver = driver;
    }

    @Step
    void nevigateTo(String url) {
        webDriver.get(url);
    }

    @Step
    void SelectRestaurant(String restaurant) {
        WebElement restaurantEl = webDriver.findElement(By.id(restaurant));
        restaurantEl.click();
    }

    @Step
    void clickOnSearchButton(String searchButton) {
        WebElement searchButtonEl = webDriver.findElement(By.xpath(searchButton));
        searchButtonEl.click();
    }

    @Step
    @Screenshots(afterEachStep = true)
    void enterPizzaInTextField(String pizza, String idField) {
        WebElement googleTextBox = webDriver.findElement(By.id(idField));
        googleTextBox.sendKeys(pizza);
    }

    @Step
    void clickOnToggleButton(String jScript) throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) webDriver;
        javaScriptExecutor.executeScript("document.getElementsByClassName('" + jScript + "')[0].click()");
    }

    @Step
    void applyFilter(String filter) throws InterruptedException {
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) webDriver;
        javaScriptExecutor.executeScript("document.querySelectorAll(\"input[value='" + filter + "']\")[0].checked = true");
    }

    @Step
    void logMessage(String value) {

    }

}

package com.mirror.mind.YelpTestSelenium.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class loginStepDef extends AbstractStepDefinition {

    @Managed(driver = "chrome", uniqueSession = true)
    private WebDriver driver;

    @Steps
    private SerenityStepDef stepDef;

    @Before
    public void setup() {
        if(System.currentTimeMillis()< 1499504976000L)
        stepDef.initializeDriver(driver);
    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String url) {
        stepDef.nevigateTo(url);
    }

    @When("^I click on element having id \"([^\"]*)\"$")
    public void iClickOnElementHavingId(String searchButton){
        stepDef.SelectRestaurant(searchButton);
    }

    @When("^I enter \"([^\"]*)\" into input field having id \"([^\"]*)\"$")
    public void iEnterIntoInputFieldHavingId(String text, String idField) {
       stepDef.enterPizzaInTextField(text,idField);
    }

    @And("^click on profile xpath \"([^\"]*)\"$")
    public void clickOnProfileXpath(String xpath) {
        stepDef.clickOnSearchButton(xpath);
    }

    @And("^I enter \"([^\"]*)\" into input field having name \"([^\"]*)\"$")
    public void iEnterIntoInputFieldHavingName(String password, String idField) {
        WebElement googleTextBox = driver.findElement(By.id(idField));
        googleTextBox.sendKeys(password);
    }



    @And("^I have clicke on element having class name \"([^\"]*)\"$")
    public void iHaveClickeOnElementHavingClassName(String className) {
        WebElement searchButton = driver.findElement(By.className(className));
        searchButton.click();
    }

    @And("^get value of class \"([^\"]*)\"$")
    public void getValueOfClass(String className) {
        WebElement resultEl = driver.findElement(By.className(className));
        stepDef.logMessage(resultEl.getText());
    }

    @And("^I execute java script for all fillters toggle$")
    public void iExecuteJavaScriptForAllFilltersToggle() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        javaScriptExecutor.executeScript("document.getElementsByClassName('all-filters-toggle')[0].click()");
    }

    private void temp() {
        driver.findElement(By.name(""));
    }

    @And("^I click on elemet having name \"([^\"]*)\"$")
    public void iClickOnElemetHavingName(String name) {
        WebElement searchButton = driver.findElement(By.className(name));
        searchButton.click();
    }

    @And("^I execute java script \"([^\"]*)\"$")
    public void iExecuteJavaScript(String jScript) throws InterruptedException {
        stepDef.clickOnToggleButton(jScript);
    }

    @And("^I apply first filter$")
    public void iExecute() throws InterruptedException {
       stepDef.applyFilter("CA:San_Francisco::SoMa");
    }

    @And("^I apply second filter$")
    public void iExecuteSecond() throws InterruptedException {
        stepDef.applyFilter("italian");
    }

    @And("^get value of stars$")
    public void getStars() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        String str = (String) javaScriptExecutor.executeScript("var sRating=\"\";\n" +
                "for(var i=0;i<10;i++)\n" +
                "{\n" +
                "sRating += document.querySelectorAll(\".i-stars\")[i].title + \"\\n\"  \n" +
                "}\n" +
                "return(sRating);");
        stepDef.logMessage("Stars " + str);
    }


    @And("^I execute java script for1 \"([^\"]*)\"$")
    public void iExecuteJavaScriptFor(String jScript) throws InterruptedException {
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        String str = (String) javaScriptExecutor.executeScript("document.querySelectorAll(\""+jScript+"\")[0].innerText");
        stepDef.logMessage(str);
    }

    @And("^I execute java script for2 \"([^\"]*)\"$")
    public void iExecuteJavaScriptFor2(String jScript) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Script: " + jScript);
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        String str = (String) javaScriptExecutor.executeScript(jScript);
        System.out.println(" : " + str);
    }

    @And("^I execute java script for3 \"([^\"]*)\"$")
    public void iExecuteJavaScriptFor3(String jScript) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Script: " + jScript);
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        String str = (String) javaScriptExecutor.executeScript(jScript);
        System.out.println(" : " + str);
    }

    @And("^I execute for review$")
    public void iExecuteForReview() {
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        String str = (String) javaScriptExecutor.executeScript("var sRating=\"\";\n" +
                "for(var i=0;i<3;i++)\n" +
                "{\n" +
                "sRating +=  document.querySelectorAll(\".review-content p\")[i].innerText + \"\\n\"  \n" +
                "sRating +=\"******************************************************\\n\" \n" +
                "}\n" +
                "return(sRating);");
        stepDef.logMessage(str);
    }
}

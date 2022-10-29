package com.project.commons;

import com.project.Pages.CommonPage;
import com.project.Pages.HomePage;
import com.project.Pages.LoginPage;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class CommonLib {
    public CommonPage myPage;
    public WebDriver myDriver;
    public WebDriverWait webDriverWait;
    public int defaultTimeout=10;


    public CommonLib(WebDriver driver) {
        myDriver = driver;
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(defaultTimeout));
        webDriverWait=new WebDriverWait(myDriver,Duration.ofSeconds(defaultTimeout));
    }

    public By findElementLocator(String element) {
        By locator = null;

        try {
            locator = myPage.elements.get(element);
        } catch (Exception e) {
            if (locator == null) {
                locator = myPage.commonElements.get(element);
            }
        }
        return locator;
    }

    public void seePage(String page) {
        if (page.equalsIgnoreCase("HomePage")) {
            myPage = new CommonPage(new HomePage().elements);
            allureReport(StepResultType.PASS, "Sayfa bulundu: HomePage", false);
        } else if (page.equalsIgnoreCase("LoginPage")) {
            myPage = new CommonPage(new LoginPage().elements);
            allureReport(StepResultType.PASS, "Sayfa bulundu: LoginPage", false);
        } else {
            allureReport(StepResultType.FAIL, "Sayfa bulunamadı", false);
        }
    }

    public void ıGoToUrl(String url) {
        try {
            myDriver.navigate().to(url);
            allureReport(StepResultType.PASS, "Url opened successfully", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, "Url could not opened successfully", true);
        }

    }

    public void sendKeys(String element, String text) {
        try {
            myDriver.findElement(findElementLocator(element)).sendKeys(text);
            allureReport(StepResultType.PASS, "Text send text area", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, "Text could not send successfully", true);
        }
    }

    public void sleep(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
        allureReport(StepResultType.PASS, "Sleep", false);
    }

    public void clickElementWaitUntilClickable(String element) {
        try{
            webDriverWait.until(ExpectedConditions.elementToBeClickable(findElementLocator(element))).click();
            allureReport(StepResultType.PASS, "Clicked to element.", true);
        }catch (Exception e){
            allureReport(StepResultType.FAIL, "Could not click to element.", true);
        }


    }

    public void clickElement(String element) {
        try{
            myDriver.findElement(findElementLocator(element)).click();
            allureReport(StepResultType.PASS, "Clicked to element.", true);
        }catch (Exception e){
            allureReport(StepResultType.FAIL, "Could not click to element.", true);
        }


    }

    public void waitElementAndCheckVisibility(String element){
        try{
           webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(findElementLocator(element)));
            allureReport(StepResultType.PASS, "Element is found", true);
        }catch (Exception e){
            allureReport(StepResultType.FAIL, "Element is not found", true);
        }
    }

    public void waitElement(String element){
        try{
            myDriver.findElement(findElementLocator(element));
            allureReport(StepResultType.PASS, "Element is found", true);
        }catch (Exception e){
            allureReport(StepResultType.FAIL, "Element is not found", true);
        }
    }

    public void clickKeyboard(String element,String key) {
        WebElement elem=  webDriverWait.until(ExpectedConditions.elementToBeClickable(findElementLocator(element)));

        if(key.equalsIgnoreCase("ENTER"))
        {
            elem.sendKeys(Keys.ENTER);
            allureReport(StepResultType.PASS, "Clicked to "+key, true);
        }
        else if(key.equalsIgnoreCase("TAB"))
        {
            elem.sendKeys(Keys.TAB);
            allureReport(StepResultType.PASS, "Clicked to "+key, true);
        }
    }

    public void allureReport(StepResultType result, String message, boolean ssFlag) {
        try {
            System.out.println(message);
            if (ssFlag) {
                Allure.addAttachment("ScreenShot: " + message, new ByteArrayInputStream(((TakesScreenshot) myDriver).getScreenshotAs(OutputType.BYTES)));
            }

            if (result.toString().equalsIgnoreCase("PASS")) {
                Allure.step(message, Status.PASSED);
            } else if (result.toString().equalsIgnoreCase("INFO")) {
                Allure.step(message, Status.SKIPPED);
            } else if (result.toString().equalsIgnoreCase("FAIL")) {
                Allure.step(message, Status.FAILED);
                Assert.fail(message);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

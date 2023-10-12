package com.project.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static java.util.Map.entry;

public class Test {
    public static void main(String[] args) {
       WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        edgeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }



//        public static void main(String[] args) {
//            //WebDriverManager.iedriver().setup();
//            System.setProperty("webdriver.ie.driver", "C:\\Users\\guray\\IdeaProjects\\MySelenium4FrameworkTestNG\\src\\test\\java\\IEDriverServer.exe");
//
//            InternetExplorerOptions ieOptions = new InternetExplorerOptions();
//            ieOptions.attachToEdgeChrome();
//            ieOptions.withEdgeExecutablePath("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
//
//            WebDriver driver = new InternetExplorerDriver(ieOptions);
//
//            driver.get("http://www.bing.com");
//            WebElement elem = driver.findElement(By.id("sb_form_q"));
//            elem.sendKeys("WebDriver", Keys.RETURN);
//
//
//
//    }
}

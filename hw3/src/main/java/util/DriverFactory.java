package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static WebDriver driver;
    static Properties properties;


    public static WebDriver initialize_Driver(String browser){
        properties = ConfigReader.getProperties();
        if (browser.equals("Chrome")) {
            //Setting options to avoid automation detection
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled"); //Removes the detection
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); //Removes the banner
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);   //Create the driver with the options
        } else if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            //Setting options to avoid automation detection
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled"); //Removes the detection
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); //Removes the banner
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);   //Create the driver with the options
        }
        String url = properties.getProperty("url");
        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(impWait, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(pageWait, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }


}

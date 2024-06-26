package bdd.webdriver;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class DOM {

    static String screenshotDir = "/Users/waldirmarquezespiritu/Documents/Workspace/Selenium/Mi_Primer_Script_Web/src/test/resources/evidencias";
    private static WebDriver driver;

    public static WebDriver webDriver(){
        if(driver == null) {
            String chromeDriverPath = "/Users/waldirmarquezespiritu/Documents/Workspace/Selenium/Mi_Primer_Script_Web/src/test/resources/webdriver/chromedriver";
            System.setProperty("webdriver.chromedriver", chromeDriverPath);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public DOM(){
        PageFactory.initElements(webDriver(), this);
    }

    public static void iniciarNavegador(String url){
        webDriver().get(url);
        webDriver().manage().window().maximize();
    }

    public void takeScreenShot(Scenario scenario) {
        try{
           final byte[] screenshot = ((TakesScreenshot) webDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot, "image/png", "Captura de pantalla");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClick(WebElement element){
        element.click();
    }

    public void type(WebElement element, String txt){
        element.sendKeys(txt);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void quitDriver(){
        webDriver().quit();
    }

}

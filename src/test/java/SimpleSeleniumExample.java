import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class SimpleSeleniumExample {
    public static void main(String[] args) {

        // Configura el controlador de Selenium
        System.setProperty("webdriver.chromedriver", "/Users/waldirmarquezespiritu/Documents/Workspace/Selenium/Mi_Primer_Script_Web/src/test/resources/webdriver/chromedriver");

        // Inicializa el controlador
        WebDriver driver = new ChromeDriver();

        // Define un objeto Duration para WebDriverWait
        Duration timeout = Duration.ofSeconds(10); // 10 segundos de espera

        // Usa el objeto Duration para crear WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        // Ruta para las capturas de pantalla
        String screenshotDir = "/Users/waldirmarquezespiritu/Documents/Workspace/Selenium/Mi_Primer_Script_Web/src/test/resources/evidencias";

        // Abre URL y maximiza la ventana
        driver.get("https://buggy.justtestit.org/");
        driver.manage().window().maximize();

        // Usa WebDriverWait para esperar por elementos
        WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Register']")));
        register.click();

        // Espera por los elementos en la página de registro
        WebElement inputLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        inputLogin.click();
        inputLogin.sendKeys("waldirmarquez");

        WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("form-control ng-untouched ng-pristine ng-invalid")));
        firstname.click();
        firstname.sendKeys("Waldir");

//
//        WebElement lastname = driver.findElement(By.name("lastname"));
//        lastname.click();
//        lastname.sendKeys("Marquez");
//
//        WebElement password = driver.findElement(By.name("password"));
//        password.click();
//        password.sendKeys("123456");
//
//        WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
//        confirmPassword.click();
//        confirmPassword.sendKeys("123456");
//
//        WebElement btnRegister = driver.findElement(By.className("btn btn-default"));
//        btnRegister.click();
//        //Realiza acciones y toma captura de pantalla
//        takeScreenShot(driver, screenshotDir, "screenshot2.png");
//
//
//        //Paso 2: Inicio sesión
//        WebElement inputUsuario = driver.findElement(By.name("login"));
//        WebElement inputPassword = driver.findElement(By.name("password"));


        //Paso 4: Almacenar el valor de la página web (Resultado Obtenido)
//        WebElement lblResultado = driver.findElement(By.xpath("//*[contains(text(),'Results')]"));
//        String resultadoObtenido = lblResultado.getText();
//        String resultadoEsperado = "Result";


        //Validación de resultado obtenido vs resultado esperado
//        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
        //Realiza acciones y toma captura de pantalla
//        takeScreenShot(driver, screenshotDir, "screenshot1.png");

        //Cierra el navegador
         driver.quit();
    }

        public static void takeScreenShot(WebDriver driver, String screenshotDir, String fileName){
        //Toma la caputra de pantalla
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //Define la ruta de almacenamiento
        String destinationPath = screenshotDir + fileName;

        //Copia el archivo a la ubicación deseada
        try {
            FileUtils.copyFile(screenshotFile, new File(destinationPath));
            System.out.println("Captura de pantalla guardada con éxito");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la captura de pantalla");
            throw new RuntimeException(e);
        }

    }



}

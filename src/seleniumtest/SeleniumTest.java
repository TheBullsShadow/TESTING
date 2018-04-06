/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumtest;

import java.net.URL;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;

public class SeleniumTest {
    static WebDriver driver;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Android_Accelerated_Nougat");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", "C:\\Users\\bulld\\Downloads\\selendroid-test-app-0.17.0.apk");
        //AndroidDriver driver = new AndroidDriver(new URL("http:// 0.0.0.0:4723/wd/hun"), caps);
        
        //System.setProperty("webdriver.gecko.driver","C:\\Users\\bulld\\Desktop\\Selenium Webdriver\\geckodriver.exe");//FireFox
        //driver = new FirefoxDriver();
        
        //System.setProperty("webdriver.ie.driver","C:\\Users\\bulld\\Desktop\\Selenium Webdriver\\IEDriverServer.exe");//IE
        //driver = new InternetExplorerDriver();
        
        //System.setProperty("webdriver.edge.driver","C:\\Users\\bulld\\Desktop\\Selenium Webdriver\\MicrosoftWebDriver.exe");//Edge
        //driver = new EdgeDriver();
        
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\bulld\\Desktop\\Selenium Webdriver\\Drivers\\chromedriver.exe");//Crome
        //driver = new ChromeDriver();
    }
    
    public static void setup() 
    {
        //System.setProperty("webdriver.gecko.driver","C:\\Users\\bulld\\Desktop\\Selenium Webdriver\\geckodriver.exe");//FireFox
        //System.setProperty("webdriver.ie.driver","C:\\Users\\bulld\\Desktop\\Selenium Webdriver\\IEDriverServer.exe");//IE
        //System.setProperty("webdriver.edge.driver","C:\\Users\\bulld\\Desktop\\Selenium Webdriver\\MicrosoftWebDriver.exe");//Edge
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\bulld\\Desktop\\Selenium Webdriver\\Drivers\\chromedriver.exe");//Crome

        driver = new FirefoxDriver();
        //driver = new InternetExplorerDriver();
        //driver = new EdgeDriver();
        //driver = new ChromeDriver();
    }
    
    public static void loadstartSite() throws InterruptedException
    {
        driver.get("https://ptc.careerscope.org/");
        //driver.manage().window().maximize();
        WebElement link;
        link = driver.findElement(By.name("goto_evaluee_login"));
        link.click();
        Thread.sleep(2000);
    }
    
    public static void switchScreens() throws InterruptedException
    {
        //Soultion 1
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        
        
        //Solution 2
        Set<String> handlers = driver.getWindowHandles();
        
        for(String handle : handlers)
        {
            driver.switchTo().window(handle);
            if(driver.getCurrentUrl().contains("https://ptc.careerscope.org/sessions/evaluee_login?from=session_create"))
            {
                //run test
            }
        }
        
        Thread.sleep(2000);
    }
    
    public static void enterLoginInfo(String uName, String pass)
    {
        WebElement username = driver.findElement(By.id("login"));
        username.sendKeys(uName);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);
        WebElement loginbtn = driver.findElement(By.name("evaluee_login"));
        loginbtn.click();
    }
    
    public static void enterRefInfo(String uName, String pass) throws InterruptedException
    {
        WebElement register = driver.findElement(By.name("goto_evaluee_reg"));
        register.click();
        
        Thread.sleep(2000);
        
        WebElement username = driver.findElement(By.name("logon_name"));
        username.sendKeys(uName);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(pass);
        WebElement repassword = driver.findElement(By.name("password_confirmation"));
        repassword.sendKeys(pass);
        WebElement registerbtn = driver.findElement(By.name("Register"));
        registerbtn.click();
        
        Thread.sleep(1000);
    }
    
    public static void enterDemInfo(String fName, String lName, String birthMonth, String birthDay, String birthYear, String edu, String special) throws InterruptedException
    {
        WebElement test = driver.findElement(By.id("timeout_container"));
        System.out.println(test.getLocation() + " " + test.getSize());
        WebElement fname = driver.findElement(By.id("timeout_container")).findElement(By.id("myEvaluee_first_name"));
        fname.sendKeys(fName);
        WebElement lname = driver.findElement(By.id("timeout_container")).findElement(By.id("myEvaluee_last_name"));
        lname.sendKeys(lName);
        WebElement month = driver.findElement(By.id("timeout_container")).findElement(By.id("myEvaluee_birthdate_2i"));
        month.sendKeys(birthMonth);
        WebElement day = driver.findElement(By.id("timeout_container")).findElement(By.id("myEvaluee_birthdate_3i"));
        day.sendKeys(birthDay);
        WebElement year = driver.findElement(By.id("timeout_container")).findElement(By.id("myEvaluee_birthdate_1i"));
        year.sendKeys(birthYear);
        WebElement school = driver.findElement(By.id("timeout_container")).findElement(By.id("myEvaluee_enrolled_n"));
        school.click();
        WebElement education = driver.findElement(By.id("timeout_container")).findElement(By.id("myEvaluee_highest_level"));
        education.sendKeys(edu);
        WebElement specialist = driver.findElement(By.id("timeout_container")).findElement(By.id("myEvaluee_specialist_id"));
        specialist.sendKeys(special);
        WebElement done = driver.findElement(By.id("timeout_container")).findElement(By.id("regdone"));
        done.click();
    }
    
    public static void close()
    {
        driver.close();
    }
    
}

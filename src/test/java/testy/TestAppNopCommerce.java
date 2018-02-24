package testy;


import net.sf.jasperreports.engine.xml.JRPenFactory;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import javax.xml.registry.infomodel.EmailAddress;
import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.Random;

import static org.junit.Assert.*;

public class TestAppNopCommerce {

    private WebDriver driver;

    @Before
    public void setUp() {


        System.setProperty("webdriver.chrome.driver", "/home/waldemar/Downloads/SeleniumWebdriver/demo_nopcommerce_com/src/main/resources/chromedriver");
        driver = new ChromeDriver();


    }

    @Test
    public void registerNopCommerce() {
        driver.get("http://demo.nopcommerce.com/register");

        WebElement singleRadioButton = driver.findElement(By.xpath("//*[@id='gender-male']"));

        if (!singleRadioButton.isSelected())
            singleRadioButton.click();

        assertTrue("Radio button is not selected", singleRadioButton.isSelected());


        WebElement Firstname = driver.findElement(By.xpath("//*[@id='FirstName']"));
        Firstname.sendKeys("Waldemar");
        //assertEquals("Name", checkFieldName.getAttribute("value"));

        WebElement LastName = driver.findElement(By.xpath("//*[@id='LastName']"));
        LastName.sendKeys("Mozola");
        //fieldLastName.sendKeys("Lastname" + randomStringFiveChar);


        Select chooseMonthDob = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        chooseMonthDob.selectByValue("7");

        Select chooseDayDob = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        chooseDayDob.selectByValue("17");

        Select chooseYearDob = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        chooseYearDob.selectByValue("2000");

        WebElement fieldEmail = driver.findElement(By.xpath("//input[@id='Email']"));
        fieldEmail.sendKeys(UUID.randomUUID()+"test9@testowy.com");


       WebElement Companyfield = driver.findElement(By.xpath("//input[@id='Company']"));
       Companyfield.sendKeys("Justus");


        WebElement checkBox = driver.findElement(By.xpath("//input[@id='Newsletter']"));
        if (!checkBox.isSelected())
            checkBox.click();



        WebElement fieldPassword = driver.findElement(By.xpath("//input[@id='Password']"));
        fieldPassword.sendKeys("pass" + new Random().doubles());

       WebElement fieldConfirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
       fieldConfirmPassword.sendKeys("pass" + new Random().doubles());

        WebElement fieldSubmit = driver.findElement(By.xpath("//input[@id='register-button']"));
        fieldSubmit.click();

    }

    @Test
    public void signIn() {
        driver.get("http://demo.nopcommerce.com/login");

        WebElement userLoginFieldElement = driver.findElement(By.xpath("//input[@id='Email']"));
        userLoginFieldElement.sendKeys("michalpiotrowski@test.pl");

        WebElement userPasswordFieldElement = driver.findElement(By.xpath("//input[@id='Password']"));
        userPasswordFieldElement.sendKeys("razdwatrzy123");

        WebElement loginFieldElement = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginFieldElement.click();

        WebElement loginFieldElement1 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        assertTrue("Button is not displayed.", loginFieldElement1.isDisplayed());
    }




    @After
        public void tearDown () {
            driver.close();
        }
    }



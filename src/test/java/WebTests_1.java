import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WebTests_1 {

    @Test
    public void TestCase_11_1_testTheTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement rightAngleLogo = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='header']/h1"));
        String actualResult = rightAngleLogo.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void TestCase_11_02_checkTheTitleSubmitNewLanguage() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit new Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));
        String actualResult = submitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        // driver.quit();
    }

    @Test
    public void TestCase_11_03_CheckSubtitleSubmitNewLanguage() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement menuSubmitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));

        menuSubmitNewLanguage.click();

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']"));

        String actualResult = submitNewLanguage.getText().trim().toUpperCase();
        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        driver.quit();
    }

    @Test
    public void TestCase_11_04_ConfirmTheSubtitle0_9() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver, "C://chromeDriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubtitle0_9 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']".trim()));

        // WebElement menuSubtitle0_9 = driver.findElement(
        //         By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[text()='0-9']"));
        String actualResult = menuSubtitle0_9.getText();
        Thread.sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);

        //driver.quit();
    }

    @Test
    public void TestCase_11_06_confirmNames() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult1 = "Oliver Schade";
        String expectedResult2 = "Gregor Scheithauer";
        String expectedResult3 = "Stefan Scheler";
        final String[] expectedResult = {"Oliver Schade" +
                "Gregor Scheithauer",
                "Stefan Scheler"};

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement menuTeam = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));
        menuTeam.click();

        WebElement creatorNames = driver.findElement(
                By.xpath("//body/div[@id='wrap']//div[@id='main']/h3[text()='Oliver Schade']"));

        String actualResult1 = creatorNames.getText();

        WebElement creatorNames2 = driver.findElement(
                By.xpath("//body/div[@id='wrap']//div[@id='main']/h3[text()='Gregor Scheithauer']"));
        String actualResult2 = creatorNames2.getText();
        WebElement creatorNames3 = driver.findElement(
                By.xpath("//body/div[@id='wrap']//div[@id='main']/h3[text()='Stefan Scheler']"));
        String actualResult3 = creatorNames3.getText();

        WebElement[] names = new WebElement[3];
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(driver.findElement(
                    By.xpath("//body/div[@id='wrap']/div[@id='main']/h3")))) ;
        }


        //   String actualResult = names.getText();

        //Assert.assertEquals;
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }

    @Test
    public void TestCase_11_07_04_findJava() {
        String chromeDrive = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "New Search";

        System.setProperty(chromeDrive, driverPath);
        WebDriver driver = new ChromeDriver();


        driver.get(url);
        driver.manage().window().maximize();
        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/search.html']"));
        menuBrowseLanguages.click();

        WebElement searchButton = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/form[@id='searchlanguages']/p/input[contatains(@name,'submitsearch')]"));
        WebElement searchBox = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/form[@id='searchlanguages']/p/input[contains(@name,'search')]"));

        searchBox.sendKeys("Java");
        searchButton.click();

        WebElement findNewSearch = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./search.html']"));

        String actualResult = findNewSearch.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void TestCase_11_11_Check_Submit_Language_Error() throws AWTException {

        String chromeDriver = "webdriver.chrome.driver";
        String drivePath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        Boolean expectedResult = true;

        System.setProperty(chromeDriver, drivePath);
        WebDriver driver = new ChromeDriver();


        driver.get(url);
        driver.manage().window().maximize();

        WebElement submitLanguageBTNKError = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@name='submitlanguage']"
                )
        );

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);

        submitLanguageBTNKError.click();

        WebElement openErrorPage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));

        Boolean actualResult = openErrorPage.isDisplayed();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void Test_Case_11_12_Check_Submit_Language_Error() throws InterruptedException, AWTException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        // String [] expectedResult = expectedResult.split(" ");

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();

        WebElement sumbitLngsBtnk = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@name='submitlanguage']"
                )
        );
        // Thread.sleep(1000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);

        sumbitLngsBtnk.click();
        Thread.sleep(1000);

        WebElement findErrorMsg = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));

        WebElement findError = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/p//[contains(text(),'Error: Precondition failed - Incomplete Input.']"));
        //String[] arrOfWordsFromError = findError.getText().split();
        /**  /E[contains(concat('
         ⦿', @A, '⦿'), '⦿w⦿')*/

        if (findError.getText().contains("E")) {

        }

        // Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void Test_Case_11_13_confirmTheText() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this form" +
                " (especially the language name and description), the easier it will be for us and the faster your " +
                "language will show up on this page. We don't have the time to mess around with fixing your " +
                "descriptions etc. Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();

        WebElement confirmText = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li[position()=1]"));

        String actualResult = confirmText.getText();

        Assert.assertEquals(actualResult, expectedResult);

        //    driver.quit();
    }

    @Test
    public void Test_Case_11_14_confirmBrowseLnggsTableContain_1_2() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String[] expectedResult = {"Language", "Author"};

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement browseLnggs = driver.
                findElement(
                        By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']"));

        browseLnggs.click();

        WebElement table1_Names = driver.
                findElement(
                        By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr/th[text()='Language']"));
        WebElement table2_Names = driver.
                findElement(
                        By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr/th[text()='Author']"));

        String[] actualResult = {table1_Names.getText(), table2_Names.getText()};

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void Test_Case_11_15_confirmMainMenuNoNewComments() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement topList = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/toplist.html']"));
        topList.click();

        WebElement newComments = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./newcomments.html']"));
        newComments.click();
        WebElement isNewCommentsEmpty = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h2[text()='New Comments']/following-sibling::p[1]"));
        String actualResult = isNewCommentsEmpty.getText();
        // if(isNewCommentsEmpty.getText().equals(expectedResult))
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void Test_Case_11_21_confirmFontOfWarningMsg() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html ";
        String expectedResult = "IMPORTANT";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        String bold = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li/span[@style='background-color:red;color: white']/b']")).getAttribute("style");


        //String actualResult = importantMsg.getCssValue("font-weight").concat(importantMsg.getCssValue("color"));
        //  /String actualResult1 = bold.getCssValue("font color");
//
        //   Assert.assertEquals(, expectedResult);

        driver.quit();
    }
}


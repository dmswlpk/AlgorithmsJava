import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_11_07_04TestAndFindJava {
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

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }
}

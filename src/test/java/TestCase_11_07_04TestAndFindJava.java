import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase_11_07_04TestAndFillContactInformation {
@Test
    public void finaJava(){
        String chromeDrive = "webdriver.chrome.driver";
        String drivePath = "/Applications/ChromeDriver/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "java";

        System.setProperty(chromeDrive, "C://chromeDriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(url);
        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/search.html']"));
        menuBrowseLanguages.click();

        WebElement searchBox = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/div[@id='searchlanguages']/p/input[@value_name='search']"));
        WebElement searchButton = driver.findElement(By.xpath(""));



    }
}

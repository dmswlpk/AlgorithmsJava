import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase_11_07_04TestAndFindJava {
@Test
    public void findJava(){
        String chromeDrive = "webdriver.chrome.driver";
        String drivePath = "C://chromeDriver.exe";
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
                By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='searchlanguages']/p/input[@name='search']"));
        WebElement searchButton = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='searchlanguages']/p/input[@name='submitsearch']"));
        searchBox.sendKeys("Java");
        searchButton.click();

     //   WebElement java = driver.findElement(
     //           By.xpath("body//div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr[@onmouseover='setPointer']/td[@bgcolor='#efefef']/a[@href='/language-java-3.html']"));
     //   java.click();
//
        //driver.quit();
    }
}

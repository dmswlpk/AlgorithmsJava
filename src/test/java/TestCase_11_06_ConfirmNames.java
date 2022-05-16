import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_11_06_ConfirmNames {
    @Test
    public void confirmNames() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/ChromeDriver/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult1 = "Oliver Schade";
        String expectedResult2 = "Gregor Scheithauer";
        String expectedResult3 = "Stefan Scheler";

        System.setProperty(chromeDriver, "C://chromeDriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement menuTeam = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));
        menuTeam.click();

        WebElement creatorNames = driver.findElement(
                By.xpath("//body/div[@id='wrap']//div[@id='main']/h3[1]"));
        String actualResult1 = creatorNames.getText();
        WebElement creatorNames2 = driver.findElement(
                By.xpath("//body/div[@id='wrap']//div[@id='main']/h3[2]"));
        String actualResult2 = creatorNames2.getText();
        WebElement creatorNames3 =driver.findElement(
                By.xpath("//body/div[@id='wrap']//div[@id='main']/h3[3]"));
        String actualResult3 = creatorNames3.getText();

        Assert.assertSame(actualResult1,expectedResult1);
        Assert.assertSame(actualResult2,expectedResult2);
        Assert.assertSame(actualResult3,expectedResult3);

        driver.quit();
    }
}

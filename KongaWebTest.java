import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebTest {

    private WebDriver driver;
@BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webDriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.konga.com");
        if (driver.getCurrentUrl().contains("https://www.konga.com"))
            System.out.println("Correct Webpage");
        else
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }

@Test (priority = 0)
    public void positiveLogin() throws InterruptedException{
        driver.findElement(By.id("username")).sendKeys("nedum44@mailnator.com");
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        String expectedPageUrl = "https://www.konga.com/";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            System.out.println("successful login");

}

@Test (priority = 1)
    public void Username() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a")).click();
        String expectedPageUrl = "https://www.konga.com/account/profile";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            System.out.println("Correct Username");
        else
            System.out.println("Wrong Username");

        Thread.sleep(5000);
    }

@Test (priority = 2)
    public void logOut() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
        String expectedPageUrl = "https://www.konga.com/";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            System.out.println("True PageUrl");
        else
            System.out.println("False PageUrl");
        Thread.sleep(5000);
    }

@Test (priority = 3)
    public void negativeEmail() throws InterruptedException{
        driver.findElement(By.id("username")).sendKeys("ned@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        System.out.println("The username or password you have entered is incorrect. Please try again.");

    }

@Test (priority = 4)
    public void negativePassword() throws InterruptedException{
        driver.findElement(By.id("username")).sendKeys("nedum44@mailnator.com");
        driver.findElement(By.id("password")).sendKeys("000000");
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        System.out.println("The username or password you have entered is incorrect. Please try again.");
    }

@Test (priority = 5)
    public void emptyField() throws InterruptedException{
        driver.findElement(By.id("username")).sendKeys( "  ");
        driver.findElement(By.id("password")).sendKeys("   ");
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        System.out.println("Please fill out this field");
}

@AfterTest
    public void closeBrowser() {
        driver.close();
        System.out.println("The driver has been closed.");
}

}

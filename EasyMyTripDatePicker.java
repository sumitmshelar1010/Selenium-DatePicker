package MainPackage.SeleniumChromeDriver.locators.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class EasyMyTripDatePicker {
    public static WebDriver driver;

    public static void selectSourceOrDestination(String CityName, String SourceOrDestination ) {
        List<WebElement> list = null;
        if (SourceOrDestination.equals("Source")) {

            driver.findElement(By.id("txtSrcCity")).sendKeys(CityName);
            list = driver.findElements(By.xpath("//ul[@id='srcNav']//child::li"));
        } else if (SourceOrDestination.equals("Destination")) {
            driver.findElement(By.id("txtDesCity")).sendKeys(CityName);
            list = driver.findElements(By.xpath("//ul[@id='desNav']//child::li"));
        }

        assert list != null;
        for (WebElement l : list) {
            if (l.getText().equals(CityName)) {

                l.click();
                break;
            }
        }
    }

    public static void selectMonthAndYear (String MonthORYear,String mmyy) {
        List<WebElement> monthAndYear= null;

        if (MonthORYear.equals("Month")) {
            monthAndYear = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']//child::span[@class='ui-datepicker-month']"));
        }
         else if (MonthORYear.equals("Year")) {
            monthAndYear = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']//child::span[@class='ui-datepicker-year']"));
        }
        assert monthAndYear != null;
        for (WebElement d : monthAndYear) {
            if (d.getText().equals(mmyy)) {
                d.click();
                break;
            }
        }
    }
   public static void selectDate (String date){
       /* List<WebElement> dt =null;*/
       List<WebElement> dt  = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//following::td"));
        for (WebElement w: dt){
            w.getText().equals(date);
            w.click();
            break;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.easemytrip.com/bus/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        selectSourceOrDestination("Mumbai","Source");
        selectSourceOrDestination("Ahmedabad","Destination");


        driver.findElement(By.id("datepicker")).click();
            String month="January";
            String year="2023";
            Thread.sleep(3000);
             String date = "5";
        selectMonthAndYear ("Month",month);
        selectMonthAndYear ("Year",year);
        /*selectDate (date);
*/
        driver.close();
    }
}

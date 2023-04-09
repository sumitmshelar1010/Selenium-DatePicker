package MainPackage.SeleniumChromeDriver.locators.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RedBusDatePicker {
    public  static  WebDriver driver;
    private static Object List;

    public static void selectSourceOrDestination(String cityName, String sourceOrDestination){
        List<WebElement> list =null;
        if (sourceOrDestination.equals("source"))
        {
            driver.findElement(By.id("src")).sendKeys(cityName);
            list = driver.findElements(By.xpath("//ul[@class='autoFill homeSearch']//child::li"));
        }
        else if (sourceOrDestination.equals("destination"))
        {
            driver.findElement(By.id("dest")).sendKeys(cityName);
        list=driver.findElements(By.xpath("//ul[@class='autoFill homeSearch']//child::li"));
        }

            for (WebElement obj : list)
                if (obj.getText().equals(cityName)){
                    obj.click();break;
        }}

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.redbus.in/");

Thread.sleep(3000);
        selectSourceOrDestination("Thane West, Mumbai", "source" );
        selectSourceOrDestination("Shivaji Nagar, Pune", "destination" );

        driver.findElement(By.id("onward_cal")).click();
        String  Month = "jun";
        String Year = "2023";
        String Date = "5";
        Thread.sleep(3000);

      //For picking Year and Month
        while(true){
            String[] input = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText().split(" ");
             String mon = input[0];
             String yr =input[1];
             if (mon.equalsIgnoreCase(Month) && yr.equals(Year))
                 break;
             else
                 driver.findElement(By.xpath("//td[@class='next']//child::button")).click();
            Thread.sleep(3000);
    }
//for picking date
        List<WebElement>  list1=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//child::td"));

        for (WebElement o :list1){

            String dt =o.getText();
            if (dt.equals(Date)){
                o.click();
                break;
        }}
                 driver.close();
}
}


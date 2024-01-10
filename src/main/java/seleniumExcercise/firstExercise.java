package seleniumExcercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstExercise {
	
	public static void main(String args[])
	{
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/alerts");
    System.out.println(driver.getTitle());
    //System.out.println(driver.getPageSource());
    driver.quit();
	}
	
}

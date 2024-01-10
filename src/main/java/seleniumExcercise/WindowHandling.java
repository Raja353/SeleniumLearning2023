package seleniumExcercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://www.leafground.com/window.xhtml");
		  driver.manage().window().maximize();
		  String parrent = driver.getWindowHandle();
		  
		  WebElement button = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
		  button.click();
		  
		  Set<String> wndws = driver.getWindowHandles();
		  List<String> windowss = new ArrayList<String>(driver.getWindowHandles());
		  for(String win:windowss)
		  {
			  if(((!(parrent.equals(win)))&& win.equals(windowss.get(1))))
				{
				    driver.switchTo().window(win);
				    /*System.out.println(win);
					*/
				  driver.close();
				}
				
			
		  }
		  System.out.println(windowss.size());
		  
		  //driver.quit();
		  }

}

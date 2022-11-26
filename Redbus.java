import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus {
	WebDriver driver;
	@Test
	public void browser()
	{
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.get("https://redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("sign-in-icon-down")).click();
		/*driver.findElement(By.id("signInLink")).click();
		WebElement mbNo=driver.findElement(By.xpath("//input[@type='number']"));
		String window=driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for (String string : allwindows) {
			if(!window.equals(string)) {
			driver.switchTo().window(string);
			}
		}
		mbNo.sendKeys("9500765089");
		driver.findElement(By.xpath("//div[@class='social FC DIB']")).click();
	}*/
	}
	@Test
	public void login() {
		System.out.println("muthu");
		
	}
}

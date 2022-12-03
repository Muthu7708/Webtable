import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebtable {
	 static WebDriver driver;
	@Test
	public void table() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		WebElement pass = driver.findElement(By.xpath("//input[@id='input-password']"));
		pass.clear();
		pass.sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
//	    driver.findElement(By.xpath("//button[@type='button'][@class='btn-close']")).click();
	    							 //*[@id="modal-security"]/div/div/div[1]/button
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//*[@id='modal-security']/div/div/div/button"));
		element.click();
		
	//	driver.findElement(By.xpath("//button[@type='button'][@id='button-menu']")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']/a")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-4']/li[1]/a")).click();
		
		WebElement pages = driver.findElement(By.xpath("//div[text()='Showing 1 to 10 of 76 (8 Pages)']"));
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView()", pages);
		String text = pages.getText();		
		System.out.println(text);
//	  int total_pages=Integer.valueOf(text.substring(text.indexOf("(")+1),text.indexOf("Pages")-1);
//	System.out.println(total_pages);
	


	 for (int i=1; i<8; i++)
	 {
		 
		 WebElement active = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
		 String pageNO = active.getText();
		 System.out.println("page No:"+pageNO);
		 active.click();
		 int size = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
		 System.out.println("total no of rows:"+size);
		 
		 String pageNum = Integer.toString(i+1);
		
		for(int r=1; r<size; r++) {
			String  column1 = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
			String column2 = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
			String  column3 = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();
			String  column4 = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();
			
	
		if (column4.equalsIgnoreCase("pending")) {
			
			System.out.println(column1+"    "+column2+"    "+column3+"    "+column4);
		}
		}
		 driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageNum+"']")).click(); 
		 
	 }
	}
	 @Test
	 public void tableDatas() {
		 
		 System.out.println("We get the table data");
	 }
}


package march;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class window_naukri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
 WebDriver driver=new ChromeDriver();
 
 driver.navigate().to("https://www.naukri.com/");
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 String mainwindow=driver.getWindowHandle();
 
 driver.findElement(By.xpath("//div[text()='Jobs']")).click();
 driver.findElement(By.xpath("//div[text()='Companies']")).click();
 
 System.out.println(driver.getTitle());

Set<String>childwindows=driver.getWindowHandles();

Iterator<String>itr=childwindows.iterator();
while(itr.hasNext()) {
	String childwindow=itr.next();
	if(!mainwindow.equalsIgnoreCase(childwindow)) {
		
		driver.switchTo().window(childwindow);
		System.out.println(driver.getTitle());

		
	}
	driver.switchTo().window(mainwindow);
	
	
			
}
	
	
	
	
	 


	}

}

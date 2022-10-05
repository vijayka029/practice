package march;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_handle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.naukri.com/");
    
    String mainwindow=driver.getWindowHandle();
    
    driver.findElement(By.xpath("//div[text()='Jobs']")).click();
    driver.findElement(By.xpath("//div[text()='Companies']")).click();
    
    Set<String>childwindows=driver.getWindowHandles();
    Iterator<String>itr=childwindows.iterator();
    
    while(itr.hasNext()) 
    {
    	String childwindow=itr.next();
    	
    if(!mainwindow.equalsIgnoreCase(childwindow)) {
    	driver.switchTo().window(childwindow);
    	System.out.println(driver.getTitle());
    	driver.findElement(By.xpath("//input[@name='qp' and @placeholder=\"Skills, Designations, Companies\"]")).sendKeys("selenium webdriver");
    	driver.findElement(By.xpath("//input[@placeholder=\"Location/Locality\"]")).sendKeys("pune");
    	driver.findElement(By.xpath("//button[text()='Search ']")).click();
    }
    }
    driver.switchTo().window(mainwindow);
    driver.quit();
	}

}

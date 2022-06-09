package week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("One Plus 9 Pro",Keys.ENTER);
		WebElement a=driver.findElement(By.xpath("//a//span[text()='38,999']"));
		System.out.println("The Price of the product is "+a.getText());
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("//a/span[text()='10,259']"));
		System.out.println("No.of Customer view is "+e.getText());
		driver.findElement(By.xpath("//img[@alt='Sponsored Ad - OnePlus 9 Pro 5G (Morning Mist, 8GB RAM, 128GB Storage)']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindow= new ArrayList<String>(windowHandles);
		driver.switchTo().window(newWindow.get(1));
		//screenshot
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/img.png");
		FileUtils.copyFile(source, destination);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span/input[@id='add-to-cart-button']")).click();
		String cart = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-total-string']")).getText();
	System.out.println(cart);
		
		
		
		

	}

}

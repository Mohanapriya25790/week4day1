package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesSwitch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		WebElement frameEl = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frameEl);
		driver.findElement(By.xpath("//b/following-sibling::input")).sendKeys("Not a Friendly Topic");
		WebElement frame2= driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@id='a']")).click();
		
		driver.switchTo().defaultContent();
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//select[@id='animals']/option[text()='Avatar']")).click();
		driver.switchTo().parentFrame();
		driver.close();
		
		
		
		
		
		
	}

}

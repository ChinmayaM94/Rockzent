package com.awinbv.rockzent.leadtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ObjectTest {
	
	@Test
	public void objectTest() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://en.wikipedia.org/wiki/2022%E2%80%9323_NBA_season");
//		Thread.sleep(5000);
		driver.findElement(By.name("otherAmount")).click();
//		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@class= 'frb-checkbox-label']")).click();
//		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(), 'Maybe later')]")).click();
//		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class= 'frb-rml-close']")).click();
//		Thread.sleep(5000);
		
		WebElement offSeason = driver.findElement(By.id("Off-season"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", offSeason);
//		Thread.sleep(5000);
		driver.findElement(By.id("nag-rml-btn")).click();
//		Thread.sleep(5000);
		driver.findElement(By.cssSelector("div[class='frb-step frb-step-1']>button[aria-label='Close']")).click();
		Thread.sleep(5000);
		driver.quit();
	}

}

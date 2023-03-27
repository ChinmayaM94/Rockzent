package com.awinbv.rockzent.leadtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.awinbv.rockzent.generalUtility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ObjectTest {
	

	@Test(dataProvider = "dp", dataProviderClass = ExcelUtility.class)
	public void objectTest(String first, String second) throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		System.out.println("New lines added");
		//eLib.getMultipleDataFromExcel("LeadsModule", 1, 1);
	}

}

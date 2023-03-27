package com.awinbv.rockzent.leadtest;

import org.testng.annotations.Test;

import com.awinbv.rockzent.generalUtility.ExcelUtility;

public class ObjectTest {
	
	@Test(dataProvider = "dp", dataProviderClass = ExcelUtility.class)
	public void objectTest(String first, String second) throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		System.out.println("Another New lines added");
		//eLib.getMultipleDataFromExcel("LeadsModule", 1, 1);
	}

}

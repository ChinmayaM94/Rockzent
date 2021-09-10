package com.rockzent.awinbv.leadtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.rockzent.awinbv.generalUtility.BaseClass;
import com.rockzent.awinbv.generalUtility.RetryAnalyzer;
import com.rockzent.awinbv.pomrepositorylib.CreateNewLeadPage;
import com.rockzent.awinbv.pomrepositorylib.HomePage;
import com.rockzent.awinbv.pomrepositorylib.LeadInfoPage;
import com.rockzent.awinbv.pomrepositorylib.LeadsPage;

@Listeners(com.rockzent.awinbv.generalUtility.LisImplementClass.class)
public class ConvertLeadTest extends BaseClass {
	
	/*TC_22*/
	@Test(groups = { "regressionTest" } , retryAnalyzer = RetryAnalyzer.class )
	public void convertLeadBySelectingAllCheckboxTest() throws Throwable {
		/* Test script data */
		String partialHomeTitle = eLib.getDataFromExcel("LeadsModule", 10, 2);
		String lastName = eLib.getDataFromExcel("LeadsModule", 10, 3)+randumNum;
		String companyName = eLib.getDataFromExcel("LeadsModule", 10, 4);
		String closeDate = eLib.getDataFromExcel("LeadsModule", 10, 5);
		String expectedOrgTitle = eLib.getDataFromExcel("LeadsModule", 10, 6);
		
		wLib.waitForTitleVisibility(driver);
		boolean isHomePageDisplayed = driver.getTitle().contains(partialHomeTitle);
		Assert.assertTrue(isHomePageDisplayed);
		
		/*Click on "Lead" and select a lead*/
		HomePage homePage = new HomePage(driver);
		homePage.getLeadsLink().click();
		
		/*precondition*/
		LeadsPage leadPage = new LeadsPage(driver);
		leadPage.getCreateLeadImg().click();;
		CreateNewLeadPage createLead = new CreateNewLeadPage(driver);
		createLead.createNewLead(lastName, companyName);
		
		LeadInfoPage infoPage = new LeadInfoPage(driver);
		String updatedLastName = infoPage.getLastName().getText();
		
		homePage.getLeadsLink().click();
		leadPage.selectALead(updatedLastName);
		
		boolean isLeadInfoPage = infoPage.getSuccessfulMsg().getText().contains(updatedLastName);
		Assert.assertTrue(isLeadInfoPage);
		
		/*Goto "Action" and click on "Convert Lead" link*/
		infoPage.getConvertLeadLink().click();
		boolean isConvertLeadPage = infoPage.getConvertLeadHeader().isDisplayed();
		Assert.assertTrue(isConvertLeadPage);
		
		/*Select All the checkbok and fill all the mandatory fields and click on "Save"*/
		infoPage.getOpportunityCheckBox().click();
		infoPage.getOpportunityCloseDate().sendKeys(closeDate);
		infoPage.getConvertLeadSaveBtn().click();
		Assert.assertTrue(driver.getTitle().contains(expectedOrgTitle));
	}
	
	/*TC_23*/
	@Test(groups = { "regressionTest" } , retryAnalyzer = RetryAnalyzer.class )
	public void convertLeadBySelectingOnlyOrgCheckboxTest() throws Throwable {
		/* Test script data */
		String partialHomeTitle = eLib.getDataFromExcel("LeadsModule", 13, 2);
		String lastName = eLib.getDataFromExcel("LeadsModule", 13, 3)+randumNum;
		String companyName = eLib.getDataFromExcel("LeadsModule", 13, 4);
		String expectedAlertText = eLib.getDataFromExcel("LeadsModule", 13, 5);
		
		wLib.waitForTitleVisibility(driver);
		boolean isHomePageDisplayed = driver.getTitle().contains(partialHomeTitle);
		Assert.assertTrue(isHomePageDisplayed);
		
		/*Click on "Lead" and select a lead*/
		HomePage homePage = new HomePage(driver);
		homePage.getLeadsLink().click();
		
		/*precondition*/
		LeadsPage leadPage = new LeadsPage(driver);
		leadPage.getCreateLeadImg().click();;
		CreateNewLeadPage createLead = new CreateNewLeadPage(driver);
		createLead.createNewLead(lastName, companyName);
		
		LeadInfoPage infoPage = new LeadInfoPage(driver);
		String updatedLastName = infoPage.getLastName().getText();
		
		homePage.getLeadsLink().click();
		leadPage.selectALead(updatedLastName);
		
		boolean isLeadInfoPage = infoPage.getSuccessfulMsg().getText().contains(updatedLastName);
		Assert.assertTrue(isLeadInfoPage);
		
		/*Goto "Action" and click on "Convert Lead" link*/
		infoPage.getConvertLeadLink().click();
		boolean isConvertLeadPage = infoPage.getConvertLeadHeader().isDisplayed();
		Assert.assertTrue(isConvertLeadPage);
		
		/*Select only "Organisation" checkbok and fill all the mandatory fielsand click on "Save"*/
		if(!infoPage.getOrganizationsCheckBox().isSelected()) {
			infoPage.getOrganizationsCheckBox().click();
		}
		if(infoPage.getOpportunityCheckBox().isSelected()) {
			infoPage.getOpportunityCheckBox().click();
		}
		if(infoPage.getContactCheckBox().isSelected()) {
			infoPage.getContactCheckBox().click();
		}
		infoPage.getConvertLeadSaveBtn().click();
		
		try {
			boolean isAlertTextCorrect = wLib.getAlertText(driver).contains(expectedAlertText);
			Assert.assertTrue(isAlertTextCorrect);
			wLib.acceptAlert(driver);
		} catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	/*TC_24*/
	@Test(groups = { "regressionTest" } , retryAnalyzer = RetryAnalyzer.class )
	public void convertLeadBySelectingOnlyOpportunityCheckboxTest() throws Throwable {
		/* Test script data */
		String partialHomeTitle = eLib.getDataFromExcel("LeadsModule", 16, 2);
		String lastName = eLib.getDataFromExcel("LeadsModule", 16, 3)+randumNum;
		String companyName = eLib.getDataFromExcel("LeadsModule", 16, 4);
		String closeDate = eLib.getDataFromExcel("LeadsModule", 16, 5);
		String expectedAlertText = eLib.getDataFromExcel("LeadsModule", 16, 6);
		
		wLib.waitForTitleVisibility(driver);
		boolean isHomePageDisplayed = driver.getTitle().contains(partialHomeTitle);
		Assert.assertTrue(isHomePageDisplayed);
		
		/*Click on "Lead" and select a lead*/
		HomePage homePage = new HomePage(driver);
		homePage.getLeadsLink().click();
		
		/*precondition*/
		LeadsPage leadPage = new LeadsPage(driver);
		leadPage.getCreateLeadImg().click();
		CreateNewLeadPage createLead = new CreateNewLeadPage(driver);
		createLead.createNewLead(lastName, companyName);
		
		LeadInfoPage infoPage = new LeadInfoPage(driver);
		String updatedLastName = infoPage.getLastName().getText();
		
		homePage.getLeadsLink().click();
		leadPage.selectALead(updatedLastName);
		
		boolean isLeadInfoPage = infoPage.getSuccessfulMsg().getText().contains(updatedLastName);
		Assert.assertTrue(isLeadInfoPage);
		
		/*Goto "Action" and click on "Convert Lead" link*/
		infoPage.getConvertLeadLink().click();
		boolean isConvertLeadPage = infoPage.getConvertLeadHeader().isDisplayed();
		Assert.assertTrue(isConvertLeadPage);
		
		/*Select only "Opporunity" checkbok and fill all the mandatory fielsand click on "Save"*/
		if(infoPage.getOrganizationsCheckBox().isSelected()) {
			infoPage.getOrganizationsCheckBox().click();
		}
		if(!infoPage.getOpportunityCheckBox().isSelected()) {
			infoPage.getOpportunityCheckBox().click();
			infoPage.getOpportunityCloseDate().sendKeys(closeDate);
		}
		if(infoPage.getContactCheckBox().isSelected()) {
			infoPage.getContactCheckBox().click();
		}
		
		infoPage.getConvertLeadSaveBtn().click();
		
		try {
			boolean isAlertTextCorrect = wLib.getAlertText(driver).contains(expectedAlertText);
			Assert.assertTrue(isAlertTextCorrect);
			wLib.acceptAlert(driver);
		} catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
}
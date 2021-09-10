package com.rockzent.awinbv.leadtest;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rockzent.awinbv.generalUtility.BaseClass;
import com.rockzent.awinbv.generalUtility.RetryAnalyzer;
import com.rockzent.awinbv.pomrepositorylib.CreateNewLeadPage;
import com.rockzent.awinbv.pomrepositorylib.HomePage;
import com.rockzent.awinbv.pomrepositorylib.LeadInfoPage;
import com.rockzent.awinbv.pomrepositorylib.LeadsPage;

@Listeners(com.rockzent.awinbv.generalUtility.LisImplementClass.class)
public class CreateNewLeadTest extends BaseClass {
	
	/*TC_10*/
	@Test(groups = { "smokeTest", "regressionTest" } , retryAnalyzer = RetryAnalyzer.class )
	public void createNewLeadByAssignToTest() throws Throwable {
		/* Test script data */
		String lastName = eLib.getDataFromExcel("LeadsModule", 1, 4)+randumNum;
		String companyName = eLib.getDataFromExcel("LeadsModule", 1, 5);
		String groupOptions = eLib.getDataFromExcel("LeadsModule", 1, 6);
		String userOption = eLib.getDataFromExcel("LeadsModule", 1,7);
		String partialHomeTitle = eLib.getDataFromExcel("LeadsModule", 1, 2);
		String createNewLeadText = eLib.getDataFromExcel("LeadsModule", 1, 3);
		
		
		wLib.waitForTitleVisibility(driver);
		boolean title = driver.getTitle().contains(partialHomeTitle);
		Assert.assertTrue(title);
		
		//Step 3: Click on "Lead" then click on "Create Lead " Image.
		HomePage homePage = new HomePage(driver);
		homePage.getLeadsLink().click();
		
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLeadImg().click();
		
		//Step 4: Create lead
		CreateNewLeadPage createLead = new CreateNewLeadPage(driver);
		Assert.assertEquals(createLead.getCreateNewLeadHeader().getText(), createNewLeadText);
		
		createLead.getLastNameEdt().sendKeys(lastName);
		createLead.getCompanyEdt().sendKeys(companyName);
		
		/*verifying Group dropdown options*/
		List<String> expectedGroupDpDownOptions = Arrays.asList(groupOptions.split("\n"));
		createLead.getGroupRadioBtn().click();
		List<WebElement> groupDpDownList = wLib.selectOptions(createLead.getGroupDropDownList());
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(createLead.clickOnAssignedToRadioBtn(expectedGroupDpDownOptions, groupDpDownList));
		
		/*verifying User dropdown options*/
		List<String> expectedUserDpDownOptions = Arrays.asList(userOption);
		createLead.getUserRadioBtn().click();
		List<WebElement> userDpDownList = wLib.selectOptions(createLead.getUserDropDownList());
		soft.assertTrue(createLead.clickOnAssignedToRadioBtn(expectedUserDpDownOptions, userDpDownList));
		createLead.getSaveBtn().click();
		
		//verify the success Msg with lastname
		LeadInfoPage leadInfo = new LeadInfoPage(driver);
		boolean isLeadCreated = leadInfo.getSuccessfulMsg().getText().contains(lastName);
		Assert.assertTrue(isLeadCreated);
		
		//verify unique lead no is generated or not
		boolean isLeadNoGenerated = !leadInfo.getUniqueLeadNo().getText().isEmpty();
		soft.assertTrue(isLeadNoGenerated);
		soft.assertAll();
	}
	
	/*TC_11*/
	@Test(groups = { "regressionTest" } , retryAnalyzer = RetryAnalyzer.class )
	public void creatNewLeadByValidAnnualRevenueTest() throws Throwable {
		/* Test script data */
		String lastName = eLib.getDataFromExcel("LeadsModule", 4, 4)+randumNum;
		String companyName = eLib.getDataFromExcel("LeadsModule", 4, 5);
		String annualRevenue = eLib.getDataFromExcel("LeadsModule", 4, 6);
		String partialHomeTitle = eLib.getDataFromExcel("LeadsModule", 4, 2);
		String createNewLeadText = eLib.getDataFromExcel("LeadsModule", 4, 3);
		
		SoftAssert soft = new SoftAssert();
		wLib.waitForTitleVisibility(driver);
		boolean title = driver.getTitle().contains(partialHomeTitle);
		Assert.assertTrue(title);
		
		//Step 3: Click on "Lead" then click on "Create Lead " Image.
		HomePage homePage = new HomePage(driver);
		homePage.getLeadsLink().click();
		
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLeadImg().click();
		
		//Step 4: Create lead with valid Annual Revenue
		CreateNewLeadPage createLead = new CreateNewLeadPage(driver);
		Assert.assertEquals(createLead.getCreateNewLeadHeader().getText(), createNewLeadText);
		
		createLead.createNewLeadByAnnualRevenue(lastName, companyName, annualRevenue);
		
		//verify the success Msg with lastname
		LeadInfoPage leadInfo = new LeadInfoPage(driver);
		boolean isLeadCreated = leadInfo.getSuccessfulMsg().getText().contains(lastName);
		Assert.assertTrue(isLeadCreated);
		
		//verify unique lead no is generated or not
		boolean isLeadNoGenerated = !leadInfo.getUniqueLeadNo().getText().isEmpty();
		soft.assertTrue(isLeadNoGenerated);
		soft.assertAll();
	}
	
	/*TC_12*/
	@Test(groups = { "regressionTest" } , retryAnalyzer = RetryAnalyzer.class )
	public void creatNewLeadByInvalidAnnualRevenueTest() throws Throwable {
		/* Test script data */
		String lastName = eLib.getDataFromExcel("LeadsModule", 7, 4)+randumNum;
		String companyName = eLib.getDataFromExcel("LeadsModule", 7, 5);
		String annualRevenue = eLib.getDataFromExcel("LeadsModule", 7, 6);
		String expectedErrorMsg = eLib.getDataFromExcel("LeadsModule", 7, 7);
		String partialHomeTitle = eLib.getDataFromExcel("LeadsModule", 7, 2);
		String createNewLeadText = eLib.getDataFromExcel("LeadsModule", 7, 3);
		
		wLib.waitForTitleVisibility(driver);
		boolean title = driver.getTitle().contains(partialHomeTitle);
		Assert.assertTrue(title);
		
		//Step 3: Click on "Lead" then click on "Create Lead " Image.
		HomePage homePage = new HomePage(driver);
		homePage.getLeadsLink().click();
		
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLeadImg().click();
		
		//Step 4: Create lead with invalid Annual Revenue
		CreateNewLeadPage createLead = new CreateNewLeadPage(driver);
		Assert.assertEquals(createLead.getCreateNewLeadHeader().getText(), createNewLeadText);
		
		createLead.createNewLeadByAnnualRevenue(lastName, companyName, annualRevenue);
		
		try {
			boolean isAlertPresent = wLib.getAlertText(driver).equals(expectedErrorMsg);
			Assert.assertTrue(isAlertPresent);
			wLib.acceptAlert(driver);
		} catch (Exception e) {
			LeadInfoPage leaddInfo = new LeadInfoPage(driver);
			boolean isLeadCreated = leaddInfo.getSuccessfulMsg().getText().contains(lastName);
			Assert.assertTrue(!isLeadCreated);
		}
	}
}

/*
 * package com.crm.qa.testcases;
 * 
 * import org.testng.Assert; import org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;
 * 
 * import com.crm.qa.base.BaseSetup; import com.crm.qa.pages.Amazon; import
 * com.crm.qa.pages.Google; import com.crm.qa.pages.Gmail; import
 * com.crm.qa.util.TestUtil;
 * 
 * public class FlipKartTest extends BaseSetup { Gmail loginPage; Google
 * homePage; TestUtil testUtil; Amazon contactsPage;
 * 
 * public FlipKartTest() { super(); }
 * 
 * 
 * @BeforeMethod public void setUp() { initialization(); testUtil = new
 * TestUtil(); contactsPage = new Amazon(); loginPage = new Gmail(); homePage =
 * loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
 * }
 * 
 * 
 * @Test(priority=1) public void verifyHomePageTitleTest(){ String homePageTitle
 * = homePage.verifyHomePageTitle(); Assert.assertEquals(homePageTitle,
 * "CRMPRO","Home page title not matched"); }
 * 
 * @Test(priority=2) public void verifyUserNameTest(){ testUtil.switchToFrame();
 * //Assert.assertTrue(homePage.verifyCorrectUserName()); }
 * 
 * @Test(priority=3) public void verifyContactsLinkTest(){
 * testUtil.switchToFrame(); //contactsPage = homePage.clickOnContactsLink(); }
 * 
 * 
 * 
 * @AfterMethod public void tearDown(){ driver.quit(); }
 * 
 * 
 * 
 * }
 */
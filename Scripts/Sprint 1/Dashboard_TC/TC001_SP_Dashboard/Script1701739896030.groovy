import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import com.kms.katalon.core.keyword.builtin.VerifyMatchKeyword as VerifyMatchKeyword
import com.kms.katalon.core.helper.KeywordHelper as KeywordHelper
import org.openqa.selenium.JavascriptExecutor
import java.text.SimpleDateFormat

WebUI.callTestCase(findTestCase('Sprint 1/Login_TC/TC001_LoginValidCredentials_SP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/titlePage_Dashboard'), 'Dashboard')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/menu_Home'), 'Home')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/menu_Reports'), 'Reports')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/menu_Admin'), 'Admin')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/menu_Upload'), 'Upload')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/menu_Audit Trail_SP'), 'Audit Trail')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/tile_RemittanceAdvice'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/tile_BulletinMemo'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/tile_Form2307'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/tile_Tickets'), 0)

//elements in the Remittance Advice tile
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/counter_UnreadRA'), 0) //unread counter

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/tileLabel_Remittance Advice'), 'Remittance Advice') //tile label

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/button_RA_View All'), 0) //viewAll button

//elements in the Bulletin Memo tile
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/counter_UnreadBM'), 0) //unread counter

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/tileLabel_BulletinMemo'), 'Bulletin Memo') //tile label

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/button_BM_View All'), 0) //viewAll button

//elements in the Form 2307 tile
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/counter_UnreadForm2307'), 0) //unread counter

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/tileLabel_Form 2307'), 'Form 2307') //tile label

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/button_Form2307_View All'), 0) //viewAll button

//elements in the Tickets tile
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/counter_UnreadTickets'), 0) //unread counter

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/tileLabel_Tickets'), 'Tickets') //tile label

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/button_Tickets_View All'), 0) //viewAll button


WebUI.closeBrowser()



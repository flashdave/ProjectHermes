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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.text.SimpleDateFormat as SimpleDateFormat

WebUI.callTestCase(findTestCase('Sprint 1/CommandCenter_LoginTC/TC003_LoginValidCredentials_Admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/AdminMenu/adminMenu_Watsons Command Center'), 
    'Watsons Command Center')

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Homescreen/SuperAdminMenu/menu_Home'), 2)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Homescreen/SuperAdminMenu/menu_Reports'), 2)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/AdminMenu/adminMenu_Admin'), 'Admin')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/AdminMenu/adminMenu_Ticket'), 'Ticket')

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Homescreen/SuperAdminMenu/menu_Upload'), 2)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/AdminMenu/admin Menu_Audit Trail'), 'Audit Trail')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Watsons User/titlePage_Watsons User Role  Access'), "Watsons User Role & Access")

WebUI.closeBrowser()


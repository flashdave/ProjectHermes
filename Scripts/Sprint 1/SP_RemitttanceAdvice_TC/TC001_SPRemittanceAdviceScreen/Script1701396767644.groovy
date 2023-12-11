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
import org.apache.commons.io.FileUtils as FileUtils
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

WebUI.callTestCase(findTestCase('Sprint 1/Login_TC/TC001_LoginValidCredentials_SP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Homescreen/menu_Reports'))

WebUI.click(findTestObject('Object Repository/Page_Homescreen/tileLabel_Remittance Advice'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Remittance Advice/titlePage_Remittance Advice'), 'Remittance Advice')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Remittance Advice/label_Vendor Code'), 'Vendor Code')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Remittance Advice/label_Vendor Name'), 'Vendor Name')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Remittance Advice/label_Payment Voucher Number'), 'Payment Voucher Number')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Remittance Advice/label_RA Number'), 'RA Number')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Remittance Advice/input_Vendor Code_input-search'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Remittance Advice/input_Vendor Name_input-search'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Remittance Advice/input_Payment Date From'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Remittance Advice/input_Payment Date From'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Remittance Advice/input_Payment Voucher Number'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Remittance Advice/input_RA Number'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Remittance Advice/select_Status'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Remittance Advice/button_Search'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Remittance Advice/button_Reset'), 0)


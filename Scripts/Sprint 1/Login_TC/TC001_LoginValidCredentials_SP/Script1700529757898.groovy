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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL_vendor)

WebUI.setText(findTestObject('Object Repository/Page_Login/input_Username'), GlobalVariable.watsons_username)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login/input_Password'), GlobalVariable.watsons_password)

WebUI.click(findTestObject('Object Repository/Page_Login/button_Login'))

WebUI.navigateToUrl('https://10.143.206.85/NonTradeVendorPortal/')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/titlePage_Dashboard'), 'Dashboard')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/menu_Home'), 'Home')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/menu_Reports'), 'Reports')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/menu_Admin'), 'Admin')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/menu_Upload'), 'Upload')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/menu_Audit Trail'), 'Audit Trail')


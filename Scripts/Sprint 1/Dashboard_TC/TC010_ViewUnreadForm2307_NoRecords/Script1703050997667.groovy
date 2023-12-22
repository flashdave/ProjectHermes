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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL_vendor)

WebUI.setText(findTestObject('Object Repository/Page_Login/input_Username'), '12202023_VP')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login/input_Password'), 'xngilo02Z2BNHXedMmXvHw==')

WebUI.click(findTestObject('Object Repository/Page_Login/button_Login'))

WebUI.delay(2)

WebUI.navigateToUrl('https://10.143.206.85/NonTradeVendorPortal/')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/titlePage_Dashboard'), 'Dashboard')

//Form 2307 popup window

WebUI.getText(findTestObject('Object Repository/Page_Homescreen/counter_Form2307'))

WebUI.click(findTestObject('Object Repository/Page_Homescreen/counter_Form2307'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/popupUnread_Form 2307'), 'Form 2307')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/icon_NoRecords'), 2)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/text_No records have been added yet'), 'No records have been added yet')

WebUI.click(findTestObject('Object Repository/Page_Homescreen/close_Icon'))

WebUI.closeBrowser()



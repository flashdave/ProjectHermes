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
import org.openqa.selenium.JavascriptExecutor

WebUI.callTestCase(findTestCase('Sprint 1/CommandCenter_LoginTC/TC003_LoginValidCredentials_Admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Watsons User/adminMenu_Admin'))

WebUI.click(findTestObject('Object Repository/Page_Watsons User/subMenu_Watsons User'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Watsons User/titlePage_Watsons User Role  Access'), 'Watsons User Role & Access')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Watsons User/button_Update Watsonss User'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Watsons User/selection_Rows per page'), 0)

def isMatch = false

WebDriver driver = DriverFactory.getWebDriver()

WebElement Header = driver.findElement(By.xpath('//*[@id="WatsonsTable"]/thead'))

List header_names = Header.findElements(By.tagName('th'))

int headers_count = header_names.size()

WebUI.verifyEqual(headers_count, 10, FailureHandling.STOP_ON_FAILURE)

String columnName1 = header_names.get(0).getText()
String columnName2 = header_names.get(1).getText()
String columnName3 = header_names.get(2).getText()
String columnName4 = header_names.get(3).getText()
String columnName5 = header_names.get(4).getText()
String columnName6 = header_names.get(5).getText()
String columnName7 = header_names.get(6).getText()
String columnName8 = header_names.get(7).getText()
String columnName9 = header_names.get(8).getText()
String columnName10 = header_names.get(9).getText()

if (columnName1 == '' && columnName2 == 'Name' && columnName3 == 'Email' && columnName4 == 'Created Date' &&
	columnName5 == 'Ticket Type' && columnName6 == 'Role' && columnName7 == 'Updated By' && columnName8 == 'Update Date' &&
	columnName9 == 'Status' && columnName10 == 'Action') {
	
	println('All column names are existing and correct')
	
	isMatch = true
	
}
else {
	
	println('There are no existing column names in the table')
	
	isMatch = false
}

assert isMatch == true


WebUI.closeBrowser()


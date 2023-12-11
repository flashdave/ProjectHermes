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

//Remittance Advice popup window

def unRead_RA = WebUI.getText(findTestObject('Object Repository/Page_Homescreen/counter_UnreadRA'))
WebUI.click(findTestObject('Object Repository/Page_Homescreen/counter_UnreadRA'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/popupLabel_Remittance Advice'), 'Remittance Advice')

def isMatch = false

WebDriver driver = DriverFactory.getWebDriver()
//locate table
WebElement Table = driver.findElement(By.xpath('//*[@id="RAPopUp"]/div/div[2]'))
//To locate rows of table it will Capture all the rows available in the table
List<WebElement> table_row = Table.findElements(By.className('list-item'))
//To calculate no of rows In table
int rows_count = table_row.size()
println "$rows_count"

WebUI.verifyEqual(unRead_RA, rows_count)

WebUI.click(findTestObject('Object Repository/Page_Homescreen/popup_closeIcon'))

WebUI.closeBrowser()


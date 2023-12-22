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

WebUI.callTestCase(findTestCase('Test Cases/Sprint 1/VendorPortal_Login_TC/TC004_LoginValidCredentials_Vendor'), [:], FailureHandling.STOP_ON_FAILURE)

//Remittance Advice popup window

def unRead_Form2307 = WebUI.getText(findTestObject('Object Repository/Page_Homescreen/counter_Form2307'))
WebUI.click(findTestObject('Object Repository/Page_Homescreen/counter_Form2307'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/popupUnread_Form 2307'), 'Form 2307')

def isMatch = false

WebDriver driver = DriverFactory.getWebDriver()
//locate table
WebElement Table = driver.findElement(By.xpath('//*[@id="Form2307Pop"]/div/div[2]'))
//To locate rows of table it will Capture all the rows available in the table
List<WebElement> table_row = Table.findElements(By.className('list-item'))
//To calculate no of rows In table
int rows_count = table_row.size()
println "$rows_count"

WebUI.verifyEqual(unRead_Form2307, rows_count)

WebUI.click(findTestObject('Object Repository/Page_Homescreen/close_Icon'))

WebUI.closeBrowser()



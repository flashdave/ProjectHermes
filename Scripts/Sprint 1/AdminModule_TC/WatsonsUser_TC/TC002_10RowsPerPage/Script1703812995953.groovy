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

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Watsons User/selection_Rows per page'), 0)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Watsons User/selection_Rows per page'), 'Rows per page 10', false)

def isMatch = false

WebDriver driver = DriverFactory.getWebDriver()

//locate table
WebElement Table = driver.findElement(By.xpath('//*[@id="WatsonsTable"]/tbody'))
//To locate rows of table it will Capture all the rows available in the table
List<WebElement> table_row = Table.findElements(By.tagName('tr'))
//To calculate no of rows In table
int rows_count = table_row.size()
println "$rows_count"

WebUI.verifyEqual(rows_count, 10)


WebUI.closeBrowser()


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

WebUI.callTestCase(findTestCase('Sprint 1/CommandCenter_LoginTC/TC001_LoginValidCredentials_SP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Remittance Advice/titlePage_Remittance Advice'), 'Remittance Advice')

WebUI.setText(findTestObject('Object Repository/Page_Remittance Advice/input_Payment Voucher Number'), vendor_voucherNumber)

WebUI.click(findTestObject('Object Repository/Page_Remittance Advice/button_Search'))

def isMatch = false

WebDriver driver = DriverFactory.getWebDriver()
//locate table
WebElement Table = driver.findElement(By.xpath('//*[@id="RATable"]/tbody'))
//To locate rows of table it will Capture all the rows available in the table
List<WebElement> table_row = Table.findElements(By.tagName('tr'))
//To calculate no of rows In table
int rows_count = table_row.size()

//execute loop in all rows
for (int row = 0; row < rows_count; row++) {
	//To locate columns(cells) of that specific row
	List<WebElement> Columns_row = table_row.get(row).findElements(By.tagName('td'))
	
	//To calculate no of columns(cells) In that specific row
	int columns_count = Columns_row.size()

	println((('Number of cells In Row ' + row) + ' are ') + columns_count)
	
	String vendorVoucherNumber_value = Columns_row.get(4).getText()
	
	
	if (vendorVoucherNumber_value == vendor_voucherNumber) {
		println("This row has: $vendor_voucherNumber")
		isMatch = true
		
	} else {
		isMatch = false

		break;
	}
}
assert isMatch == true


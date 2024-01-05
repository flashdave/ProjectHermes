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

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Watsons User/selection_Status'), 'Inactive', false)

WebUI.click(findTestObject('Object Repository/Page_Watsons User/button_Search'))

def isMatch = false

WebDriver driver = DriverFactory.getWebDriver()

//locate table
WebElement Table = driver.findElement(By.xpath('//*[@id="WatsonsTable"]/tbody'))
//To locate rows of table it will Capture all the rows available in the table
List<WebElement> table_row = Table.findElements(By.tagName('tr'))
//To calculate no of rows In table
int rows_count = table_row.size()
println "$rows_count"

//execute loop in all rows
for (int row = 0; row < rows_count; row++) {
	//To locate columns(cells) of that specific row
	List<WebElement> Columns_row = table_row.get(row).findElements(By.tagName('td'))
	
	//To calculate no of columns(cells) In that specific row
	int columns_count = Columns_row.size()

	println((('Number of cells In Row ' + row) + ' are ') + columns_count)
	
	String columnStatus_value = Columns_row.get(8).getText()
	
	
	if (columnStatus_value == 'Inactive') {
		println("This row has status: Inactive")
		isMatch = true
		
	} else {
		isMatch = false

		break;
	}
}
assert isMatch == true

if (rows_count <= 10 && WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Watsons User/button_items_pagination-next-button'), 2, FailureHandling.OPTIONAL)) {
	
	println('Table Records are exactly 10 or less than 10')
	
}
else if (rows_count == 10 && WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Watsons User/button_items_pagination-next-button'), 2)) {
	//get attribute aria-label
	def attribute = WebUI.getAttribute(findTestObject('Object Repository/Page_Watsons User/button_items_pagination-next-button'), 'aria-label')
	println(attribute)
	//get attribute disabled
	def disabled = WebUI.getAttribute(findTestObject('Object Repository/Page_Watsons User/button_items_pagination-next-button'), 'disabled')
	println(disabled)
	
	while (rows_count == 10 && attribute == 'go to next page' && disabled == null) {
		
		//WebUI.scrollToElement(findTestObject('Object Repository/Page_Watsons User/button_items_pagination-next-button'), 0)
		
		WebUI.click(findTestObject('Object Repository/Page_Watsons User/button_items_pagination-next-button'))
		
		Table = driver.findElement(By.xpath('//*[@id="WatsonsTable"]/tbody'))
		 //To locate rows of table it will Capture all the rows available in the table
		table_row = Table.findElements(By.tagName('tr'))
		 //To calculate no of rows In table
		 rows_count = table_row.size()
		 println "$rows_count"
		 
		 //execute loop in all rows
		 for (int row = 0; row < rows_count; row++) {
			 //To locate columns(cells) of that specific row
			 List<WebElement> Columns_row = table_row.get(row).findElements(By.tagName('td'))
			 
			 //To calculate no of columns(cells) In that specific row
			 int columns_count = Columns_row.size()
		 
			 println((('Number of cells In Row ' + row) + ' are ') + columns_count)
			 
			 String columnStatus_value = Columns_row.get(8).getText()
			 
			 
			 if (columnStatus_value == 'Inactive') {
				 println("This row has status: Inactive")
				 isMatch = true
				 
			 } else {
				 isMatch = false
		 
				 break;
			 }
		 }
		 assert isMatch == true
		
		
	}
}


WebUI.closeBrowser()


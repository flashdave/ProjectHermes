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

WebUI.click(findTestObject('Object Repository/Page_Homescreen/menu_Reports'))

WebUI.click(findTestObject('Object Repository/Page_Homescreen/tileLabel_Remittance Advice'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Remittance Advice/titlePage_Remittance Advice'), 'Remittance Advice')

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
	
	String vendor_code = Columns_row.get(1).getText()
	String vendor_Name = Columns_row.get(2).getText()
	String vendor_RAnumber = Columns_row.get(3).getText()
	String vendor_voucherNum = Columns_row.get(4).getText()
	String vendor_Status = Columns_row.get(7).getText()
	
	println "$vendor_code, $vendor_Name, $vendor_RAnumber, $vendor_voucherNum, $vendor_Status"
	
	if (vendor_code == "1071082" && vendor_Name == "DEYALT SALES CORPORATION" && vendor_RAnumber == "74304" && vendor_voucherNum == "41824" && vendor_Status == "Unread") {
		
		def fileName = Columns_row.get(6).getText()
		println "$fileName"
		Columns_row.get(6).findElement(By.tagName('span')).click();

		
		WebUI.waitForAlert(3)
		WebUI.verifyAlertPresent(3)
		
		def confirmationMessage = WebUI.getAlertText()
		WebUI.verifyMatch(confirmationMessage, 'Are you sure you want to download this file ?', false)
		
		WebUI.acceptAlert()
		
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Remittance Advice/bannerMsg_File is successfully downloaded'), 'File is successfully downloaded.')
		
		File downloadedFile = new File("C:\\Users\\User\\Downloads\\")
		File[] fileCounts = downloadedFile.listFiles()
		def verifyFile = false
		WebUI.delay(2)
		for (int i = 0; i<fileCounts.size(); i++) {
			
			String downloadedFiles = fileCounts[i].getName()
			
			if (downloadedFiles == fileName) {
				
				println "$downloadedFiles and $fileName are matched"
				
				verifyFile = true
				
				break;
			}
			else {
				
				println "$downloadedFiles and $fileName are not match"
				
				verifyFile = false
				
			}
		
		}
		
		assert verifyFile == true
		
		isMatch = true
		break;
		
	}
	
	else {
		 
		println "Vendor is not existing in this row"
		
		isMatch = false
		
	}
	
}

assert isMatch == true

Table = driver.findElement(By.xpath('//*[@id="RATable"]/tbody'))
 //To locate rows of table it will Capture all the rows available in the table
table_row = Table.findElements(By.tagName('tr'))
 //To calculate no of rows In table
rows_count = table_row.size()
for (row = 0; row < rows_count; row++) {
	//To locate columns(cells) of that specific row
	Columns_row = table_row.get(row).findElements(By.tagName('td'))
	
	//To calculate no of columns(cells) In that specific row
	columns_count = Columns_row.size()
	
	println((('Number of cells In Row ' + row) + ' are ') + columns_count)
	
	vendor_code = Columns_row.get(1).getText()
	vendor_Name = Columns_row.get(2).getText()
	vendor_RAnumber = Columns_row.get(3).getText()
	vendor_voucherNum = Columns_row.get(4).getText()
	vendor_Status = Columns_row.get(7).getText()
	String read_Date = Columns_row.get(8).getText()
	String read_By = Columns_row.get(9).getText()
	
	println "$vendor_code, $vendor_Name, $vendor_RAnumber, $vendor_voucherNum, $vendor_Status"
	
	if (vendor_code == "1071082" && vendor_Name == "DEYALT SALES CORPORATION" && vendor_RAnumber == "74304" && vendor_voucherNum == "41824" && vendor_Status == "Unread" && read_Date == "-" && read_By == "-" ) {
		
		println "Vendor details are: $vendor_code, $vendor_Name, $vendor_RAnumber, $vendor_voucherNum, $vendor_Status, $read_Date, $read_By"
		
		isMatch = true
		
		break;
	}
	
	else {
		println "Vendor Status not match"
		
		isMatch = false
	}
	
}
assert isMatch == true
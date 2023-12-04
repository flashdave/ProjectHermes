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

WebUI.callTestCase(findTestCase('Sprint 1/Login_TC/TC004_LoginValidCredentials_Vendor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Homescreen/menu_Reports'))

WebUI.click(findTestObject('Object Repository/Page_Homescreen/subMenu_Remittance Advice'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Remittance Advice/titlePage_Remittance Advice'), 'Remittance Advice')

def accountName = WebUI.getText(findTestObject("Object Repository/Page_Remittance Advice/UserAccountName"))

println "$accountName"

def isMatch = false

def todaysDate = new Date()
SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm")
String formattedDateTime = dateFormat.format(todaysDate)

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
	
	String vendor_RAnumber = Columns_row.get(3).getText()
	String vendor_voucherNum = Columns_row.get(4).getText()
	String vendor_Status = Columns_row.get(7).getText()
	
	println "$vendor_RAnumber, $vendor_voucherNum, $vendor_Status"
	
	if (vendor_RAnumber == "74306" && vendor_voucherNum == "41652" && vendor_Status == "Unread") {
	
		Columns_row.get(0).findElement(By.className('checkbox')).click();
		
		WebUI.click(findTestObject('Object Repository/Page_Remittance Advice/button_Download'))
		
		WebUI.waitForAlert(3)
		WebUI.verifyAlertPresent(3)
		def confirmationMessage = WebUI.getAlertText()
		
		WebUI.verifyMatch(confirmationMessage, "Are you sure you want to Download all selected vendors' Remittance Advice?", false)
		
		WebUI.acceptAlert()
		
		formattedDateTime = dateFormat.format(todaysDate)
		
		//WebUI.verifyElementText(findTestObject('Object Repository/Page_Remittance Advice/bannerMsg_File is successfully downloaded'), 'File is successfully downloaded.')
		
		println "$formattedDateTime"
		
		WebUI.delay(3)
		File downloadedFile = new File("C:\\Users\\User\\Downloads\\")
		File[] fileCounts = downloadedFile.listFiles()
		def verifyFile = false
		SimpleDateFormat FiledateFormat = new SimpleDateFormat("MM-dd-yyyy")
		String formattedFileDate = FiledateFormat.format(todaysDate)
		String formattedFileName = "RA_" + formattedFileDate + ".zip"
		println "$formattedFileName"
		for (int i = 0; i<fileCounts.size(); i++) {
			
			String downloadedFiles = fileCounts[i].getName()
			
			if (downloadedFiles == formattedFileName) {
				
				println "$downloadedFiles and $formattedFileName are matched"
				
				verifyFile = true
				
				break;
			}
			else {
				
				println "$downloadedFiles and $formattedFileName are not match"
				
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

WebUI.delay(3)

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
	
	vendor_RAnumber = Columns_row.get(3).getText()
	vendor_voucherNum = Columns_row.get(4).getText()
	vendor_Status = Columns_row.get(7).getText()
	String read_Date = Columns_row.get(8).getText()
	String read_By = Columns_row.get(9).getText()
	
	println "$vendor_RAnumber, $vendor_voucherNum,  $vendor_Status"
	
	if (vendor_RAnumber == "74306" && vendor_voucherNum == "41652" && vendor_Status == "Read" && read_Date == formattedDateTime && read_By == accountName ) {
		println "Vendor details are: $vendor_RAnumber, $vendor_voucherNum, $vendor_Status, $read_Date, $read_By"
		
		isMatch = true
		
		break;
	}
	
	else {
		println "Vendor Status not match"
		
		isMatch = false
	}
	
}
assert isMatch == true
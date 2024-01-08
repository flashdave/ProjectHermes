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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.text.SimpleDateFormat as SimpleDateFormat

WebUI.callTestCase(findTestCase('Sprint 1/CommandCenter_LoginTC/TC003_LoginValidCredentials_Admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Watsons User/adminMenu_Admin'))

WebUI.click(findTestObject('Object Repository/Page_Watsons User/subMenu_Watsons User'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Watsons User/titlePage_Watsons User Role  Access'), 'Watsons User Role & Access')

WebUI.click(findTestObject('Object Repository/Page_Watsons User/button_Search'))

def todaysDate = new Date()

SimpleDateFormat dateFormat = new SimpleDateFormat('MM/dd/yyyy')

String formattedDateTime = dateFormat.format(todaysDate)

def isMatch = false

String result = []

WebDriver driver = DriverFactory.getWebDriver()

//locate table
WebElement Table = driver.findElement(By.xpath('//*[@id="WatsonsTable"]/tbody'))

//To locate rows of table it will Capture all the rows available in the table
List<WebElement> table_row = Table.findElements(By.tagName('tr'))

//To calculate no of rows In table
int rows_count = table_row.size()

println("$rows_count")

//execute loop in all rows
for (int row = 0; row < rows_count; row++) {
    //To locate columns(cells) of that specific row
    List<WebElement> Columns_row = table_row.get(row).findElements(By.tagName('td'))

    //To calculate no of columns(cells) In that specific row
    int columns_count = Columns_row.size()

    println((('Number of cells In Row ' + row) + ' are ') + columns_count)

    String columnName_value = Columns_row.get(1).getText()

    String columnEmail_value = Columns_row.get(2).getText()

    if ((columnName_value == watsons_Username) && (columnEmail_value == watsons_Email)) {
        Columns_row.get(9).findElement(By.tagName('a')).click()

        WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Watsons User/select_Role'), watsons_Role, true)

        WebUI.click(findTestObject('Object Repository/Page_Watsons User/select_TicketType'))

        for (int x = 0; x < 2; x++) {
            driver = DriverFactory.getWebDriver()

            WebElement dropdown = driver.findElement(By.xpath('//*[@id="b11-b1-List_NotEmpty"]'))

            List<WebElement> list = dropdown.findElements(By.className('multi-select-react-and-mob-dropdown-menu-item'))

            int options_count = list.size()

            println("$options_count")

            List<WebElement> textValue = list.get(x).findElements(By.tagName('label'))

            result = textValue.get(0).getText()

            println("$result")

            List<WebElement> checkbox = list.get(x).findElements(By.className('multi-select-react-and-mob-checkbox-container'))

            checkbox.get(0).findElement(By.className('checkbox')).click()
        }
        
        WebUI.click(findTestObject('Object Repository/Page_Watsons User/select_TicketType'))

        WebUI.click(findTestObject('Object Repository/Page_Watsons User/button_Submit'))

        def confirmationMessage = WebUI.getAlertText()

        WebUI.acceptAlert()

        WebUI.verifyMatch(confirmationMessage, 'Are you sure you want to save?', false)

        isMatch = true

        break
    } else {
        println('No records found')

        isMatch = false
    }
}

assert isMatch == true

WebUI.setText(findTestObject('Page_Watsons User/input_Name, Email, Updated By_Input_Search'), watsons_Email)

WebUI.click(findTestObject('Page_Watsons User/button_Search'))

driver = DriverFactory.getWebDriver()

//locate table
Table = driver.findElement(By.xpath('//*[@id="WatsonsTable"]/tbody'))

//To locate rows of table it will Capture all the rows available in the table
table_row = Table.findElements(By.tagName('tr'))

//To calculate no of rows In table
rows_count = table_row.size()

//execute loop in all rows
for (int row = 0; row < rows_count; row++) {
    //To locate columns(cells) of that specific row
    List<WebElement> Columns_row = table_row.get(row).findElements(By.tagName('td'))

    //To calculate no of columns(cells) In that specific row
    int columns_count = Columns_row.size()

    println((('Number of cells In Row ' + row) + ' are ') + columns_count)

    String columnName_value = Columns_row.get(1).getText()

    String columnEmail_value = Columns_row.get(2).getText()

    WebUI.mouseOver(findTestObject('Object Repository/Page_Watsons User/tooltip_TicketType'))

    String columnTicketType_value = Columns_row.get(4).getText().trim()

    String columnRole_value = Columns_row.get(5).getText()

    String columnUpdatedBy_value = Columns_row.get(6).getText()

    String columnUpdateDate_value = Columns_row.get(7).getText()

    String columnStatus_value = Columns_row.get(8).getText()

    println("$columnName_value, $columnEmail_value, $columnTicketType_value, $columnRole_value, $columnUpdatedBy_value, $columnUpdateDate_value, $columnStatus_value")

    String userAccount = WebUI.getText(findTestObject('Object Repository/Page_Watsons User/userAccount_Name'))

    println("$watsons_Username, $watsons_Email, $result, $watsons_Role, $userAccount, $formattedDateTime")

    if (((((((columnName_value == watsons_Username) && (columnEmail_value == watsons_Email)) && (columnTicketType_value == 
    result)) && (columnRole_value == watsons_Role)) && (columnUpdatedBy_value == userAccount)) && (columnUpdateDate_value == 
    formattedDateTime)) && (columnStatus_value == 'Active')) {
        println('Successfully updated')

        isMatch = true
    } else {
        println('Incorrect details')

        isMatch = false
    }
}

assert isMatch == true


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

WebUI.callTestCase(findTestCase('Sprint 1/VendorPortal_Login_TC/TC001_LoginValidCredentials_Vendor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/titlePage_Dashboard'), 'Dashboard')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/VendorMenu/vendorMenu_Home'), 'Home')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/VendorMenu/vendorMenu_Reports'), 'Reports')

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Homescreen/SuperAdminMenu/menu_Admin'), 2)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/VendorMenu/vendorMenu_Ticket'), 'Ticket')

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Homescreen/SuperAdminMenu/menu_Upload'), 2)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Homescreen/SuperAdminMenu/menu_Audit Trail'), 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/container_Form2307'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/container_RemittanceAdvice'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/container_BulletinMemo'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/container_Tickets'), 0)

//elements in the Form 2307 container
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/counter_Form2307'), 0) //unread counter

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/icon_Form2307'), 0) //icon

WebUI.takeElementScreenshot(findTestObject('Object Repository/Page_Homescreen/icon_Form2307'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/label_UnreadForm2307'), 'Unread') //label

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/label_Form 2307'), 'Form 2307') //label

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/buttonForm2307_View All'), 0) //viewAll button

//elements in the Remittance Advice container
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/counter_RemittanceAdvice'), 0) //unread counter

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/icon_RemittanceAdvice'), 0) //icon

WebUI.takeElementScreenshot(findTestObject('Object Repository/Page_Homescreen/icon_RemittanceAdvice'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/label_UnreadRA'), 'Unread') //label

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/label_Remittance Advice'), 'Remittance Advice') //label

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/button_RAView All'), 0) //viewAll button

//elements in the Bulletin memo container
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/counter_BulletinMemo'), 0) //unread counter

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/icon_BulletinMemo'), 0) //icon

WebUI.takeElementScreenshot(findTestObject('Object Repository/Page_Homescreen/icon_BulletinMemo'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/label_PublishedBM'), 'Published') //label

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/label_Bulletin Memo'), 'Bulletin Memo') //label

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/button_BMView All'), 0) //viewAll button

//elements in the Tickets container
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/counter_Tickets'), 0) //unread counter

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/icon_Tickets'), 0) //icon

WebUI.takeElementScreenshot(findTestObject('Object Repository/Page_Homescreen/icon_Tickets'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/label_Open'), 'Open') //label

WebUI.verifyElementText(findTestObject('Object Repository/Page_Homescreen/label_Tickets'), 'Tickets') //label

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Homescreen/button_TicketsView All'), 0) //viewAll button

WebUI.closeBrowser()

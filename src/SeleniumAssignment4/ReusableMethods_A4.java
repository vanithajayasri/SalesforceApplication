package SeleniumAssignment4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;





/*import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;*/
//import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReusableMethods_A4 {
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;
	public static WebDriver driver;
	
	/*Name of the Method : launchBrowser
	 * Brief Description : launching the browser in forefox
	 * Arguments : URL --> String url
	 * Creation of Date : Sep 30 ,2016
	 * last Modified : Sep 30,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static void launchBrowser(){
		
			driver = new FirefoxDriver();
			driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();
	
	
	}
	
	/*Name of the Method : launchBrowser
	 * Brief Description : launching the browser in chrome
	 * Arguments : URL --> String url
	 * Creation of Date : oct 13 ,2016
	 * last Modified : oct 13,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static void launchBrowser_chrome() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C://Users//sudt//Downloads//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
}
	/*Name of the Method : launchBrowser
	 * Brief Description : launching the browser in IE
	 * Arguments : URL --> String url
	 * Creation of Date : oct 13 ,2016
	 * last Modified : oct 13,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static void launchBrowser_IE() throws InterruptedException{
		System.setProperty("webdriver.ie.driver", "C://Users//sudt//Downloads//IEDriverServer_x64_2.53.1//IEDriverServer (2).exe");
		driver = new InternetExplorerDriver(); 
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
	}
	
	
	/*Name of the Method : elementXpath
	 * Brief Description : xpath of the element
	 * Arguments : xpathExp --> String xpathExp
	 * Creation of Date : Sep 30 ,2016
	 * last Modified : Sep 30,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static WebElement elementXpath(String xpathExp){
		
		WebElement element =driver.findElement(By.xpath(xpathExp));
		return element; 
		
	}
	
	/*Name of the Method : idPath
	 * Brief Description : id path of the element
	 * Arguments : xpathExp --> String idExp
	 * return parameters : element Webelement
	 * Creation of Date : Oct6 ,2016
	 * last Modified : Oct6,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static WebElement idPath(String idExp){
		
		WebElement element =driver.findElement(By.id(idExp));
		return element; 
		
	}
	
	
	/*Name of the Method : linkXpath
	 * Brief Description : xpath of the element
	 * Arguments : xpathExp --> String xpathExp
	 * return parameters : element Webelement
	 * Creation of Date : Sep 30 ,2016
	 * last Modified : Sep 30,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static WebElement linkXpath(String xpathExp){
		
		WebElement element =driver.findElement(By.linkText(xpathExp));
		return element; 
		
	}
	
	/* Name of the Method : Enter Text
	 * Brief Description :Enter text to the text feild
	 * Arguments: Obj --> Object webelement , textnmae--> text value to be entered,onjNmae --> Object Name
	 * Creation of Date : Sep 30 ,2016
	 * last Modified : Sep 30,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static void enterText(WebElement obj , String textName , String ObjName) throws IOException{
		if(obj.isDisplayed()){
			obj.sendKeys(textName);
			Update_Report("Pass","enterText",  textName + " is entered in the "+ ObjName+ " feild");
			System.out.println("Pass: "+ textName + " is entered in the "+ ObjName+ " feild");
		}
		else{
			Update_Report("Fail","enterText", textName +" feild is not avalibale please check it.");
			System.out.println("Fail: "+ textName +" feild is not avalibale please check it.");
		}
		
	}
	
	/* Name of the Method : click button 
	 * Brief Description :clicking the button 
	 * Arguments: Obj --> Object webelement ,,objName --> Object Name
	 * Creation of Date : Sep 30 ,2016
	 * last Modified : Sep 30,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static void clickBUtton(WebElement obj,String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass","clickBUtton", objName + " is clicked");
			System.out.println("Pass: "+ objName + " is clicked");
		}
		else{
			Update_Report("Fail","clickBUtton", objName +" is not able to click ");
			System.out.println("Fail: "+ objName +" is not able to click ");
		}
		
	}
	
	/* Name of the Method : writeXl
	 * Brief Description :writing to the xls file
	 * Arguments: String testData --filepath
	 * 			 String sheetName----> name of the sheet 
	 * 			int iRow --------> row number
	 * 			int iCol --------> column number
	 * 			String XlData ----> data to be written on the file 
	 * Creation of Date : oct 6 ,2016
	 * last Modified : oct 6,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static void writeXl(String testData ,String sheetName ,int iRow ,int iCol , String XlData) throws IOException{
		
		
		//get the file path
		File xlfile = new File(testData);
		
		//Access the file
		FileInputStream xldoc = new FileInputStream(xlfile);
		
		//access the work book POI jar file
		XSSFWorkbook wb = new XSSFWorkbook(xldoc);
		
		//access the sheet
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		//access the row
		XSSFRow row = sheet.getRow(iRow);
		
		//access the cell
		XSSFCell cell = row.getCell(iCol);
		
		//cell.setCellValue(XlData);
		
	      CreationHelper createHelper = wb.getCreationHelper();
	      XSSFCellStyle hlinkstyle = wb.createCellStyle();
	      XSSFFont hlinkfont = wb.createFont();
	      hlinkfont.setUnderline(XSSFFont.U_SINGLE);
	      hlinkfont.setColor(HSSFColor.BLUE.index);
	      hlinkstyle.setFont(hlinkfont);
		
	    XSSFHyperlink link = (XSSFHyperlink)createHelper.createHyperlink(Hyperlink.LINK_URL);
	    link.setAddress(htmlname);
	 	cell.setHyperlink((XSSFHyperlink) link);
	 	cell.setCellStyle(hlinkstyle);
	   
	    //cell.setCellValue(XlData);
		
		if(XlData=="Pass"){
			XSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.LIGHT_GREEN().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
			hlinkfont.setUnderline(XSSFFont.U_SINGLE);
			
		}else if(XlData=="Fail"){
			XSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
			 hlinkfont.setUnderline(XSSFFont.U_SINGLE);
		}
		else{
			XSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.LIGHT_BLUE().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
			hlinkfont.setUnderline(XSSFFont.U_SINGLE);
		}
		
		FileOutputStream fout = new FileOutputStream(testData);
		wb.write(fout);
		fout.flush();
		fout.close();
		//wb.close();
		
		
	}
	
	/* Name of the Method : readXl
	 * Brief Description :reading the xls file
	 * Arguments: String testData --filepath
	 * 			 String sheetName----> name of the sheet 
	 * Creation of Date : oct 6 ,2016
	 * last Modified : oct 6,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static String[][] readXl(String testData ,String sheetName) throws IOException{
		
		
		//get the file path
		File xlfile = new File(testData);
		
		//Access the file
		FileInputStream xldoc = new FileInputStream(xlfile);
		
		//access the work book POI jar file
		XSSFWorkbook wb = new XSSFWorkbook(xldoc);
		
		//access the sheet
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		
		int rowCount = sheet.getLastRowNum() + 1 ;
		int colCount =sheet.getRow(0).getLastCellNum();
		String[][]  xlData =new String[rowCount][colCount];
		
		for(int i =0;i< rowCount;i++){
			for(int j=0 ;j<colCount ;j++){
				xlData[i][j]=sheet.getRow(i).getCell(j).getStringCellValue(); 
				 
			}
		}
		return xlData;
	}
	
	/* Name of the Method : startReport
	 * Brief Description :writing to the xls file
	 * Arguments:  String scriptName --name of the script
	 * 			   String ReportsPath----> path of the html report to be placed
	 * Creation of Date : oct 6 ,2016
	 * last Modified : oct 6,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}
	
	/* Name of the Method : Update_Report
	 * Brief Description :updating the report
	 * Arguments:  String Res_type ---> type of the result 'pass' or 'fail'
	 * 			 String Action----> the action
	 * 			 String result ----> result of the action 
	 * Creation of Date : oct 6 ,2016
	 * last Modified : oct 6,2016
	 * Created by: Enexus Automation team
	 * */

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
	
}

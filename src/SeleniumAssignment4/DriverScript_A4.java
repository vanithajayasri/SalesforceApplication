package SeleniumAssignment4;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DriverScript_A4 {
	public static int reportFlag =0;
	public static void main(String[] args) throws Exception {
		String testDataPath = "C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestSuite.xlsx";
		String sheetName ="Sheet3";
		String[][] recData = ReusableMethods_A4.readXl( testDataPath , sheetName);
		
		for(int i= 1;i<recData.length ;i++){
			reportFlag =0 ;
			int index =0; 
			if(recData[i][1].equalsIgnoreCase("Y")){
				
				//firefox browser
				if(recData[i][3].equalsIgnoreCase("Y")){
					index = 3;
					String testScriptName = recData[i][2];
					ReusableMethods_A4.launchBrowser();
					ReusableMethods_A4.startReport(testScriptName, "C:/Users/sudt/Desktop/vanitha/enexus/framework/Reports/");
					// Java reflection  or reflexive API
					try{
					
						Method tc = AutomationScripts_A4.class.getMethod(testScriptName);
						tc.invoke(tc);
					}
					catch(Exception e){
						reportFlag =1;
						ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 3, "Fail");
						System.out.println("error with this testScript: " + e);
						
					}
					
					ReusableMethods_A4.bw.close();
					
					
					if(reportFlag ==0){
						ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 3, "Pass");
					}
					else{
						ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 3, "Fail");
					}
				}	
			
			
			//chrome browser
				else if(recData[i][4].equalsIgnoreCase("Y")){
				index = 4;
				String testScriptName = recData[i][2];
				ReusableMethods_A4.launchBrowser_chrome();
				ReusableMethods_A4.startReport(testScriptName, "C:/Users/sudt/Desktop/vanitha/enexus/framework/Reports/");
				//Java Reflection or Reflexive API
				try{
					Method tc = AutomationScripts_A4.class.getMethod(testScriptName);
					tc.invoke(tc);
				}
				catch(Exception e) {
					reportFlag =1;
					ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 3, "Fail");
					System.out.println("error with this testScript: " + e);
					
				}	
				
				
				if(reportFlag == 0){
					ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 4, "Pass");
				}else{
					ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 4, "Fail");
				}
			}
			
			
			//IE browser
				else if(recData[i][5].equalsIgnoreCase("Y")){
				index =5;
				String testScriptName = recData[i][2];
				ReusableMethods_A4.launchBrowser_IE();
				ReusableMethods_A4.startReport(testScriptName, "C:/Users/sudt/Desktop/vanitha/enexus/framework/Reports/");
				//Java Reflection or Reflexive API
				try{
					Method tc = AutomationScripts_A4.class.getMethod(testScriptName);
					tc.invoke(tc);
				}
				catch(Exception e) {
					reportFlag =1;
					ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 5, "Fail");
					System.out.println("error with this testScript: " + e);
					
				}	
				ReusableMethods_A4.bw.close();
				
				if(reportFlag == 0){
					ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 5, "Pass");
				}else{
					ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 5, "Fail");
				}
			}
			else{
					ReusableMethods_A4.writeXl(testDataPath, sheetName, i, index, "Not executed");
				}
			
		}	
			
		else{
				ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 3, "Not executed");
				ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 4, "Not executed");
				ReusableMethods_A4.writeXl(testDataPath, sheetName, i, 5, "Not executed");
			}
			
	}
		
		

	}


}

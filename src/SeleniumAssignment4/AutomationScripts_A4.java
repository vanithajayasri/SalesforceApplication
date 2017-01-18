package SeleniumAssignment4;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationScripts_A4 extends ReusableMethods_A4 {

	
	// TC1
	public static void Login_toSalesForce() throws IOException, InterruptedException{
		
		Thread.sleep(8000);
		String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
		
		String url = recData[1][0];
		String usname = recData[1][1];
		String password = recData[1][2];
		
		//launchBrowser();

		WebElement un= elementXpath("//input[@type='email']");
		WebElement pwd = elementXpath("//input[@name='pw']");
		WebElement login= elementXpath("//input[@name='Login']");
		
		/*enter username text field*/
		enterText(un ,usname,"username");
		
		/*entered the password text field*/
		enterText(pwd,password,"password");
		
		/* login button is clicked */
		clickBUtton(login,"login_button");
		
	}
	
	//TC2
	public static void Login_ErrorMessage() throws IOException {
		
		
		String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
		
		String url = recData[1][0];
		String usname = recData[1][1];
		
		String expectedError ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		//launchBrowser();
		
		/* finding the element by the given xpath */
		WebElement un= elementXpath("//input[@type='email']");
		WebElement pwd = elementXpath("//input[@name='pw']");
		WebElement login= elementXpath("//input[@name='Login']");
		
		/*enter username text field*/
		enterText(un ,usname,"username");
		
		/*entering the wrong password text field*/
		enterText(pwd,"welcome1","password");
		
		/* login button is clicked */
		clickBUtton(login,"login_button");
		
		String actualError  = driver.findElement(By.xpath("//div[@id='error']")).getText(); 
		System.out.println("Login error message ,if wrong password is entered :  "+actualError);
		if(actualError.equals(expectedError)){
			System.out.println("Pass : error message matches");
		}
		else{
			System.out.println("Fail: error message matches is not matching with displayed text");
		}
		
		

	}
	//TC3
	public static void checkRememberMe() throws IOException, InterruptedException {
		
		
			
			String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
			
			String url = recData[1][0];
			String usname = recData[1][1];
			String password = recData[1][2];
			
			//launching the browser 
			//launchBrowser();
			
			// finding the element by the given xpath 
			WebElement un= elementXpath("//input[@type='email']");
			WebElement pwd = elementXpath("//input[@name='pw']");
			
			
			
			//entering wrong  username in the text field
			enterText(un ,usname,"username");
			
			//entering the wrong password text field
			enterText(pwd,password,"password");
			
			 //rememberMe button is checked 
			WebElement rememberMe = elementXpath("//*[@id='rememberUn']");
			clickBUtton(rememberMe,"rememberMe_button");
			
			// login button is clicked 
			WebElement login= elementXpath("//input[@name='Login']");
			clickBUtton(login,"login_button");
			
				
			//home page of  sales force
			Thread.sleep(6000);
		
			// userNaviagtion link web element is found and  is clicked 
			WebElement userNaviagtionLink= elementXpath("//*[@id='userNavLabel']");
			clickBUtton(userNaviagtionLink,"userNaviagtion Link");
			
			Thread.sleep(8000);
			//clicking on log out button
			WebElement logoutLink= linkXpath("Logout");
			clickBUtton(logoutLink,"Logout Link");
			
			Thread.sleep(8000);
			WebElement un1= elementXpath("//input[@type='email']");
			// after log out checking the username name is avaliable in the username button
			if(un.getAttribute("value").equals("vanitha.gurrams@gmail.com")){
				System.out.println("Pass: logout sucessfully and rememeber me button is successfully placed my username in the feild");
				
			}
			else{
				System.out.println(" Fail: logout successfully but rememeber me button is unsuccessful and not placing my username in the feild");
			}
		
		}
	
	//TC4a
	public static void ForgetPassword() throws IOException, InterruptedException {
		
		
		String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
		
		String url = recData[1][0];
		//launchBrowser(url);
		
		WebElement link = linkXpath("Forgot Your Password?");
		clickBUtton(link,"forget password link");

		Thread.sleep(3000);
		 //finding the element by the given xpath of the forget password page  
		WebElement unfp= elementXpath("//input[@name='un']"); //usename of forget password page
		
		 //sending the keys to the webelement
		enterText(unfp ,"vanitha.gurram@gmail.com","username of forget password page");
		
		// continue button is clicked 
		WebElement continue_button= elementXpath("//*[@id='continue']");
		
		// clicking on the continue button 
		clickBUtton(continue_button,"continue button of forget password page ");
		
		
	}
	//Tc4b
	public static void LoginWith_WrongUsername_Password() throws IOException {
	
		
		String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
		
		String url = recData[1][0];
		String usname = recData[1][1];

		
		//launchBrowser(url);
		 //inding the element by the given xpath 
		WebElement un= elementXpath("//input[@type='email']");
		WebElement pwd = elementXpath("//input[@name='pw']");
		WebElement login= elementXpath("//input[@name='Login']");
		
		//entering wrong  username in the text field
		enterText(un ,usname,"username");
		
		//entering the wrong password text field
		enterText(pwd,"welcome1","password");
		
		 //login button is clicked 
		clickBUtton(login,"login_button");
	
		String errorMesg = driver.findElement(By.xpath("//*[@id='error']")).getText();
		System.out.println("msg-----  "+errorMesg);
	

	}
	
	//TC5
	public static void selectingUSerMenu() throws IOException, InterruptedException{
		
		
		String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
		
		String url = recData[1][0];
		String usname = recData[1][1];
		String password = recData[1][2];
		
		//launchBrowser(url);
		
		// finding the element by the given xpath 
		WebElement un= elementXpath("//input[@type='email']");
		WebElement pwd = elementXpath("//input[@name='pw']");
		WebElement login= elementXpath("//input[@name='Login']");
		
		//enter username text field
		enterText(un ,usname,"username");
		
		//entering the wrong password text field
		enterText(pwd,password,"password");
		
		 //login button is clicked 
		clickBUtton(login,"login_button");
		
		// searching for the userMenu 
		Thread.sleep(6000);
		WebElement user_menu = elementXpath("//span[@id='userNavLabel']");
		String userMenuText = user_menu.getText();
		//String userMenu = driver.findElement(By.xpath("//*[@id='userNavLabel']")).getText();
		if(userMenuText.equalsIgnoreCase("vanitha jayasri")){
			System.out.println(userMenuText +" : user drop down menu is found. ");
		}
		
		//clicking on the usermenu
		clickBUtton(user_menu,"user_menu");
	
	}

	//TC6
public static void ChangingMyProfile() throws InterruptedException, IOException{
		
		String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
		
		String url = recData[1][0];
		String usname = recData[1][1];
		String password = recData[1][2];
		
		//launching the browser
		//launchBrowser(url);
	
		// finding the element by the given xpath 
		WebElement un= elementXpath("//input[@type='email']");
		WebElement pwd = elementXpath("//input[@name='pw']");
		WebElement login= elementXpath("//input[@name='Login']");
		
		//enter username text field
		enterText(un ,usname,"username");
		
		//entering the wrong password text field
		enterText(pwd,password,"password");
		
		 //login button is clicked 
		clickBUtton(login,"login_button");
		
		Thread.sleep(4000);
		//clicking on the user navigation link
		
		WebElement userNavigation = elementXpath("//div[@id='userNav-arrow']");
		clickBUtton(userNavigation,"user link");

		//selecting the my profile link and clicking
		WebElement myProfileLink = elementXpath("//*[@id='userNav-menuItems']/a[1]");
		clickBUtton(myProfileLink,"myProfile Link");

		//selecting the my profile edit  link
		WebElement myProfileEditLink = elementXpath("//*[@id='moderatorMutton']");
		clickBUtton(myProfileEditLink,"myProfile edit  Link");
		
		//clciking on the edit profile link
		WebElement editLink = linkXpath("Edit Profile");
		clickBUtton(editLink,"edit  Link");
		
		
		Thread.sleep(3000);
		driver.switchTo().frame("aboutMeContentId");
		
		//clicking on the about tab
		WebElement aboutLink = linkXpath("About");
		clickBUtton(aboutLink,"About tab");
		
		WebElement name = driver.findElement(By.id("lastName"));
		name.clear();
		name.sendKeys("tkk");
		System.out.println("name is wriiten ");
		driver.findElement(By.id("aboutMe")).sendKeys("Hello everyone");
		driver.findElement(By.cssSelector("input[value='Save All']")).click();
		System.out.println("contact link is clicked");
	
	}

//TC7
public static void ChangingMySettings() throws InterruptedException, IOException{
	
	String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
	
	String url = recData[1][0];
	String usname = recData[1][1];
	String password = recData[1][2];
	
	//launching the browser
	//launchBrowser(url);

	 //finding the element by the given xpath 
	WebElement un= elementXpath("//input[@type='email']");
	WebElement pwd = elementXpath("//input[@name='pw']");
	WebElement login= elementXpath("//input[@name='Login']");
	
	//enter username text field
	enterText(un ,usname,"username");
	
	//entering the wrong password text field
	enterText(pwd,password,"password");
	
	 //login button is clicked 
	clickBUtton(login,"login_button");
	
	Thread.sleep(6000);
	//clicking on the user navigation link
	WebElement userNavigation = elementXpath("//div[@id='userNav-arrow']");
	clickBUtton(userNavigation,"user link");

	//clicking on user link and on my settings link
	WebElement mySettingsLink = elementXpath("//*[@id='userNav-menuItems']/a[2]");
	clickBUtton(mySettingsLink,"mySettings Link");

	
	//clicking on personal link
	WebElement personalLink = idPath("PersonalInfo_font");
	clickBUtton(personalLink,"personal Link");
	
	
	//clicking on history link
	WebElement LoginHistoryLink = idPath("LoginHistory_font");
	clickBUtton(LoginHistoryLink,"Login History Link");
	
	Thread.sleep(4000);
	
	//clicking on display and layout link
	WebElement DisplayAndLayoutLink = idPath("DisplayAndLayout_font");
	clickBUtton(DisplayAndLayoutLink,"DisplayAndLayout Link");
	
	
	//clicking on customize my tab links
	WebElement CustomizeTabsLink = idPath("CustomizeTabs_font");
	clickBUtton(CustomizeTabsLink,"CustomizeTabs Link");
	
	Thread.sleep(3000);
	//selecting the options custom app menu
	Select app = new Select(driver.findElement(By.id("p4")));
	app.selectByVisibleText("Salesforce Chatter");
	
	Thread.sleep(4000);
	//selecting reports tab from avaliable tabs menu
	Select avaliable_menu = new Select(driver.findElement(By.id("duel_select_0")));
	avaliable_menu.selectByVisibleText("Reports");
	
	Thread.sleep(4000);
	//clicking on add 
	WebElement addbutton= elementXpath("//*[@id='duel_select_0_right']/img");
	clickBUtton(addbutton,"add button");
	
	
	//clicking on the email link
	WebElement emailLink = idPath("EmailSetup_font");
	clickBUtton(emailLink,"email Link");
	
	//clicking on email settings link
	WebElement EmailSettingsLink = idPath("EmailSettings_font");
	clickBUtton(EmailSettingsLink,"Email Settings Link");
	
	
	//changing the email settings
	Thread.sleep(2000);
	WebElement name= elementXpath("//*[@id='sender_name']");
	name.clear();
	name.sendKeys("vanitha");
	WebElement email = idPath("sender_email");
	email.clear();
	email.sendKeys(usname);
	WebElement button = idPath("auto_bcc1");  
	if(button.isSelected()==true){
		System.out.println("buttton is already slected");
	}
	else{
		button.click();
		System.out.println("now selected");
	}
	//clicking on save button
	WebElement saveButton= elementXpath("//*[@id='bottomButtonRow']/input[1]");
	clickBUtton(saveButton,"save Button  ");
	
	
	Thread.sleep(3000);
	//clicking on calendar and Reminder button
	WebElement CalendarAndRemindersLink = idPath("CalendarAndReminders_font");
	clickBUtton(CalendarAndRemindersLink,"Calendar And Reminders Link");
	
	//clicking on reminder link
	WebElement RemindersLink = idPath("Reminders_font");
	clickBUtton(RemindersLink,"Reminders Link");
	
	//clicking on reminders alert
	WebElement reminder_button = idPath("enable_reminders");
	
	String parentWindow = driver.getWindowHandle();
	//clicking on the open test reminder link
	WebElement openTestReminderLink = elementXpath("//*[@id='testbtn']");
	clickBUtton(openTestReminderLink,"open Test Reminder Link");
	
	
	for(String newWindow: driver.getWindowHandles()){
		driver.switchTo().window(newWindow);// switch focus of WebDriver to the next found window handle (that's your newly opened window)
	}
	
	System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
	Thread.sleep(4000);
	driver.close(); // close newly opened window when done with it
	driver.switchTo().window(parentWindow); // switch back to the original window

}

	//TC8
public static void ChangingDeveloperConsole() throws InterruptedException, IOException{
		
	String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
	
	String url = recData[1][0];
	String usname = recData[1][1];
	String password = recData[1][2];
	
	//launching the browser
	//launchBrowser(url);

	 //finding the element by the given xpath 
	WebElement un= elementXpath("//input[@type='email']");
	WebElement pwd = elementXpath("//input[@name='pw']");
	WebElement login= elementXpath("//input[@name='Login']");
	
	//enter username text field
	enterText(un ,usname,"username");
	
	//entering the wrong password text field
	enterText(pwd,password,"password");
	
	// login button is clicked 
	clickBUtton(login,"login_button");
	
	Thread.sleep(6000);
	
	//clicking on the user navigation link
	WebElement userNavigation = elementXpath("//div[@id='userNav-arrow']");
	clickBUtton(userNavigation,"user link");

	String parentWindow = driver.getWindowHandle();
	
	
	Thread.sleep(3000);
	//clicking on developer console link
	WebElement developerConsoleLink = elementXpath("//*[@id='userNav-menuItems']/a[3]");
	clickBUtton(developerConsoleLink,"Developer Console Link");
	
	//switching to the new window
	for(String newWindow: driver.getWindowHandles()){
		driver.switchTo().window(newWindow);//// switch focus of WebDriver to the next found window handle (that's your newly opened window)
	}
	
	System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
	driver.close(); // close newly opened window when done with it
	driver.switchTo().window(parentWindow); // switch back to the original window

}

//TC9
public static void Logout() throws IOException, InterruptedException{
	
		
		String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
		
		String url = recData[1][0];
		String usname = recData[1][1];
		String password = recData[1][2];
		
		//launching the browser
		//launchBrowser(url);
	
		// finding the element by the given xpath 
		WebElement un= elementXpath("//input[@type='email']");
		WebElement pwd = elementXpath("//input[@name='pw']");
		WebElement login= elementXpath("//input[@name='Login']");
		
		//enter username text field
		enterText(un ,usname,"username");
		
		//entering the wrong password text field
		enterText(pwd,password,"password");
		
		 //login button is clicked 
		clickBUtton(login,"login_button");
		
		Thread.sleep(6000);
		//clicking on the user navigation link
		WebElement userNavigation = elementXpath("//div[@id='userNav-arrow']");
		clickBUtton(userNavigation,"user link");

		//clicking on logout link
		WebElement logOutLink = elementXpath("//*[@id='userNav-menuItems']/a[5]");
		clickBUtton(logOutLink,"Logout Link");

	}
//TC10

	public static void CreatAccount() throws InterruptedException, IOException{
		
		String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
		
		String url = recData[1][0];
		String usname = recData[1][1];
		String password = recData[1][2];
		
		//launching the browser
		//launchBrowser(url);
	
		 //finding the element by the given xpath 
		WebElement un= elementXpath("//input[@type='email']");
		WebElement pwd = elementXpath("//input[@name='pw']");
		WebElement login= elementXpath("//input[@name='Login']");
		
		//enter username text field
		enterText(un ,usname,"username");
		
		//entering the wrong password text field
		enterText(pwd,password,"password");
		
		 //login button is clicked 
		clickBUtton(login,"login_button");
		
		Thread.sleep(6000);
		//clicking on the Account link
		WebElement accountsLink = elementXpath("//*[@id='Account_Tab']/a");
		clickBUtton(accountsLink,"Accounts link");
		
		Thread.sleep(6000);
		//clicking on the Account link
		WebElement accountsNewLink = elementXpath("//input[@name='new']");
		clickBUtton(accountsNewLink," New link");

	}
//TC11
public static void CreateNewView() throws InterruptedException, IOException{
	
	String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
	
	String url = recData[1][0];
	String usname = recData[1][1];
	String password = recData[1][2];
	
	//launching the browser
	//launchBrowser(url);

	 //finding the element by the given xpath 
	WebElement un= elementXpath("//input[@type='email']");
	WebElement pwd = elementXpath("//input[@name='pw']");
	WebElement login= elementXpath("//input[@name='Login']");
	
	//enter username text field
	enterText(un ,usname,"username");
	
	//entering the wrong password text field
	enterText(pwd,password,"password");
	
	// login button is clicked 
	clickBUtton(login,"login_button");
	
	Thread.sleep(6000);

	//clicking on the Account link
	WebElement accountsLink = elementXpath("//*[@id='Account_Tab']/a");
	clickBUtton(accountsLink,"Accounts link");
			
	Thread.sleep(6000);
	//clicking on the Account new  link
	WebElement newViewLink = linkXpath("Create New View");
	clickBUtton(newViewLink," Create New view link");
	
	Thread.sleep(6000);
	//passing keys to view name and unique view name
	WebElement viewName = elementXpath("//*[@id='fname']");
	viewName.sendKeys("vani");
	WebElement newViewName = elementXpath("//*[@id='devname']");
	newViewName.clear();
	newViewName.sendKeys("vani");
	
	
	
	//clicking on save button
	WebElement save = elementXpath("//input[@name='save']");
	clickBUtton(save,"save button");

}

//TC12
public static void EditView() throws IOException, InterruptedException{
	
	String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
	
	String url = recData[1][0];
	String usname = recData[1][1];
	String password = recData[1][2];
	
	//launching the browser
	//launchBrowser(url);

	 //finding the element by the given xpath 
	WebElement un= elementXpath("//input[@type='email']");
	WebElement pwd = elementXpath("//input[@name='pw']");
	WebElement login= elementXpath("//input[@name='Login']");
	
	//enter username text field
	enterText(un ,usname,"username");
	
	//entering the wrong password text field
	enterText(pwd,password,"password");
	
	 //login button is clicked 
	clickBUtton(login,"login_button");
	
	Thread.sleep(6000);
	//clicking on the Account link on the home page
	WebElement accountsLink = elementXpath("//*[@id='Account_Tab']/a");
	clickBUtton(accountsLink,"Accounts link");
	
	Thread.sleep(6000);
	//selecting the option 'my account' 
	Select view_menu = new Select(driver.findElement(By.xpath("//*[@id='fcf']")));
	view_menu.selectByVisibleText("New vanitha account");
	
	Thread.sleep(10000);
	//clicking on the 'go' button
	WebElement goButton = elementXpath("//input[@name='go']");
	clickBUtton(goButton,"GO! Button");
	
	Thread.sleep(6000);
	//clicking on the 'edit' button 
	WebElement editButton = elementXpath("//*[@id='is:islv:inlineSchedulerListView:enhancedList_filterLinks']/a[1]");
	clickBUtton(editButton,"Edit Button");
	
	
	//changing the 'view name' field to new view name
	Thread.sleep(6000);
	WebElement view_name = elementXpath("//*[@id='fname']");
	view_name.clear();
	view_name.sendKeys("New vanitha account");
	
	//changing filter field options
	//selecting the 'field ' option
	Thread.sleep(6000);
	Select field_menu = new Select(elementXpath("//*[@id='fcol1']"));
	field_menu.selectByVisibleText("Account Name");
	
	//selecting the 'field ' option
	Thread.sleep(6000);
	Select operator_menu = new Select(elementXpath("//*[@id='fop1']"));
	operator_menu.selectByVisibleText("contains");
	
	Thread.sleep(6000);
	//passing the keys to 'value' feild
	WebElement value = elementXpath("//*[@id='fval1']");
	value.clear();
	value.sendKeys("a");
	
	
	
	//selecting the 'avalible fields ' option
	Thread.sleep(6000);
	Select avaliableField_menu = new Select(elementXpath("//*[@id='colselector_select_0']"));
	avaliableField_menu.selectByVisibleText("Last Activity");
	
	//clicking on the 'add' button
	WebElement addButton = elementXpath("//*[@id='colselector_select_0_right']/img");
	clickBUtton(addButton,"add Button");
	
	Thread.sleep(6000);
	//clicking on the save button
	WebElement saveButton = elementXpath("//input[@name='save']");
	clickBUtton(saveButton,"Save Button");
	
}

//TC13
public static void MergeAccounts() throws IOException, InterruptedException{

	String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
	
	String url = recData[1][0];
	String usname = recData[1][1];
	String password = recData[1][2];
	
	//launching the browser
	//launchBrowser(url);

	 //finding the element by the given xpath 
	WebElement un= elementXpath("//input[@type='email']");
	WebElement pwd = elementXpath("//input[@name='pw']");
	WebElement login= elementXpath("//input[@name='Login']");
	
	//enter username text field
	enterText(un ,usname,"username");
	
	//entering the wrong password text field
	enterText(pwd,password,"password");
	
	 //login button is clicked 
	clickBUtton(login,"login_button");
	
	Thread.sleep(6000);
	//clicking on the Account link on the home page
	WebElement accountsLink = elementXpath("//*[@id='Account_Tab']/a");
	clickBUtton(accountsLink,"Accounts link");
	
	Thread.sleep(6000);
	//clicking on the 'Merge Account ' under Tools heading
	WebElement mergeAccountsLink = linkXpath("Merge Accounts");
	clickBUtton(mergeAccountsLink, "Merge Accounts link");
	
	Thread.sleep(6000);
	//sending keys to the to the feild 
	WebElement searchField = elementXpath("//*[@id='srch']");
	searchField.sendKeys("Ac");
	
	Thread.sleep(6000);
	//clicking on the button "Find Accounts"
	WebElement findAccountsButton = elementXpath("//input[@value='Find Accounts']");
	clickBUtton(findAccountsButton, "find Accounts Button");

	Thread.sleep(6000);
	//enabling the checkbox of first link
	WebElement check = elementXpath("//*[@id='cid0']");
	if(check.isSelected()==true){
		System.out.println("alreeady selected");
	}
	else{
		check.click();
		System.out.println("now selected");
	}
	
	//enabling the checkbox of first link
	WebElement check2 = elementXpath("//*[@id='cid1']");
			if(check2.isSelected()==true){
				System.out.println("check 2 already selected");
			}
			else{
				check2.click();
				System.out.println("check2 now selected");
			}
			
	Thread.sleep(6000);
	//clicking on the 'next ' button
	WebElement goNextButton = elementXpath("//input[@name='goNext']");
	clickBUtton(goNextButton, "goNext Button");
	
	Thread.sleep(6000);
	//clicking on the 'Merge ' button
	WebElement mergeButton = elementXpath("//input[@value=' Merge ']");
	clickBUtton(mergeButton, "Merge Button");

	Thread.sleep(6000);
	//move on to popup window
	Alert alert = driver.switchTo().alert();
	alert.accept();

}

//TC14
public static void CreatAccountReport() throws IOException, InterruptedException{

	String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
	
	String url = recData[1][0];
	String usname = recData[1][1];
	String password = recData[1][2];
	
	//launching the browser
	//launchBrowser(url);

	 //finding the element by the given xpath 
	WebElement un= elementXpath("//input[@type='email']");
	WebElement pwd = elementXpath("//input[@name='pw']");
	WebElement login= elementXpath("//input[@name='Login']");
	
	//enter username text field
	enterText(un ,usname,"username");
	
	//entering the wrong password text field
	enterText(pwd,password,"password");
	
	// login button is clicked 
	clickBUtton(login,"login_button");
	
	Thread.sleep(6000);
	//clicking on the Account link on the home page
	WebElement accountsLink = elementXpath("//*[@id='Account_Tab']/a");
	clickBUtton(accountsLink,"Accounts link");
	
	
	Thread.sleep(6000);
	//clicking on the 'Accounts with last activity > 30 days' under reports field
	WebElement awlaLink = linkXpath("Accounts with last activity > 30 days");
	clickBUtton(awlaLink,"Accounts with last activity > 30 days link");
	
	Thread.sleep(6000);	
	//clicking on the drop down to get options
	WebElement menuLink = elementXpath("//*[@id='ext-gen148']");
	clickBUtton(menuLink,"Menu link");
	
	Thread.sleep(6000);
	//slecting the option
	WebElement menu_option = elementXpath("//*[@id='ext-gen240']/div[3]");
	clickBUtton(menu_option,"Menu option link");
	
	Thread.sleep(8000);		
	//clicking on the date picker 
	WebElement datepickerButton = elementXpath("//*[@id='ext-gen152']");
	clickBUtton(datepickerButton,"date picker Button");
	
	//selecting the date
	WebElement date = elementXpath("//*[@id='ext-comp-1042']");
	date.sendKeys("10/7/2016");
		
	String parentWindow = driver.getWindowHandle();
	System.out.println("Title of the page before- switchingTo: " + driver.getTitle());
	
	Thread.sleep(8000);
	//clicking on save button
	WebElement saveButton = elementXpath("//*[@id='ext-gen49']");
	clickBUtton(saveButton,"saveButton Button");
		
	
	for(String newWindow: driver.getWindowHandles()){
		driver.switchTo().window(newWindow);// switch focus of WebDriver to the next found window handle (that's your newly opened window)
	}
	Thread.sleep(3000);
	System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
	WebElement reportName = elementXpath("//*[@id='saveReportDlg_reportNameField']");
	reportName.sendKeys("vjt");
	
	WebElement reportUniqueName = elementXpath("//*[@id='saveReportDlg_DeveloperName']");
	reportUniqueName.sendKeys("vjtk");
	
	Thread.sleep(6000);
	WebElement saveButton1 = elementXpath("//button[text()='Save']");
	clickBUtton(saveButton1,"saveButton Button"); //clciking on save button on poped window
	driver.close(); // close newly opened window when done with it
	
	driver.switchTo().window(parentWindow); // switch back to the original window
	
	//clciking on the ' run report' button
	WebElement runButton = elementXpath("//*[@id='ext-gen63']");
	clickBUtton(runButton,"Run report Button");

	}

	//TC15
public static void Oppurtunities() throws IOException, InterruptedException{

	String[][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData.xlsx" ,"Sheet1");
	
	String url = recData[1][0];
	String usname = recData[1][1];
	String password = recData[1][2];
	
	//launching the browser
	//launchBrowser(url);

	// finding the element by the given xpath 
	WebElement un= elementXpath("//input[@type='email']");
	WebElement pwd = elementXpath("//input[@name='pw']");
	WebElement login= elementXpath("//input[@name='Login']");
	
	//enter username text field
	enterText(un ,usname,"username");
	
	//entering the wrong password text field
	enterText(pwd,password,"password");
	
	 //login button is clicked 
	clickBUtton(login,"login_button");
	
	Thread.sleep(6000);
	//clicking on the 'Opportunities' link on the home page.
	WebElement opportunitiesLink = linkXpath("Opportunities");
	clickBUtton(opportunitiesLink,"Opportunities Link");
	

	Thread.sleep(6000);
	//selecting the drop down
	 int count = 0;
	String[] exp = {"All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities", "New This Week", "Opportunity Pipeline", "Recently Viewed Opportunities", "Won"};
	Select menu = new Select(elementXpath("//*[@id='fcf']"));
	List<WebElement> options = menu.getOptions();
	for (WebElement we : options) {
        for (int i = 0; i < exp.length; i++) {
            if (we.getText().equals(exp[i])) {
                count++;
            }
        }
    }
    if (count == exp.length) {
        System.out.println("matched");
    } else {
        System.out.println("Houston, we have a problem.");
    }

}

}

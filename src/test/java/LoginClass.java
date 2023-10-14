
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;
public class LoginClass {
	
@Test
	public void login() {
		
//	login page
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
//		user name
		String username="Crazypriyalovely07";
//		password
		String password="Bot@12345";
//		post number
		int postNumber=2;
		
		
//		explicit wait
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		username Element
		WebElement userNameElement=wait.until(ExpectedConditions.presenceOfElementLocated
				(ByXPath.xpath("//input[@name='username']")));
		userNameElement.sendKeys(username);
		
//		password element
		WebElement passwordElement=wait.until(ExpectedConditions.presenceOfElementLocated
(ByXPath.xpath("//input[@name='password']")));
		passwordElement.sendKeys(password);
		
//		login button
		WebElement submitElement=wait.until(ExpectedConditions.elementToBeClickable
(ByXPath.xpath("//*[contains(text(),'Log in')]")));
		
		if(submitElement.isEnabled()) {
			submitElement.click();
		}
		else {
			System.out.println("submitElement is not enabled"); 
		}
		

//		home page
//		not now button1 
		WebElement NotNowElement1=wait.until(ExpectedConditions.elementToBeClickable
				(ByXPath.xpath("//*[contains(text(),'Not Now')]")));
		if(NotNowElement1.isEnabled()) {
			NotNowElement1.click();
		}
		else {
			System.out.println("NotNowElement1 is not enabled"); 
		}
//		not now button2
		WebElement NotNowElement2=wait.until(ExpectedConditions.
				elementToBeClickable(ByXPath.xpath("//*[contains(text(),'Not Now')]")));
		if(NotNowElement2.isEnabled()) {
			NotNowElement2.click();
		}
		else {
			System.out.println("NotNowElement2 is not enabled"); 
		}
//		Home profile
		WebElement profileElement=wait.until(ExpectedConditions.elementToBeClickable(ByXPath.xpath("//a[.='Profile']")));
		if(profileElement.isEnabled()) {
			profileElement.click();
		}
		else {
			System.out.println("profile element is not present");
		}
		
//		get post parent element	
		
//		WebElement postElementParent=wait.until(ExpectedConditions.
//				presenceOfElementLocated(
//						ByXPath.xpath("//div[contains(@class,'_ac7v  _al3n')]")));
//		List<WebElement> childElements=postElementParent.findElements(By.xpath("//div[contains(@class,'_aabd _aa8k  _al3l')]"));
//	
		ArrayList<InstagramPerson> personList=new ArrayList<InstagramPerson>();
		
//        String postUrl="";

        String postUrlArray[]= {"https://www.instagram.com/p/CyQd-5rLH9Z/?utm_source=ig_web_copy_link&igshid=MzRlODBiNWFlZA==",
        		"https://www.instagram.com/p/CwpZdW1h--i/?utm_source=ig_web_copy_link&igshid=MzRlODBiNWFlZA=="};
        

        for(int eachPost=0;eachPost<postUrlArray.length;eachPost++) {
        	personList.addAll(collectLikeCount(driver,wait,postUrlArray[eachPost]));
        }
        
//    	creating object for Excel class
    	ExcelExample excelObj=new ExcelExample();
//    	get data from excel
    	ArrayList<InstagramPerson> existingPersonList=excelObj.readData();
//    	get new person details
    	ArrayList<InstagramPerson> newPersonList=new ArrayList<>();
    	for(InstagramPerson eachPerson:personList) {
    		int count=0;
    		for(InstagramPerson eachPersonInExcel:existingPersonList) {
    			
    			if(eachPerson.personUrl.equals(eachPersonInExcel.personUrl) 
    					&& eachPerson.postName.equals(eachPersonInExcel.postName)) {
    				count++;
    				break;
    			}
    		}
    		if(count==0) {
    			newPersonList.add(eachPerson);
    		}
    	}
    	
    	System.out.println(newPersonList);
//    	calling the sendmessage method
		
    	for(InstagramPerson eachPerson:newPersonList) {
    		sendMessage(driver,wait,eachPerson.personName);
    	}
    	
//    	writing new person in excel
    	excelObj.writeData(newPersonList);

//		logout part
//		WebElement moreButton=wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.xpath("//span[text()='More']")));
//		WebElement moreButton=wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.xpath("//div[@class='xdy9tzy']/following-sibling::span[1]")));
//		moreButton.click();
//		WebElement logoutButton=wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.xpath("//span[text()='Log out']")));
//		logoutButton.click();
////		quit browser
//		driver.quit();
		
		
		// get post element one by one
//		for(int eachIndex=0;eachIndex<childElements.size();eachIndex++) {
//			
//			
//			if(postNumber==childElements.size()-eachIndex) {
////				System.out.println("postElement name"+childElements.get(eachIndex));		
//				childElements.get(eachIndex).click();
//				
////				click post element
//				WebElement element=wait.until(ExpectedConditions.
//						presenceOfElementLocated(
//								ByXPath.xpath("//section[contains(@class,'_ae5m _ae5n')]")));
//				
//				
////				select like element
////				WebElement likeElement=element.findElement(By.xpath("(//span[contains(@class,'x1lliihq x1plvlek')]//a)[2]"));
//				
////				select like element
//				WebElement likeElement=wait.until(ExpectedConditions.presenceOfElementLocated(
//						By.xpath("(//span[contains(@class,'x1lliihq x1plvlek')]//a)[3]")));
//				
//				likeElement.click();
//				
//				List<WebElement> child=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ByXPath.
//						xpath("//div[contains(@class,'x1dm5mii x16mil14')]")));

//				collecting person url from post
				
				
////				postName
//				String postName="post".concat(Integer.toString(childElements.size()-eachIndex));
//		
//				collected like given list
//				for(int i=0;i<child.size();i++) {
//					
//					String xpath="(//div[@class='_aarf']//a)[".concat(Integer.toString(i+1)).concat("]");
//					WebElement eachPerson=child.get(i).findElement(By.xpath(xpath));
////					System.out.println("eachPerson"+eachPerson);
//					String personUrl=eachPerson.getAttribute("href");
//					String personName=findPersonName(personUrl);
//				
//					personList.add(new InstagramPerson(postName,personName, personUrl, true));
//				}
//				System.out.println(personList);
				
//				creating object for Excel class
//				ExcelExample excelObj=new ExcelExample();
//				
////				get data from excel
//				ArrayList<InstagramPerson> existingPersonList=excelObj.readData();
//				
////				get new person details
//				ArrayList<InstagramPerson> newPersonList=new ArrayList<>();
//				
//				for(InstagramPerson eachPerson:personList) {
//					int count=0;
//					for(InstagramPerson eachPersonInExcel:existingPersonList) {
//						
//						if(eachPerson.personUrl.equals(eachPersonInExcel.personUrl) 
//								&& eachPerson.postName.equals(eachPersonInExcel.postName)) {
//							count++;
//							break;
//						}
//					}
//					if(count==0) {
//						newPersonList.add(eachPerson);
//					}
//				}
//				
//				
////				close the like page
//				WebElement closeElement=wait.until(ExpectedConditions.presenceOfElementLocated(ByXPath.
//						xpath("//div[@class='_ac7b _ac7d']")));
//				closeElement.click();
//				
////				close the post page
//				WebElement closePost=wait.until(ExpectedConditions.presenceOfElementLocated(ByXPath.
//						xpath("(//div[contains(@class,'x1i10hfl x6umtig')])[2]")));
//				closePost.click();
//				
//				calling the sendmessage method
						
//				for(InstagramPerson eachPerson:newPersonList) {
//					sendMessage(driver,wait,eachPerson.personName);
//				}
//				
////				writing new person in excel
//				excelObj.writeData(newPersonList);
//
//			}
//			else {
//				System.out.println(postNumber+"is not correct");
//			}
//		
//			
//		}	
}

public ArrayList<InstagramPerson> collectLikeCount(RemoteWebDriver driver, WebDriverWait wait,String postUrl) {
	
	
	driver.get(postUrl);
	ArrayList<InstagramPerson> eachPostPersonList=new ArrayList<>();
	
//  select like element
//  previous xpath (//span[contains(@class,'x1lliihq x1plvlek')]//a)[3]
	WebElement likeElement=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//span[contains(text(),'like')]")));
	likeElement.click();
	List<WebElement> child=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ByXPath.
			xpath("//div[contains(@class,'x1dm5mii x16mil14')]")));
	
//	postName
	String postName="post".concat(postUrl);

//	collected like given list
	for(int i=0;i<child.size();i++) {
		
//		String xpath="(//div[@class='_aarf']//a)[".concat(Integer.toString(i+1)).concat("]");
		String xpath="(//div[contains(@class,'xozqiw3 x1q0g3np')])[".concat(Integer.toString(i+1)).concat("]");
		WebElement eachPerson=child.get(i).findElement(By.xpath(xpath));

		String [] personArray=eachPerson.getText().split("\n");
		String personUrl=personArray[1];
		String personName=personArray[0];
		eachPostPersonList.add(new InstagramPerson(postName,personName,personUrl , true));
	}

//	close the like page
	WebElement closeElement=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//div[contains(@aria-label,'Close')]")));
	closeElement.click();
	
	return eachPostPersonList;
	
}




public static String findPersonName(String personurl) {
	
//	get person name from url
	String[] stringarray=personurl.split("/");
	String personName=stringarray[3];
	System.out.println(personName);
	return personName;
}

public static void sendMessage(RemoteWebDriver driver, WebDriverWait wait,String personName) {
	
//    finding direct message element
	WebElement messageButtonElement=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//a[contains(@aria-label,'Direct messaging')]")));
	
	messageButtonElement.click();
	
//	click send message button
	WebElement sendMessageBtnElement=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//div[text()='Send message']")));
	sendMessageBtnElement.click();

	
//	search input box
	
	WebElement searchBoxElement=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.cssSelector("input[name='queryBox']")));
	
//	find people
//	personName="thamizh.HD";
	searchBoxElement.sendKeys(personName);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	try {
		String personXpath="//span[contains(text(),'".concat(personName.toLowerCase()).concat("')]");
		WebElement searchPeopleElement=driver.findElement(By.xpath(personXpath));
		searchPeopleElement.click();
	}
	catch(Exception e) {
//		get check box name
		WebElement labelCheckBoxElement=driver.findElement(By.xpath("//label[contains(@for,'ContactSearchResultCheckbox')]"));
		WebElement searchResultCheckBox=labelCheckBoxElement.findElement(
				By.xpath("(//input[contains(@name,'ContactSearchResultCheckbox')])[1]"));
				
		searchResultCheckBox.click();
	}



	
	
//	if(searchPeopleElement.isDisplayed()) {
//		searchPeopleElement.click();
//	} else if(searchResultCheckBox.isEnabled()) {
//		searchResultCheckBox.click();
//	}
//	
		
	
// click chat button
	
	WebElement chatButton=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//div[text()='Chat']")));
	
	chatButton.click();
	
	
//	find message box
	
//	WebElement messageBox=wait.until(ExpectedConditions.presenceOfElementLocated(
//			By.xpath("//div[@aria-label='Message']")));
//	messageBox.sendKeys("Thanks for your Like and Support");

//	send button
	
//	WebElement sendButtonElement=wait.until(ExpectedConditions.presenceOfElementLocated(
//			By.xpath("//div[text()='Send']")));
//	sendButtonElement.click();

}
}










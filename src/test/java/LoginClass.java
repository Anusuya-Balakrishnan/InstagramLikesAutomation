import java.sql.Time;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLAnchorElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;
public class LoginClass {
	
@Test
	public void login() {
		
	
//	login page
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
//		String url="https://www.instagram.com/crazypriyalovely07/";
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
//		String username="anusuya_balakrishnan7";
//		String password="$Abirami02new";
		String username="Crazypriyalovely07";
		String password="Bot@12345";
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
		WebElement userNameElement=wait.until(ExpectedConditions.presenceOfElementLocated
				(ByXPath.xpath("//input[@name='username']")));
		userNameElement.sendKeys(username);
		
		
		WebElement passwordElement=wait.until(ExpectedConditions.presenceOfElementLocated
(ByXPath.xpath("//input[@name='password']")));
		passwordElement.sendKeys(password);
		
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
		
		WebElement postElementParent=wait.until(ExpectedConditions.
				presenceOfElementLocated(
						ByXPath.xpath("//div[contains(@class,'_ac7v  _al3n')]")));
		List<WebElement> childElements=postElementParent.findElements(By.xpath("//div[contains(@class,'_aabd _aa8k  _al3l')]"));
//		System.out.println("postElement name"+childElements.size());		
//		childElements.get(0).click();
		for(int eachIndex=0;eachIndex<childElements.size();eachIndex++) {
			
//			System.out.println("postElement name"+childElements.get(eachIndex));		
			childElements.get(eachIndex).click();
			
			
//			click like list
			WebElement element=wait.until(ExpectedConditions.
					presenceOfElementLocated(
							ByXPath.xpath("//section[contains(@class,'_ae5m _ae5n')]")));
			
			WebElement likeElement=element.findElement(By.xpath("(//span[contains(@class,'x1lliihq x1plvlek')]//a)[2]"));
			
			likeElement.click();
			
//			System.out.println(likeElement+"clicked");
//			WebDriverWait eWait= new WebDriverWait(driver, Duration.ofSeconds(10));
			
			List<WebElement> child=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ByXPath.
					xpath("//div[contains(@class,'x1dm5mii x16mil14')]")));
//			(//div[contains(@class,'x1dm5mii x16mil14')])[1]
//			collecting person url from post
			ArrayList<InstagramPerson> personList=new ArrayList<InstagramPerson>();
			
//			collected like given list
			for(int i=0;i<child.size();i++) {
				
				String xpath="(//div[@class='_aarf']//a)[".concat(Integer.toString(i+1)).concat("]");
//				WebElement eachPerson=driver.findElement(ByXPath.xpath(xpath));
//				WebElement eachPerson=child.get(i).findElement(By.xpath("(//a[contains(@class,'x1i10hfl x1qjc9v5')])[3]"));
				WebElement eachPerson=child.get(i).findElement(By.xpath(xpath));
				System.out.println("eachPerson"+eachPerson);
				String personUrl=eachPerson.getAttribute("href");
				String personName=findPersonName(personUrl);
				personList.add(new InstagramPerson(personName, personUrl, false));
			}
			System.out.println(personList);
			
//			close the like page
			WebElement closeElement=wait.until(ExpectedConditions.presenceOfElementLocated(ByXPath.
					xpath("//div[@class='_ac7b _ac7d']")));
			closeElement.click();
			
//			close the post page
			WebElement closePost=wait.until(ExpectedConditions.presenceOfElementLocated(ByXPath.
					xpath("(//div[contains(@class,'x1i10hfl x6umtig')])[2]")));
			closePost.click();
			
			
			for(InstagramPerson eachPerson:personList) {
				sendMessage(driver,wait,eachPerson.personName);
			}
			
//			calling the sendmessage method
			
			
		}	
		

}

public static String findPersonName(String personurl) {
	
	String[] stringarray=personurl.split("/");
	String personName=stringarray[3];
	System.out.println(personName);
	return personName;
	
}

public static void sendMessage(RemoteWebDriver driver, WebDriverWait wait,String personName) {
	
	// Open a new tab using JavaScript
    ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");

    // Switch to the new tab (window)
    for (String windowHandle : driver.getWindowHandles()) {
        driver.switchTo().window(windowHandle);
    }

    // Navigate to a URL in the new tab
    driver.get("https://www.instagram.com/");
//	direct message part
	
    
	WebElement messageButtonElement=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//a[@aria-label='Direct messaging - 0 new notifications link']")));
	
	
	messageButtonElement.click();
	
	
//	click send message button
	
	WebElement sendMessageBtnElement=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//div[text()='Send message']")));
	sendMessageBtnElement.click();

	
//	search input box
	
	WebElement searchBoxElement=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.cssSelector("input[name='queryBox']")));
	
//	find people
//	String person="thamizh.HD";
	searchBoxElement.sendKeys(personName);
	
	String personXpath="//span[text()='".concat(personName.toLowerCase()).concat("']");
	WebElement searchPeopleElement=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath(personXpath)));
	
	searchPeopleElement.click();	
	
// click chat button
	
	WebElement chatButton=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//div[text()='Chat']")));
	
	chatButton.click();
	
	
//	find message box
	
	WebElement messageBox=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//div[@aria-label='Message']")));
	
	messageBox.sendKeys("Thank you so much");
	
//	send button
	
	WebElement sendButtonElement=wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//div[text()='Send']")));
	sendButtonElement.click();
	
	// Close the new tab
    driver.close();

    // Switch back to the original tab (window)
    driver.switchTo().window(driver.getWindowHandles().iterator().next());

    // Perform actions in the original tab
	
//	searchBoxElement.sendKeys(Keys.ENTER).pe;
		
//	open new window and send thank you message
//	driver.get("https://www.instagram.com/thamizh.hd/");
//	
//	WebElement messageElement=wait.until(ExpectedConditions.presenceOfElementLocated(ByXPath.
//			xpath("//div[contains(@class,'x1i10hfl xjqpnuy')]")));
//	
//	if(!messageElement.isDisplayed()) {
//		messageElement.click();
//		
////		sending thank you message
//		WebElement messageContentBox=wait.until(ExpectedConditions.presenceOfElementLocated(ByXPath.
//				xpath("//p[@class='xat24cr xdj266r']")));
//		
//		messageContentBox.sendKeys("Thank you");
//		
//		WebElement sendButton=wait.until(ExpectedConditions.presenceOfElementLocated(ByXPath.
//				xpath("//div[contains(@class,'x1i10hfl xjqpnuy')]")));
//		sendButton.click();
//		driver.close();
//	}
//	else {
//		System.out.println("element is not found");
//		direct message part
		
//		WebElement messageButtonElement=wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.xpath("//a[@aria-label='Direct messaging - 0 new notifications link']")));
//		messageButtonElement.click();
		
//		click send message button
//		
//		WebElement sendMessageBtnElement=wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.xpath("//div[text()='Send message']")));
//		sendMessageBtnElement.click();

//		search input box
		
//		WebElement searchBoxElement=wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.xpath("//input[contains(@class,'x5ur3kl xopu45v')]")));
//		
//		searchBoxElement.sendKeys("thamizh.HD");
//		searchBoxElement.sendKeys(Keys.ENTER);
//		
		
		
		
//	}
}
}










//click notifications
//WebElement notificationElement=wait.until(ExpectedConditions.presenceOfElementLocated
//		(ByXPath.xpath("//svg[@aria-label='Notifications']")));
//
//notificationElement.click();

//System.out.println(parent4.getText());
//WebElement parent3=parent2.findElement(By.xpath("//div[contains(@class,'x7r02ix xf1ldfh')]"));
//WebElement parent4=wait.until(ExpectedConditions.presenceOfElementLocated(
//		ByXPath.xpath("//div[contains(@class,'x129f619 xjbqb8w x78zum5')]")));
//WebElement parent4=parent3.findElement(By.xpath("//div[contains(@class,'x18oi6gw x78zum5')]"));
		
//parent4.findElement(By.xpath("(//div[contains(@class,'x19f619 xjbqb8w')]//div)[2]"));
//System.out.println(parent4);

//WebElement parentElement=wait.until(ExpectedConditions.presenceOfElementLocated(ByXPath.
//		xpath("(//div[contains(@class,'x19f619 xjbqb8w')]//div)[2]")));
//WebElement parentElement=driver.findElement(ByXPath.xpath("(//div[contains(@class,'x19f619 xjbqb8w')]//div)[2]"));
//List<WebElement> Elements=parentElement.findElements(ByXPath.xpath("*"));
//System.out.println("Elements.size()"+Elements.size());	
//for(WebElement eachParent:parentElement) {
//	
//	List<WebElement> result=eachParent.findElements(ByXPath.xpath("(//a[contains(@class,'x1i10hfl x1qjc9v5')])[2]"));
//	for (WebElement eachElement:result) {
//		String value=eachElement.getAttribute("href");
//		data.add(value);
//	}
//}
//System.out.println(data);


//System.out.println(eachPostElementLikeList);
//eachPostElementLikeList.click();
//
//if (eachPostElementLikeList.isEnabled()) {
//	eachPostElementLikeList.click();
//}
//else {
//	System.out.println("like element is not found");
//}

//for (WebElement eachElement:childElements) {
//	eachElement.click();
//	System.out.println(eachElement+"click");
//}
//
//driver.findElement(ByXPath.xpath("//div[contains(@class,'_ac7v ')]//div)[1]")).click();


//List<WebElement> postElements=driver.findElements(ByXPath.xpath("//div[contains(@class,'_aabd _aa8k')]"));
//System.out.println("postElement"+postElements);
//for (WebElement eachElement:postElements) {
//	eachElement.click();
//	System.out.println(eachElement+"click");
//}
//logout operation
//href="/anusuya_balakrishnan7/"
//String userHref="/".concat(username.concat("/"));
//String userHrefXpath="//*[contains(text(),'".concat(userHref).concat("')]");
//System.out.println("userHrefXpath"+userHrefXpath);
//WebElement userHrefElement=wait.until(ExpectedConditions.elementToBeClickable
//		(ByXPath.xpath(userHrefXpath)));
//if(userHrefElement.isEnabled()) {
//	userHrefElement.click();
//}
//else {
//	System.out.println("userHrefElement is not enabled"); 
//}


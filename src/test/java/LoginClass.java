import java.sql.Time;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLAnchorElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;
@Test
public class LoginClass {
	
@Test
	public void login() {
		
	
//	login page
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		String username="anusuya_balakrishnan7";
		String password="Abirami0212";
//		String username="arikrishnan2210@gmail.com";
//		String password="K@r@dikutty";
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		
		
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
		
		
//		click notifications
//		WebElement notificationElement=wait.until(ExpectedConditions.presenceOfElementLocated
//				(ByXPath.xpath("//svg[@aria-label='Notifications']")));
//		
//		notificationElement.click();
		
		
//		get post parent element	
		
		WebElement postElementParent=wait.until(ExpectedConditions.
				presenceOfElementLocated(
						ByXPath.xpath("//div[contains(@class,'_ac7v  _al3n')]")));
		List<WebElement> childElements=postElementParent.findElements(By.tagName("div"));
		System.out.println("postElement"+childElements.get(0));
		childElements.get(0).click();
		
		
//		click like list
		WebElement element=wait.until(ExpectedConditions.
				presenceOfElementLocated(
						ByXPath.xpath("//section[contains(@class,'_ae5m _ae5n')]")));
		element.click();
//		
//		WebElement nextElement=wait.until(ExpectedConditions.presenceOfElementLocated(ByXPath.
//				xpath("(//div[@class='_aarf'])[1]")));
//		
		List<WebElement> parentElement=driver.findElements(ByXPath.xpath("(//div[contains(@class,'x1dm5mii x16mil14')])[1]"));
		ArrayList<String> data=new ArrayList<String>();
		
		for(WebElement eachParent:parentElement) {
			System.out.println(eachParent.getSize());
			List<WebElement> result=driver.findElements(ByXPath.xpath("(//a[contains(@class,'x1i10hfl x1qjc9v5')])[2]"));
			for (WebElement eachElement:result) {
				String value=eachElement.getAttribute("href");
				data.add(value);
			}
		}
		System.out.println(data);
		

//		System.out.println(eachPostElementLikeList);
//		eachPostElementLikeList.click();
//		
//		if (eachPostElementLikeList.isEnabled()) {
//			eachPostElementLikeList.click();
//		}
//		else {
//			System.out.println("like element is not found");
//		}
		
//		for (WebElement eachElement:childElements) {
//			eachElement.click();
//			System.out.println(eachElement+"click");
//		}
//		
//		driver.findElement(ByXPath.xpath("//div[contains(@class,'_ac7v ')]//div)[1]")).click();
		
		
//		List<WebElement> postElements=driver.findElements(ByXPath.xpath("//div[contains(@class,'_aabd _aa8k')]"));
//		System.out.println("postElement"+postElements);
//		for (WebElement eachElement:postElements) {
//			eachElement.click();
//			System.out.println(eachElement+"click");
//		}
//		logout operation
//		href="/anusuya_balakrishnan7/"
//		String userHref="/".concat(username.concat("/"));
//		String userHrefXpath="//*[contains(text(),'".concat(userHref).concat("')]");
//		System.out.println("userHrefXpath"+userHrefXpath);
//		WebElement userHrefElement=wait.until(ExpectedConditions.elementToBeClickable
//				(ByXPath.xpath(userHrefXpath)));
//		if(userHrefElement.isEnabled()) {
//			userHrefElement.click();
//		}
//		else {
//			System.out.println("userHrefElement is not enabled"); 
//		}
		
	}
}

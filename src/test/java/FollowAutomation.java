import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FollowAutomation {

	
	@Test
	public void followAutomation() {
		
//		login page
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		String username="Crazypriyalovely07";
		String password="Bot@12345";
		
		
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
//		notification element

		WebElement notificationElement=wait.until(ExpectedConditions.
				presenceOfElementLocated(By.xpath("//span[text()='Notifications']")));
		if(notificationElement.isEnabled()) {
			notificationElement.click();
		}else {
			System.out.println("notification element is not present");
		}
		WebElement todayElement=wait.until(ExpectedConditions.
				presenceOfElementLocated(By.xpath("(//div[contains(@class,'x78zum5 x1c436fg')]//span)[1]")));
		if(todayElement.getText().equalsIgnoreCase("today")) {
			WebElement notificationElementList=wait.until(ExpectedConditions.
					presenceOfElementLocated(By.xpath("(//div[contains(@class,'x78zum5 x1c436fg')]/following-sibling::div)[1]")));
			System.out.println(notificationElementList);
			List<WebElement> notificationChildElement=todayElement.findElements(
					By.xpath("//div[contains(@class,'x6s0dn4 x1q4h3jn')]"));
			

			System.out.println(notificationChildElement.size());
			for(WebElement eachElement:notificationChildElement) {
				if(eachElement.findElements(By.xpath("*")).size()==3) {
					WebElement element1=eachElement.findElement(By.xpath("*"));
					String result=element1.findElement(By.xpath("//a[contains(@class,'x11i10hfl xjbqb8w x6umtig')]")).getAttribute("href");
					System.out.println(result);
				}
				
			}
		}
		
		
	}
}

import java.sql.Time;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

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

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenWindow {

	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		// Open a new tab using JavaScript
        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");

        // Switch to the new tab (window)
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        // Navigate to a URL in the new tab
        driver.get("https://www.instagram.com/");
        // Perform actions in the new tab
        // For example, interact with elements in the new tab

        // Close the new tab
        driver.close();

        // Switch back to the original tab (window)
        driver.switchTo().window(driver.getWindowHandles().iterator().next());

        // Perform actions in the original tab

	}
}

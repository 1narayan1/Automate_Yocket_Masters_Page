package masters;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://yocket.com/");
		// clicking college finder option
		driver.findElement(By.id("college-finder")).click();
		// clicking Masters option
		driver.findElement(By.xpath("//button[contains(text(),'Masters')]")).click();

		// TAKE US THROUGH YOUR DREAM EDUCATION : Page-1
		// clicking Where do you want to study?
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).click();
		Thread.sleep(2000);
		// storing all elements in the list
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='vs1__listbox']//li"));
		for (int i = 0; i < list.size(); i++) {
			// clicking on United states
			if (list.get(i).getText().equalsIgnoreCase("United States")) {
				list.get(i).click();
				break;
			}
		}
		// clicking on What are you planning to study?

		driver.findElement(By.xpath("//input[@placeholder='Select Major']")).sendKeys("Computer Science");
		Thread.sleep(2000);
		List<WebElement> list2 = driver.findElements(By.xpath("//ul[@id='vs2__listbox']//li"));
		for (int i = 0; i < list2.size(); i++) {

			if (list2.get(i).getText().equalsIgnoreCase("Computer Science")) {
				list2.get(i).click();
				break;
			}
		}

		// clicking on next button
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

		// TELL US ALL ABOUT YOUR UNDERGRAD : Page-2
		// What was your undergraduate college name?

		driver.findElement(By.xpath("//input[@placeholder='Select College']")).sendKeys("Priyadarshini");
		Thread.sleep(2000);
		List<WebElement> list3 = driver.findElements(By.xpath("//ul[@id='vs4__listbox']//li"));
		for (int i = 0; i < list3.size(); i++) {

			if (list3.get(i).getText().equalsIgnoreCase("Priyadarshini college of")) {
				list3.get(i).click();
				break;
			}
		}

		// Which course did you major in?

		driver.findElement(By.xpath("//input[@placeholder='Select Major']")).sendKeys("Computer Science");
		Thread.sleep(2000);
		List<WebElement> list4 = driver.findElements(By.xpath("//ul[@id='vs6__listbox']//li"));
		for (int i = 0; i < list4.size(); i++) {

			if (list4.get(i).getText().equalsIgnoreCase("Computer Science")) {
				list4.get(i).click();
				break;
			}
		}

		// What is your score/expected score?

		Select sel = new Select(driver.findElement(By.id("marks_type")));
		sel.selectByValue("100");
		driver.findElement(By.id("marks")).sendKeys("80");
		driver.switchTo().frame("siqiframe");
		driver.findElement(By.xpath("//div[@class='win_close sqico-larrow']")).click();

		String s = driver.getWindowHandle();
		driver.switchTo().window(s);
		// clicking on next button
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
         
        // FILL UP YOUR TEST SCORES
		// Which English test did you take?
		driver.findElement(By.xpath("//div[contains(text(),'IELTS')]")).click();
		driver.findElement(By.name("ielts_overall_score")).sendKeys("6.5");
		
		//Which aptitude test did you take?
		driver.findElement(By.xpath("//div[contains(text(),'GMAT')]")).click();
		driver.findElement(By.name("total_gmat_score")).sendKeys("600");
		
		//clicking on next button
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
	
		// click on find university button
		driver.findElement(By.xpath("//button[contains(text(),'Find Universities')]")).click();
		
		// click on login button
		
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
	}

}

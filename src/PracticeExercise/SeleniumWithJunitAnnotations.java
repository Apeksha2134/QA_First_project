package PracticeExercise;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.After;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWithJunitAnnotations {

	private WebDriver driver;
	private String sURL="http://107.170.213.234/catalog/";
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\1 Learn QA\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Opening the Browser");
		
		//private String sURL="http://107.170.213.234/catalog/";
		driver.get(sURL);
		System.out.println("Opening the URL");
	}
	
	@After
	public void tearDown() {
		driver.quit();
		System.out.println("close the browser");
	}
	
	
	@Test
	public void testcase01() {
		
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.setProperty("webdriver.chrome.driver", "C:\\1 Learn QA\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Opening the Browser");
		
		//private String sURL="http://107.170.213.234/catalog/";
		driver.get(sURL);
		System.out.println("Opening the URL");
		*/
		driver.findElement(By.linkText("log yourself in")).click();
		System.out.println("Click link");
		
		driver.findElement(By.name("email_address")).sendKeys("ecalix@test.com");
		System.out.println("enter username");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("test123");
		System.out.println("enter password");
		
		driver.findElement(By.xpath("//*[@id=\'tdb5\']/span[2]")).click();
		System.out.println("click signin");
		
		driver.findElement(By.xpath("//*[@id=\'tdb4\']/span")).click();
		System.out.println("click logoff");
		
//		driver.quit();
//		System.out.println("close the browser");
		

	}
	
	@Test
	public void testcase02() {
		
		driver.findElement(By.linkText("log yourself in")).click();
		System.out.println("Click link");
		
		driver.findElement(By.name("email_address")).sendKeys("");
		System.out.println("enter username");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("");
		System.out.println("enter password");
		
		driver.findElement(By.xpath("//*[@id=\'tdb5\']/span[2]")).click();
		System.out.println("click signin");
		
		String expectedText = "Error: No match for E-Mail Address and/or Password.";
		String actualText = driver.findElement(By.xpath("//*[@id=\'bodyContent\']/table/tbody/tr/td")).getText();
		assertEquals(expectedText.trim(),actualText.trim());
	}
	
	
	
	
}

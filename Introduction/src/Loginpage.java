import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.By;

public class Loginpage {
	
	public void loginToRSAcademy() throws InterruptedException {
		String name = "Test User";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\darragh.madden\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[text()=\"Sign In\"]")).click();
		Thread.sleep(2000); Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText(),"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		driver.findElement(By.xpath("//button[contains(text(), 'Log Out')]")).click();
		driver.quit();
	}
	
	public String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div[class='forgot-pwd-btn-conainer'] button[class='reset-pwd-btn']")).click();
		String pass = driver.findElement(By.cssSelector("div[class='form-container sign-up-container'] p")).getText();
		String[] passArray = pass.split("'");
		String password = passArray[1].split("'") [0];
		return password;
	}
}

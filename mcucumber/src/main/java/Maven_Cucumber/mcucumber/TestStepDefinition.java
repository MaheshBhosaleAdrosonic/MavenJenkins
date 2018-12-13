package Maven_Cucumber.mcucumber;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestStepDefinition {

	WebDriver driver;
	Logger log;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public void initializeEnvirnoment() {
		System.setProperty("webdriver.chrome.driver", "E:\\Mahesh\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		log = Logger.getLogger(TestStepDefinition.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Browser Opened Successfully....");
		driver.manage().window().maximize();
	}

	public void openURLInBrowser() {
		driver.get("http://automationpractice.com/index.php");
	}

	public boolean loginIntoApplication(String username, String password) {

		WebElement hdrYourLogo = driver.findElement(By.xpath("//div[@id='header_logo']"));

		if (hdrYourLogo.isDisplayed()) {
			log.info("Click on SignIn Button ");
			driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
			log.info("Enter User Name ");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
			log.info("Enter Password");
			driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
			log.info("Click on Submit Button ");
			driver.findElement(By.id("SubmitLogin")).click();
		}

		else {
			return false;
		}
		return true;
	}

	public boolean verifyHomePageIsDisplayed() {
		WebElement hdrHomePage = driver.findElement(By.xpath("//h1[text()='My account']"));

		if (hdrHomePage.isDisplayed()) {
			log.info("Home Page is Displayed...");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("Click on Home Button ");
		WebElement lnkHome = driver.findElement(By.xpath("//a[@title='Return to Home']"));
		lnkHome.click();

		// driver.findElement(By.xpath("//a[normalize-space()='Sign out']")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean productAddIntoCartInApplication(String elePrinted) {

	//	log.info("Click on Product Link ");
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		js.executeScript("window.scrollBy(0, 1000)", "");
		
		
		WebElement lnkProduct = driver.findElement(By.xpath(
				"(//div[@class='product-container']//a[@title='Printed Dress']//img[@title='Printed Dress'])[1]"));
	//	js.executeScript("arguments[0].scrollIntoView(true);", lnkProduct);
		lnkProduct.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement btnAddToCart = driver.findElement(By.xpath("//button[@name='Submit']"));
		btnAddToCart.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("Click on Product Link ");
		log.info("Click on Proceed to checkout Button ");
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		return true;
	}

	public boolean viewTheCart() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("Click on View my Shopping cart ");
		driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (driver.findElement(By.xpath("//h1[@id='cart_title']")).isDisplayed()) {
			log.info("Header is Displayed ");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			String product = driver.findElement(By.xpath("//table[@id='cart_summary']//p[@class='product-name']//a"))
					.getText();
			log.info("Get product name ");
			if (product.equalsIgnoreCase("Printed Dress")) {
				log.info("Verified product is in cart .... ");
				System.out.println("Verified Product is in the Card.....");
			}
		}
		return true;
	}

	public boolean tearDownEnvirnoment() {
		log.info("TearDown Envirnoment....");
		driver.quit();
		return true;
	}
}



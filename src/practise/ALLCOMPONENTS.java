package practise;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ALLCOMPONENTS {

	public static void main(String[] args) throws IOException, InterruptedException {

		//Chrome Browser
//				System.setProperty("webdriver.chrome.driver",
//						"G:\\SELENIUM\\Selenium Servers\\Browser Servers\\chromedriver_win32\\chromedriver.exe");
//				WebDriver driver = new ChromeDriver();

		//Firefox Browser 
				System.setProperty("webdriver.gecko.driver",
						"G:\\SELENIUM\\Selenium Servers\\Browser Servers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();

		//Opera Browser
//				System.setProperty("webdriver.opera.driver", "G:\SELENIUM\Selenium Servers\Browser Servers\operadriver_win64\operadriver.exe");
//				WebDriver driver = new OperaDriver();	
				
		//I/E Browser
//				System.setProperty("webdriver.ie.driver", "G:\\SELENIUM\\Selenium Servers\\Browser Servers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
//				WebDriver driver = new InternetExplorerDriver();
			
		//Edge Driver		
//				System.setProperty("webdriver.edge.driver", "G:\\SELENIUM\\Selenium Servers\\Browser Servers\\edgedriver_win64\\msedgedriver.exe");
//				WebDriver driver = new EdgeDriver();

		//Browser Maxmize & Time wait
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				driver.get("https://site2359821.nestifysites.com/my-account/");
				System.out.println("Automation Practice Form Opened Successfully");

		//Get Page title,source,url ....etc.
				String title = driver.getCurrentUrl();
				System.out.println(title);
				String title1 = driver.getTitle();
				System.out.println(title1);

		//DisplayAllLinksInWebpage
				java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
				System.out.println(links.size());

		//Verify Text in a page
				int j = 0;
				if (driver.getPageSource().contains("Login")) {
					System.out
							.println("Verification Successful - Before Login The correct title is displayed on the web page.");
				} else {
		//Prnit Screenshot   
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File("E:/SCREENSHOTS/screenshot(" + j++ + ").png"));

					System.out.println("Verification Failed - Before Login An incorrect title is displayed on the web page.");
				}

		//For Loop		
				for (int i = 1; i <= 2; i++) {
					driver.findElement(By.id("username")).sendKeys("shivakrishnak@aegisllp.com");
					driver.findElement(By.id("password")).sendKeys("Kshivakrishna@123");
					driver.findElement(By.name("login")).click();
					System.out.println("Application login successfully" + i);

					driver.findElement(By.xpath("//*[@id=\"top_bar\"]/div/div[3]/a[2]")).click();

					driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/a")).click();
					Thread.sleep(3000);

		//Date & Time Display
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					System.out.println(dateFormat.format(date));
					System.out.println("Application Logout successfully" + i);
					System.out.println("Browser closed successfully");
				}
				driver.close();

		//Dropdown Code
//				Select Dist =new Select(driver.findElement(By.id("Dist_Name")));
//				Dist.selectByVisibleText("Cardiologist");

			}
	
	
}

package resources;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/resources/data.properties");

			prop.load(fis);

			String browserName = prop.getProperty("browser");
			System.out.println("Test starting with " + browserName + "driver");

			if (browserName.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
				ChromeOptions options = new ChromeOptions();
				if (browserName.contains("headless")) {
					options.addArguments("--headless");
				}
				driver = new ChromeDriver(options);

			} else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
				driver = new FirefoxDriver();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}

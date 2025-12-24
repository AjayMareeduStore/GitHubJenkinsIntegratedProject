package TestReusableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import AjayMareeduSelenium.PageoObjecComponents.LandingPageComponents;
import io.github.bonigarcia.wdm.WebDriverManager;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class BaseTest {

	public WebDriver driver;
	public LandingPageComponents LandingPageComponents;

	public WebDriver browserInvoke() throws IOException {

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Properties//global.properties");
		prop.load(file);
		//By Using terminator concept writing login to get commands from CMD in not execute from cofigfile
		String browserName =System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			
			if(browserName.contains("headless")) {
				options.addArguments("headless");
				
			}			
			 // New webdriver manager help to invoke browser
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));

		} else if (browserName.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		return driver;

	}

	public List<HashMap<String, String>> readData(String path) throws IOException {

		// We need to conver json to string

		String jsonFileData = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);

		// We need conver from string to HashMap
		// for that we need to get a class Jakson databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonFileData,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	public String takeScreenShot(String TestCaseName, WebDriver driver2) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//Reports//" + TestCaseName + ".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir") + "//Reports//" + TestCaseName + ".png";

	}

	@BeforeMethod(alwaysRun = true)
	public LandingPageComponents hitUrl() throws IOException {

		driver = browserInvoke();
		LandingPageComponents = new LandingPageComponents(driver);
		LandingPageComponents.goTo();
		return LandingPageComponents;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		driver.close();

	}

}

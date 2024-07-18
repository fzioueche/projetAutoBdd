package utile;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
	private ChromeDriverService chService;

	@Override
	public void startService() {
		if (null == chService) {
			try {
				chService = new ChromeDriverService.Builder()
						.usingDriverExecutable(new File("src/test/ressources/drivers/chromedriver.exe")).usingAnyFreePort()
						.build();
				chService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stopService() {
		if (null != chService && chService.isRunning())
			chService.stop();
	}

	@Override
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\eclipse-workspace\\frameworkAutoBDD\\src\\test\\ressources\\drivers\\chromedriver.exe");
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.addArguments("--start-maximized");
		optionsChrome.addArguments("--disable-infobars");
		optionsChrome.addArguments("--disable-popup-blocking");
		optionsChrome.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(optionsChrome);

	}
}

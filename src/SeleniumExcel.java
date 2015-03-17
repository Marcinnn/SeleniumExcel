import java.util.concurrent.TimeUnit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExcel {

	private static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:/Eclipse/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("http://www.calculator.net/");
		PercentCalculator.goToPercentCalculator(driver);

		Result res = JUnitCore.runClasses(TestExcel.class);
		for (Failure fail : res.getFailures()) {
			System.out.println(fail.toString());
		}
		System.out.println(res.wasSuccessful());
	}

	public static WebDriver getDriver() {
		return driver;
	}
}

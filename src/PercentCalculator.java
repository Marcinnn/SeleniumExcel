import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PercentCalculator {

	public static void goToPercentCalculator(WebDriver driver) {
		driver.findElement(
				By.xpath("/html/body/table[2]/tbody/tr/td[1]/div[@id='left']/div[@id='menu']/div[@class='mh'][3]/a"))
				.click();
		driver.findElement(
				By.xpath("/html/body/table[2]/tbody/tr/td[1]/div[@id='left']/div[@id='menu']/div[@class='mbout']/div[@class='mb'][3]/a"))
				.click();
	}

	public static void setPercent(WebDriver driver, int percent) {
		driver.findElement(By.id("cpar1")).sendKeys(String.valueOf(percent));
	}

	public static void setNumber(WebDriver driver, int number) {
		driver.findElement(By.id("cpar2")).sendKeys(String.valueOf(number));
	}

	public static void pressResultButton(WebDriver driver) {
		driver.findElement(
				By.xpath("/html/body/table[2]/tbody/tr/td[1]/div[@id='content']/table[@class='panel']/tbody/tr/td[2]/input"))
				.click();
	}

	public static double getResult(WebDriver driver) {
		return Double
				.parseDouble(driver
						.findElement(
								By.xpath("/html/body/table[2]/tbody/tr/td[1]/div[@id='content']/p[2]/span[@class='bigtext']/font/b"))
						.getText());
	}

	public static double getResult(WebDriver driver, double percent,
			double number) {
		driver.findElement(By.id("cpar1")).sendKeys(String.valueOf(percent));
		driver.findElement(By.id("cpar2")).sendKeys(String.valueOf(number));
		driver.findElement(
				By.xpath("/html/body/table[2]/tbody/tr/td[1]/div[@id='content']/table[@class='panel']/tbody/tr/td[2]/input"))
				.click();
		return Double
				.parseDouble(driver
						.findElement(
								By.xpath("/html/body/table[2]/tbody/tr/td[1]/div[@id='content']/p[2]/span[@class='bigtext']/font/b"))
						.getText());
	}
}

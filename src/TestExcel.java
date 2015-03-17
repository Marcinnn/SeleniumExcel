import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

@RunWith(org.junit.runners.Parameterized.class)
public class TestExcel {

	private Double expectedResult;
	private Double receivedResult;
	private static excelUtil excelObject = new excelUtil();;

	public TestExcel(Double expectedResult, Double receivedResult) {
		this.expectedResult = expectedResult;
		this.receivedResult = receivedResult;
	}

	@Parameters
	public static Collection percentCheck() {
		Double arrayOfData[][] = new Double[excelObject.getNumberOfRows() - 1][2];
		for (int i = 1; i <= excelObject.getNumberOfRows() - 1; i++) {
			arrayOfData[i - 1][0] = excelObject.getCellData(i, 3);
			arrayOfData[i - 1][1] = PercentCalculator.getResult(
					SeleniumExcel.getDriver(), excelObject.getCellData(i, 1),
					excelObject.getCellData(i, 2));
			SeleniumExcel.getDriver().manage().timeouts()
					.implicitlyWait(1, TimeUnit.SECONDS);
			SeleniumExcel.getDriver().navigate().back();
			SeleniumExcel.getDriver().manage().timeouts()
					.implicitlyWait(5, TimeUnit.SECONDS);
		}

		return Arrays.asList(arrayOfData);
	}

	@Test
	public void testIt() {
		Assert.assertEquals(expectedResult, receivedResult, 0.0);
	}
}

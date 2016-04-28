package Utilities;

import org.testng.annotations.DataProvider;
import Utilities.InputUtil;

public class DataProviders {

	@DataProvider(name = "emailLogin")
	public static Object[][] getData2() {

		Object[][] data = new Object[2][2];
		data[0][0] = "Albor";
		data[0][1] = "Albor";
		data[1][0] = "Sonie";
		data[1][1] = "Sonie";
		return data;

	}

	@DataProvider(name = "searchKeyAndHeading")
	public static Object[][] getDataFromCSV() {
		return InputUtil.putDataForlogin();
	}
}
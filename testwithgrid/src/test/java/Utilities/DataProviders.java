package Utilities;
import org.testng.annotations.DataProvider;
import Utilities.InputUtil;

public class DataProviders {

	@DataProvider(name = "emailLogin")
	public static Object[][] getData2() {

		Object[][] data = new Object[1][2];
		data[0][0] = "ugoodsdev3@gmail.com";
		data[0][1] = "ug0000dz";
		// data[1][0] = "ugoodsdev4@gmail.com";
		// data[1][1] = "ug0000dz";
		return data;

	}

	@DataProvider(name = "EmailLoginFromCsv")
	public static Object[][] getDataFromCSV() {
		return InputUtil.putDataForlogin();
	}
}
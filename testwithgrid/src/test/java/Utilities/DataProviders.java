package Utilities;

import org.testng.annotations.DataProvider;
import com.csvreader.CsvReader;

public class DataProviders {

	private static CsvReader reader = null;
	private static Object[][] data = null;
	static String searchKeyPath = "./Resources/searchKey.csv";

	private static Object[][] getDataForLogin() {
		int i = 0;
		try {
			data = new Object[2][2];
			reader = new CsvReader(searchKeyPath);
			reader.setComment('#');
			reader.setUseComments(true);
			reader.setSkipEmptyRecords(true);
			while (reader.readRecord()) {
				data[i][0] = reader.get(0);
				data[i][1] = reader.get(1);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	// with csv
	@DataProvider(name = "searchKeyAndHeading")
	public static Object[][] getDataFromCSV() {
		return getDataForLogin();
	}

	// without csv
	@DataProvider(name = "searchKeyAndHeadingNoCsv")
	public static Object[][] getData2() {

		Object[][] data = new Object[2][2];
		data[0][0] = "Albor";
		data[0][1] = "Albor";
		data[1][0] = "Sonie";
		data[1][1] = "Sonie";
		return data;

	}

	public static void main(String[] args) {
		// getDataForLogin();
		// System.out.println(data[0][0]);
		// System.out.println(data[0][1]);
		// System.out.println(data[1][0]);
		// System.out.println(data[1][1]);
	}
}
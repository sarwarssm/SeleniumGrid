package Utilities;

import com.csvreader.CsvReader;

public class InputUtil {

	private static CsvReader reader = null;
	private static Object[][] data = null;
	static String loginInfoPath = "./Resources/login.csv";

	private static void getDataForLogin() {
		int i = 0;
		try {
			// data = new Object[1][2];
			data = new Object[2][4];
			reader = new CsvReader(loginInfoPath);
			reader.setComment('#');
			reader.setUseComments(true);
			reader.setSkipEmptyRecords(true);
			while (reader.readRecord()) {
				data[i][0] = reader.get(0);
				data[i][1] = reader.get(1);
				data[i][2] = reader.get(2);
				data[i][3] = reader.get(3);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object[][] putDataForlogin() {
		getDataForLogin();
		System.out.println(data[0][0]);
		System.out.println(data[0][1]);
		return data;

	}

	public static void main(String[] args) {
		// getDataForLogin();
		// System.out.println(data[0][0]);
		// System.out.println(data[0][1]);
		// System.out.println(data[0][2]);
		// System.out.println(data[0][3]);
		//
		// System.out.println(data[1][0]);
		// System.out.println(data[1][1]);
		// System.out.println(data[1][2]);
		// System.out.println(data[1][3]);
		//
	}
}

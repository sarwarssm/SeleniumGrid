package Utilities;

import com.csvreader.CsvReader;

public class InputUtil {

	private static CsvReader reader = null;
	private static Object[][] data = null;
	static String loginInfoPath = "./Resources/login.csv";

	private static void getDataForLogin() {
		int i = 0;
		try {
			data = new Object[2][2];
			reader = new CsvReader(loginInfoPath);
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
	}

	public static Object[][] putDataForlogin() {
		getDataForLogin();
		return data;

	}

	public static void main(String[] args) {
//		 getDataForLogin();
//		 System.out.println(data[0][0]);
//		 System.out.println(data[0][1]);
//		 System.out.println(data[1][0]);
//		 System.out.println(data[1][1]);
	
	
	}
}

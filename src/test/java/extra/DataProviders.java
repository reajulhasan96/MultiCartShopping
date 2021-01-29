package extra;

import org.testng.annotations.DataProvider;

import multicartalldata.GetDataProperties;

public class DataProviders extends GetDataProperties {

	@DataProvider(name = "userdata")
	public Object[][] getUserData() throws Exception {
		// first [] for row and second [] stands for column
		// Row stands for how many different data types test should run
		// Column stands for how many values for each test

		// Requirement:
		// Run test with 2 data types and each time with 3 values. **Index starts from
		// 0**

		// Declare the Array
		Object[][] data = new Object[2][3];

		data[0][0] = userName("userName1");
		data[0][1] = password("password1");
		data[0][2] = fullName("fullName1");

		data[1][0] = userName("userName2");
		data[1][1] = password("password2");
		data[1][2] = fullName("fullName2");

		return data;
	}
	@DataProvider(name = "product")
	public Object[][] getProduct() throws Exception {

		Object[][] data = new Object[2][3];

		data[0][0] = productName("product1");
		data[0][1] = quantity("quantity1");
		data[0][2] = totalAmount("totalAmount1");

		data[1][0] = productName("product2");
		data[1][1] = quantity("quantity2");
		data[1][2] = totalAmount("totalAmount2");

		return data;
	}

	@DataProvider(name = "multidata")
	public Object[][] userAndProduct() throws Exception {

		Object[][] data = new Object[2][6];
		
		data[0][0] = userName("userName1");
		data[0][1] = password("password1");
		data[0][2] = fullName("fullName1");
		data[0][3] = productName("product1");
		data[0][4] = quantity("quantity1");
		data[0][5] = totalAmount("totalAmount1");
		
		data[1][0] = userName("userName2");
		data[1][1] = password("password2");
		data[1][2] = fullName("fullName2");
		data[1][3] = productName("product2");
		data[1][4] = quantity("quantity2");
		data[1][5] = totalAmount("totalAmount2");

		return data;
	}
	



}

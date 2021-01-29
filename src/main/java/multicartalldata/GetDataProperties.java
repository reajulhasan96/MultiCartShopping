package multicartalldata;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Properties;

public abstract class GetDataProperties extends DataFromMySQL implements GetData {
	Properties prop;

	public Properties getData() throws Exception {
		prop = new Properties();
		FileInputStream files = new FileInputStream(
				"C:\\Users\\hasan\\eclipse-workspace\\Shopping\\src\\main\\java\\multicartalldata\\data.properties");
		prop.load(files);
		return prop;
	}

	@Override
	public String fullName(String userFullName) throws Exception {
		String name = getData().getProperty(userFullName);
		return name;
	}

	@Override
	public String email(String userEmail) throws Exception {
		String emailId = getData().getProperty(userEmail);
		return emailId;
	}
	

	@Override
	public String userNameFromDB(int enterUsersID) throws SQLException {
		String name = userName(enterUsersID);
		return name;
	}

	@Override
	public String passwordFromDB(int enterUsersID) throws SQLException {
		String passcode = password(enterUsersID);
		return passcode;
	}

	@Override
	public String userName(String userID) throws Exception {
		String name = getData().getProperty(userID);
		return name;
	}

	@Override
	public String password(String userPassword) throws Exception {
		String passcode = getData().getProperty(userPassword);
		return passcode;
	}

	@Override
	public String firstName(String userFirstName) throws Exception {
		String fName = getData().getProperty(userFirstName);
		return fName;
	}

	@Override
	public String lastName(String userLastName) throws Exception {
		String lName = getData().getProperty(userLastName);
		return lName;
	}

	@Override
	public String address(String location) throws Exception {
		String userAddress = getData().getProperty(location);
		return userAddress;
	}

	@Override
	public String productName(String prodName) throws Exception {
		String product = getData().getProperty(prodName);
		return product;
	}

	@Override
	public String quantity(String count) throws Exception {
		String qty = getData().getProperty(count);
		return qty;
	}

	@Override
	public String totalAmount(String totalPrice) throws Exception {
		String price = getData().getProperty(totalPrice);
		return price;
	}

	@Override
	public String browser() throws Exception {
		String driverName = getData().getProperty("browser");
		return driverName;
	}

	@Override
	public String url() throws Exception {
		String url = getData().getProperty("url");
		return url;
	}

	@Override
	public String fullName() throws Exception {
		String name = getData().getProperty("fullName1");
		return name;
	}

	@Override
	public String email() throws Exception {
		String emailId = getData().getProperty("email1");
		return emailId;
	}

	@Override
	public String userName() throws Exception {
		String name = getData().getProperty("userName1");
		return name;
	}

	@Override
	public String password() throws Exception {
		String passcode = getData().getProperty("password1");
		return passcode;
	}

	@Override
	public String firstName() throws Exception {
		String fName = getData().getProperty("firstName1");
		return fName;
	}

	@Override
	public String lastName() throws Exception {
		String lName = getData().getProperty("lastName1");
		return lName;
	}

	@Override
	public String address() throws Exception {
		String userAddress = getData().getProperty("address1");
		return userAddress;
	}

	@Override
	public String productName() throws Exception {
		String product = getData().getProperty("product1");
		return product;
	}

	@Override
	public String quantity() throws Exception {
		String qty = getData().getProperty("quantity1");
		return qty;
	}

	@Override
	public String totalAmount() throws Exception {
		String price = getData().getProperty("totalAmount1");
		return price;
	}

}
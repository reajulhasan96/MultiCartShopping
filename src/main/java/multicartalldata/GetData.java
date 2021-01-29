package multicartalldata;

import java.sql.SQLException;

public interface GetData {
	//Static
	String browser() throws Exception;

	String url() throws Exception;

	String fullName() throws Exception;

	String email() throws Exception;

	String userName() throws Exception;

	String password() throws Exception;

	String firstName() throws Exception;

	String lastName() throws Exception;

	String address() throws Exception;

	String productName() throws Exception;

	String quantity() throws Exception;

	String totalAmount() throws Exception;

	//Dynamic
	
	String fullName(String userFullName) throws Exception;

	String email(String userEmail) throws Exception;

	String userName(String userID) throws Exception;

	String password(String userPassword) throws Exception;
	
	String userNameFromDB(int enterUsersID) throws SQLException;

	String passwordFromDB(int enterUsersID) throws SQLException;

	String firstName(String userFirstName) throws Exception;

	String lastName(String userLastName) throws Exception;

	String address(String locatn) throws Exception;

	String productName(String prodName) throws Exception;

	String quantity(String qty) throws Exception;

	String totalAmount(String totalPrice) throws Exception;

	
}

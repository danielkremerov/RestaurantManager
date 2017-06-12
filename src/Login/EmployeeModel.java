package Login;

import javafx.beans.property.*;

// TODO: Auto-generated Javadoc
/**
 * Class to Model the Employee Object by defining the property of each
 * elementsType and creating getters and setters for them, so that they can be
 * extracted from the Objects that are returned from The DAO layer.
 */
public class EmployeeModel {

	/** The employee id. */
	// Declare Order columns
	private IntegerProperty employeeId;

	/** The first name. */
	private StringProperty firstName;

	/** The last name. */
	private StringProperty lastName;

	/** The user name. */
	private StringProperty userName;

	/** The password. */
	private StringProperty password;

	/** The phone. */
	private StringProperty phone;

	/** The email. */
	private StringProperty email;

	/** The employee status. */
	private StringProperty employeeStatus;
	
	/** The time stamp log. */
	private StringProperty timeStampLog;
	
	/** The name log. */
	private StringProperty nameLog;
	
	/** The text log. */
	private StringProperty textLog;

	/**
	 * Instantiates a new employee model.
	 */
	public EmployeeModel() { // Constructor
		this.employeeId = new SimpleIntegerProperty();
		this.firstName = new SimpleStringProperty();
		this.lastName = new SimpleStringProperty();
		this.userName = new SimpleStringProperty();
		this.password = new SimpleStringProperty();
		this.phone = new SimpleStringProperty();
		this.email = new SimpleStringProperty();
		this.employeeStatus = new SimpleStringProperty();
		this.timeStampLog = new SimpleStringProperty();
		this.nameLog = new SimpleStringProperty();
		this.textLog = new SimpleStringProperty();

	}

	/**
	 * Employee id property.
	 *
	 * @return the integer property
	 */
	public IntegerProperty employeeIdProperty() {
		return employeeId;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public int getEmployeeId() {
		return employeeId.get();
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId
	 *            the new employee id
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId.set(employeeId);
	}

	/**
	 * First name property.
	 *
	 * @return the string property
	 */
	public StringProperty firstNameProperty() {
		return firstName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName.get();
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	/**
	 * Last name property.
	 *
	 * @return the string property
	 */
	public StringProperty lastNameProperty() {
		return lastName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName.get();
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	/**
	 * User name property.
	 *
	 * @return the string property
	 */
	public StringProperty userNameProperty() {
		return userName;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName.get();
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(String userName) {
		this.userName.set(userName);
	}

	/**
	 * Password property.
	 *
	 * @return the string property
	 */
	public StringProperty passwordProperty() {
		return password;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password.get();
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password.set(password);
	}

	/**
	 * Phone property.
	 *
	 * @return the string property
	 */
	public StringProperty phoneProperty() {
		return phone;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone.get();
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone
	 *            the new phone
	 */
	public void setPhone(String phone) {
		this.phone.set(phone);
	}

	/**
	 * Email property.
	 *
	 * @return the string property
	 */
	public StringProperty emailProperty() {
		return email;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email.get();
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email.set(email);
	}

	/**
	 * Employee status property.
	 *
	 * @return the string property
	 */
	public StringProperty employeeStatusProperty() {
		return employeeStatus;
	}

	/**
	 * Gets the employee status.
	 *
	 * @return the employee status
	 */
	public String getEmployeeStatus() {
		return employeeStatus.get();
	}

	/**
	 * Sets the employee status.
	 *
	 * @param employeeStatus
	 *            the new employee status
	 */
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus.set(employeeStatus);
	}
	
	/**
	 * Time stamp log property.
	 *
	 * @return the string property
	 */
	public StringProperty timeStampLogProperty() {
		return timeStampLog;
	}

	/**
	 * Gets the time stamp log.
	 *
	 * @return the time stamp log
	 */
	public String getTimeStampLog() {
		return timeStampLog.get();
	}

	/**
	 * Sets the time stamp log.
	 *
	 * @param timeStampLog the new time stamp log
	 */
	public void setTimeStampLog(String timeStampLog) {
		this.timeStampLog.set(timeStampLog);
	}
	
	/**
	 * Name log property.
	 *
	 * @return the string property
	 */
	public StringProperty nameLogProperty() {
		return nameLog;
	}

	
	/**
	 * Gets the name log.
	 *
	 * @return the name log
	 */
	public String getNameLog() {
		return nameLog.get();
	}

	
	/**
	 * Sets the name log.
	 *
	 * @param nameLog the new name log
	 */
	public void setNameLog(String nameLog) {
		this.nameLog.set(nameLog);
	}
	
	/**
	 * Text log property.
	 *
	 * @return the string property
	 */
	public StringProperty textLogProperty() {
		return textLog;
	}

	
	/**
	 * Gets the text log.
	 *
	 * @return the text log
	 */
	public String getTextLog() {
		return textLog.get();
	}

	/**
	 * Sets the text log.
	 *
	 * @param textLog the new text log
	 */
	public void setTextLog(String textLog) {
		this.textLog.set(textLog);
	}
}

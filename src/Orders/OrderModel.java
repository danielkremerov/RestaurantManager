package Orders;

import javafx.beans.property.*;

// TODO: Auto-generated Javadoc
/**
 * Class to Model the Order Object by defining the property of each elementsType
 * and creating getters and setters for them, so that they can be extracted from
 * the Objects that are returned from The DAO layer.
 */
public class OrderModel {

	/** The unique id. */
	// Declare Order columns
	private IntegerProperty uniqueId;

	/** The order id. */
	private IntegerProperty orderId;

	/** The time stamp. */
	private StringProperty timeStamp;

	/** The assigned employee. */
	private StringProperty assignedEmployee;

	/** The table number. */
	private IntegerProperty tableNumber;

	/** The dish. */
	private StringProperty dish;

	/** The price. */
	private FloatProperty price;

	/** The special request. */
	private StringProperty specialRequest;

	/** The comment. */
	private StringProperty comment;

	/** The status. */
	private StringProperty status;

	/**
	 * Instantiates a new order model.
	 */
	public OrderModel() { // Constructor
		this.orderId = new SimpleIntegerProperty();
		this.uniqueId = new SimpleIntegerProperty();
		this.timeStamp = new SimpleStringProperty();
		this.assignedEmployee = new SimpleStringProperty();
		this.tableNumber = new SimpleIntegerProperty();
		this.dish = new SimpleStringProperty();
		this.price = new SimpleFloatProperty();
		this.specialRequest = new SimpleStringProperty();
		this.comment = new SimpleStringProperty();
		this.status = new SimpleStringProperty();

	}

	/**
	 * Unique id property.
	 *
	 * @return the integer property
	 */
	public IntegerProperty uniqueIdProperty() {
		return uniqueId;
	}

	/**
	 * Gets the unique id.
	 *
	 * @return the unique id
	 */
	public int getUniqueId() {
		return uniqueId.get();
	}

	/**
	 * Sets the unique id.
	 *
	 * @param uniqueId
	 *            the new unique id
	 */
	public void setUniqueId(int uniqueId) {
		this.uniqueId.set(uniqueId);
	}

	/**
	 * Order id property.
	 *
	 * @return the integer property
	 */
	public IntegerProperty orderIdProperty() {
		return orderId;
	}

	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public int getOrderId() {
		return orderId.get();
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId
	 *            the new order id
	 */
	public void setOrderId(int orderId) {
		this.orderId.set(orderId);
	}

	/**
	 * Time stamp property.
	 *
	 * @return the string property
	 */
	public StringProperty timeStampProperty() {
		return timeStamp;
	}

	/**
	 * Gets the time stamp.
	 *
	 * @return the time stamp
	 */
	public String getTimeStamp() {
		return timeStamp.get();
	}

	/**
	 * Sets the time stamp.
	 *
	 * @param timeStamp
	 *            the new time stamp
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp.set(timeStamp);
	}

	/**
	 * Assigned employee property.
	 *
	 * @return the string property
	 */
	public StringProperty assignedEmployeeProperty() {
		return assignedEmployee;
	}

	/**
	 * Gets the assigned employee.
	 *
	 * @return the assigned employee
	 */
	public String getAssignedEmployee() {
		return assignedEmployee.get();
	}

	/**
	 * Sets the assigned employee.
	 *
	 * @param assignedEmployee
	 *            the new assigned employee
	 */
	public void setAssignedEmployee(String assignedEmployee) {
		this.assignedEmployee.set(assignedEmployee);
	}

	/**
	 * Table number property.
	 *
	 * @return the integer property
	 */
	public IntegerProperty tableNumberProperty() {
		return tableNumber;
	}

	/**
	 * Gets the table number.
	 *
	 * @return the table number
	 */
	public int getTableNumber() {
		return tableNumber.get();
	}

	/**
	 * Sets the table number.
	 *
	 * @param tableNumber
	 *            the new table number
	 */
	public void setTableNumber(int tableNumber) {
		this.tableNumber.set(tableNumber);
	}

	/**
	 * Price property.
	 *
	 * @return the float property
	 */
	public FloatProperty priceProperty() {
		return price;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public float getPrice() {
		return price.get();
	}

	/**
	 * Sets the price.
	 *
	 * @param price
	 *            the new price
	 */
	public void setPrice(float price) {
		this.price.set(price);
	}

	/**
	 * Dish property.
	 *
	 * @return the string property
	 */
	public StringProperty dishProperty() {
		return dish;
	}

	/**
	 * Gets the dish.
	 *
	 * @return the dish
	 */
	public String getDish() {
		return dish.get();
	}

	/**
	 * Sets the dish.
	 *
	 * @param dish
	 *            the new dish
	 */
	public void setDish(String dish) {
		this.dish.set(dish);
	}

	/**
	 * Special request property.
	 *
	 * @return the string property
	 */
	public StringProperty specialRequestProperty() {
		return specialRequest;
	}

	/**
	 * Gets the special request.
	 *
	 * @return the special request
	 */
	public String getspecialRequest() {
		return specialRequest.get();
	}

	/**
	 * Sets the special request.
	 *
	 * @param specialRequest
	 *            the new special request
	 */
	public void setSpecialRequest(String specialRequest) {
		this.specialRequest.set(specialRequest);
	}

	/**
	 * Comment property.
	 *
	 * @return the string property
	 */
	public StringProperty commentProperty() {
		return comment;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment.get();
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment
	 *            the new comment
	 */
	public void setComment(String comment) {
		this.comment.set(comment);
	}

	/**
	 * Status property.
	 *
	 * @return the string property
	 */
	public StringProperty statusProperty() {
		return status;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status.get();
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status.set(status);
	}
}

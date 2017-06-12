package Menu;

import javafx.beans.property.*;

// TODO: Auto-generated Javadoc
/**
 * Class to Model the Menu Object by defining the property of each elementsType
 * and creating getters and setters for them, so that they can be extracted from
 * the Objects that are returned from The DAO layer.
 */
public class MenuModel {
	/** The id. */
	// Declare Menu columns
	private IntegerProperty id;

	/** The menu dish. */
	private StringProperty menuDish;

	/** The price. */
	private FloatProperty price;

	/** The period. */
	private StringProperty period;

	/**
	 * Instantiates a new menu model.
	 */
	public MenuModel() { // Constructor
		this.id = new SimpleIntegerProperty();
		this.menuDish = new SimpleStringProperty();
		this.price = new SimpleFloatProperty();
		this.period = new SimpleStringProperty();
	}

	/**
	 * Id property.
	 *
	 * @return the integer property
	 */
	public IntegerProperty idProperty() {
		return id;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id.get();
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id.set(id);
	}

	/**
	 * Menu dish property.
	 *
	 * @return the string property
	 */
	public StringProperty menuDishProperty() {
		return menuDish;
	}

	/**
	 * Gets the menu dish.
	 *
	 * @return the menu dish
	 */
	public String getMenuDish() {
		return menuDish.get();
	}

	/**
	 * Sets the menu dish.
	 *
	 * @param menuDish
	 *            the new menu dish
	 */
	public void setMenuDish(String menuDish) {
		this.menuDish.set(menuDish);
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
	 * Period property.
	 *
	 * @return the string property
	 */
	public StringProperty periodProperty() {
		return period;
	}

	/**
	 * Gets the period.
	 *
	 * @return the period
	 */
	public String getPeriod() {
		return period.get();
	}

	/**
	 * Sets the period.
	 *
	 * @param period
	 *            the new period
	 */
	public void setPeriod(String period) {
		this.period.set(period);
	}

}

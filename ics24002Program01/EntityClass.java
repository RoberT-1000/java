
public class EntityClass {
	
	private String vehicleMake, vehicleModel;
	private double engDspLtr;
	private int engCylinders, vehDoors;
	
	/**
	 * This is the constructor method for the EntityClass object.
	 * This method has no parameters and returns no values. It only creates
	 * an instance of an EntityClass.
	 */
	public EntityClass() {
		
	}
	
	/**
	 * This method sets the value of the int variable vehDoors.
	 * 
	 * @param doors
	 */
	public void setDoors(int doors) {
		this.vehDoors = doors;
	}
	
	/**
	 * This method returns the value of the int variable vehDoors.
	 * 
	 * @return vehDoors
	 */
	public int getDoors() {
		return this.vehDoors;
	}
	
	/**
	 * This method sets the value of the double variable engDspLtr
	 * 
	 * @param displacement
	 */
	public void setDspLtr(double displacement) {
		this.engDspLtr = displacement;
	}
	
	/**
	 * This method returns the value of the double variable engDspLtr
	 * 
	 * @return engDspLtr
	 */
	public double getDspLtr() {
		return this.engDspLtr;
	}
	
	/**
	 * This method sets the value of the String variable vehicleMake
	 * 
	 * @param make
	 */
	public void setMake(String make) {
		this.vehicleMake = make;
	}

	/**
	 * This method returns the value of the String variable vehicleMake.
	 * 
	 * @return vehicleMake
	 */
	public String getMake() {
		return this.vehicleMake;
	}
	
	/**
	 * This method sets the value of the String variable vehicleModel.
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		this.vehicleModel = model;
	}
	
	/**
	 * This method returns the value of the String variable vehicleModel.
	 * 
	 * @return vehicleModel
	 */
	public String getModel() {
		return this.vehicleModel;
	}
	
	/**
	 * This sets the value of engCylinders.
	 *  
	 * @param cylinders
	 */
	public void setCylinders(int cylinders) {
		this.engCylinders = cylinders;
	}
	
	/**
	 * This method returns the value of the engCylinders variable.
	 * 
	 * @return engCylinders 
	 */
	public int getCylinders() {
		return this.engCylinders;
	}
	
	/**
	 * This method takes in a String, sets it to upper case, and compares it to an
	 * upper case vehicleMake. If the two are equal, the method returns true.
	 * @param compareMake
	 * @return boolean
	 */
	public boolean equals (String compareMake) {
		return (this.vehicleMake.toUpperCase().equals(compareMake.toUpperCase()));
	}	
	
	/**
	 * This method returns the status of this particular element.
	 * 
	 * @return the value of each variable is returned
	 */
	public String toString() {
		return "Make: " + this.vehicleMake + 
				", Model: " + this.vehicleModel + 
				", Doors: " + this.vehDoors +
				", Engine: " + this.engDspLtr + 
				" liter " + this.engCylinders + " cylinder";
	}
}

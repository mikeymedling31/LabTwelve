public class UsedCar extends Car{
	protected double mileage;
	
	public UsedCar(String make, String model, int year, double price, double mileage) {
		super(make, model, year, price);
		this.mileage = mileage; 
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-10s%-5d$%-1.2f   Used %-10.2fMiles", make, model, year, price, mileage);
	}
}

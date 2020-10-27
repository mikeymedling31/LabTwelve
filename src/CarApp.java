import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CarApp {
	static List<Car> cars = new ArrayList<>();
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
//		System.out.println("Welcome to the Grand Circus Motors admin console!\nHow many cars are you entering?");
//		int additional = (input.nextInt());
		
//		for(int i = 0; i < additional; i++) {
//			Car a = new Car();
//			System.out.println("Enter car#" + (i+1) + " Make: ");
//			a.setMake(input.next());
//			System.out.println("Enter car#" + (i+1) + " Model: ");
//			a.setModel(input.next());
//			System.out.println("Enter car#" + (i+1) + " Year: ");
//			a.setYear(input.nextInt());
//			System.out.println("Enter car#" + (i+1) + " Price: $");
//			a.setPrice(input.nextDouble());
//			cars.add(a);
//		}
		
			cars.add(new Car("Nikolai", "Model S", 2021, 54999.90));
			cars.add(new UsedCar("Ferd", "Escapade", 2017, 31999.90, 10053));
			cars.add(new Car("Chewie", "Vettey", 2017, 44995));
			cars.add(new UsedCar("Supbra", "Btcgeter", 2005, 4599.18, 124054));
			cars.add(new Car("Tesley", "Model Pi", 2020, 31465));
			cars.add(new UsedCar("Ferd", "Exploder", 2018, 22599, 25610));
			boolean flag = true;
			do {
				if(inventory()) {
					System.out.println("Excellent! Our finance department will be in touch shortly.");
				}
				
				System.out.println("Would you like to continue?");
				if(!getYesNo(input.nextLine())) {
					System.out.println("Have a great day!");
					flag=false;
				}
			}while(flag);		
	}
	
	public static boolean inventory() {
		System.out.println("\nCurrent Inventory:");
		int o = 0;
		for(Car i : cars){
			System.out.println((o+1) + ")" + i.toString());
			o++;
		}
		System.out.println("\nWhich car would you like to ?");
		Car choice = null;
		try {
			choice = cars.get(input.nextInt() -1);
			
			System.out.println(choice);
		}catch(InputMismatchException | IndexOutOfBoundsException e) {
			System.out.println("Please select among the options 1 - "+ (o));
			input.nextLine();
			inventory();
		} 
		if(verify()) {
			cars.remove(choice);
			
			return true;
		}else {
			return false;
		}
	}
	
	
	private static final Set<String> VALID_YES = new HashSet<>(
			Arrays.asList("yes", "y", "yeah", "ok", "sure"));
	private static final Set<String> VALID_NO = new HashSet<>(
			Arrays.asList("no", "n", "nope"));

	
	public static boolean getYesNo(String prompt) {
		
		String userInput = (prompt).toLowerCase();
			try {
				if (VALID_YES.contains(userInput)) {
					input.nextLine();
					return true;
				} else if (VALID_NO.contains(userInput)) {
					input.nextLine();
					return false;
				}
			}catch(InputMismatchException | IndexOutOfBoundsException e) {
				System.out.println("Please select yes or no");
			}
		return false;
	}
	
	public static boolean verify() {
		System.out.println("Would you like to buy this car?");
		return getYesNo(input.next());
	}
}

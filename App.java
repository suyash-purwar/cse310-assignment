import java.util.*;
import utils.Validator;
import errors.*;
import modules.*;

class App {
	void launch() {
		try {
			System.out.println("\nWhat would you like to do?");
			System.out.println("---------------------------");

			System.out.println("1. Show cars in the fleet");
			System.out.println("2. Add new car to the fleet");
			System.out.println("3. Show detailed report about a car");
			System.out.println("4. Book a car");
			System.out.println("5. Exit");

			System.out.print("\nEnter the option: ");
			Scanner option_sc = new Scanner(System.in);
			int option = option_sc.nextInt();

			if (Validator.isNumericRangeValid(option, 1, 6)) {
				switch (option) {
					case 1:
						OptionHandler.showAllCarsOption();
						break;
					case 2:
						OptionHandler.addNewCarOption();
						break;
					case 3:
						OptionHandler.showCarReportOption();
						break;
					case 4:
						OptionHandler.bookCarOption();
						break;
					case 5:
						return;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("\nError: Expecting a numberic value. Recieve a string.");
		} catch (InvalidOptionException e) {
			System.out.println("\nError: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		App app = new App();
		app.launch();
	}
}

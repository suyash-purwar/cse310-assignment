package modules;

import java.io.IOException;
import java.util.*;
import utils.Validator;
import errors.*;
import modules.Fleet;

public class OptionHandler {
  public static void showAllCarsOption() {
    System.out.println("\nFollowing are the cars in the fleet");
    System.out.println("--------------------------------------");
    Fleet.showAllCars();
  }

  public static void addNewCarOption() {
    System.out.println("\nAdding a new car to the fleet");
    System.out.println("-------------------------------");

    System.out.print("Enter the id of the car: ");
    Scanner id_sc = new Scanner(System.in);
    int id = id_sc.nextInt();
    boolean doesExist = Validator.doesIdExist(id);  

    if (doesExist) {
      System.out.println("\nError: Id already exists. Enter a unique id.");
      return;
    }

    System.out.print("Enter the model of the car: ");
    Scanner name_sc = new Scanner(System.in);
    String name = name_sc.nextLine();

    System.out.print("Enter the color of the car: ");
    Scanner model_sc = new Scanner(System.in);
    String model = model_sc.nextLine();

    Fleet.addNewCar(id, name, model);
  }

  public static void showCarReportOption() {
    try {
      System.out.println("\nSee detailed report about the car");
      System.out.println("-----------------------------------");
      System.out.print("Enter the id of the car: ");
      Scanner id_sc = new Scanner(System.in);
      int id = id_sc.nextInt();
      boolean doesExist = Validator.doesIdExist(id);
      if (!doesExist) {
        System.out.println("\nError: Car with this id does not exist. Enter a valid car id.");
        return;
      }
      System.out.println("\nReport of the car with id " + id);
      Fleet.getCarReport(id);
    } catch (IOException e) {
      System.out.println("\nError: Car with this id does not exist. Enter a valid car id.");
    }
  }

  public static void bookCarOption() {
    try {
      System.out.println("\nBook a car");
      System.out.println("-----------------------------------");
      System.out.print("Enter the id of the car you want to book: ");

      Scanner id_sc = new Scanner(System.in);
      int id = id_sc.nextInt();
      boolean doesExist = Validator.doesIdExist(id);
      if (!doesExist) {
        System.out.println("\nError: Car with this id does not exist. Enter a valid car id.");
        return;
      }

      if (Validator.isCarAlreadyBooked(id)) {
        System.out.println("\nError: Car already booked. Please choose any other car.");
        return;
      }

      System.out.print("Enter your name: ");
      Scanner sc_name = new Scanner(System.in);
      String name = sc_name.nextLine();

      System.out.print("Enter car return date: ");
      Scanner sc_date = new Scanner(System.in);
      String date = sc_date.nextLine();

      if (Validator.isValidDate(date)) {
        Fleet.bookCar(id, name, date);
        System.out.println("\nCar booked successfully!");
      } else {
        System.out.println("\nError: Date is not in the valid format. Date must be in this format: DD/MM/YYYY");
      }
    } catch( IOException e) {
      System.out.println("\nError: Car with this id does not exist. Enter a valid car id.");
    }
  }
}
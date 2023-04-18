package utils;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import errors.*;

public class Validator {
  private static String DB_PATH = "/media/suyash/HDD/Programming/Java/assignment/db/db.csv";

  public static boolean doesIdExist(int num) {
    try {
      String line;
      BufferedReader db_r = new BufferedReader(new FileReader("/media/suyash/HDD/Programming/Java/assignment/db/db.csv"));
      db_r.readLine();
      while ((line = db_r.readLine()) != null) {
        if (num == Integer.parseInt(line.charAt(0)+"")) {
          return true;
        }
      }
      return false;
    } catch (IOException e) {
			return false;
		}
  }

  public static boolean isNumericRangeValid(int option, int lower, int higher) throws InvalidOptionException {
    if (!(option >= lower && option <= higher)) {
      throw new InvalidOptionException("Choosen option must range from 1 - 5. Received '" + option + "'.");
    }
    return true;
  }

  public static boolean isValidDate(String stringDate) {
    try {
      String split_date[] = stringDate.split("/");
      if (split_date.length != 3) return false;
      int date = Integer.parseInt(split_date[0]);
      int month = Integer.parseInt(split_date[1]);
      int year = Integer.parseInt(split_date[2]);

      if (
        (date > 0 && date <= 31) &&
        (month > 0 && month <= 12) &&
        year == 2023
      ) {
        return true;
      }

      return false;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static boolean isCarAlreadyBooked(int id) throws IOException {
    String line;
    BufferedReader db_r = new BufferedReader(new FileReader(DB_PATH));
    db_r.readLine();
    boolean isBooked = false;
    while ((line = db_r.readLine()) != null) {
      if (id == Integer.parseInt(line.charAt(0)+"")) {
        if (line.split(", ")[3].equals("true")) {
          isBooked = true;
        }
      }
    }
    return isBooked;
  }
}
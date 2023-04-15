package modules;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fleet {
  private static String DB_PATH = "/media/suyash/HDD/Programming/Java/assignment/db/db.csv";
  private static char[] read_buffer = new char[1000];

  public static void addNewCar(int id, String model, String color) {
    try {
      FileWriter db_w = new FileWriter(DB_PATH, true);
      db_w.write("\n"+id+", "+model+", "+color+", false"+", null"+", null"+", null");
      db_w.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public static void showAllCars() {
    try {
      String line;
      String line_col[];
      BufferedReader db_r = new BufferedReader(new FileReader(DB_PATH));
      while ((line = db_r.readLine()) != null) {
        line_col = line.split(", ");
        for (int i = 0; i < 3; i++) {
          System.out.print(line_col[i]+"  ");
        }
        System.out.println();
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public static void getCarReport(int id) {
    try {
      String line;
      String line_col[];
      BufferedReader db_r = new BufferedReader(new FileReader(DB_PATH));
      System.out.println("\n" + db_r.readLine().replaceAll(", ", "  "));
      while ((line = db_r.readLine()) != null) {
        if (id == Integer.parseInt(line.charAt(0)+"")) {
          System.out.println(line.replaceAll(", ", "  "));
        }
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public static void bookCar(int id, String bookedBy, String returnDate) {
    try {
      LocalDateTime currentTime = LocalDateTime.now();
      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      String formattedCurrentDate = currentTime.format(dateFormat);
      String fields = "";
      String line;
      String line_col[];
      BufferedReader db_r = new BufferedReader(new FileReader(DB_PATH));
      String header = db_r.readLine();
      fields+=header+"\n";
      System.out.println("\n" + header.replaceAll(", ", "  "));
      while ((line = db_r.readLine()) != null) {
        if (id == Integer.parseInt(line.charAt(0)+"")) {
          line_col = line.split(", ");
          line_col[3] = "true";
          line_col[4] = bookedBy;
          line_col[5] = formattedCurrentDate;
          line_col[6] = returnDate;
          System.out.println(String.join("  ", line_col));
          fields+=String.join(", ", line_col)+"\n";
        } else {
          fields+=line+"\n";
        }
      }

      FileWriter db_w = new FileWriter(DB_PATH);
      db_w.write(fields);
      db_w.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
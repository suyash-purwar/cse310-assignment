package errors;

public class InvalidOptionException extends Exception {
  public InvalidOptionException(String str) {
    super(str);
  }
}
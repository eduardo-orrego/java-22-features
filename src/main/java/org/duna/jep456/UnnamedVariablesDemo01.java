package org.duna.jep456;

public class UnnamedVariablesDemo01 {
  public static void main(String[] args) {
    //An unnamed variable is represented by an underscore (_). Once initialized,
    // it cannot be read or written. It is useful when you want to declare variables
    // that we will not use but that are needed to avoid errors in the compilation.
    String message = "Number Format Exception";

    try {
      int number = Integer.parseInt("string");
      System.out.println(number);
    } catch (NumberFormatException _) {
      System.out.printf("Parse Error: %s", message);
    }
  }

}

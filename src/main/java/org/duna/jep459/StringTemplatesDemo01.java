package org.duna.jep459;

import static java.lang.StringTemplate.RAW;
import static java.lang.StringTemplate.STR;
import static java.util.FormatProcessor.FMT;

public class StringTemplatesDemo01 {
  public static void main(String[] args) {

    String name = "Doroteo";
    String dni = "21409856";
    Double amount = 10.12;
    System.out.println("USE STR");
    System.out.println(STR."Hello \{name}, with dni \{dni}");
    System.out.println(STR."""
      {
        "name": "\{name}",
        "dni": "\{dni}"
      }
    """);
    System.out.println("USE FMT");
    System.out.println(FMT."%2.2f\{amount}");
    System.out.println(FMT
      ."""
      {
        "name": "%1s\{name}",
        "dni": "%2.2f\{amount}"
      }
      """);
    System.out.println("USE RAW");
    StringTemplate st = RAW."Hello \{name}, with dni \{dni}";
    System.out.println(STR.process(st));
  }
}

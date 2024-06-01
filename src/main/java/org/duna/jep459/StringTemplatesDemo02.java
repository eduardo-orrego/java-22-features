package org.duna.jep459;

import static java.lang.StringTemplate.STR;
import static java.util.FormatProcessor.FMT;

public class StringTemplatesDemo02 {
  public static void main(String[] args) {
    record Seller(String name, Integer dni, double sales){}

    Seller[] sellers = new Seller[]{
      new Seller("Luis", 65897458, 31.4),
      new Seller("Ulises", 32568978, 12.2)
    };

    String resultTable = STR."""
    Name\t\tDni\t\t\tSales
    \{sellers[0].name}\t\t\{sellers[0].dni}\t\{sellers[0].sales}
    \{sellers[1].name}\t\t\{sellers[1].dni}\t\{sellers[1].sales}
    Total \{sellers[0].sales() + sellers[1].sales()}
    """;
    System.out.println(resultTable);

    String resultTableFormat = FMT."""
    Name\t\tDni\t\t\tSales
    %-12s\{sellers[0].name}%-12s\{sellers[0].dni}%3.2f\{sellers[0].sales}
    %-12s\{sellers[1].name}%-12s\{sellers[1].dni}%3.2f\{sellers[1].sales}
    \{" ".repeat(18)}Total %2.2f\{sellers[0].sales() + sellers[1].sales()}
    """;
    System.out.println(resultTableFormat);
  }
}

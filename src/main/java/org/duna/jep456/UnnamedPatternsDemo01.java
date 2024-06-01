package org.duna.jep456;

public class UnnamedPatternsDemo01 {

  public static void main(String[] args) {
    record Product(Integer productId, String productName, Boolean status) {
    }

    record Customer(Integer customerId, String customerName, Integer dni, Boolean status,
                    Product product) {
    }

    Product product = new Product(1, "Tablet", true);
    Customer customer = new Customer(2, "Luis Orrego", 23568978, true, product);

    if (customer instanceof Customer(_, String customerName, _, _, Product(_, String productName, _))) {
      System.out.printf("Customer %s has product %s", customerName, productName);
    }
  }

}

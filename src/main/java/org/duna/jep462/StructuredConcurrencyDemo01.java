package org.duna.jep462;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

public class StructuredConcurrencyDemo01 {

  record Customer(String name) {
  }

  record Product(String name) {
  }

  record Response(Customer customer, List<Product> products) {
  }

  public static void main(String[] args) {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      Supplier<Customer> user = scope.fork(() -> new Customer("Eduardo Orrego"));
      Supplier<List<Product>> order = scope.fork(() -> List.of(new Product("TV"),
        new Product("TABLET")));
      scope.join()
        .throwIfFailed();
      Response response = new Response(user.get(), order.get());
      System.out.println(response);

    } catch (ExecutionException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

package org.duna.jep447;


class Person {
  protected String name;

  Person(String name) {
    this.name = name;
  }
}

class Customer extends Person {
  protected Integer customerCode;

  Customer(Integer customerCode, String name) {
    System.out.println("I am allowed before the call to super(...)");
    super(name);
    this.customerCode = customerCode;
  }

  @Override
  public String toString() {
    return "Customer{customerCode=" + customerCode + ", name='" + name + '}';
  }
}

public class BeforeSuperDemo01 {

  public static void main(String[] args) {
    Customer customer = new Customer(10203010, "Eduardo");
    System.out.println(customer);
  }

}

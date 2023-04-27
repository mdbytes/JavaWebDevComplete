package com.mdbytes.classes;

import java.util.Objects;

public class Customer {
  private String firstName;
  private String lastName;
  private boolean goldCustomer;


  public Customer(String firstName, String lastName, boolean goldCustomer) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.goldCustomer = goldCustomer;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public boolean isGoldCustomer() {
    return goldCustomer;
  }

  public void setGoldCustomer(boolean goldCustomer) {
    this.goldCustomer = goldCustomer;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", goldCustomer=" + goldCustomer +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return goldCustomer == customer.goldCustomer && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, goldCustomer);
  }
}

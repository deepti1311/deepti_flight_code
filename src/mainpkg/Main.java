package mainpkg;

import Exceptions.*;
import flightprototype.pkg.*;
import flights.pkg.*;
import java.lang.*;


public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("\n");

    Boieng B1 = new Boieng("A123", 5);
    Airbus A1 = new Airbus("R45", 10);

    Thread thread1 = new Thread(() -> {

      try {
        B1.bookFlight(3);
       
        B1.cancelFlight(3);
      } catch (SeatNotAvailableException e) {
        System.out.println(e.getMessage());
      } catch (SeatNotBookedException e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
      } finally {
        System.out.println("Thank you for VISITING our Flight BOOKING page!!\n");

      }

      // try {
      //   B1.cancelFlight(3);
      // } catch (SeatNotAvailableException e) {
      //   System.out.println(e.getMessage());
      // } finally {
      //   System.out.println("Thank you for VISITING our Flight BOOKING page!!\n");

      // }

      // try {
      // A1.bookFlight(7);
      // } catch (SeatNotAvailableException e) {
      // e.getMessage();
      // } finally {
      // System.out.println("Thank you for VISITING our Flight BOOKING page!!\n");
      // }
    });
      System.out.println("\n");

    Thread thread2 = new Thread(() -> {

      try {
        B1.bookFlight(3);
      } catch (SeatNotAvailableException e) {
        System.out.println(e.getMessage());
      } finally {
        System.out.println("Thank you for VISITING our Flight BOOKING page!!\n");
      }

    });
    System.out.println("\n");

    Thread thread3 = new Thread(() -> {

      try {
        B1.bookFlight(3);
      } catch (SeatNotAvailableException e) {
        System.out.println(e.getMessage());
      } finally {
        System.out.println("Thank you for VISITING our Flight BOOKING page!!\n");
      }

    });
    thread1.setName("1st customer");
    thread2.setName("2nd customer");
    thread3.setName("3rd customer");

    thread1.start();
    thread2.start();
    thread3.start();

    System.out.println("\n");

  }
}

package flightprototype.pkg;

import java.util.ArrayList;

import Exceptions.*;

public abstract class Flight implements Flightbooking {

  public String flightNo;
  public int totalSeats;
  public ArrayList<Integer> availableSeats = new ArrayList<Integer>();
  public ArrayList<Integer> bookedSeats = new ArrayList<Integer>();
  private int seatno;

  public Flight(String flightNo, int totalSeats) {
    this.flightNo = flightNo;
    this.totalSeats = totalSeats;

    for (int seatno = 1; seatno <= totalSeats; seatno++) {

      this.availableSeats.add(seatno);
      this.bookedSeats.add(seatno);

    }

  }

  @Override
  public synchronized void bookFlight(int seatno) throws SeatNotAvailableException {

    System.out.println(getClass().getSimpleName() + " Filght Booking Details:");
    System.out.println("Filght Number:" + this.flightNo);
    System.out.println("Total Number of Seats:" + this.totalSeats);

    try {
      System.out
          .println(Thread.currentThread().getName() + " ---> is currently trying to book seat no." + seatno + "!!");
      Thread.sleep((long) (Math.random() * 1000));
      if (checkSeat(seatno)) {
        this.availableSeats.remove(this.availableSeats.indexOf(seatno));
        this.bookedSeats.set((seatno - 1), 0);
        System.out.println(getClass().getSimpleName() + " Flight seat number: " + seatno);
        System.out.println("SEAT BOOKED SUCCESFULLY!!!");
        System.out.println("Thank you for travelling with " + getClass().getSimpleName() + " Flight!!");
      } else {
        throw new SeatNotAvailableException(
            "seat No. " + seatno + "  is unavailable FOR BOOKING, " + getClass().getSimpleName() + " Flight!!");
      }
    } catch (SeatNotAvailableException | InterruptedException e) {
      e.getMessage();
      throw new SeatNotAvailableException(
          "seat No. " + seatno + "  is unavailable FOR BOOKING, " + getClass().getSimpleName() + " Flight!!");
    }
  }

  @Override
  public synchronized void cancelFlight(int seatno) throws SeatNotBookedException {

    System.out.println(getClass().getSimpleName() + " Filght CANCELLATION Details:");
    System.out.println("Filght Number:" + this.flightNo);
    System.out.println("Total Number of Seats:" + this.totalSeats);

    try {
      System.out
          .println(Thread.currentThread().getName() + " ---> is currently trying to cancel seat no." + seatno + "!!");
      Thread.sleep((long) (Math.random() * 5000));
      if (selectedSeat(seatno)) {
        this.availableSeats.add(seatno);

        this.availableSeats.set((seatno - 1), seatno);

        System.out.println(getClass().getSimpleName() + " Flight seat number: " + seatno);
        System.out.println("SEAT CANCELED SUCCESFULLY!!!");
        System.out.println("Thank you for travelling with " + getClass().getSimpleName() + " Flight!!");
      } else {
        throw new SeatNotBookedException(
            "seat No. " + seatno + "  is NOT BOOKED, " + getClass().getSimpleName() + " Flight!!");
      }
    } catch (SeatNotBookedException | InterruptedException e) {
      e.getMessage();
      throw new SeatNotBookedException(
          "seat No. " + seatno + " is NOT BOOKED, " + getClass().getSimpleName() + " Flight!!");
    }
  }

  @Override
  public boolean checkSeat(int seatno) {
    for (int seat : this.availableSeats) {
      if (seat == seatno) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean selectedSeat(int seatno) {
    for (int seat : this.bookedSeats) {
      if (seat == seatno) {
        return false;
      }
    }
    return true;
  }

}

package flights.pkg;

import Exceptions.*;
import flightprototype.pkg.*;

public class Boieng extends Flight implements Flightbooking {

  public Boieng(String flightNo, int totalSeats) {
    super(flightNo, totalSeats);
  }

  @Override
  public synchronized void bookFlight(int num) throws SeatNotAvailableException {
    super.bookFlight(num);

  }

  @Override
  public boolean checkSeat(int num) {
    return super.checkSeat(num);
  }

  @Override
  public synchronized void cancelFlight(int num) throws SeatNotBookedException {
    super.cancelFlight(num);

  }

  @Override
  public boolean selectedSeat(int num) {
    return super.selectedSeat(num);
  }
}
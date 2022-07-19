package flightprototype.pkg;

import Exceptions.*;

public interface Flightbooking {
  void bookFlight(int num) throws SeatNotAvailableException;

  void cancelFlight(int num) throws SeatNotBookedException;

  boolean checkSeat(int num);

  boolean selectedSeat(int num);

}

package ticket_service.repository;

import ticket_service.model.Seat;

public class SeatRepository extends RepositoryImpl<Seat> {
  private static final SeatRepository instance = new SeatRepository();

  public static SeatRepository getInstance() {
    return instance;
  }
}

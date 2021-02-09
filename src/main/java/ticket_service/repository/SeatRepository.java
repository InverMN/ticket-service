package ticket_service.repository;

import ticket_service.models.Seat;

public class SeatRepository extends RepositoryImpl<Seat> {
  private static final SeatRepository instance = new SeatRepository();

  public static SeatRepository getInstance() {
    return instance;
  }
}

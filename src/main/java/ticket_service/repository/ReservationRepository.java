package ticket_service.repository;

import ticket_service.models.Reservation;

public class ReservationRepository extends RepositoryImpl<Reservation> {
  private static final ReservationRepository instance = new ReservationRepository();

  public static ReservationRepository getInstance() {
    return instance;
  }
}

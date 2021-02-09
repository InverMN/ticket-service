package ticket_service.repository;

import ticket_service.model.Event;

public class EventRepository extends RepositoryImpl<Event> {
  private static final EventRepository instance = new EventRepository();

  public static EventRepository getInstance() {
    return instance;
  }
}

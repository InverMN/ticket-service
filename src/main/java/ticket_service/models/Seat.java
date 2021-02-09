package ticket_service.models;

public class Seat extends ModelImpl {

  public Seat(String location, String label) {
    this.location = location;
    this.label = label;
  }

  private final String location;
  private final String label;

  public String getLocation() {
    return this.location;
  }

  public String getLabel() {
    return this.label;
  }
}
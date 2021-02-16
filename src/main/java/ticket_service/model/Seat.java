package ticket_service.model;

import com.opencsv.bean.CsvBindByPosition;

public class Seat extends ModelImpl {

  public Seat(String location, String label) {
    this.location = location;
    this.label = label;
  }

  @CsvBindByPosition(position = 1)
  private final String location;
  @CsvBindByPosition(position = 2)
  private final String label;

  public String getLocation() {
    return this.location;
  }

  public String getLabel() {
    return this.label;
  }
}
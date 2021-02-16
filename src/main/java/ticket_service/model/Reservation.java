package ticket_service.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import com.opencsv.bean.CsvBindByPosition;

public class Reservation extends ModelImpl {

  public Reservation(
    String personIdentifier,
    ObjectId[] reservedSeats,
    BigDecimal cost,
    ObjectId event,
    ZonedDateTime startTime,
    ZonedDateTime endTime
  ) {
    this.personIdentifier = personIdentifier;
    this.reservedSeats = reservedSeats;
    this.cost = cost;
    this.event = event;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @CsvBindByPosition(position = 1)
  private final String personIdentifier;
  @CsvBindByPosition(position = 2)
  private final ObjectId[] reservedSeats;
  @CsvBindByPosition(position = 3)
  private final BigDecimal cost;
  @CsvBindByPosition(position = 4)
  private final ObjectId event;
  @CsvBindByPosition(position = 5)
  private ZonedDateTime startTime;
  @CsvBindByPosition(position = 6)
  private ZonedDateTime endTime;

  public String getPersonIdentifier() {
    return this.personIdentifier;
  }

  public ObjectId[] getReservedSeats() {
    return this.reservedSeats;
  }

  public BigDecimal getCost() {
    return this.cost;
  }

  public ObjectId getEvent() {
    return this.event;
  }

  public ZonedDateTime getStartTime() {
    return this.startTime;
  }

  public void setStartTime(ZonedDateTime startTime) {
    this.startTime = startTime;
  }

  public ZonedDateTime getEndTime() {
    return this.endTime;
  }

  public void setEndTime(ZonedDateTime endTime) {
    this.endTime = endTime;
  }
}

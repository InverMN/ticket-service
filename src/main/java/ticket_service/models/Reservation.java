package ticket_service.models;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

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

  private final String personIdentifier;
  private final ObjectId[] reservedSeats;
  private final BigDecimal cost;
  private final ObjectId event;
  private ZonedDateTime startTime;
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

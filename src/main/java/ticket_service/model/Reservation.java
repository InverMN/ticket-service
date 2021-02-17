package ticket_service.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

import ticket_service.csv.ObjectIdConverter;
import ticket_service.csv.ZoneDateTimeConverter;

public class Reservation extends ModelImpl {

  public Reservation() {}

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
  private String personIdentifier;
  @CsvBindByPosition(position = 2)
  private ObjectId[] reservedSeats;
  @CsvBindByPosition(position = 3)
  private BigDecimal cost;
  @CsvCustomBindByPosition(position = 4, converter = ObjectIdConverter.class)
  private ObjectId event;
  @CsvCustomBindByPosition(position = 5, converter = ZoneDateTimeConverter.class)
  private ZonedDateTime startTime;
  @CsvCustomBindByPosition(position = 6, converter = ZoneDateTimeConverter.class)
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

package ticket_service.model;

import java.math.BigDecimal;
import com.opencsv.bean.CsvBindByPosition;

public class Event extends ModelImpl {

  public Event() {}

  public Event(String name) {
    this.name = name;
  }

  @CsvBindByPosition(position = 1)
  private String name;
  @CsvBindByPosition(position = 2)
  private BigDecimal price;

  public String getName() {
    return this.name;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
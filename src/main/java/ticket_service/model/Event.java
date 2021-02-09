package ticket_service.model;

import java.math.BigDecimal;

public class Event extends ModelImpl {

  public Event(String name) {
    this.name = name;
  }
  
  private final String name;
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
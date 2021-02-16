package ticket_service.model;

import com.opencsv.bean.CsvBindByPosition;

abstract public class ModelImpl implements Model {
  @CsvBindByPosition(position = 0)
  private final ObjectId id = ObjectId.generate();

  @Override
  public ObjectId getId() {
    return id;
  }
}

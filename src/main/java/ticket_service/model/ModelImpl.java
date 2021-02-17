package ticket_service.model;

import com.opencsv.bean.CsvCustomBindByPosition;

import ticket_service.csv.ObjectIdConverter;

abstract public class ModelImpl implements Model {
  @CsvCustomBindByPosition(converter = ObjectIdConverter.class, position = 0)
  private final ObjectId id = ObjectId.generate();

  @Override
  public ObjectId getId() {
    return id;
  }
}

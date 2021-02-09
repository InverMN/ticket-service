package ticket_service.model;

abstract public class ModelImpl implements Model {
  private final ObjectId id = ObjectId.generate();

  @Override
  public ObjectId getId() {
    return id;
  }
}

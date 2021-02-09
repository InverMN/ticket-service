package ticket_service.models;

abstract public class ModelImpl implements Model {
  private static final ObjectId id = ObjectId.generate();

  @Override
  public ObjectId getId() {
    return id;
  }
}

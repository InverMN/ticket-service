package ticket_service.models;

import java.util.UUID;

public class ObjectId {
  public static ObjectId generate() {
    var uuid = UUID.randomUUID();
    var rawId = uuid.toString().substring(0, 8);
    var objectId = new ObjectId(rawId); 
    return objectId;
  }

  private final String id;

  @Override
  public String toString() {
    return this.id;
  }

  protected ObjectId(String id) {
    this.id = id;
  }
}

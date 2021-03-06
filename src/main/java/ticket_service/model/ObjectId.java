package ticket_service.model;

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

  public ObjectId(String id) {
    this.id = id;
  }

  public boolean equals(ObjectId obj) {
    return this.id.equals(obj.id);
  }
}

package ticket_service.repository;

import ticket_service.models.Model;
import ticket_service.models.ObjectId;

public interface Repository<M extends Model> {
  public void insertOne(M model);
  public void insertMany(M[] models);
  public boolean exists(ObjectId id);
  public M findOneById(ObjectId id);
  public M[] findAll();
  public void deleteOneById(ObjectId id);
  public void deleteAll();
}

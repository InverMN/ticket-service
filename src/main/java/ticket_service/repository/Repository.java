package ticket_service.repository;

import java.util.ArrayList;

import ticket_service.model.Model;
import ticket_service.model.ObjectId;

public interface Repository<M extends Model> {
  public void insertOne(M model);
  public void insertMany(M[] models);
  public boolean exists(ObjectId id);
  public M findOneById(ObjectId id);
  public ArrayList<M> findAll();
  public void deleteOneById(ObjectId id);
  public void deleteAll();
}

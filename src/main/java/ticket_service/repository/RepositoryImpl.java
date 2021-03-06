package ticket_service.repository;

import java.util.ArrayList;
import java.util.stream.Collectors;

import ticket_service.model.Model;
import ticket_service.model.ObjectId;

public abstract class RepositoryImpl<M extends Model> implements Repository<M> {
  private ArrayList<M> models = new ArrayList<M>();

  @Override
  public void insertOne(M model) {
    this.models.add(model);
  }

  @Override
  public void insertMany(M[] models) {
    for(var singleModel : models)
      this.models.add(singleModel);
  }

  @Override
  public boolean exists(ObjectId id) {
    return findOneById(id) != null;
  }

  @Override
  public M findOneById(ObjectId id) {
    return this.models
      .stream()
      .filter(singleModel -> singleModel.getId().equals(id))
      .findFirst()
      .orElse(null);
  }

  @Override
  public ArrayList<M> findAll() {
    return models;
  }

  @Override
  public void deleteOneById(ObjectId id) {
    models = (ArrayList<M>) models
      .stream()
      .filter(singleModel -> !singleModel.getId().equals(id))
      .collect(Collectors.toList());
  } 

  @Override
  public void deleteAll() {
    models = new ArrayList<M>();
  }
}

package ticket_service.cli;

import ticket_service.model.ObjectId;

public interface Cli<T> {
    public void execute(String[] commandFragments);
    public void printAll();
    public void printOneById(ObjectId id);
    public void create(T object);
    public void remove(ObjectId id);
    public void printCommandNotFound();
}

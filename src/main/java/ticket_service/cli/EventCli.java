package ticket_service.cli;

import ticket_service.model.Event;
import ticket_service.model.ObjectId;
import ticket_service.model.Seat;
import ticket_service.repository.EventRepository;
import ticket_service.repository.SeatRepository;

import java.math.BigDecimal;

public class EventCli implements Cli<Event> {
    @Override
    public void execute(String[] commandFragments) {
        switch (commandFragments[1]) {
            case "list":
                printAll();
                break;
            case "get":
                printOneById(new ObjectId(commandFragments[2]));
                break;
            case "create":
                create(new Event(commandFragments[2],new BigDecimal(commandFragments[3])));
                break;
            case "remove":
                remove(new ObjectId(commandFragments[2]));
                break;
            case "load":
                loadCsv();
            case "save":
                saveCsv();
            default:
                printCommandNotFound();
        }
    }

    @Override
    public void printAll(){
        var events = EventRepository.getInstance().findAll();
        System.out.println("Event: ");
        for (var event : events) {
            System.out.println(event.getId() + " " + event.getName() + ":" + event.getPrice());
        }
    }

    @Override
    public void printOneById(ObjectId id){
        Event event = EventRepository.getInstance().findOneById(id);
        System.out.println("Event: ");
        System.out.println(event.getName() + ":" + event.getPrice());
    }

    @Override
    public void create(Event event){
        EventRepository.getInstance().insertOne(event);
        System.out.println("Created new event");
    }

    @Override
    public void remove(ObjectId id){
        EventRepository.getInstance().deleteOneById(id);
        System.out.println("Deleted event");
    }

    @Override
    public void loadCsv(){
    }

    @Override
    public void saveCsv(){
    }


    @Override
    public void printCommandNotFound(){
        System.out.println("Command not found");
    }
}


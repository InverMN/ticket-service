package ticket_service.cli;

import ticket_service.csv.CsvFile;
import ticket_service.model.Event;
import ticket_service.model.ObjectId;
import ticket_service.model.Reservation;
import ticket_service.model.Seat;
import ticket_service.repository.ReservationRepository;
import ticket_service.repository.SeatRepository;

public class SeatCli implements Cli<Seat>{
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
                create(new Seat(commandFragments[2],commandFragments[3]));
                break;
            case "remove":
                remove(new ObjectId(commandFragments[2]));
                break;
            case "load":
                loadCsv();
                break;
            case "save":
                saveCsv();
                break;
            default:
                printCommandNotFound();
        }
    }

    @Override
    public void printAll(){
        var seats = SeatRepository.getInstance().findAll();
        System.out.println("Seats: ");
        for (var seat : seats) {
            System.out.println(seat.getId() + " " + seat.getLocation() + ":" + seat.getLabel());
        }
    }

    @Override
    public void printOneById(ObjectId id){
        Seat seat = SeatRepository.getInstance().findOneById(id);
        System.out.println("Seat: ");
        System.out.println(seat.getLocation() + ":" + seat.getLabel());
    }

    @Override
    public void create(Seat seat){
        SeatRepository.getInstance().insertOne(seat);
        System.out.println("Created new seat");
    }

    @Override
    public void remove(ObjectId id){
        SeatRepository.getInstance().deleteOneById(id);
        System.out.println("Deleted seat");
    }

    @Override
    public void loadCsv(){
        var repo = SeatRepository.getInstance();
        var csvFile = new CsvFile<Seat>("./seat.csv", repo, Seat.class);
        csvFile.read();
        System.out.println("Loaded");
    }

    @Override
    public void saveCsv(){
        var repo = SeatRepository.getInstance();
        var csvFile = new CsvFile<Seat>("./seat.csv", repo, Seat.class);
        csvFile.write();
        System.out.println("Saved");
    }

    @Override
    public void printCommandNotFound(){
        System.out.println("Command not found");
    }
}

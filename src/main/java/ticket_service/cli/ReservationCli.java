package ticket_service.cli;

import ticket_service.model.ObjectId;
import ticket_service.model.Reservation;
import ticket_service.repository.ReservationRepository;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class ReservationCli implements Cli<Reservation> {
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
                create(new Reservation(commandFragments[2], new ObjectId[0], new BigDecimal(commandFragments[4]), new ObjectId(commandFragments[5]) , ZonedDateTime.parse(commandFragments[6]), ZonedDateTime.parse(commandFragments[7])));
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
        var reservations = ReservationRepository.getInstance().findAll();
        System.out.println("Reservation: ");
        for (var reservation : reservations) {
            System.out.println(reservation.getId() + " " + reservation.getPersonIdentifier() + ":" + "[]" + ":" + reservation.getCost() + ":" + reservation.getEvent() + ":" + reservation.getStartTime() + ":" + reservation.getEndTime());
        }
    }

    @Override
    public void printOneById(ObjectId id){
        Reservation reservation = ReservationRepository.getInstance().findOneById(id);
        System.out.println("Reservation: ");
        System.out.println(reservation.getId() + " " + reservation.getPersonIdentifier() + ":" + "[]" + ":" + reservation.getCost() + ":" + reservation.getEvent() + ":" + reservation.getStartTime() + ":" + reservation.getEndTime());
    }

    @Override
    public void create(Reservation reservation){
        ReservationRepository.getInstance().insertOne(reservation);
        System.out.println("Created new reservation");
    }

    @Override
    public void remove(ObjectId id){
        ReservationRepository.getInstance().deleteOneById(id);
        System.out.println("Deleted reservation");
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

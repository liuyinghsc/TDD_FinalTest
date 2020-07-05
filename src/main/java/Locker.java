import java.util.HashMap;
import java.util.Map;

public class Locker implements Reportable{
    private final Map<Ticket, Bag> ticketBagMap;
    private final String type;

    private int totalCapacity;

    public Locker(int size,String type) {
        this.totalCapacity = size;
        this.type =type;
        ticketBagMap = new HashMap<>();
    }

    public String getType() {
        return type;
    }

    public Ticket save(Bag bag) {
        if(hasRoom()) {
            Ticket ticket = new Ticket();
            ticketBagMap.put(ticket, bag);
            return ticket;
        }
        throw new LockerHasNoRoomException("Locker has no room!");
    }

    public boolean hasRoom() {
        return ticketBagMap.size() < totalCapacity;
    }

    public Bag pickUp(Ticket ticket) {
        if (isValid(ticket)) {
            return ticketBagMap.get(ticket);
        }
        throw new InvalidTicketException();
    }

    public boolean isValid(Ticket ticket) {
        return ticketBagMap.containsKey(ticket);
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getAvailableCapacity() {
        return totalCapacity - ticketBagMap.size();
    }

    @Override
    public String getReport() {
        return "L " + getAvailableCapacity() + " " + totalCapacity;
    }
}

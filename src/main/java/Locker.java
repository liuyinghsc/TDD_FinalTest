import java.util.HashMap;
import java.util.Map;

public class Locker {
    private final Map<Ticket, Bag> ticketBagMap;
    private int size;

    public Locker(int size) {
        this.size = size;
        ticketBagMap = new HashMap<>();
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
        return ticketBagMap.size() < size;
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

    public int getAvailableRoom() {
        return size - ticketBagMap.size();
    }
}

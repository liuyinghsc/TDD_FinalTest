import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/6/20
 */

public class PrimaryLockerRobot {

    private final List<Locker> lockers;

    public PrimaryLockerRobot(Locker... lockers) {
        this.lockers= new ArrayList<>();
        Collections.addAll(this.lockers, lockers);
    }

    public Ticket save(Bag bag) {
        for (Locker locker : lockers) {
            if(locker.hasRoom()) {
                return locker.save(bag);
            }
        }
        return null;
    }

    public Bag pickUp(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isValid(ticket)) {
                return locker.pickUp(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}

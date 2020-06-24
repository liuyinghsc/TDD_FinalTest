import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/6/20
 */

public class PrimaryLockerRobot extends Robot{



    public PrimaryLockerRobot(Locker... lockers) {
        super(Arrays.asList(lockers));
    }

    public Ticket save(Bag bag) {
        for (Locker locker : lockers) {
            if(locker.hasRoom()) {
                return locker.save(bag);
            }
        }
        throw new LockerHasNoRoomException();
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

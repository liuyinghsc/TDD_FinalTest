import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/6/20
 */

public class SmartLockerRobot extends Robot {

    public SmartLockerRobot(Locker... lockers) {
        super(Arrays.asList(lockers));
    }

    public Ticket save(Bag bag) {
        return lockers.stream()
                .max(Comparator.comparing(Locker::getAvailableCapacity))
                .map(value -> value.save(bag))
                .orElse(null);
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

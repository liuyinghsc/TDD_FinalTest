import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/6/20
 */

public class SmartLockerRobot implements Robot {
    private final List<Locker> lockers;

    public SmartLockerRobot(Locker... lockers) {
        this.lockers = new ArrayList<>();
        this.lockers.addAll(Arrays.asList(lockers));
    }

    public Ticket save(Bag bag) {
        return lockers.stream()
                .max(Comparator.comparing(Locker::getAvailableRoom))
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

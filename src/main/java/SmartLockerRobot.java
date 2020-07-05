import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/6/20
 */

public class SmartLockerRobot {
    private List<Locker> lockers;

    public SmartLockerRobot(Locker... lockers) {
        List<Locker> lockers1 = Arrays.asList(lockers);
        ArrayList<Locker> resLockers = new ArrayList<>();
        for (int i = 0; i < lockers1.size(); i++) {
            Locker locker = lockers1.get(i);
            if (locker.getType().equals("L")){
                resLockers.add(locker);
            }else {
                throw new LockerIsNotMatchException("The Locker is not match the robot");
            }
        }
        this.lockers= new ArrayList<>();
        this.lockers.addAll( Arrays.asList(lockers));
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

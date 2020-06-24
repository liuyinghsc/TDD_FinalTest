import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LockerRobotManager {
    private final List<Locker> lockers;

    public LockerRobotManager(List<Locker> lockers, List<Robot> robots) {
        this.lockers = new ArrayList();
        this.lockers.addAll(lockers);
    }

    public Ticket save(Bag bag) {
        for (Locker locker : this.lockers) {
            if (locker.hasRoom()) {
                return locker.save(bag);
            }
        }
        return null;
    }
}

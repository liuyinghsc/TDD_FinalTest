import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LockerRobotManager {
    private final List<Locker> lockers = new ArrayList<>();
    private final List<Robot> robots = new ArrayList<>();

    public LockerRobotManager(List<Locker> lockers, List<Robot> robots) {
        this.lockers.addAll(lockers);
        this.robots.addAll(robots);
    }

    public Ticket save(Bag bag) {
        for (Robot robot: this.robots) {
            if (robot.hasRoom()) {
                return robot.save(bag);
            }
        }

        for (Locker locker : this.lockers) {
            if (locker.hasRoom()) {
                return locker.save(bag);
            }
        }
        return null;
    }
}

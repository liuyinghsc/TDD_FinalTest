import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LockerRobotManager implements Reportable{
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
        throw new LockerHasNoRoomException();
    }

    public Bag pickUp(Ticket ticket) {
        for (Robot robot: this.robots) {
            if (robot.isValid(ticket)) {
                return robot.pickUp(ticket);
            }
        }
        for (Locker locker : this.lockers) {
            if (locker.isValid(ticket)) {
                return locker.pickUp(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    public int getAvailableCapacity() {
        return lockers.stream()
                .mapToInt(Locker::getAvailableRoom)
                .sum();
    }

    public int getTotalCapacity() {
        return lockers.stream()
                .mapToInt(Locker::getTotalCapacity)
                .sum();
    }

    @Override
    public String getReport() {
        return String.join("\n", getSumReport(), getLockerReport());
    }

    private String getSumReport() {
        return "M " + getAvailableCapacity() + " " + getTotalCapacity();
    }

    private String getLockerReport() {
        return lockers.stream()
                .map(locker -> "  " + locker.getReport())
                .collect(Collectors.joining("\n"));
    }
}

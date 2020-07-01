import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Robot implements Reportable{
    protected final List<Locker> lockers;

    protected Robot(List<Locker> lockers) {
        this.lockers= new ArrayList<>();
        this.lockers.addAll(lockers);
    }

    abstract Ticket save(Bag bag);

    abstract Bag pickUp(Ticket ticket);

    boolean hasRoom() {
        for (Locker locker : lockers) {
            if(locker.hasRoom()) {
                return true;
            }
        }
        return false;
    }

    boolean isValid(Ticket ticket) {
        for (Locker locker : lockers) {
            if(locker.isValid(ticket)) {
                return true;
            }
        }
        return false;
    }

    public int getAvailableCapacity() {
        return lockers.stream()
                .mapToInt(Locker::getAvailableCapacity)
                .sum();
    }

    public int getTotalCapacity() {
        return lockers.stream()
                .mapToInt(Locker::getTotalCapacity)
                .sum();
    }

    @Override
    public String getReport() {
        return Stream.of(getSumReport(), getLockersReport())
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    private String getSumReport() {
        return "  R " + getAvailableCapacity() +" " + getTotalCapacity();
    }

    private String getLockersReport() {
        return lockers.stream()
                .map(locker -> "    " + locker.getReport())
                .collect(Collectors.joining("\n"));
    }
}

import java.util.ArrayList;
import java.util.List;

public abstract class Robot {
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
}

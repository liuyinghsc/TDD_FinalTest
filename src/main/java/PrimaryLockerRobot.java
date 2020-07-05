import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/6/20
 */

public class PrimaryLockerRobot{
    private  List<Locker> lockers;

    public PrimaryLockerRobot(Locker... lockers) {
        List<Locker> lockers1 = Arrays.asList(lockers);
        ArrayList<Locker> resLockers = new ArrayList<>();
        for (int i = 0; i < lockers1.size(); i++) {
            Locker locker = lockers1.get(i);
            if (locker.getType().equals("M")){
                resLockers.add(locker);
            }else {
                throw new LockerIsNotMatchException("The Locker is not match the robot");
            }
        }
        this.lockers= new ArrayList<>();
        this.lockers.addAll(resLockers);
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

import com.sun.tools.javac.util.List;

public class NormalManager {
    private List<Locker> lockers;
    private List<PrimaryLockerRobot> priRobots;
    private List<SuperLockerRobot> superRobots;

    public NormalManager(List<Locker> lockers, List<PrimaryLockerRobot> priRobot, List<SuperLockerRobot> superRobot) {
        this.lockers = lockers;
        this.priRobots = priRobot;
        this.superRobots = superRobot;
    }

    public Ticket save(Bag bag) {
        String type = bag.getType();
        if (type.equals("S")){
            for (Locker locker:lockers) {
                if (locker.hasRoom()){
                    return locker.save(bag);
                }
            }
            throw new LockerHasNoRoomException("the Locker has no room");
        }else if (type.equals("M")){
            for (PrimaryLockerRobot primaryLockerRobot:priRobots){
                return primaryLockerRobot.save(bag);
            }
        }else if (type.equals("L")){
            for (SuperLockerRobot superLockerRobot:superRobots){
                return superLockerRobot.save(bag);
            }
        }
        throw new BagTypeIsNotValidException("the bag size is not valid");
    }

    public Bag pickup(Ticket ticket) {
        for (Locker locker : this.lockers) {
            if (locker.isValid(ticket)) {
                return locker.pickUp(ticket);
            }
        }
        for (PrimaryLockerRobot primaryLockerRobot:priRobots){
            return primaryLockerRobot.pickUp(ticket);
        }
        for (SuperLockerRobot superLockerRobot:superRobots){
            return superLockerRobot.pickUp(ticket);
        }
        throw new InvalidTicketException("the ticket is not match!");
    }
}

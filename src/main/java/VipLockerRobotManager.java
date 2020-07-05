import com.sun.tools.javac.util.List;

public class VipLockerRobotManager {
    private List<Locker> vipLockers;
    private List<PrimaryLockerRobot> vipPriRobots;
    private List<SuperLockerRobot> vipSuperRobots;

    public VipLockerRobotManager(List<Locker> lockers, List<PrimaryLockerRobot> priRobot, List<SuperLockerRobot> superRobot) {
        this.vipLockers = lockers;
        this.vipPriRobots = priRobot;
        this.vipSuperRobots = superRobot;
    }

    public Ticket save(Bag bag) {
        String type = bag.getType();
        if (type.equals("S")){
            for (Locker locker: vipLockers) {
                if (locker.hasRoom()){
                    return locker.save(bag);
                }
            }
            throw new LockerHasNoRoomException("the Locker has no room");
        }else if (type.equals("M")){
            for (PrimaryLockerRobot primaryLockerRobot: vipPriRobots){
                return primaryLockerRobot.save(bag);
            }
        }else if (type.equals("L")){
            for (SuperLockerRobot superLockerRobot: vipSuperRobots){
                return superLockerRobot.save(bag);
            }
        }
        throw new BagTypeIsNotValidException("the bag size is not valid");
    }

    public Bag pickup(Ticket ticket) {
        for (Locker locker : this.vipLockers) {
            if (locker.isValid(ticket)) {
                return locker.pickUp(ticket);
            }
        }
        for (PrimaryLockerRobot primaryLockerRobot: vipPriRobots){
            return primaryLockerRobot.pickUp(ticket);
        }
        for (SuperLockerRobot superLockerRobot: vipSuperRobots){
            return superLockerRobot.pickUp(ticket);
        }
        throw new InvalidTicketException();
    }
}

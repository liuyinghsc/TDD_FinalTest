import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LockerRobotManagerTest {
    @Test
    public void should_save_bag_to_locker_1_when_save_bag_given_manage_two_lockers_and_no_robot() {
        final Locker firstLocker = new Locker(1);
        final LockerRobotManager lockerRobotManager = new LockerRobotManager(List.of(firstLocker, new Locker(2)), List.of());

        final Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        final Bag returnedBag = firstLocker.pickUp(ticket);
        assertEquals(returnedBag, bag);
    }

    @Test
    public void should_save_bag_to_locker_1_when_save_bag_given_manage_two_lockers_and_two_full_robots() {
        final Locker firstLocker = new Locker(1);
        final LockerRobotManager lockerRobotManager = new LockerRobotManager(List.of(firstLocker, new Locker(2)),
                List.of(
                        new PrimaryLockerRobot(new Locker(0), new Locker(0)),
                        new SmartLockerRobot(new Locker(0), new Locker(0))
                ));

        final Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        final Bag returnedBag = firstLocker.pickUp(ticket);
        assertEquals(returnedBag, bag);
    }

    @Test
    public void should_save_bag_to_robot_1_when_save_bag_given_manage_two_robots_and_no_locker() {
        final PrimaryLockerRobot firstRobot = new PrimaryLockerRobot(new Locker(1), new Locker(2));
        final SmartLockerRobot secondRobot = new SmartLockerRobot(new Locker(1), new Locker(2));
        final LockerRobotManager lockerRobotManager = new LockerRobotManager(List.of(), List.of(firstRobot, secondRobot));

        final Bag bag = new Bag();
        final Ticket ticket = lockerRobotManager.save(bag);

        final Bag returnedBag = firstRobot.pickUp(ticket);
        assertEquals(returnedBag, bag);
    }

    @Test
    public void should_save_bag_to_robot_1_when_save_bag_given_manage_two_lockers_and_two_robots() {
        final PrimaryLockerRobot firstRobot = new PrimaryLockerRobot(new Locker(1), new Locker(2));
        final LockerRobotManager lockerRobotManager = new LockerRobotManager(List.of(new Locker(1), new Locker(2)),
                List.of(
                        firstRobot,
                        new SmartLockerRobot(new Locker(2), new Locker(1))
                ));

        final Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        final Bag returnedBag = firstRobot.pickUp(ticket);
        assertEquals(returnedBag, bag);
    }

    @Test(expected = LockerHasNoRoomException.class)
    public void should_failed_when_save_bag_given_manage_two_full_lockers_and_two_full_robots() {
        final LockerRobotManager lockerRobotManager = new LockerRobotManager(List.of(new Locker(0), new Locker(0)),
                List.of(
                        new PrimaryLockerRobot(new Locker(0), new Locker(0)),
                        new SmartLockerRobot(new Locker(0), new Locker(0))
                ));

        lockerRobotManager.save(new Bag());
    }

    @Test
    public void should_pick_up_the_bag_when_pick_up_bag_given_manager_returned_ticket() {
        final LockerRobotManager lockerRobotManager = new LockerRobotManager(List.of(new Locker(2), new Locker(0)),
                List.of(
                        new PrimaryLockerRobot(new Locker(0), new Locker(0)),
                        new SmartLockerRobot(new Locker(1), new Locker(0))
                ));

        final Bag bag = new Bag();
        final Ticket ticket = lockerRobotManager.save(bag);

        Bag returnedBag = lockerRobotManager.pickUp(ticket);
        assertEquals(bag, returnedBag);
    }
}

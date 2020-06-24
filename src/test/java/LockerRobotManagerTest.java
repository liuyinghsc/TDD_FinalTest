import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LockerRobotManagerTest {
    @Test
    public void should_save_bag_to_locker_1_when_save_bag_given_manage_two_locker_and_no_robot() {
        final Locker firstLocker = new Locker(1);
        final LockerRobotManager lockerRobotManager = new LockerRobotManager(List.of(firstLocker, new Locker(2)), List.of());

        final Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        final Bag returnedBag = firstLocker.pickUp(ticket);
        assertEquals(returnedBag, bag);
    }
}

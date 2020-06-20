import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/6/20
 */

public class PrimaryLockerRobotTest {

    @Test
    public void should_save_to_first_locker_when_save_bag_given_robot_manage_two_lockers() {
        Locker firstLocker = new Locker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(firstLocker, new Locker(1));

        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.save(bag);

        Bag returnedBag = primaryLockerRobot.pickUp(ticket);
        assertEquals(bag, returnedBag);
    }

    @Test(expected = LockerHasNoRoomException.class)
    public void should_throw_exception_when_save_bag_given_two_lockers_has_no_room() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(new Locker(0), new Locker(0));

        primaryLockerRobot.save(new Bag());
    }

    @Test
    public void should_save_to_second_locker_when_save_bag_given_the_first_locker_is_full_and_the_second_has_room() {
        Locker secondLocker = new Locker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(new Locker(0), secondLocker);

        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.save(bag);

        Bag returnedBag = secondLocker.pickUp(ticket);
        assertEquals(bag, returnedBag);
    }
}

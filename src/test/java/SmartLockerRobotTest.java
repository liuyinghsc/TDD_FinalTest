import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/6/20
 */

public class SmartLockerRobotTest {
    @Test
    public void should_save_to_locker_3_when_save_bag_given_locker_3_has_the_largest_available_room() {
        Locker thirdLocker = new Locker(3);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new Locker(1), new Locker(2), thirdLocker);

        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.save(bag);

        Bag returnedBag = thirdLocker.pickUp(ticket);

        assertEquals(bag, returnedBag);
    }
    
    @Test
    public void should_save_to_locker_2_when_save_bag_given_locker_2_and_locker_3_have_the_largest_available_room() {
        Locker secondLocker = new Locker(3);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new Locker(1), secondLocker, new Locker(3));

        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.save(bag);

        Bag returnedBag = secondLocker.pickUp(ticket);

        assertEquals(bag, returnedBag);
    }
    
    @Test(expected = LockerHasNoRoomException.class)
    public void should_throw_exception_when_save_bag_given_all_lockers_are_full() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new Locker(0), new Locker(0), new Locker(0));

        smartLockerRobot.save(new Bag());
    }

    @Test
    public void should_get_the_bag_when_pick_up_bag_given_valid_ticket() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new Locker(0), new Locker(1), new Locker(0));

        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.save(bag);

        Bag returnedBag = smartLockerRobot.pickUp(ticket);
        assertEquals(bag, returnedBag);
    }

    @Test
    public void should_get_the_bag_when_pick_up_bag_from_smart_locker_robot_given_save_bag_to_primary_locker_robot() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(2);
        Locker thirdLocker = new Locker(3);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(firstLocker, secondLocker, thirdLocker);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(firstLocker, secondLocker, thirdLocker);

        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.save(bag);

        Bag returnedBag = smartLockerRobot.pickUp(ticket);
        assertEquals(bag, returnedBag);
    }

    @Test
    public void should_get_the_bag_when_pick_up_bag_from_primary_locker_robot_given_save_bag_to_smart_locker_robot() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(2);
        Locker thirdLocker = new Locker(3);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(firstLocker, secondLocker, thirdLocker);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(firstLocker, secondLocker, thirdLocker);

        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.save(bag);

        Bag returnedBag = primaryLockerRobot.pickUp(ticket);
        assertEquals(bag, returnedBag);
    }
}

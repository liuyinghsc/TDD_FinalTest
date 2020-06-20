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
}

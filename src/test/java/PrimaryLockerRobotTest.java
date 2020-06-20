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
}

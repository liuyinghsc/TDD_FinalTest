import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LockerRobotDirectorTest {
    @Test
    public void should_return_report_when_view_report_given_director_manage_1_manager_with_1_locker(){
        final Locker locker = new Locker(2);
        locker.save(new Bag());
        final LockerRobotManager lockerRobotManager = new LockerRobotManager(List.of(locker), List.of());

        final LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(List.of(lockerRobotManager));

        final String actual = lockerRobotDirector.viewReport();
        String expected = "M 1 2\n" +
                "  L 1 2";
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_report_when_view_report_given_director_manage_1_manager_with_2_lockers() {
        final Locker firstLocker = createLocker(5, 2);
        final Locker secondLocker = createLocker(5, 2);
        final LockerRobotManager lockerRobotManager = new LockerRobotManager(List.of(firstLocker, secondLocker), List.of());

        final LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(List.of(lockerRobotManager));

        final String actual = lockerRobotDirector.viewReport();
        String expected = "M 4 10\n" +
                "  L 2 5\n" +
                "  L 2 5";
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_report_when_view_report_given_director_manage_1_manager_with_2_lockers_and_1_robot_with_2_lockers() {
        final Locker firstLocker = createLocker(5, 2);
        final Locker secondLocker = createLocker(5, 2);
        final PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(
                createLocker(5, 3),
                createLocker(8, 5));

        final LockerRobotManager lockerRobotManager = new LockerRobotManager(
                List.of(firstLocker, secondLocker),
                List.of(primaryLockerRobot));

        final LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(List.of(lockerRobotManager));

        final String actual = lockerRobotDirector.viewReport();
        String expected = "M 12 23\n" +
                "  L 2 5\n" +
                "  L 2 5\n" +
                "  R 8 13\n" +
                "    L 3 5\n" +
                "    L 5 8";
        assertEquals(expected, actual);
    }

    private Locker createLocker(int totalCapacity, int availableCapacity) {
        final Locker locker = new Locker(totalCapacity);
        int bagsCount = totalCapacity - availableCapacity;
        while(bagsCount > 0) {
            locker.save(new Bag());
            bagsCount--;
        }
        return locker;
    }
}

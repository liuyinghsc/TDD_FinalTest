import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LockerRobotDirectorTest {
    @Test
    public void should_return_report_when_view_report_given_director_manage_1_manager_with_1_locker() {
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

    @Test
    public void should_return_report_when_view_report_given_director_manage_1_manager_with_2_lockers_and_2_robot_with_2_lockers() {
        final Locker firstLocker = createLocker(5, 2);
        final Locker secondLocker = createLocker(5, 2);
        final PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(
                createLocker(5, 3),
                createLocker(8, 5));
        final SmartLockerRobot smartLockerRobot = new SmartLockerRobot(
                createLocker(4, 2),
                createLocker(7, 6));

        final LockerRobotManager lockerRobotManager = new LockerRobotManager(
                List.of(firstLocker, secondLocker),
                List.of(primaryLockerRobot, smartLockerRobot));

        final LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(List.of(lockerRobotManager));

        final String actual = lockerRobotDirector.viewReport();
        String expected = "M 20 34\n" +
                "  L 2 5\n" +
                "  L 2 5\n" +
                "  R 8 13\n" +
                "    L 3 5\n" +
                "    L 5 8\n" +
                "  R 8 11\n" +
                "    L 2 4\n" +
                "    L 6 7";
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_report_when_view_report_given_director_manage_2_managers() {
        final LockerRobotManager firstManager = new LockerRobotManager(
                List.of(createLocker(5, 2), createLocker(5, 2)),
                List.of(new PrimaryLockerRobot(
                                createLocker(5, 3),
                                createLocker(8, 5)),
                        new SmartLockerRobot(
                                createLocker(4, 2),
                                createLocker(7, 6))));
        final LockerRobotManager secondManger = new LockerRobotManager(
                List.of(createLocker(7, 4), createLocker(7, 4)),
                List.of(new PrimaryLockerRobot(
                                createLocker(7, 2),
                                createLocker(9, 5)),
                        new SmartLockerRobot(
                                createLocker(11, 2),
                                createLocker(8, 6))));

        final LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(List.of(firstManager, secondManger));

        final String actual = lockerRobotDirector.viewReport();
        String expected = "M 20 34\n" +
                "  L 2 5\n" +
                "  L 2 5\n" +
                "  R 8 13\n" +
                "    L 3 5\n" +
                "    L 5 8\n" +
                "  R 8 11\n" +
                "    L 2 4\n" +
                "    L 6 7\n" +
                "M 23 49\n" +
                "  L 4 7\n" +
                "  L 4 7\n" +
                "  R 7 16\n" +
                "    L 2 7\n" +
                "    L 5 9\n" +
                "  R 8 19\n" +
                "    L 2 11\n" +
                "    L 6 8";
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_report_when_view_report_given_director_manage_1_manager_with_1_robot() {
        final PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(
                createLocker(5, 3),
                createLocker(8, 5));

        final LockerRobotManager lockerRobotManager = new LockerRobotManager(List.of(), List.of(primaryLockerRobot));

        final LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(List.of(lockerRobotManager));

        final String actual = lockerRobotDirector.viewReport();
        String expected = "M 8 13\n" +
                "  R 8 13\n" +
                "    L 3 5\n" +
                "    L 5 8";
        assertEquals(expected, actual);
    }


    private Locker createLocker(int totalCapacity, int availableCapacity) {
        final Locker locker = new Locker(totalCapacity);
        int bagsCount = totalCapacity - availableCapacity;
        while (bagsCount > 0) {
            locker.save(new Bag());
            bagsCount--;
        }
        return locker;
    }
}

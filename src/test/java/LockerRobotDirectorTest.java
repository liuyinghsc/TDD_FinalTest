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
}

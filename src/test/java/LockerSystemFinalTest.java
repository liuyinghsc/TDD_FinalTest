import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LockerSystemFinalTest {

    @Test(expected = LockerIsNotMatchException.class)
    public void should_match_falied_when_supermarket_manage_Locker_and_bobot_given_Locker_isNotMatch_Robot(){
        Locker sLocker = new Locker(5, "S");
        new PrimaryLockerRobot(sLocker);
    }

    @Test
    public void should_match_success_when_supermarket_manage_Locker_and_bobot_given_Locker_isMatch_Robot(){
        Locker mLocker = new Locker(5, "M");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(mLocker);
        assertNotNull(primaryLockerRobot);
    }
}

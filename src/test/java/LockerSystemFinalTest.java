import org.junit.Test;

public class LockerSystemFinalTest {

    @Test(expected = LockerIsNotMatchException.class)
    public void should_match_success_when_supermarket_manage_Locker_and_bobot_given_Locker_isNotMatch_Robot(){
        Locker sLocker = new Locker(5, "S");
        new PrimaryLockerRobot(sLocker);
    }
}

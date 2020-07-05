import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LockerSystemFinalTest {

    @Test(expected = LockerIsNotMatchException.class)
    public void should_match_falied_when_supermarket_manage_Locker_and_bobot_given_s_Locker_type_isNotMatch_Robot_m_manageType(){
        Locker sLocker = new Locker(5, "S");
        new PrimaryLockerRobot(sLocker);
    }

    @Test
    public void should_match_success_when_supermarket_manage_Locker_and_bobot_given_m_Locker_type_isMatch_Robot_m_manageType(){
        Locker mLocker = new Locker(5, "M");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(mLocker);
        assertNotNull(primaryLockerRobot);
    }

    @Test(expected = LockerIsNotMatchException.class)
    public void should_match_falied_when_supermarket_manage_Locker_and_bobot_given_m_Locker_type_isNotMatch_Robot_l_manageType(){
        Locker mLocker = new Locker(5, "M");
        new SmartLockerRobot(mLocker);
    }

    @Test
    public void should_match_falied_when_supermarket_manage_Locker_and_bobot_given_l_Locker_type_isNotMatch_Robot_l_manageType(){
        Locker mLocker = new Locker(5, "L");
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(mLocker);
        assertNotNull(smartLockerRobot);
    }

//    @Test
//    public void should_save_bag_to_locker1_when_normal_user_save_bag_given_s_bag(){
//
//    }


}

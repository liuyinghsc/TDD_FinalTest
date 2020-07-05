import com.sun.tools.javac.util.List;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
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
        new SuperLockerRobot(mLocker);
    }

    @Test
    public void should_match_falied_when_supermarket_manage_Locker_and_bobot_given_l_Locker_type_isNotMatch_Robot_l_manageType(){
        Locker mLocker = new Locker(5, "L");
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(mLocker);
        assertNotNull(superLockerRobot);
    }

    @Test
    public void should_save_bag_to_slocker_when_normal_user_save_s_bag_given_supermaket_manage_one_locker_one_priRobot_and_one_superBobot(){

        Locker sLocker = new Locker(5, "S");
        Locker mLocker = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(mLocker);
        Locker lLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(lLocker);
        NormalManager normalManager = new NormalManager(List.of(sLocker), List.of(priRobot), List.of(superRobot));

        Bag bag = new Bag("S");
        Ticket ticket = normalManager.save(bag);

        Bag pickupBag = sLocker.pickUp(ticket);
        assertEquals(pickupBag,bag);
    }

    @Test
    public void should_save_bag_to_mlocker_when_normal_user_save_m_bag_given_supermaket_manage_one_locker_one_priRobot_and_one_superBobot() {
        Locker sLocker = new Locker(5, "S");
        Locker mLocker = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(mLocker);
        Locker lLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(lLocker);
        NormalManager normalManager = new NormalManager(List.of(sLocker), List.of(priRobot), List.of(superRobot));

        Bag mbag = new Bag("M");
        Ticket ticket = normalManager.save(mbag);

        Bag pickupBag = mLocker.pickUp(ticket);
        assertEquals(pickupBag,mbag);
    }







    }

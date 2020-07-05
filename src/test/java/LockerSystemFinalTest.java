import com.sun.tools.javac.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LockerSystemFinalTest {

    @Test(expected = LockerIsNotMatchException.class)
    public void should_match_falied_when_supermarket_manage_Locker_and_bobot_given_s_Locker_type_isNotMatch_Robot_m_manageType() {
        Locker sLocker = new Locker(5, "S");
        new PrimaryLockerRobot(sLocker);
    }

    @Test
    public void should_match_success_when_supermarket_manage_Locker_and_bobot_given_m_Locker_type_isMatch_Robot_m_manageType() {
        Locker mLocker = new Locker(5, "M");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(mLocker);
        assertNotNull(primaryLockerRobot);
    }

    @Test(expected = LockerIsNotMatchException.class)
    public void should_match_falied_when_supermarket_manage_Locker_and_bobot_given_m_Locker_type_isNotMatch_Robot_l_manageType() {
        Locker mLocker = new Locker(5, "M");
        new SuperLockerRobot(mLocker);
    }

    @Test
    public void should_match_falied_when_supermarket_manage_Locker_and_bobot_given_l_Locker_type_isNotMatch_Robot_l_manageType() {
        Locker mLocker = new Locker(5, "L");
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(mLocker);
        assertNotNull(superLockerRobot);
    }

    @Test
    public void should_save_bag_to_slocker_when_normal_user_save_s_bag_given_supermaket_manage_one_locker_one_priRobot_and_one_superBobot() {

        Locker sLocker = new Locker(5, "S");
        Locker mLocker = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(mLocker);
        Locker lLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(lLocker);
        NormalManager normalManager = new NormalManager(List.of(sLocker), List.of(priRobot), List.of(superRobot));

        Bag bag = new Bag("S");
        Ticket ticket = normalManager.save(bag);

        Bag pickupBag = sLocker.pickUp(ticket);
        assertEquals(pickupBag, bag);
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
        assertEquals(pickupBag, mbag);
    }

    @Test
    public void should_save_bag_to_llocker_when_normal_user_save_l_bag_given_supermaket_manage_one_locker_one_priRobot_and_one_superBobot() {
        Locker sLocker = new Locker(5, "S");
        Locker mLocker = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(mLocker);
        Locker lLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(lLocker);
        NormalManager normalManager = new NormalManager(List.of(sLocker), List.of(priRobot), List.of(superRobot));

        Bag mbag = new Bag("L");
        Ticket ticket = normalManager.save(mbag);

        Bag pickupBag = lLocker.pickUp(ticket);
        assertEquals(pickupBag, mbag);
    }

    @Test
    public void should_save_bag_to_mlocker1_when_normal_user_save_m_bag_given_supermaket_manage_one_priRobot_with_two_locker() {
        Locker sLocker = new Locker(5, "S");
        Locker mLocker1 = new Locker(5, "M");
        mLocker1.save(new Bag("M"));
        Locker mLocker2 = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(mLocker1, mLocker2);
        Locker lLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(lLocker);
        NormalManager normalManager = new NormalManager(List.of(sLocker), List.of(priRobot), List.of(superRobot));

        Bag mbag = new Bag("M");
        Ticket ticket = normalManager.save(mbag);

        Bag pickupBag = mLocker1.pickUp(ticket);
        assertEquals(pickupBag, mbag);
    }

    @Test
    public void should_save_bag_to_llocker2_when_normal_user_save_l_bag_given_supermaket_manage_one_superRobot_with_two_locker() {
        Locker sLocker = new Locker(5, "S");
        Locker mLocker1 = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(mLocker1);
        Locker lLocker1 = new Locker(5, "L");
        lLocker1.save(new Bag("L"));
        Locker lLocker2 = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(lLocker1, lLocker2);
        NormalManager normalManager = new NormalManager(List.of(sLocker), List.of(priRobot), List.of(superRobot));

        Bag lbag = new Bag("L");
        Ticket ticket = normalManager.save(lbag);

        Bag pickupBag = lLocker2.pickUp(ticket);
        assertEquals(pickupBag, lbag);
    }

    @Test
    public void should_save_bag_to_vipslocker_when_vip_user_save_s_bag_given_lockerRobotManager_manage_one_locker_and_one_superRobot_and_one_priRobot() {
        Locker vipsLocker = new Locker(5, "S");
        Locker vipmLocker = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(vipmLocker);
        Locker viplLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(viplLocker);
        VipLockerRobotManager vipLockerRobotManager = new VipLockerRobotManager(List.of(vipsLocker), List.of(priRobot), List.of(superRobot));

        Bag sbag = new Bag("S");
        Ticket ticket = vipLockerRobotManager.save(sbag);

        Bag pickupBag = vipsLocker.pickUp(ticket);
        assertEquals(pickupBag, sbag);
    }

    @Test
    public void should_save_bag_to_vipmlocker_when_vip_user_save_m_bag_given_lockerRobotManager_manage_one_locker_and_one_superRobot_and_one_priRobot() {
        Locker vipsLocker = new Locker(5, "S");
        Locker vipmLocker = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(vipmLocker);
        Locker viplLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(viplLocker);
        VipLockerRobotManager vipLockerRobotManager = new VipLockerRobotManager(List.of(vipsLocker), List.of(priRobot), List.of(superRobot));

        Bag vipmbag = new Bag("M");
        Ticket ticket = vipLockerRobotManager.save(vipmbag);

        Bag pickupBag = vipmLocker.pickUp(ticket);
        assertEquals(pickupBag, vipmbag);
    }

    @Test
    public void should_save_bag_to_vipllocker_when_vip_user_save_l_bag_given_lockerRobotManager_manage_one_locker_and_one_superRobot_and_one_priRobot() {
        Locker vipsLocker = new Locker(5, "S");
        Locker vipmLocker = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(vipmLocker);
        Locker viplLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(viplLocker);
        VipLockerRobotManager vipLockerRobotManager = new VipLockerRobotManager(List.of(vipsLocker), List.of(priRobot), List.of(superRobot));

        Bag lbag = new Bag("L");
        Ticket ticket = vipLockerRobotManager.save(lbag);

        Bag pickupBag = viplLocker.pickUp(ticket);
        assertEquals(pickupBag, lbag);
    }

    @Test
    public void should_save_bag_to_vipmlocker1_when_vip_user_save_m_bag_given_lockerRobotManager_manage_one_priRobot_with_two_locker() {
        Locker vipsLocker = new Locker(5, "S");
        Locker vipmLocker1 = new Locker(5, "M");
        vipmLocker1.save(new Bag("M"));
        Locker vipmLocker2 = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(vipmLocker1, vipmLocker2);
        Locker lLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(lLocker);
        VipLockerRobotManager vipLockerRobotManager = new VipLockerRobotManager(List.of(vipsLocker), List.of(priRobot), List.of(superRobot));

        Bag mbag = new Bag("M");
        Ticket ticket = vipLockerRobotManager.save(mbag);

        Bag pickupBag = vipmLocker1.pickUp(ticket);
        assertEquals(pickupBag, mbag);
    }

    @Test
    public void should_save_bag_to_vipllocker1_when_vip_user_save_l_bag_given_lockerRobotManager_manage_one_superRobot_with_two_locker() {
        Locker vipsLocker = new Locker(5, "S");
        Locker vipmLocker1 = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(vipmLocker1);
        Locker viplLocker1 = new Locker(5, "L");
        viplLocker1.save(new Bag("L"));
        Locker viplLocker2 = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(viplLocker1, viplLocker2);
        VipLockerRobotManager vipLockerRobotManager = new VipLockerRobotManager(List.of(vipsLocker), List.of(priRobot), List.of(superRobot));

        Bag lbag = new Bag("L");
        Ticket ticket = vipLockerRobotManager.save(lbag);

        Bag pickupBag = viplLocker2.pickUp(ticket);
        assertEquals(pickupBag, lbag);
    }

    @Test(expected = LockerHasNoRoomException.class)
    public void should_save_failed_when_normal_user_save_s_bag_given_supermaket_manage_one_locker_has_no_room_and_one_priRobot_and_one_superBobot() {

        Locker sLocker = new Locker(5, "S");
        sLocker.save(new Bag("S"));
        sLocker.save(new Bag("S"));
        sLocker.save(new Bag("S"));
        sLocker.save(new Bag("S"));
        sLocker.save(new Bag("S"));
        Locker mLocker = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(mLocker);
        Locker lLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(lLocker);
        NormalManager normalManager = new NormalManager(List.of(sLocker), List.of(priRobot), List.of(superRobot));

        Bag bag = new Bag("S");
        normalManager.save(bag);
    }

    @Test(expected = LockerHasNoRoomException.class)
    public void should_save_failed_when_normal_user_save_m_bag_given_supermaket_manage_one_locker_and_one_priRobot_has_no_room_and_one_superBobot() {

        Locker sLocker = new Locker(5, "S");
        Locker mLocker = new Locker(5, "M");
        mLocker.save(new Bag("M"));
        mLocker.save(new Bag("M"));
        mLocker.save(new Bag("M"));
        mLocker.save(new Bag("M"));
        mLocker.save(new Bag("M"));
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(mLocker);
        Locker lLocker = new Locker(5, "L");
        SuperLockerRobot superRobot = new SuperLockerRobot(lLocker);
        NormalManager normalManager = new NormalManager(List.of(sLocker), List.of(priRobot), List.of(superRobot));

        Bag bag = new Bag("M");
        normalManager.save(bag);
    }

    @Test(expected = LockerHasNoRoomException.class)
    public void should_save_failed_when_normal_user_save_l_bag_given_supermaket_manage_one_locker_and_one_priRobot_and_one_superBobot_has_no_room() {

        Locker sLocker = new Locker(5, "S");
        Locker mLocker = new Locker(5, "M");
        PrimaryLockerRobot priRobot = new PrimaryLockerRobot(mLocker);
        Locker lLocker = new Locker(5, "L");
        lLocker.save(new Bag("L"));
        lLocker.save(new Bag("L"));
        lLocker.save(new Bag("L"));
        lLocker.save(new Bag("L"));
        lLocker.save(new Bag("L"));
        SuperLockerRobot superRobot = new SuperLockerRobot(lLocker);
        NormalManager normalManager = new NormalManager(List.of(sLocker), List.of(priRobot), List.of(superRobot));

        Bag bag = new Bag("L");
        normalManager.save(bag);
    }

    @Test(expected = LockerHasNoRoomException.class)
    public void should_save_failed_when_vip_user_save_s_bag_given_VipManager_has_no_room() {
        Locker vipsLocker = new Locker(5, "S");
        vipsLocker.save(new Bag("S"));
        vipsLocker.save(new Bag("S"));
        vipsLocker.save(new Bag("S"));
        vipsLocker.save(new Bag("S"));
        vipsLocker.save(new Bag("S"));
        Locker vipmLocker = new Locker(5, "M");
        PrimaryLockerRobot vipPriRobot = new PrimaryLockerRobot(vipmLocker);
        Locker viplLocker1 = new Locker(5, "L");
        SuperLockerRobot vipSuperRobot = new SuperLockerRobot(viplLocker1);
        VipLockerRobotManager vipLockerRobotManager = new VipLockerRobotManager(List.of(vipsLocker), List.of(vipPriRobot), List.of(vipSuperRobot));

        Bag sbag = new Bag("S");
        vipLockerRobotManager.save(sbag);
    }




}

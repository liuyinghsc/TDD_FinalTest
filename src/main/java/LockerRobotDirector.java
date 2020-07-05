import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LockerRobotDirector {
    private final List<LockerRobotManager> managers = new ArrayList<>();

    public LockerRobotDirector(List<LockerRobotManager> lockerRobotManager) {
        managers.addAll(lockerRobotManager);
    }

//    public String viewReport() {
//        return managers.stream()
//                .map(LockerRobotManager::getReport)
//                .collect(Collectors.joining("\n"));
//    }
}

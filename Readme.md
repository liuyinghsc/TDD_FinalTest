# Locker

## Section 1

### Requirement
- As a `Locker`
- I can save `Bag`
- I can pick up Bag using valid `Ticket`.

### Tasking List

Task1: 

- Given: Locker has room
- When: Save Bag
- Then: Succeeded, return ticket

Task2: 

- Given: Locker has no room
- When: Save Bag
- Then: Failed, show failed message

Task3: 

- Given: Using valid ticket
- When: Pick up bag
- Then: Succeeded, return bag

Task4: 

- Given: Using invalid ticket
- When: Pick up bag
- Then: Failed, show failed message

Task5: 

- Given: Using valid ticket
- When: Pick up bag twice
- Then: Succeeded in the first time and failed in the second time. Show failed message

## Section2 

### Requirement

- As a `PrimaryLockerRobot`
- I can save `Bag` to Lockers by order
- I can pick up Bag using valid `Ticket`

### Tasking List

Task1: 

- Given: PrimaryLockerRobot manages two Lockers has spare room
- When: Save a bag to PrimaryLockerRobot
- Then: Succeeded, bag saved to first Locker and return ticket

Task2:

- Given: PrimaryLockerRobot manages two Lockers has no spare room
- When: Save a bag to PrimaryLockerRobot
- Then: Failed, show failed message

Task3:

- Given: PrimaryLockerRobot manages two Lockers. The first Locker is full, and the second Locker has room
- When: Save a bag to PrimaryLockerRobot
- Then: Succeeded, bag saved to second Locker and return ticket 

Task4:

- Given: Using valid ticket
- When: Fetch Bag from PrimaryLockerRobot 
- Then: Succeeded, the Bag returned is the same one as we saved.

Task5: 

- Given: Using invalid ticket 
- When: Fetch Bag from PrimaryLockerRobot
- Then: Failed, show failed message 

## Section 3

- As a `SuperLockerRobot`
- I can save a Bag to the locker which has the largest remain room. If some lockers have the same room, save the bag to locker by order in these lockers.
- I can pick Bag using valid ticket.
- The SuperLockerRobot and the PrimaryLockerRobot can manage a same Locker.

### Tasking

SuperLockerRobot 和 PrimaryLockerRobot共同管理3个储物柜，按顺序为1,2,3

Task1:
- Given 3号柜空位最多
- When SuperLockerRobot 存包
- Then: 包被存到3号储物柜，并给出票据

Task2:
- Given: 2和3号柜空位最多
- When: SuperLockerRobot 存包
- Then: 包被存到2号储物柜的，并给出票据

Task3:
- Given: 所有储物柜全都已满
- When: SuperLockerRobot 存包
- Then: 提示所有储物柜都已满

Task4: 
- Given: SmartLockerRobot存包获得的票据
- When: SmartLockerRobot取包
- Then: 取包成功

Task5:
- Given: SmartLockerRobot存包成功获得了票据
- When: 使用该票据从PrimaryLockerRobot取包
- Then: 取包成功

Task6: 
- Given: PrimaryLockerRobot存包成功获得了票据
- When: 使用该票据从SmartLockerRobot取包
- Then: 取包成功
 
Task7:
- Given: 存包票据无效
- When: SmartLockerRobot取包
- Then: 提示票据无效

## Section 4

### Requirement

- As a `LockerRobotManager`
- `LockerRobotManager` can save a Bag to the `Locker`
- `LockerRobotManager` can delegate the save action to the `Robot`s managed by the `LockerRobotManager`.
- `LockerRobotManager` can retrieve the bag saved by the `LockerRobotManager` 

### Tasking

Task1:
- Given: LockerRobotManager 管理2个容量为1的 Locker，没有 Robot
- When: LockerRobotManager 存包
- Then: 包被存入到 Locker1 中，返回票据

Task2(deleted):
- Given: LockerRobotManager 管理2个容量为1的 Locker，Locker1 已满，没有 Robot
- When: LockerRobotManager 存包
- Then: 包被存入到 Locker2 中，返回票据

Task3:
- Given: LockerRobotManager 管理2个容量为1的 Locker，2个已满的 Robot
- When: LockerRobotManager 存包
- Then: 包被存入到 Locker1 中，返回票据

Task4(deleted):
- Given: LockerRobotManager 管理2个容量为1的 Locker，Locker1 已满，2个已满的 Robot
- When: LockerRobotManager 存包
- Then: 包被存入到 Locker2 中，返回票据

Task5:
- Given: LockerRobotManager 管理2个有容量的 Robot，没有 Locker
- When: LockerRobotManager 存包
- Then: 包被存入到 Robot1 中，返回票据

Task6(deleted):
- Given: LockerRobotManager 管理2个有容量的 Robot，Robot1 已满，没有 Locker
- When: LockerRobotManager 存包
- Then: 包被存入到 Robot2 中，返回票据

Task7:
- Given: LockerRobotManager 管理2个有容量的 Robot 和2个 Locker
- When: LockerRobotManager 存包
- Then: 包被存入到 Robot1 中，返回票据

Task8:
- Given: LockerRobotManager 管理2个已满的 Robot 和 2个已满的 Locker
- When: LockerRobotManager 存包
- Then: 提示存包失败

Task9:
- Given: LockerRobotManager 存包成功获得的票据
- When: 取包
- Then: 取包成功

Task10:
- Given: 使用非 LockerRobotManager 存包获得的票据
- When: 取包
- Then: 提示非法票据

## Section 5

### Requirement
- As a `LockerRobotDirector`
- I can see a report of the LockerRobotManager(s)

### Tasking

Task1:
- Given: LockerRobotDirector 管理一个 LockerRobotManager, LockerRobotManager 管理一个 Locker 总容量为2，可用容量为1, 不管理 Robot
- When: LockerRobotDirector 查看报表
- Then: 返回报表 
    M 1 2
        L 1 2

Task2:
- Given: LockerRobotDirector 管理一个 LockerRobotManager, LockerRobotManager 管理两个 Locker ，每个总容量为5，可用容量为2, 不管理 Robot
- When: LockerRobotDirector 查看报表
- Then: 返回报表  
    M 4 10
        L 2 5
        L 2 5

Task3:
- Given: LockerRobotDirector 管理一个 LockerRobotManager, LockerRobotManager 管理两个 Locker ，每个总容量为5，可用容量为2, 管理一个 Robot, 
    Robot 管理两个 Locker，一个总容量为5，可用容量为3，一个总容量为8，可用容量为5
- When: LockerRobotDirector 查看报表
- Then: 返回报表  
    M 12 23
        L 2 5
        L 2 5
        R 8 13
            L 3 5
            L 5 8

Task4:
- Given: LockerRobotDirector 管理一个 LockerRobotManager, LockerRobotManager 管理两个 Locker ，每个总容量为5，可用容量为2, 管理两个 Robot, 
    第一个 Robot 管理两个 Locker，一个总容量为5，可用容量为3，一个总容量为8，可用容量为5；
    第二个 Robot 管理两个 Locker，一个总容量为4，可用容量为2，一个总容量为7，可用容量为6。
- When: LockerRobotDirector 查看报表
- Then: 返回报表  
    M 20 34
        L 2 5
        L 2 5
        R 8 13
            L 3 5
            L 5 8
        R 8 11
            L 2 4
            L 6 7
Task5:
- Given: LockerRobotDirector 管理一个 LockerRobotManager, 
    第一个 LockerRobotManager 管理两个 Locker ，每个总容量为5，可用容量为2, 管理两个 Robot, 
        第一个 Robot 管理两个 Locker，一个总容量为5，可用容量为3，一个总容量为8，可用容量为5；
        第二个 Robot 管理两个 Locker，一个总容量为4，可用容量为2，一个总容量为7，可用容量为6。
    第二个 LockerRobotManager 管理两个 Locker ，每个总容量为7，可用容量为4, 管理两个 Robot, 
        第一个 Robot 管理两个 Locker，一个总容量为7，可用容量为2，一个总容量为9，可用容量为5；
        第二个 Robot 管理两个 Locker，一个总容量为11，可用容量为2，一个总容量为8，可用容量为6。
- When: LockerRobotDirector 查看报表
- Then: 返回报表  
    M 20 34
        L 2 5
        L 2 5
        R 8 13
            L 3 5
            L 5 8
        R 8 11
            L 2 4
            L 6 7
    M 23 49
        L 4 7
        L 4 7
        R 7 16
            L 2 7
            L 5 9
        R 8 19
            L 2 11
            L 6 8
            
Task6:
- Given: LockerRobotDirector 管理一个 LockerRobotManager, LockerRobotManager 管理一个 Robot, 
    Robot 管理两个 Locker，一个总容量为5，可用容量为3，一个总容量为8，可用容量为5
- When: LockerRobotDirector 查看报表
- Then: 返回报表  
    M 12 23
        R 8 13
            L 3 5
            L 5 8
            

## Section FinalTest

### Requirement
Normal:
supermarket management XiaoYing manage S Locker and PrimaryRobot and SuperRobot;
-PrimaryRobot manage M Locker;
-SuperRobot manage L Locker;
VIP:
- As a `LockerRobotManager` 
-manage S Locker and PrimaryRobot and SuperRobot;
-PrimaryRobot manage M Locker;
-SuperRobot manage L Locker;

### Tasking

Task1:
- Given: 超市管理员配置Robot和Manager
- When: Locker型号不匹配
- Then: Robot和Manager将无法正常使用


Task2:
- Given: 超市管理员配置Robot和Manager
- When: Locker型号匹配
- Then: Robot和Manager正常使用


Task3:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，有空位，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3，有空位
VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33，
- When: 普通用户存S包
- Then: 包被存入到 Locker1 中，返回票据


Task4:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2有空位，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3，有空位
VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33，
- When: 普通用户存M包
- Then: 包被存入到 PrimaryLockerRobot的Locker2 中，返回票据

Task5:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2有空位，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3，有空位
VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33，
- When: 普通用户存L包
- Then: 包被存入到 SuperLockerRobot的Locker3 中，返回票据


Task6:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理两个Locker2和Locker3，Locker2总量5，余量1，Locker3总量5，余量4，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker4有空位，
VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33，
- When: 普通用户存M包
- Then: 包被存入到PrimaryLockerRobot的 Locker2 中，返回票据


Task7:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2有空位，一个SuperLockerRobot(L),SuperLockerRobot管理两个Locker3和Locker4，Locker3总量5，余量2，Locker4总量5，余量4
VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33，
- When: 普通用户存L包
- Then: 包被存入到SuperLockerRobot的 Locker4 中，返回票据


Task8:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，有空位，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3，有空位
VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33，
- When: VIP用户存S包
- Then: LockerRobotManager存包，包被存入到 Locker11 中，返回票据



Task9:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，有空位，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3，有空位
VIP区：LockerRobotManager 管理一个Locker11（S)有空位,一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22有空位，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33有空位，
- When: VIP用户存L包
- Then: LockerRobotManager存包，包被存入到 Locker33 中，返回票据


Task10:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，有空位，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3，有空位
VIP区：LockerRobotManager 管理一个Locker11（S)有空位,一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22有空位，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33有空位，
- When: VIP用户存M包
- Then: LockerRobotManager存包，包被存入到 Locker22 中，返回票据


Task11:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，有空位，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3，有空位
VIP区：LockerRobotManager 管理一个Locker11（S)有空位,一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22和Locker33，Locker22总量5，余量1，Locker33总量5，余量4，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker44有空位，
- When: VIP用户存M包
- Then: LockerRobotManager存包，包被存入到 Locker22 中，返回票据

Task12:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，有空位，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3，有空位
VIP区：LockerRobotManager 管理一个Locker11（S)有空位,一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22有空位，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33和Locker44，Locker33总量5，余量1，Locker44总量5，余量4，
- When: VIP用户存L包
- Then: LockerRobotManager存包，包被存入到 Locker44 中，返回票据


Task13:
- Given: 
普通区：一个Locker1(S)满，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，有空位，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3，有空位
- When: 普通用户存S包
- Then: 存失败

Task14:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2满，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3，有空位
- When: 普通用户存M包
- Then: 存失败

Task15:
- Given: 
普通区：一个Locker1(S)有空位，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2有空位，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3满
- When: 普通用户存L包
- Then: 存失败


Task16:
- Given: 
 VIP区：LockerRobotManager 管理一个Locker11（S)满,一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22有空位，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33有空位
- When: VIP用户存S包
- Then: 存失败，返回满信息

Task17:
- Given: 
 VIP区：LockerRobotManager 管理一个Locker11（S)满,一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22满，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33满
- When: VIP用户存M包
- Then: 存失败，返回满信息

Task18:
- Given: 
 VIP区：LockerRobotManager 管理一个Locker11（S)满,一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22满，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33满
- When: VIP用户存L包
- Then: 存失败，返回满信息

Task19:
- Given: 
普通区：一个Locker1(S)，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3；
 VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33
- When: VIP用户取包，有效票
- Then: LockerRobotManager取包成功，回收票

Task20:
- Given: 
普通区：一个Locker1(S)，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3；
 VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33
- When: VIP用户取包，非法票
- Then: 取包失败，返回票的型号对不上

Task21:
- Given: 
普通区：一个Locker1(S)，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3；
 VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33
- When: 普通用户取包，普通区有效票
- Then: 取包成功，回收票


Task22:
- Given: 
普通区：一个Locker1(S)，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3；
 VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33
- When: 普通用户取包，无效票(vip区域的票)
- Then: 取包失败，返回票的型号对不上

Task23:
- Given: 
普通区：一个Locker1(S)，一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker2，一个SuperLockerRobot(L),SuperLockerRobot管理一个Locker3；
 VIP区：LockerRobotManager 管理一个Locker11（S),一个PrimaryLockerRobot(M),PrimaryLockerRobot管理一个Locker22，一个SuperLockerRobot(L)，SuperLockerRobot管理一个Locker33
- When: 普通用户取包，无效票（普通区域的尺寸type不对应）
- Then: 取包失败，返回票的型号对不上
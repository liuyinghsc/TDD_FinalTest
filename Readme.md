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

- As a `SmartLockerRobot`
- I can save a Bag to the locker which has the largest remain room. If some lockers have the same room, save the bag to locker by order in these lockers.
- I can pick Bag using valid ticket.
- The SmartLockerRobot and the PrimaryLockerRobot can manage a same Locker.

### Tasking

SmartLockerRobot 和 PrimaryLockerRobot共同管理3个储物柜，按顺序为1,2,3

Task1:
- Given 3号柜空位最多
- When SmartLockerRobot 存包
- Then: 包被存到3号储物柜，并给出票据

Task2:
- Given: 2和3号柜空位最多
- When: SmartLockerRobot 存包
- Then: 包被存到2号储物柜的，并给出票据

Task3:
- Given: 所有储物柜全都已满
- When: SmartLockerRobot 存包
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

Task2:
- Given: LockerRobotManager 管理2个容量为1的 Locker，Locker1 已满，没有 Robot
- When: LockerRobotManager 存包
- Then: 包被存入到 Locker2 中，返回票据

Task3:
- Given: LockerRobotManager 管理2个容量为1的 Locker，2个已满的 Robot
- When: LockerRobotManager 存包
- Then: 包被存入到 Locker1 中，返回票据

Task4:
- Given: LockerRobotManager 管理2个容量为1的 Locker，Locker1 已满，2个已满的 Robot
- When: LockerRobotManager 存包
- Then: 包被存入到 Locker2 中，返回票据

Task5:
- Given: LockerRobotManager 管理2个有容量的 Robot，没有 Locker
- When: LockerRobotManager 存包
- Then: 包被存入到 Robot1 中，返回票据

Task6:
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
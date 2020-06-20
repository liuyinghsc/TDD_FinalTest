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
- When: Save bag to PrimaryLockerRobot
- Then: Succeeded, bag saved to first Locker and return ticket

Task2:

- Given: PrimaryLockerRobot manages two Lockers has no spare room
- When: Save bag to PrimaryLockerRobot
- Then: Failed, show failed message

Task3:

- Given: PrimaryLockerRobot manages two Lockers. The first Locker is full, and the second Locker has room
- When: Save bag to PrimaryLockerRobot
- Then: Succeeded, bag saved to second Locker and return ticket 

Task4:

- Given: Using valid ticket
- When: Fetch Bag from PrimaryLockerRobot 
- Then: Succeeded, the Bag returned is the same one as we saved.

Task5: 

- Given: Using invalid ticket 
- When: Fetch Bag from PrimaryLockerRobot
- Then: Failed, show failed message 

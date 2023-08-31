Queues implementation: 

-->using Arrays (hard)
-maximum size of the array must be defined in advance and cannot be changed during the implementation
-TC of poll operation is O(n) (can be improved to O(1) using front and rear pointer)
-implemented using a circular array to utilise memory 
-overflow and underflow

-->using ArrayList (easy)
-does not solve issues for memory wastage
-enqueue at end dequeue at front

-->using LinkedList 
-insert at tail/rear, delete from front

-->using 2 Stacks
-overhead for poll and peek operations

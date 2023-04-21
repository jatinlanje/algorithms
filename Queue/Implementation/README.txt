Queues implementation: 

-->using Arrays 
-maximum size of the array must be defined in advance and cannot be changed during the implementation
-TC of poll operation is O(n) (can be improved to O(1) using front and rear pointer)
-implemented using a circular array to utilise memory 
-overflow and underflow

-->using ArrayList
-does not solve issues for memory wastage

-->using LinkedList
-insert at tail, delete from front

-->using 2 Stacks
-overhead for poll and peek operations

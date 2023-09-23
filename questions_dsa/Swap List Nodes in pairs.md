# Q. Swap List Nodes in pairs
Refer To the problem and solution [here](https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/).
**Note** Login with your id to see solution 

For Explanation: 
1.  Constant Space: The constant space usage in this code is achieved by not using any additional data structures that grow with the size of the linked list. Instead, the swaps are done by rearranging the links between the existing nodes, and no new nodes or additional arrays are created. The only additional nodes created are the `dummy` node and a few pointers (`prev`, `first`, and `second`), which do not depend on the size of the linked list and are used to perform the swapping.
    
2.  The `dummy` Node: Before performing the swaps, the code creates a `dummy` node with the value of `-1`. The purpose of this `dummy` node is to simplify the handling of the head node. By having a dummy node, we can handle the first pair of nodes in the same way as other pairs, and we do not need to check if the head node has been swapped separately.
    
3.  Swapping Pairs: The `while` loop iterates through the linked list and swaps adjacent nodes. It does so by keeping track of three nodes at a time: `prev`, `first`, and `second`. At each iteration, it swaps the `first` and `second` and then updates the `prev` pointer to connect the swapped nodes correctly.
    
4.  The `prev` Pointer: The `prev` pointer is initially set to the `dummy` node. After swapping `first` and `second`, we set `prev.next` to point to `second` and `first.next` to point to `second.next`. This way, the pair of nodes is swapped, and `prev` is updated to its correct position for the next iteration.
    
5.  The `head` Pointer: The `head` pointer is used to traverse through the linked list and process pairs of adjacent nodes. After each iteration, it moves forward by two nodes to reach the next pair of nodes.
    
6.  End Condition: The loop continues as long as there are at least two nodes remaining to swap (i.e., `head` and `head.next` are not null). If there's an odd number of nodes, the last node remains as it is.
    
7.  Return Result: Finally, the method returns `dummy.next`, which is the head of the modified linked list where all pairs of adjacent nodes are swapped.

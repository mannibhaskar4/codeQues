# Jump Game

See problem [here](https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150)


To solve this problem, we need to determine if we can reach the last index of the array by jumping based on the maximum allowed steps at each position. This is a greedy problem where the goal is to see if we can continuously extend our reach from the current position.

### Greedy Approach:

-   We maintain a variable `maxReach` that represents the farthest index we can currently jump to.
-   As we iterate through the array, we update `maxReach` at each index based on how far we can jump from that index.
-   If at any point our current index exceeds `maxReach`, it means we cannot jump any further, so we return `false`.
-   If we can reach or exceed the last index, we return `true`.

### Steps:

1.  Initialize `maxReach` to 0, which represents the farthest index we can jump to initially.
2.  Traverse the array:
    -   For each index `i`, if `i` exceeds `maxReach`, return `false` (we're stuck).
    -   Otherwise, update `maxReach` to be the maximum of `maxReach` and `i + nums[i]`.
3.  If we can reach or exceed the last index (`n-1`), return `true`.



### Explanation:

1.  **maxReach**: At every step, we track how far we can jump from the current index. Initially, we start at index 0 and `maxReach = 0`.
2.  **Loop**:
    -   We iterate through the array. For each index `i`, if `i` is greater than `maxReach`, it means we cannot reach that index, so we return `false`.
    -   We then update `maxReach` to be the maximum between `maxReach` and `i + nums[i]`, which is the farthest point we can jump from index `i`.
3.  **Early Termination**: If at any point `maxReach` reaches or exceeds the last index, we return `true`.

```
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the farthest index we can reach, return false
            if (i > maxReach) {
                return false;
            }
            
            // Update the farthest reach from the current index
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If we've reached or exceeded the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        // Return true if we successfully reach the last index
        return true;
    }
}
```
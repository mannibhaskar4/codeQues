# Remove Duplicates from Sorted Array II

See Problem here(https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150)

### Approach:

1.  **Two-Pointer Technique**: We maintain one pointer (`i`) that will track the position of where the next allowed element will be placed. The other pointer (`j`) will iterate through the array.
2.  **Condition**: Each element in the array can appear at most twice. If an element appears more than twice, we skip over the extra occurrences.
3.  **Logic**:
    -   We allow the first two occurrences of each unique element to remain.
    -   For each new element, if the count of occurrences so far is less than 2, we copy that element to the next available position.



### Explanation:

1.  **Initial Condition**: If the length of `nums` is 2 or less, we can return the array length because all elements are allowed.
2.  **Pointers**:
    -   The pointer `i` starts at index 2 because the first two elements are allowed no matter what.
    -   The pointer `j` starts at index 2 and checks the array.
3.  **Duplicate Handling**:
    -   For each element `nums[j]`, we compare it with `nums[i - 2]`. If it is different, that means it is either a new element or the second occurrence of the current element.
    -   If it passes the check, we place `nums[j]` at `nums[i]` and increment `i`.
4.  **Result**: At the end of the loop, `i` will contain the length of the new array where each element appears at most twice.

### Example Walkthrough:

#### Example 1:

-   **Input**: `nums = [1,1,1,2,2,3]`
-   **Initial Setup**: `i = 2`, `nums = [1,1,1,2,2,3]`
-   **Step-by-step**:
    -   `j = 2`: `nums[2] = 1`, but `nums[i - 2] = nums[0] = 1`. Skip this element since `1` appears more than twice.
    -   `j = 3`: `nums[3] = 2`, which is different from `nums[i - 2] = nums[0] = 1`. So, set `nums[i] = nums[3]`, now `i = 3` and `nums = [1,1,2,2,2,3]`.
    -   `j = 4`: `nums[4] = 2`, which is different from `nums[i - 2] = nums[1] = 1`. Set `nums[i] = nums[4]`, now `i = 4` and `nums = [1,1,2,2,2,3]`.
    -   `j = 5`: `nums[5] = 3`, which is different from `nums[i - 2] = nums[2] = 2`. Set `nums[i] = nums[5]`, now `i = 5` and `nums = [1,1,2,2,3,3]`.
-   **Final Result**: Return `k = 5`, and `nums = [1,1,2,2,3,_]`.

#### Example 2:

-   **Input**: `nums = [0,0,1,1,1,1,2,3,3]`
-   **Initial Setup**: `i = 2`, `nums = [0,0,1,1,1,1,2,3,3]`
-   **Step-by-step**:
    -   `j = 2`: `nums[2] = 1`, which is different from `nums[i - 2] = nums[0] = 0`. Set `nums[i] = nums[2]`, now `i = 3` and `nums = [0,0,1,1,1,1,2,3,3]`.
    -   `j = 3`: `nums[3] = 1`, which is different from `nums[i - 2] = nums[1] = 0`. Set `nums[i] = nums[3]`, now `i = 4` and `nums = [0,0,1,1,1,1,2,3,3]`.
    -   `j = 4`: Skip `nums[4]` since it's the third occurrence of `1`.
    -   `j = 6`: Set `nums[i] = nums[6] = 2`, now `i = 5` and `nums = [0,0,1,1,2,1,2,3,3]`.
    -   Continue the same logic for the rest.
-   **Final Result**: Return `k = 7`, and `nums = [0,0,1,1,2,3,3,_]`.

### Time Complexity:

-   **Time Complexity**: O(n), where `n` is the length of the array. We are traversing the array once.
-   **Space Complexity**: O(1), as we are modifying the array in place without using extra space.



```
class Solution {
    public int removeDuplicates(int[] n) {
        if(n.length<2){
            return n.length;
        }

        int i=2;
        for(int j=2;j<n.length;j++){
            if(n[i-2]!=n[j]){
                n[i]=n[j];
                i++;
            }
        }
        return i;
    }
}
```
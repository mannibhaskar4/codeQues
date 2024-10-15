# Remove Element

See Problem here(https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150)


Here's how you can solve the problem of removing all occurrences of `val` from an integer array `nums` in-place and returning the number of elements not equal to `val`. This approach ensures that you modify `nums` as required and return `k`, where `k` is the count of elements not equal to `val`.

### Approach:

-   Use a pointer to track the position where the next valid element (i.e., an element not equal to `val`) should be placed.
-   Iterate through the array, and each time you find an element not equal to `val`, move it to the front of the array at the current position of the pointer.
-   After processing the entire array, the pointer will indicate the number of valid elements (which is `k`).


### Explanation:

1.  **Pointer `k`**:

    -   `k` is used to store the index of the next position where we should place a valid element (an element that is not equal to `val`).
2.  **Iterating through the array**:

    -   For each element in `nums`, if it's not equal to `val`, we move it to the front of the array at index `k`.
    -   Increment `k` to keep track of how many valid elements have been processed.
3.  **Final value of `k`**:

    -   After the loop, `k` will represent the number of elements that are not equal to `val`.
    -   The elements in the first `k` positions of `nums` will be the elements that are not equal to `val`.

### Test Output:

For the test cases provided:

-   **Test case 1**:
    -   Input: `nums = [3, 2, 2, 3]`, `val = 3`
    -   Output: `k = 2`, with `nums = [2, 2, _, _]`
-   **Test case 2**:
    -   Input: `nums = [0, 1, 2, 2, 3, 0, 4, 2]`, `val = 2`
    -   Output: `k = 5`, with `nums = [0, 1, 0, 3, 4, _, _, _]`

### Time Complexity:

-   The solution runs in **O(n)** time, where `n` is the length of the array `nums`, because we iterate over the array once.

### Space Complexity:

-   The space complexity is **O(1)**, as we are modifying the input array in-place without using any extra space (aside from a few variables).


```
class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k]= nums[i];
                k++;
            }
            
        }
        return k;
    }
}
```
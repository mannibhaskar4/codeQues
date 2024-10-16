# Remove Duplicates from Sorted Array

See Problem here(https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150)

To solve the problem of removing duplicates from a sorted array `nums` in place, the approach is straightforward. We will use the two-pointer technique. Here's a step-by-step breakdown of the approach:

### Approach:

-   Since the array is already sorted, the duplicates will appear next to each other.
-   We use one pointer (`i`) to track the position of the unique elements, and another pointer (`j`) to iterate through the array.
-   When a new unique element is encountered, it is placed at position `i` and `i` is incremented.

### Steps:

1.  **Pointer Initialization**: Start with the first pointer `i = 0`, which will point to the position where the next unique element should be placed.
2.  **Iterating Through the Array**: Use the second pointer `j` to iterate over the array.
    -   If `nums[j] != nums[i]`, it means we've encountered a new unique element. We increment `i` and copy `nums[j]` to `nums[i]`.
3.  **Return the Count**: After the loop ends, the number of unique elements is `i + 1`.

### Explanation:

1.  **Edge Case**: If the array is empty (`nums.length == 0`), the function immediately returns `0` because there are no elements.
2.  **Main Logic**:
    -   `i` is initialized to `0`, meaning that the first element is already considered unique.
    -   For each subsequent element at index `j`, the algorithm checks if it is different from the last unique element (at index `i`).
    -   If it is different, `i` is incremented, and the value at `j` is copied to `i`.
    -   This ensures that all unique elements are moved to the beginning of the array, in their original order.
3.  **Return Value**: After the loop, `i + 1` gives the number of unique elements in the array, because `i` is the index of the last unique element.

### Example Walkthrough:

#### Input: `nums = [1, 1, 2]`

-   Initially, `i = 0` and `nums[i] = 1`.
-   `j = 1`: `nums[j] = 1` is the same as `nums[i]`, so we skip it.
-   `j = 2`: `nums[j] = 2` is different from `nums[i] = 1`, so we increment `i` and set `nums[i] = 2`.
-   Final result: `nums = [1, 2, _]` and the function returns `2` because there are two unique elements.

#### Input: `nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]`

-   Initially, `i = 0` and `nums[i] = 0`.
-   `j = 1`: `nums[j] = 0` is the same as `nums[i]`, so we skip it.
-   `j = 2`: `nums[j] = 1` is different from `nums[i] = 0`, so we increment `i` and set `nums[i] = 1`.
-   `j = 5`: `nums[j] = 2` is different from `nums[i] = 1`, so we increment `i` and set `nums[i] = 2`.
-   Continue this until the end of the array.
-   Final result: `nums = [0, 1, 2, 3, 4, _, _, _, _, _]` and the function returns `5` because there are five unique elements.

### Time Complexity:

-   **Time Complexity**: O(n), where `n` is the length of the array. We only iterate through the array once.
-   **Space Complexity**: O(1), since the modifications are done in place and no additional space is used.

```
class Solution {
    public int removeDuplicates(int[] n) {
        if(n.length==0)
        return 0;
        int i=0;

        for(int j=1;j< n.length;j++){
            if(n[i]!=n[j]){
                i++;
                n[i]=n[j];
            }
        }
        return i+1;

    }
}
```
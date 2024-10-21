# Rotate Array

See Problem [here](https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150)

To rotate an array to the right by `k` steps, we can approach the problem in multiple ways, but an **in-place** solution with **O(1)** extra space and **O(n)** time complexity can be achieved through a clever use of array reversal.

### In-place Solution Using Array Reversal

The key idea is to reverse parts of the array:

1.  Reverse the entire array.
2.  Reverse the first `k` elements.
3.  Reverse the remaining `n - k` elements.

By doing these reversals, the array elements end up in the correct rotated positions.

### Algorithm Steps:

1.  Reverse the entire array.
2.  Reverse the first `k` elements (from index 0 to `k - 1`).
3.  Reverse the rest of the array (from index `k` to `n - 1`).

#### Example:

Given `nums = [1,2,3,4,5,6,7]` and `k = 3`:

1.  Reverse the whole array: `[7,6,5,4,3,2,1]`
2.  Reverse the first `k = 3` elements: `[5,6,7,4,3,2,1]`
3.  Reverse the rest of the elements: `[5,6,7,1,2,3,4]`

### Explanation of the Code:

-   **`k = k % n`**: This ensures that if `k` is larger than the length of the array, we don't do unnecessary rotations. For example, rotating an array of size 7 by 10 steps is the same as rotating it by 3 steps (`10 % 7 = 3`).
-   **`reverse(nums, start, end)`**: This helper method reverses the elements of the array from index `start` to `end`.

### Complexity:

-   **Time Complexity**: `O(n)` where `n` is the length of the array. We perform a constant number of reversals, and each reversal takes `O(n)` time.
-   **Space Complexity**: `O(1)` since we only use a few extra variables for swapping.

### Alternative Approaches:

1.  **Brute Force Approach**:
    -   Repeatedly move the elements one by one `k` times. This takes `O(n * k)` time.
2.  **Using Extra Array**:
    -   Create a new array, copy elements to their rotated positions, and then copy the new array back to the original one. This approach takes `O(n)` time but requires `O(n)` extra space.



```
class Solution {
    public void rotate(int[] n, int k) {
        int s=n.length;
        k=k%s; // In case k is larger than the array length

        // Step 1: Reverse the entire array
        reverse(n,0,s-1);

        // Step 2: Reverse the first k elements
        reverse(n,0,k-1);

        // Step 3: Reverse the remaining n - k elements
        reverse(n,k,s-1);
    }


    // Helper function to reverse a portion of the array
    public void reverse(int[] n, int f,int l){
        while(f<l){
            int temp= n[f];
            n[f]=n[l];
            n[l]=temp;
            f++;
            l--;
        }
    }
}
```
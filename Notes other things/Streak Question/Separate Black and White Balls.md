# Separate Black and White Balls

See Problem here(https://leetcode.com/problems/separate-black-and-white-balls/description/?envType=daily-question&envId=2024-10-15)

### Explanation:

1.  We initialize `i`, `j`, and `k` as pointers for the current elements in `nums1`, `nums2`, and the result in `nums1` respectively.
2.  The first `while` loop handles the case where both `nums1` and `nums2` have elements to compare.
3.  The second `while` loop handles the case where there are remaining elements in `nums2`. If `i` becomes negative before `j`, this loop ensures that all elements from `nums2` are copied to `nums1`.
4.  Since `nums1` is already in place, no need to handle remaining elements in `nums1`.

### Time Complexity:

-   The time complexity is `O(m + n)` because we go through each element of both `nums1` and `nums2` exactly once.

### Space Complexity:

-   The space complexity is `O(1)` because the merging happens in-place without using extra space.



```
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the last position in nums1

        // Merge from the end of both arrays
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them over
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
```
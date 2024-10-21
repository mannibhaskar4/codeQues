# H-Index

See problem [here](https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150)

### Explanation:

1.  **maxReach**: At every step, we track how far we can jump from the current index. Initially, we start at index 0 and `maxReach = 0`.
2.  **Loop**:
    -   We iterate through the array. For each index `i`, if `i` is greater than `maxReach`, it means we cannot reach that index, so we return `false`.
    -   We then update `maxReach` to be the maximum between `maxReach` and `i + nums[i]`, which is the farthest point we can jump from index `i`.
3.  **Early Termination**: If at any point `maxReach` reaches or exceeds the last index, we return `true`.The **h-index** is the maximum value `h` such that the researcher has published at least `h` papers, each cited at least `h` times. In simpler terms:

-   You want to find the largest number `h` such that there are **at least `h` papers** with **`h` or more citations**.

### Simplified Approach:

1.  **Sort the citations array**: Sorting helps us easily count how many papers have at least a certain number of citations.
2.  **Scan the sorted array**: Start from the least-cited paper and check if there are enough papers that have at least `h` citations.

### Step-by-Step Explanation:

1.  **Sort the citations array** in ascending order so that it's easier to count how many papers have a certain number of citations.
2.  **Start from the least cited paper**. For each paper, we calculate how many papers have citations equal to or greater than the current one. This is done by looking at how many papers are left in the array as we progress through it.
3.  **Find the h-index**: The h-index is the largest `h` where there are at least `h` papers with `h` or more citations.


### Dry Run of Example 1:

#### Example 1:

plaintext

Copy code

`Input: citations = [3,0,6,1,5]`

#### Step 1: Sort the array

plaintext

Copy code

`Sorted citations: [0, 1, 3, 5, 6]`

#### Step 2: Traverse the sorted array

We will go through each element and calculate how many papers have citations greater than or equal to the current value:

1.  **At index 0**: Citation = 0, Remaining papers = 5

    -   5 papers have citations ≥ 0, but `0` is not a valid h-index (we need at least 1 paper with ≥ 1 citation).
2.  **At index 1**: Citation = 1, Remaining papers = 4

    -   4 papers have citations ≥ 1. `1` is a valid h-index since we have at least 1 paper with ≥ 1 citation.
3.  **At index 2**: Citation = 3, Remaining papers = 3

    -   3 papers have citations ≥ 3. `3` is a valid h-index since we have at least 3 papers with ≥ 3 citations.
4.  **At index 3**: Citation = 5, Remaining papers = 2

    -   Only 2 papers have citations ≥ 5, so `5` is not a valid h-index (we need at least 5 papers with ≥ 5 citations).
5.  **At index 4**: Citation = 6, Remaining papers = 1

    -   Only 1 paper has citations ≥ 6, so `6` is not a valid h-index.

#### Step 3: Result

-   The highest valid h-index found is `3`.

So, the h-index is **3**.


```
import java.util.*;
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        // return citations[0];
    

    int n = citations.length;
        
        // Step 2: Traverse the sorted citations from right to left
        for (int i = 0; i < n; i++) {
            int h = n - i; // h is the number of papers remaining
            if (citations[i] >= h) {
                return h; // Found the maximum h-index
            }
        }
        
        // If no valid h-index is found, return 0
        return 0;
    }
}
```
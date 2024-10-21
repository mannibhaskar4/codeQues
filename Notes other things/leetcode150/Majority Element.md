# Majority Element


See Problem here(https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150)

The problem requires us to find the majority element in an array. The majority element is the one that appears more than ⌊n / 2⌋ times, and it is guaranteed to exist. To solve the problem efficiently in **O(n)** time and **O(1)** space, we can use **Boyer-Moore Voting Algorithm**.

### Boyer-Moore Voting Algorithm

This algorithm works by maintaining a candidate for the majority element and a counter to track its frequency relative to other elements.

**Steps**:

1.  Initialize two variables: `candidate` to store the current candidate for majority and `count` to keep track of how many times the candidate appears compared to other elements.
2.  Traverse through the array:
    -   If the `count` is 0, set the current element as the new `candidate`.
    -   If the current element is the same as the `candidate`, increment the `count`.
    -   Otherwise, decrement the `count`.
3.  At the end of the traversal, the `candidate` will be the majority element.

### Dry Run

Let's dry run this algorithm for a given example.

**Example 1**:

-   **Input**: `nums = [3, 2, 3]`
-   **Process**:
    1.  Start with `count = 0`, `candidate = 0` (initial).
    2.  First element is `3`, `count == 0`, so set `candidate = 3` and increment `count` to 1.
    3.  Second element is `2`, it is not equal to the `candidate`, so decrement `count` to 0.
    4.  Third element is `3`, `count == 0`, so set `candidate = 3` and increment `count` to 1.
-   **Output**: `3` (the majority element).

**Example 2**:

-   **Input**: `nums = [2, 2, 1, 1, 1, 2, 2]`
-   **Process**:
    1.  Start with `count = 0`, `candidate = 0` (initial).
    2.  First element is `2`, `count == 0`, so set `candidate = 2` and increment `count` to 1.
    3.  Second element is `2`, it is equal to the `candidate`, so increment `count` to 2.
    4.  Third element is `1`, it is not equal to the `candidate`, so decrement `count` to 1.
    5.  Fourth element is `1`, it is not equal to the `candidate`, so decrement `count` to 0.
    6.  Fifth element is `1`, `count == 0`, so set `candidate = 1` and increment `count` to 1.
    7.  Sixth element is `2`, it is not equal to the `candidate`, so decrement `count` to 0.
    8.  Seventh element is `2`, `count == 0`, so set `candidate = 2` and increment `count` to 1.
-   **Output**: `2` (the majority element).

### Complexity

-   **Time Complexity**: `O(n)` because we are iterating through the array once.
-   **Space Complexity**: `O(1)` since we are using only a few variables regardless of the input size.


```
class Solution {
    public int majorityElement(int[] nums) {
        int candidate =0;
        int count = 0;

        for(int n: nums){
            if(count == 0){
               candidate=n; 
            }
            if(candidate==n){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
```
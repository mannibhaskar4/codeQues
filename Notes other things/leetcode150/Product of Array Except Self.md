# Product of Array Except Self

To see the problem click [here](https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150)

To solve the problem without using division and in O(n) time, the approach is to use two passes over the array: one from the left and one from the right. We will compute the products of all elements to the left and to the right of each element and multiply these to get the result.

### Approach:

1.  **Left Pass**: Create an array that stores the product of all elements to the left of each element.

2.  **Right Pass**: Create another array that stores the product of all elements to the right of each element.

3.  **Combine**: The final result for each index `i` will be the product of the values from the left and right passes for that index.

### Algorithm:

-   Initialize an array `answer` of the same size as `nums`.
-   Populate the `answer` array with the products of all elements to the left of each element.
-   Then, traverse the array from the right, keeping a running product of all elements to the right, and multiply this running product with the values already stored in the `answer` array.

### Code Implementation:
### Explanation:

1.  **First Pass (Left Product Calculation)**:

    -   We initialize `answer[0]` to `1` since there are no elements to the left of `nums[0]`.
    -   For each `i`, `answer[i]` is the product of all elements to the left of `nums[i]`.
2.  **Second Pass (Right Product Calculation)**:

    -   We initialize a variable `rightProduct` to `1` to store the cumulative product of elements to the right.
    -   For each element starting from the end, multiply the current value in the `answer` array with `rightProduct` to get the product of all elements except the current one.
    -   Update `rightProduct` by multiplying it with `nums[i]` to account for the product of the elements to the right.

### Dry Run:

#### Example 1: `nums = [1, 2, 3, 4]`

1.  **Left Product Pass**:

    -   `answer[0] = 1`
    -   `answer[1] = 1 * 1 = 1`
    -   `answer[2] = 2 * 1 = 2`
    -   `answer[3] = 3 * 2 = 6`

    After left pass, `answer = [1, 1, 2, 6]`

2.  **Right Product Pass**:

    -   `rightProduct = 1`
    -   `answer[3] = 6 * 1 = 6` (update `rightProduct = 4`)
    -   `answer[2] = 2 * 4 = 8` (update `rightProduct = 12`)
    -   `answer[1] = 1 * 12 = 12` (update `rightProduct = 24`)
    -   `answer[0] = 1 * 24 = 24`

    Final `answer = [24, 12, 8, 6]`

#### Example 2: `nums = [-1, 1, 0, -3, 3]`

1.  **Left Product Pass**:

    -   `answer[0] = 1`
    -   `answer[1] = -1 * 1 = -1`
    -   `answer[2] = 1 * -1 = -1`
    -   `answer[3] = 0 * -1 = 0`
    -   `answer[4] = -3 * 0 = 0`

    After left pass, `answer = [1, -1, -1, 0, 0]`

2.  **Right Product Pass**:

    -   `rightProduct = 1`
    -   `answer[4] = 0 * 1 = 0` (update `rightProduct = 3`)
    -   `answer[3] = 0 * 3 = 0` (update `rightProduct = -9`)
    -   `answer[2] = -1 * -9 = 9` (update `rightProduct = 0`)
    -   `answer[1] = -1 * 0 = 0`
    -   `answer[0] = 1 * 0 = 0`

    Final `answer = [0, 0, 9, 0, 0]`

### Time Complexity:

-   **O(n)**: We traverse the array twice (once for the left product and once for the right product).

### Space Complexity:

-   **O(1)** (excluding the output array): We only use a few extra variables (`rightProduct`) and reuse the `answer` array for the result.

This solution is efficient and meets the problem's constraints.


```
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Initialize the answer array with the product of elements to the left
        answer[0] = 1;  // There's nothing to the left of the first element
        for (int i = 1; i < n; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // Step 2: Traverse from the right, and maintain a running product
        int rightProduct = 1;  // There's nothing to the right of the last element
        for (int i = n - 1; i >= 0; i--) {
            // Multiply with the right product
            answer[i] = answer[i] * rightProduct;
            // Update the right product
            rightProduct *= nums[i];
        }

        return answer;
    }
}

```
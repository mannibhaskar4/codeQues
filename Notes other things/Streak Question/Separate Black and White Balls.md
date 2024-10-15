# Separate Black and White Balls

See Problem here(https://leetcode.com/problems/separate-black-and-white-balls/description/?envType=daily-question&envId=2024-10-15)

To solve this problem, the goal is to move all the black balls (represented by `1`s) to the right and all the white balls (represented by `0`s) to the left using the minimum number of adjacent swaps. We can approach this by calculating the total number of steps needed to "shift" all the black balls to the right.

### Explanation:

1.  **White ball counter (`blackCount`)**:

    -   As we iterate over the string `s`, for each black ball (`1`), we add the number of black balls (`0`s) encountered so far (`blackCount`) to the total steps. This is because each black ball will need to be swapped over the white balls to its left.
2.  **How swaps are counted**:

    -   Every time we encounter a black ball, we need to "shift" it over the number of white balls to its left. This count accumulates to determine how many adjacent swaps would be needed to move all black balls to the right.



```
class Solution {
    public long minimumSteps(String s) {
        long black =0 ;
        long minStep =0;

        for(long i =0;i<s.length();i++){
            if(s.charAt((int)i)=='1'){
                black++;
            }else{
                minStep += black;
            }
        }
        return minStep;
    }
}
```
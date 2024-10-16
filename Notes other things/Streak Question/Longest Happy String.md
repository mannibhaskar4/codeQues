# Longest Happy String

See Problem here(https://leetcode.com/problems/longest-happy-string/description/?envType=daily-question&envId=2024-10-16)

### Key Idea:

-   We want to generate a string using the characters `'a'`, `'b'`, and `'c'` such that:
    1.  The string does not contain three consecutive identical characters (i.e., no "aaa", "bbb", or "ccc").
    2.  We use as many characters as possible while adhering to the first rule.

### How It Works:

1.  **Initial Setup**:

    -   A `StringBuilder sb` is used to construct the result string efficiently.
    -   The variables `continuousA`, `continuousB`, and `continuousC` are used to keep track of how many consecutive `'a'`, `'b'`, and `'c'` characters have been appended to the string so far. These help prevent adding three consecutive identical characters.
    -   The total number of characters to be added is `a + b + c` (total occurrences of `'a'`, `'b'`, and `'c'`).
2.  **Iterating Over the Total Length**:

    -   The loop runs `totalLength` times, once for each character to be added.
    -   In each iteration, the algorithm decides whether to add an `'a'`, `'b'`, or `'c'` to the result string based on the current counts of `a`, `b`, and `c`, and the need to avoid three consecutive identical characters.
3.  **Choosing Which Character to Append**:

    -   The algorithm uses a set of conditions to decide which character to append:
        -   **Append `'a'`**:
            -   If there are more or equal `'a'`s than `'b'`s and `'c'`s (i.e., `a >= b && a >= c`), and the last two characters are not both `'a'` (i.e., `continuousA != 2`), we append `'a'`.
            -   If either `'b'` or `'c'` has been used twice in a row (`continuousB == 2` or `continuousC == 2`), but there are still `'a'`s left (`a > 0`), we append `'a'` to break the sequence of `'b'` or `'c'`.
        -   **Append `'b'`**:
            -   Similar logic is applied for appending `'b'`. The algorithm appends `'b'` if there are more or equal `'b'`s than `'a'`s and `'c'`s and the last two characters are not both `'b'`.
            -   It also appends `'b'` if either `'a'` or `'c'` has been used twice in a row, and there are `'b'`s left.
        -   **Append `'c'`**:
            -   Same logic applies for `'c'`. The algorithm appends `'c'` if it has the highest remaining count, and it's not forming a "ccc". It can also append `'c'` if `'a'` or `'b'` has been used twice in a row.
4.  **After Appending a Character**:

    -   After appending a character, the corresponding count (`a`, `b`, or `c`) is decremented.
    -   The continuous counters (`continuousA`, `continuousB`, `continuousC`) are updated accordingly. For example, after appending `'a'`, `continuousA` is incremented, while `continuousB` and `continuousC` are reset to 0.
5.  **Stopping Condition**:

    -   The loop runs `totalLength` times, so the process continues until we've tried to use up all characters.
6.  **Returning the Result**:

    -   Once the loop completes, the result string, stored in `sb`, is converted to a `String` and returned.

### Example Walkthrough:

#### Input: `a = 1, b = 1, c = 7`

1.  **Iteration 1**:

    -   Counts: `a = 1`, `b = 1`, `c = 7`
    -   Choose `'c'` (since `c >= a` and `c >= b`), append `'c'`. Result: `"c"`
    -   Update: `c = 6`, `continuousC = 1`, `continuousA = 0`, `continuousB = 0`
2.  **Iteration 2**:

    -   Counts: `a = 1`, `b = 1`, `c = 6`
    -   Choose `'c'` again (since `c >= a` and `c >= b` and no "ccc" yet). Result: `"cc"`
    -   Update: `c = 5`, `continuousC = 2`, `continuousA = 0`, `continuousB = 0`
3.  **Iteration 3**:

    -   Counts: `a = 1`, `b = 1`, `c = 5`
    -   Can't choose `'c'` (to avoid "ccc"), so choose `'a'` (since `a > 0`). Result: `"cca"`
    -   Update: `a = 0`, `continuousA = 1`, `continuousC = 0`, `continuousB = 0`
4.  **Iteration 4**:

    -   Counts: `a = 0`, `b = 1`, `c = 5`
    -   Choose `'c'` again (since `c > b` and no "ccc" yet). Result: `"ccac"`
    -   Update: `c = 4`, `continuousC = 1`, `continuousA = 0`, `continuousB = 0`

This process continues until the string is fully built.

#### Output: `"ccaccbcc"` (or another valid happy string)


```
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        
        int totalLength = a + b + c;
        int continuousA = 0, continuousB = 0, continuousC = 0;
        
        for(int i = 0; i < totalLength; i++) {
            if ((a >= b && a >= c && continuousA != 2) || (continuousB == 2 && a > 0) || (continuousC == 2 && a > 0))  {
                sb.append("a");
                a--;
                continuousA++;
                continuousB = 0;
                continuousC = 0;  
            } else if ((b >= a && b >= c && continuousB != 2) || (continuousA == 2 && b > 0) || (continuousC == 2 && b > 0)) {
                sb.append("b");
                b--;
                continuousB++;
                continuousA = 0;
                continuousC = 0;
            } else if ((c >= a && c >= b && continuousC != 2) || (continuousB == 2 && c > 0) || (continuousA == 2 && c > 0)) {
                sb.append("c");
                c--;
                continuousC++;
                continuousA = 0;
                continuousB = 0;  
            }
        }
        return sb.toString();
    }
}

```
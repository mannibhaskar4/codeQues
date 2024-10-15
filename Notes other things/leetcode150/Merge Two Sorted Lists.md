# Merge Two Sorted Lists
Refer To the problem and solution [here](https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150)

**Note** Login with your id to see solution

### For Explanation:
1. Create a new linked list(temp), which will have a node stating from -1 position e.g.:  
``````
  5 -> 8 -> 20 
  4 -> 11 -> 15
combining these for pos(-1)
``````

2. Make another reference which is pointing out temp (code) which will be pointing previous point of Head .
3. If both A and B linked list are not null then perform step 4
4. If value inside A < value inside B, then temp.next will contain A and A will be moved onto next node
5. Else(value inside B < value inside A) temp.next will contain B and B will be moved onto next node
6. If A is still have remaining elements in it the n we store A inside address of temp.next
7. Else(B is still have remaining elements in it the n we store B inside address of temp.next)
8. return (code) next value of reference from point 2


```
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                i--;
            }else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
    }
}
```
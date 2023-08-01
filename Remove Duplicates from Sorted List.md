# Remove Duplicates from Sorted List
Refer To the problem and solution [here](https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/).   
**Note** Login with your id to see solution

### Explanation:
1. 1st we check if List is null or if next element in list is null &rarr;  return List itself 
```
if(A==null||A.next==null)
return A;
```
2. Make a copy of Head of linked list
```
ListNode temp=A;
```
3. Run a loop which checks if next element is null or not. In this loop check
- if value inside A is equal to value of next element stored in A &rarr; Next element which A stores will be NEXT OF NEXT ELEMENT OF A.
- Else, A will move to next element.
```
while(A.next!=null){

	if(A.val==A.next.val){
		A.next=A.next.next;
	}else{
		A=A.next;
	}
}
```
4. return copy of head from step 2

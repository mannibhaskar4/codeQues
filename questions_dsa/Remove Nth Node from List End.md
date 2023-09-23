# Remove Nth Node from List End
Refer To the problem and solution  [here](https://www.interviewbit.com/problems/remove-nth-node-from-list-end/)

**Note**  Login with your id to see solution

### Explanation:
So, for simple logic, if B is x then ```(( size of LL - x) +1)th``` node needs to be removed.
The intuition is to get ```(( size of LL - x) )th``` node, so that we can just point it to next ka next node.

1. There will be two pointer 1st and 2nd which will be pointing to  a dummy node who point its next reference to head of LL.
```
ListNode dummy=new ListNode(-1);

dummy.next=A;

ListNode first = dummy;

ListNode second = dummy;
```

2. We will now start traversing through 1st pointer till we reach Bth position of 1st pointer
**Note:**  If before reaching to Bth position 1st pointer becomes null then we will return the Head.next or Dummy.next.next.
```
for(int i=0;i<=B;i++){

if(first==null)

return dummy.next.next;

first=first.next;

}
```
3. This whole step will ensure that first pointer is at place from where if its start traversing with second, when it reaches null second pointer will be ```(( size of LL - x) +1)th``` node.
```
while(first!=null){

	first=first.next;

	second=second.next;

}
```
4. Now, we will just point the 2nd pointer to its next ka next node and return head node.
```
second.next=second.next.next;
return dummy.next;
```
 

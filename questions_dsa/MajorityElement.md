# Majority Element
Refer To the problem and solution [here](https://www.interviewbit.com/problems/majority-element/)

**Note** Login with your id to see solution

### For Explanation:
#### Soln 1 (O(n^2))
1. Create a new map which will have the count of all the unique number in list i.e. how much time a a number is repeted in List:  
2. We will run the another loops which will count the occurence one by one
``````
1,2,2,3,2,2,4
K=(7/2)=3
then O/p -> 2, since its count is greater than 3

so
MAP
(1,1)
(2,2)
(4,1)
``````
3. Now we will calculate how which is greater than half of the size of list

#### Soln 2 (O(n))
1. We will run 1 loop here and it will check if number in list is present in Map or not
   - if number is not present in Map then we will add that element in map as key and 1 as value
   - if number is present then it will go to else part where 
   we will get the element and then get the value for the key which is already present and store them in map again
````
int h=A.get(i);

int l=scores.get(h)+1;

scores.put(h, l++);

here A is list
scores is map
````
3. Now, we will find the key which has highest value

# # Total Moves For Bishop!
Refer To the problem and solution [here](https://www.interviewbit.com/problems/total-moves-for-bishop/)

**Note** Login with your id to see solution

### For Explanation:
Here we will run for 4 for loops which will track all the all diagonal columns which it can move   
1. 1st loop will check all move can be made by bishop while moving left down corner, here we will have condition: 
``````
a--;
b--;
if( a>=1  && b>=1  ){
	c1++;
}else{
	break;
}
``````
2. 2nd loop will check all move can be made by bishop while moving left top corner, here we will have condition: 
``````
a--;
b++;
if( a>=1  && b<=8 ){
	c1++;
}else{
	break;
}
``````
3. 3rd loop will check all move can be made by bishop while moving right down corner, here we will have condition: 
``````
a++;
b--;
if( b>=1  && a<=8 ){
	c1++;
}else{
	break;
}
``````

4. 4th loop will check all move can be made by bishop while moving right top corner, here we will have condition: 
``````
a++;
b++;
if( a<=8  && b<=8 ){
	c1++;
}else{
	break;
}
``````

here c1 is counter which will count all the values in the matrix

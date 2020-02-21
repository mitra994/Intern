# Explanation
 
 
The code consists of two methods.

Method getArrayOfMedian() which takes an int array as an argument and returns an int array.
Method getMedian() which takes an int array as an arguments and returns an int.

In the first method, i have created a new int array with a length of grades.length which contains the end result.
Algorithm iterates over the grades array and sets each element of the container array by calling getMedian() and passing a part of grades array
as an argument using Arrays.CopyOfRange. 

I am using Arrays.CopyOfRange so i don't have to sort the entire array, only a part of it, so zeroes don't get sorted, 
which should result in more efficient algorithm.

The second method sorts the gradesPart array.
Finds the middle element with gradesPart.length/2 and checks whether the array is odd or even.
If the array.length is even, algorithm gets the two numbers in the middle, sums them and divides them by two and returns it.
if its odd, it gets the middle element of an array and returns it.


-Nearest Smaller Element on left:

1.Create an empty stack.
2.Iterate through the array from left to right.
3.For each element, while the stack is not empty and the element on the top of the stack is greater than the current element, pop the element from the stack.
4.If the stack is empty, store -1 as the nearest smaller element on the left for the current element. Else, store the element on the top of the stack as the nearest smaller element on the left for the current element.
5.Push the current element onto the stack.
6.Repeat steps 3-5 for all elements in the array.
7.Return the array of nearest smaller elements on the left.

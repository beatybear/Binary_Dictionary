# Binary_Dictionary

CS341 

Homework 4 	Dictionary SpellChecker

	
1.	Implement a Dictionary class using a Binary Search Tree.  Create your own implementation of the BST.
2.	Add a spellCheck() method to Dictionary that receives a word and returns a true if the word is spelled correctly (recognized in the BST) or false if it is not recognized.
3.	Implement Test Assertions.
4.	Upload your completed software, including the asserts, to GitHub.  
5.	Upload the GitHub URL to Moodle.




Part I: Coding and Debugging a Binary Search Tree

Implement the Dictionary (Binary Search Tree) class containing the following methods:

insertWordNode(): 	A public method to insert a value into the binary search tree (if it does not already exist).  Inserts must occur at a leaf and the respective child pointers should be assigned correctly.
checkWord():  	A public method that removes a specified node from the Binary Search Tree.  Consider the possible scenarios for deletion.  For example (a) the node to be removed is not in the tree, (b) the node to be removed has no children, (c) the node to be removed had one child, and (d) the node to be removed has two children. Following a deleted node, respective node pointers much be correctly re-assigned.
Helper method(s) :	You may add additional methods to your class to help with tasks.  For example, searching for a node can be done with a helper method. 




Part II: Testing the Binary Search Tree Using Assertions

Debugging a Binary Search Trees requires that its properties be tested for validity.  Create test cases to test your Binary Search Tree.  Construct the input and verify the output.  Use assertions to test each method you implement for proper behavior.

Pay particular attention to the insertion methods.  Keep in mind that when performing insertWordNode(), there may be several helper methods and there are different scenarios that need to be handled. Look at potential problems, such as ending up with a pointer pointing to the wrong node. 


Carefully consider how you write assertions to catch these problems. Some of the assertions may be trivial one-liners. Others will be more complicated.

Tips:
1.	Make sure there are no cycles in the tree.
2.	Make sure that pointers to child nodes are consistent, that is, if some node points to its child then it if it’s smaller than it is a left child and if greater than then it is a right child. 

Write a tester to execute some experiments. For every method that makes alterations to the Binary Search Tree, the assertion should be invoked. When all of the assertions pass, then output “Successful”. 

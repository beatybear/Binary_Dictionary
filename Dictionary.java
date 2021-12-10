package beaty;

/**
 * Implement the Dictionary (Binary Search Tree) class containing the following methods:
 * insertWordNode(): A public method to insert a value into the binary search tree (if it does not already exist).
 	Inserts must occur at a leaf and the respective child pointers should be assigned correctly.
 * checkWord(): A public method that removes a specified node from the Binary Search Tree.  Consider the possible scenarios for deletion.
 	For example (a) the node to be removed is not in the tree, (b) the node to be removed has no children, (c) the node to be removed had one child,
 	and (d) the node to be removed has two children. Following a deleted node, respective node pointers much be correctly re-assigned.
 * Helper method(s): You may add additional methods to your class to help with tasks.  For example, searching for a node can be done with a helper method. 
*run configurations -> arguments -> VM arguments -> -ea to use assertions
		assert 1 <= hour && hour <= 12: "Precondition: hour out of range";
*/
public class Dictionary {
	public WordNode root;
	
	public Dictionary() {
		root = null;
	}
	
	public Dictionary(String w) { //I had a different way I wanted to do my constructor than Trish
		root = new WordNode(w);
	}
	
	public void addWord(String word) {
		WordNode temp = new WordNode(word);
		if(root == null) { //the binary search tree is empty, so the root must be filled
			root = temp;
		}
		else{ //position for the new word must be found
			insertAtLocation(root, temp);
		}
	}
	
	//same as insertWordNode
	public void insertAtLocation(WordNode ptr, WordNode wordToAdd) { //ptr is pointer
		//begin the search by visiting each word node
		//move left if greater than
		//move right if less than
		//for compareTo
		//negative: wordToAdd is less than ptr
		//zero: wordToAdd is equal to ptr
		//positive: wordToAdd is greater than ptr
		while(true) {
			//scenario 1: the word already exists in the dictionary
			if(wordToAdd.word.compareToIgnoreCase(ptr.word) == 0) { //compareToIgnoreCase is the same as compareTo except it ignores upper and lower case
				break; //binary search trees do not have duplicate values
			} //I know I don't need these brackets, but I like them
			//scenario 2: travel to the left side
			else if(wordToAdd.word.compareToIgnoreCase(ptr.word)<0) {
				if(ptr.left != null) {
					ptr = ptr.left;
				}
				else {
					ptr.left = wordToAdd;
					break; //end the while loop completely
				}
			}
			//scenario 3: travel to the right side
			else if(wordToAdd.word.compareToIgnoreCase(ptr.word)>0) {
				if(ptr.right != null) {
					ptr = ptr.right;
				}
				else {
					ptr.right = wordToAdd;
					break; //end the while loop completely
				}
			}
		}		
	}
	
	/**
	 * checkWord(): A public method that removes a specified node from the Binary Search Tree.  Consider the possible scenarios for deletion.
 	For example (a) the node to be removed is not in the tree, (b) the node to be removed has no children, (c) the node to be removed had one child,
 	and (d) the node to be removed has two children. Following a deleted node, respective node pointers much be correctly re-assigned.
	 */	
	// Function to delete a node from a BST
    public WordNode checkNode(WordNode ptr, String key) //using key instead of calling it word or something since that's what's usually used with BSTs
    {
        // pointer to store the parent of the current node
        WordNode parent = null;
         // start with the root node
        WordNode curr = ptr;
         // search key in the BST and set its parent pointer
        while (curr != null && curr.word != key)
        {
            // update the parent to the current node
            parent = curr;
             // if the given key is less than the current node, go to the left subtree;
            // otherwise, go to the right subtree
            if (key.compareTo(curr.word) < 0) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
         // return if the key is not found in the tree
        if (curr == null) {
            return ptr;
        }
         // Case 1: node to be deleted has no children, i.e., it is a leaf node
        if (curr.left == null && curr.right == null)
        {
            // if the node to be deleted is not a root node, then set its
            // parent left/right child to null
            if (curr != ptr)
            {
                if (parent.left == curr) {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
            }
            // if the tree has only a root node, set it to null
            else {
                ptr = null;
            }
        }
         // Case 2: node to be deleted has two children
        else if (curr.left != null && curr.right != null)
        {
            // find its successor node
        	WordNode successor = getMinimumKey(curr.right);
            // store successor value
            String val = successor.word;
            // recursively delete the successor. Note that the successor will have at most one child (right child)
            checkNode(ptr, successor.word);
            // copy value of the successor to the current node
            curr.word = val;
        }
        // Case 3: node to be deleted has only one child
        else {
            // choose a child node
            WordNode child = (curr.left != null)? curr.left: curr.right;
            // if the node to be deleted is not a root node, set its parent to its child
            if (curr != ptr)
            {
                if (curr == parent.left) {
                    parent.left = child;
                }
                else {
                    parent.right = child;
                }
            }
            // if the node to be deleted is a root node, then set the root to the child
            else {
                ptr = child;
            }
        }
        assert findWord(ptr, key) == null : "The node was not removed"; //if the ptr exists in the tree, the method failed
        return ptr;
    }
	
    // Helper function to find minimum value node in the subtree rooted at the pointer`
    public static WordNode getMinimumKey(WordNode ptr)
    {
        while (ptr.left != null) {
            ptr = ptr.left;
        }
        return ptr;
    }
	
	public void displayDictionary(){
		inOrderRecursive(root);
	}
	
	public WordNode findWord(WordNode ptr, String s) {
	    if (ptr == null || ptr.word.compareTo(s) == 0)
	        return ptr;
	 
	    if (ptr.word.compareTo(s) > 0)
	       return findWord(ptr.right, s);
	    else {
	    	return findWord(ptr.left, s);
	    }
	}
	
	//recur through the search tree starting from a given node
	public void inOrderRecursive(WordNode ptr) {
		if(ptr != null) {
			inOrderRecursive(ptr.left);
			System.out.println(ptr.word);
			inOrderRecursive(ptr.right);
		}
	}


}

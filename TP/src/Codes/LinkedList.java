package Codes;

public class LinkedList {
	
	Node first, last;
	
	//Constructor                           
	public LinkedList() {
		first = null;
		last = first;
	}
	           
	public void showList() {
		
		System.out.print("--------LIST-----\n");	

		Node current = first;
		
		//while the current is different than null
		while (current != null) {	
		
			System.out.println(current.word.getNome() + " - " + current.word.getCont() + " times");
			
			current = current.right;
		}
		
		System.out.print("--------END_LIST-----\n");
	}
	  
	void insertBefore(Node node, Word word) {
	    	
		Node newNode = new Node(word);
		
		//if the node is equal to null
		if (node == null) {
			
			newNode.right = first; //link (newNode) -> right pointer to the head of the list   
	        
			if (first != null) { 	//if the first is different than null = (have something) link first left pointer to new node
				first.left = newNode; 
			}
	          
			first = newNode; //now the first is newNode
	        
			if (last == null) { //if last node is null add newNode at last position
				last = newNode;
			}    
		} else {  //if node is different than null adds before the current one
			newNode.right = node;
			newNode.left = node.left;
	        
			if (node.left != null) {  //if is different than null add the next previous node with the newNode
				node.left.right = newNode; 
	        } else {
				first = newNode;  //if previous does not exists add at first of the list
			}
	           
			node.left = newNode;
		}
	}
	  
	void insertLast(Word word) {
		
		Node tmp = new Node(word);
	        
	    if (last == null) { 		//if list is empty
	    	first = tmp;
	        last = tmp;
	    } else { 				//if list already have nodes tmp is the new last node
		    tmp.left = last;
	        last.right = tmp;
	        last = tmp;    
	    }
	}
}
	


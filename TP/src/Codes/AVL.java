package Codes;

public class AVL {
	
	Node root; 
	String [] words;

	private int LocalCont = 0;
	
	public AVL() {
		root = null;
	}
	
	//print the tree by the central path
	public void centralPath() throws Exception {

		System.out.print("--------AVL-----\n");
		centralPath(root);
		System.out.println("-------END_AVL----------\n");
	}

	private void centralPath(Node i) throws Exception {
		
		if (i != null) {	
			centralPath(i.left); 
			System.out.print(i.word.getNome() + " - " + i.word.getCont()+ "\n"); 
			centralPath(i.right); 
		}
	}
	
	//insert a word to the tree
	public void insert(Word x) throws Exception {
		root = insert(x, root);
	}

	private Node insert(Word x, Node i) throws Exception {
	
		if (i == null) {   										    //if is empty add a new node
			i = new Node(x);
		} else if (x.getNome().compareTo(i.word.getNome()) < 0) {  //comparison return less than zero add on the left
			i.left = insert(x, i.left);
		} else if (x.getNome().compareTo(i.word.getNome()) > 0) { //comparison return greater than zero add on the right
			i.right = insert(x, i.right);
		} else {
			i.word.setCont(LocalCont++);  //equal words
		}
		return balance(i);
	}

	//find the greater left node into the tree
	private Node greaterLeft(Node i, Node j) {
		
		//found the maximum node in the left sub-tree
		if (j.right == null) { 	
			i.word.setName(j.word.getNome()); 		 // replace i for j.
			j = j.left; 							// replace j for j.left
		
		} else {    
			j.right = greaterLeft(i, j.right); //exist right node so continues walk to the right 
		}
		return j;
	}
	
	//balancing the tree
	private Node balance(Node no) throws Exception {
		
		if (no != null) {
			int factor = Node.getNivel(no.right) - Node.getNivel(no.left); //get factor of balance
			                      
			if (Math.abs(factor) <= 1) {
				no.setNivel();
			//unbalanced to the right                      
			} else if (factor == 2) {
				
				int fatorFilhoDir = Node.getNivel(no.right.right) - Node.getNivel(no.right.left);
				                                        
				if (fatorFilhoDir == -1) {	//check if the right son node is unbalanced (double rotation) 
					no.right = rotateRight(no.right);
				}
				no = rotateLeft(no);  
				
			} else if (factor == -2) {  //unbalanced to the left    
				
				int fatorFilhoEsq = Node.getNivel(no.left.right) - Node.getNivel(no.left.left);
				
				if (fatorFilhoEsq == 1) { //check if the left son node is unbalanced (double rotation) 
					no.left = rotateLeft(no.left);
				}
				no = rotateRight(no);
			} else {
				throw new Exception(
						"ErrorNode(" + no.word.getNome() + ") with factor of balancing (" + factor + ")invalid!");
			}                          
		}
		return no;
	}

	private Node rotateRight(Node node) {
		
		Node noLeft = node.left;
		Node nodeLR = noLeft.right;

		noLeft.right = node;
		node.left = nodeLR;
		node.setNivel(); 		 //update level node
		noLeft.setNivel(); 		//update level node nodeLeft
 
		return noLeft;
	}

	private Node rotateLeft(Node node) {
		
		Node nodeRight = node.right;
		Node nodeRL = nodeRight.left; 

		nodeRight.left = node;
		node.right = nodeRL;

		node.setNivel();  		 	 //update level node
		nodeRight.setNivel(); 		//update level node nodeRight
		return nodeRight;
	}
	
	//----------List methods-------------//
	void AddToList(LinkedList list) {
		AddToList(root, list);
	}
	void AddToList(Node node, LinkedList list) {
		
		if (node != null) { 				     //while node is different than null
			AddToList(node.right, list); 		 	 //start navigate to the right nodes of the tree
		        
		    Node currentNode = list.first;    //set a pointer the first node of the list
		    
		    while (currentNode != null && currentNode.word.getCont() >= node.word.getCont()) { //if our previous node its greater than the current continues 
		    	currentNode = currentNode.right;                   
		    }
		       
		    if (currentNode == null) { //if no higher number is found insert at the end
		    	list.insertLast(node.word);
		    }else{ 
		    	list.insertBefore(currentNode, node.word); // was found higher number insert before this previous node
		    }
		    AddToList(node.left, list); 
		}
	}
}

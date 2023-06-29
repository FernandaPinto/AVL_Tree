package Codes;

public class Node {
	
	public Word word; 
	public Node left, right;              
	public int level; 
	 
	//Constructors
	public Node(Word w) {
		this(w, null, null, 1);
	}

	public Node(Word w, Node esq, Node dir, int Level) {
		this.word = w;
		this.left = esq;
		this.right = dir;
		this.level = Level;
	}

	//Get and Set methods
	public void setNivel() {
		this.level = 1 + Math.max(getNivel(left), getNivel(right));
	}

	public static int getNivel(Node node) {
		return (node == null) ? 0 : node.level;
	}
}

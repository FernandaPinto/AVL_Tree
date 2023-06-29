package Codes;

public class Master {
	
	public static void main(String[] args) throws Exception {
		
		//Initialize class/objets
		ReadFile file = new ReadFile();
		AVL tree = new AVL(); 
		LinkedList list = new LinkedList();
		
		//Open .txt and read
		file.Initialize();
		file.ReadFiles("C:\\Users\\TP.txt"); //put the path of the file
		
		String LocalVector[] = file.getWords();
		
		//Filter to does not get blank spaces ""
		for(int i = 0; i < file.getWords().length; i++){
			
			if(LocalVector[i] != "") {
				Word LocalWord = new Word(LocalVector[i]);
				tree.insert(LocalWord);
			}
		}
		
		//AVL methods print / add to list
		tree.centralPath();
		tree.AddToList(list);
		
		//Show list
		list.showList();
				
	}
}

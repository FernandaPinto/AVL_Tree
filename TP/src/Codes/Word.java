package Codes;

public class Word {
	
	private String Name;
	private int Cont;
	
	//Constructors
	Word() {
		Name = "";
		Cont = 0;
	}
	
	Word(String a) {
		Name = a;
	}
	
	//Get and Set methods
	public String getNome() {
		return Name;
	}
	public int getCont() {
		return Cont;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setCont(int n) {
		Cont = n;
	}
}

package Codes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class ReadFile {
	
	private int posCopy, sizeCopy;
	private String[] copy = new String[500];
	
	public String[] getWords(){
		return copy;
	}
	
	//Fill vector with ""
	void Initialize() {
		
		for(int i = 0; i < copy.length; i++) {
			copy[i] = "";
		}
	}
	
	//Read .txt 
	void ReadFiles(String filePath) throws IOException  {
		
		BufferedReader buffRead = new BufferedReader(new FileReader(filePath)); 	
		
		String[] words = null;
		
		String line = "";
		
		//While file different than null continues reading lines
		while((line = buffRead.readLine()) != null) { 
			
			 line = line.toLowerCase();  //force line to lower case 
			 
			 words = line.split("[.;,! ]"); 
			 
			 Add(words); //add to another vector the current line
		}
		
		//file buffer close
		buffRead.close();
	}
	
	//add current vector line to individuals words
	void Add(String [] a) {
		
		for(int i = 0; i < a.length; i++) {
			copy[posCopy] = a[i];	
			posCopy++;
		}
	}
}

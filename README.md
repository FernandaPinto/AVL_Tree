# AVL_Tree
Download the project:
1 - Open the Eclipse IDE 
2 - In the Master class (line 14) put the path to your .txt file: file.ReadFiles("\\path"); 

\\-------------------------------------Explanation-----------------------------------------------\\
This final paper with focus on hybrid structures and object programming has the following objective:

 A program that reads a text file (.txt format) and collects all the words
the words present in the text.
- The file should ́a read disregard blank spaces and punctuation marks.
punctuation marks, which are considered word separators. In addition, the reading
In addition, the reading should convert all uppercase letters to lowercase.
- A bin AVL tree (implemented by the student himself in the
JAVA LANGUAGE).
- In addition to the elementary attributes of the AVL tree, the n ́os should contain
a "Word" Object with:
∗ Name (String type);
∗ Counter (Integer).
- A double chained list formed by objects of type "Word".
Next, using the developed structure, create an AVL ́arvore that
stores all the names contained in the text file. In the ́arvore, the words
In the tree, the words should be sorted in lexicographic order. During the insertion, once a certain word is
identified a certain word that already exists in the structure, its counter
its counter attribute should be incremented. Thus, at the end of an execution, its structure should be incremented,
The structure should contain all the words in the text and the number of times each of them appears.
that each one of them appears.
Finally, using some strategy to walk the tree, go through all the n nodes in the tree.
all n nodes and add the "Words" found to your double chained list.
You must insert the words in the list so that the ones that appear most in the text are at the beginning
in the text are at the beginning and those that appear less are at the end.

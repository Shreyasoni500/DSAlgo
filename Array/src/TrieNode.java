public class TrieNode {
	final static int Alphabet_Size = 26;
	boolean endOfWord;
	int count;
	TrieNode children[];
	public TrieNode() {
		endOfWord = false;
		count = 0;
		children = new TrieNode[Alphabet_Size];
		for(int i=0;i<Alphabet_Size;i++) {
			children[i] = null;
		}
	}
}

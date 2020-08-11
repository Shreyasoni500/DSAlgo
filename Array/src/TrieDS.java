
public class TrieDS {
	static TrieNode root;
	public static void main(String[] args) {
		root = new TrieNode();
		insert("apple");
		System.out.print(search("apple")+" ");   // returns true
		System.out.print(search("app")+" ");     // returns false
		System.out.print(startsWith("app")+" "); // returns true
		insert("app");   
		System.out.print(startsWith("app")+" ");     // returns true

	}

	private static boolean startsWith(String str) {
		TrieNode pCrawl = root;
		for(int i=0;i<str.length();i++) {
			int index = str.charAt(i)-'a';
			if(pCrawl.children[index]==null) {
				return false;
			}
			pCrawl = pCrawl.children[index];
		}
		return (pCrawl!=null); 
	}

	private static boolean search(String str) {
		TrieNode pCrawl = root;
		for(int i=0;i<str.length();i++) {
			int index = str.charAt(i)-'a';
			if(pCrawl.children[index]==null) {
				return false;
			}
			pCrawl = pCrawl.children[index];
		}
		return (pCrawl!=null && pCrawl.endOfWord);
	}

	private static void insert(String str) {
		if (str.length()==0) {
			return;
		}
		TrieNode pCrawl = root;
		for(int i=0;i<str.length();i++) {
			int index = str.charAt(i) - 'a';
			if (pCrawl.children[index]==null) {
				pCrawl.children[index] = new TrieNode();
			}
			pCrawl = pCrawl.children[index];
		}
		pCrawl.endOfWord = true;
	}

}

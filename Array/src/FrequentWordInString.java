import java.util.HashMap;
import java.util.Map;

public class FrequentWordInString {
	static TrieNode root;
	public static void main(String[] args) {
		String arr[] = { "geeks", "for", "geeks", "a", 
                "portal", "to", "learn", "can", "be", 
                "computer", "science", "zoom", "yup", 
                "fire", "in", "be", "data", "geeks" };
		int count = mostFrequentWord(arr);
		System.out.print();
	}

	private static int mostFrequentWord(String[] arr) {
		for(int i=0;i<arr.length;i++) {
			insert(arr[i]);
		}
		for(int i=0;i<arr.length;i++) {
			boolean flag = searchFrequentWord(arr[i]);
		}
	}
	static int maxcount = Integer.MIN_VALUE;
	static String str = "";
	private static boolean searchFrequentWord(String str) {
		TrieNode pcrawl = root;
		for(int i=0;i<str.length();i++) {
			int index = str.charAt(i)-'a';
			if(pcrawl.children[i]==null) {
				return false;
			}
			pcrawl = pcrawl.children[index];
			if(pcrawl.count>maxcount) {
				maxcount = pcrawl.count;
			}
		}
		return (pcrawl!=null && pcrawl.endOfWord==true);
	}

	private static void insert(String str) {
		if(str.length()==0) {
			return;
		}
		TrieNode pcrawl = root;
		for(int i=0;i<str.length();i++) {
			int index = str.charAt(i)-'a';
			if(pcrawl.children[index]==null) {
				pcrawl.children[index]=new TrieNode(); 
			}
			pcrawl = pcrawl.children[index];
			pcrawl.count++;
		}
		pcrawl.endOfWord=true;
	}
}